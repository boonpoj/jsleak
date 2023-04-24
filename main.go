package main

import (
	"bufio"
	"crypto/tls"
	"encoding/json"
	"flag"
	"fmt"
	"io"
	"io/ioutil"
	"log"
	"net"
	"net/http"
	"net/url"
	"os"
	"os/exec"
	"path/filepath"
	"regexp"
	"strings"
	"sync"
	"time"
)

var httpClient = &http.Client{
	CheckRedirect: func(req *http.Request, via []*http.Request) error {
		return http.ErrUseLastResponse
	},
	Transport: &http.Transport{
		TLSClientConfig: &tls.Config{InsecureSkipVerify: true},
		DialContext: (&net.Dialer{
			Timeout:   30 * time.Second,
			KeepAlive: time.Second,
			DualStack: true,
		}).DialContext,
	},
}

func request(fullurl string, statusCode bool) string {
	req, err := http.NewRequest("GET", fullurl, nil)
	if err != nil {
		fmt.Println(err)
		return ""
	}

	req.Header.Add("User-Agent", "User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.100 Safari/537.36")

	resp, err := httpClient.Do(req)
	if err != nil {
		fmt.Println(err)
		return ""
	}
	defer resp.Body.Close()
	if statusCode && resp.StatusCode != 404 {
		fmt.Printf("[Linkfinder] %s : %d\n", fullurl, resp.StatusCode)
	}

	var bodyString string
	if resp.StatusCode == http.StatusOK {
		bodyBytes, err := io.ReadAll(resp.Body)
		if err != nil {
			fmt.Println(err)
			return ""
		}
		bodyString = string(bodyBytes)
	}
	return bodyString
}

func regexGrep(content string, Burl string) {
	regex_map := RegexMap()

	for key, element := range regex_map {
		r := regexp.MustCompile(element)
		matches := r.FindAllString(content, -1)
		for _, v := range matches {
			fmt.Println("[+] Found " + "[" + key + "]" + "	[" + v + "]" + "	[" + Burl + "]")
		}
	}
}

func linkFinder(content, baseURL string, completeURL, statusCode bool) {
	linkRegex := `(?:"|')(((?:[a-zA-Z]{1,10}://|//)[^"'/]{1,}\.[a-zA-Z]{2,}[^"']{0,})|((?:/|\.\./|\./)[^"'><,;| *()(%%$^/\\\[\]][^"'><,;|()]{1,})|([a-zA-Z0-9_\-/]{1,}/[a-zA-Z0-9_\-/]{1,}\.(?:[a-zA-Z]{1,4}|action)(?:[\?|#][^"|']{0,}|))|([a-zA-Z0-9_\-/]{1,}/[a-zA-Z0-9_\-/]{3,}(?:[\?|#][^"|']{0,}|))|([a-zA-Z0-9_\-]{1,}\.(?:php|asp|aspx|jsp|json|action|html|js|txt|xml)(?:[\?|#][^"|']{0,}|)))(?:"|')`

	r := regexp.MustCompile(linkRegex)
	matches := r.FindAllString(content, -1)

	base, err := url.Parse(baseURL)
	if err != nil {
		fmt.Println("")
	}

	for _, v := range matches {
		cleanedMatch := strings.Trim(v, `"'`)
		link, err := url.Parse(cleanedMatch)
		if err != nil {
			continue
		}
		if completeURL {
			link = base.ResolveReference(link)
		}
		if statusCode {
			request(link.String(), true)
		} else {
			fmt.Printf("[+] Found link: [%s] in [%s] \n", link.String(), base.String())
		}
	}
}

// ------------ checking installation tool ------------
func isToolsInstalled() bool {
	jadxInstalled := checkCommandAvailability("jadx")
	return jadxInstalled
}

func checkCommandAvailability(command string) bool {
	_, err := exec.LookPath(command)
	return err == nil
}

// ------------ checking file Extension ------------
func extension(filePath string) string {
	return filepath.Ext(filePath)
}

// ------------ checking file exist ------------
func isFileExist(filePath string) (bool, string) {
	absTargetPath, _ := filepath.Abs(filePath)
	if _, err := os.Stat(absTargetPath); os.IsNotExist(err) {
		return false, ""
	}
	return true, absTargetPath
}

func currentAbsPath() string {
	absCurrentPath, err := os.Getwd()
	if err != nil {
		fmt.Println(colorRed(), "Error:", err)
		return ""
	}
	return absCurrentPath
}

// ------------ decompiling ----------------
func decompileAPK(absTargetPath string, folderOut string) error {
	// command := "jadx -d " + folderOut + " " + absTargetPath + " 2>/dev/null -q"
	// jadxErr := runCommand("jadx", "-d", folderOut, absTargetPath, "-q")
	jadxErr := runCommand("jadx", "-d", folderOut, absTargetPath, "-q")
	if jadxErr != nil {
		return fmt.Errorf(colorRed(), "error running jadx: %v", jadxErr)
	}
	return nil
}

func runCommand(name string, args ...string) error {
	cmd := exec.Command(name, args...)
	cmd.Stderr = ioutil.Discard
	_, err := cmd.Output()
	if err != nil {
		fmt.Println(colorRed(), "Error running command:", err)
	}
	return nil
}

// ------------ checking hardcode ----------------
func checkHardcode(targetPath string) error {
	regex_map := RegexMap()

	concurrency := 40
	wg := sync.WaitGroup{}
	fileChan := make(chan string, concurrency)

	for i := 0; i < concurrency; i++ {
		wg.Add(1)
		go func() {
			defer wg.Done()
			for path := range fileChan {
				content, err := ioutil.ReadFile(path)
				if err != nil {
					fmt.Errorf("Error reading file: %v", err)
				}
				for key, element := range regex_map {
					r := regexp.MustCompile(element)
					matches := r.FindAllString(string(content), -1)
					for _, v := range matches {
						fmt.Println(colorGreen(), "[+] Found "+"["+key+"]"+"	["+v+"]"+"	["+path+"]")
					}
				}
			}
		}()
	}

	err := filepath.Walk(targetPath, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}
		if skipExt(path) {
			return nil
		}
		if !info.IsDir() {
			fileChan <- path
		}
		return nil
	})
	close(fileChan)
	wg.Wait()
	return err
}

// ------------ env ----------------
func colorBlue() string {
	return string("\033[34m")
}

func colorRed() string {
	return "\033[31m"
}

func colorGreen() string {
	return "\033[32m"
}

func colorPurple() string {
	return "\033[35m"
}

func colorReset() string {
	return "\033[0m"
}

func skipExt(file string) bool {
	extension := filepath.Ext(file)
	return strings.EqualFold(extension, ".jpg") ||
		strings.EqualFold(extension, ".jpeg") ||
		strings.EqualFold(extension, ".png") ||
		strings.EqualFold(extension, ".gif") ||
		strings.EqualFold(extension, ".svg") ||
		strings.EqualFold(extension, ".bmp") ||
		strings.EqualFold(extension, ".webp") ||
		strings.EqualFold(extension, ".bmp") ||
		strings.EqualFold(extension, ".eot") ||
		strings.EqualFold(extension, ".otf") ||
		strings.EqualFold(extension, ".ttf") ||
		strings.EqualFold(extension, ".woff") ||
		strings.EqualFold(extension, ".woff2") ||
		strings.EqualFold(extension, ".so")
}

func RegexMap() map[string]string {
	regex_map := make(map[string]string)

	jsonFile, err := os.Open("regex.json")
	if err != nil {
		fmt.Println("Error open file:", err)
		return nil
	}
	defer jsonFile.Close()

	byteValue, _ := ioutil.ReadAll(jsonFile)

	err = json.Unmarshal(byteValue, &regex_map)
	if err != nil {
		fmt.Println("Error unmarshal:", err)
		return nil
	}
	return regex_map
}

// ------------ delete -----------
func deleteDecompiledFolder(folder string) {
	defer os.RemoveAll(folder)
}

func findHardCodeFromAPK(filePaths string) {
	filePathArray := strings.Split(filePaths, ",")
	for _, filePath := range filePathArray {
		if !isToolsInstalled() {
			fmt.Println(colorRed(), "Please install Jadx")
			return
		}

		if extension(filePath) != ".apk" {
			fmt.Println(colorRed(), filePath, "is not <.apk> file \nPlease enter the <.apk> file")
			return
		}

		isExist, absTargetPath := isFileExist(filePath)
		if !isExist {
			fmt.Println(colorRed(), filePath+" does not exist")
			return
		}

		folder := filepath.Base(strings.TrimSuffix(filePath, filepath.Ext(filePath)))
		err := decompileAPK(absTargetPath, currentAbsPath()+"/"+folder)
		if err != nil {
			log.Fatalf(colorRed(), "Error decompiling APK file: %v", err)
			return
		}

		err = checkHardcode(currentAbsPath() + "/" + folder)
		if err != nil {
			log.Fatalf(colorRed(), "Error check Hardcode: %v", err)
			return
		}

		deleteDecompiledFolder("./" + folder)
	}
}

func findHardCodeFromFolder(folderPaths string) {
	folderPathArray := strings.Split(folderPaths, ",")
	for _, folderPath := range folderPathArray {
		isExist, absTargetPath := isFileExist(folderPath)
		if !isExist {
			fmt.Println(colorRed(), folderPath+" does not exist")
			return
		}

		err := checkHardcode(absTargetPath)
		if err != nil {
			log.Fatalf(colorRed(), "Error check Hardcode: %v", err)
		}
	}
}

func main() {
	var concurrency int
	var enableLinkFinder, completeURL, checkStatus, enableSecretFinder, checkApk, checkFolder bool
	flag.BoolVar(&enableLinkFinder, "l", false, "Enable linkFinder")
	flag.BoolVar(&completeURL, "e", false, "Complete Scope Url or not")
	flag.BoolVar(&checkStatus, "k", false, "Check status or not")
	flag.BoolVar(&enableSecretFinder, "s", false, "Enable secretFinder")
	flag.IntVar(&concurrency, "c", 10, "Number of concurrent workers")
	flag.BoolVar(&checkApk, "ha", false, "Find Hardcode from APK(s)")
	flag.BoolVar(&checkFolder, "hf", false, "Find Hardcode from Folder(s)")
	flag.Parse()
	urls := make(chan string, 10)
	go func() {
		sc := bufio.NewScanner(os.Stdin)
		for sc.Scan() {
			urls <- sc.Text()
		}
		close(urls)
		if err := sc.Err(); err != nil {
			fmt.Fprintf(os.Stderr, "failed to read input: %s\n", err)
		}
	}()

	wg := sync.WaitGroup{}
	for i := 0; i < concurrency; i++ {
		wg.Add(1)
		go func() {
			for vUrl := range urls {
				var res string
				if !checkApk && !checkFolder {
					res = request(vUrl, false)
				}
				if enableSecretFinder {
					regexGrep(res, vUrl)
				}
				if enableLinkFinder {
					linkFinder(res, vUrl, false, false)
				}
				if completeURL {
					linkFinder(res, vUrl, true, false)
				}
				if checkStatus {
					linkFinder(res, vUrl, true, true)
				}
				if checkApk {
					findHardCodeFromAPK(vUrl)
				}
				if checkFolder {
					findHardCodeFromFolder(vUrl)
				}
			}
			wg.Done()
		}()
	}
	wg.Wait()
}
