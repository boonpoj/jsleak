package com.mopub.volley.toolbox;

import com.mopub.common.Constants;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Header;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HttpClientStack;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: assets/classes2.dex */
public class HurlStack extends BaseHttpStack {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final UrlRewriter f2191;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final SSLSocketFactory f2192;

    /* loaded from: assets/classes2.dex */
    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.f2191 = urlRewriter;
        this.f2192 = sSLSocketFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static InputStream m1684(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private HttpURLConnection m1685(URL url, Request<?> request) throws IOException {
        HttpURLConnection m1691 = m1691(url);
        int timeoutMs = request.getTimeoutMs();
        m1691.setConnectTimeout(timeoutMs);
        m1691.setReadTimeout(timeoutMs);
        m1691.setUseCaches(false);
        m1691.setDoInput(true);
        if (Constants.HTTPS.equals(url.getProtocol()) && this.f2192 != null) {
            ((HttpsURLConnection) m1691).setSSLSocketFactory(this.f2192);
        }
        return m1691;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static List<Header> m1686(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new Header(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m1687(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        String str;
        String str2;
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    m1688(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                str2 = "POST";
                httpURLConnection.setRequestMethod(str2);
                m1690(httpURLConnection, request);
                return;
            case 2:
                str2 = "PUT";
                httpURLConnection.setRequestMethod(str2);
                m1690(httpURLConnection, request);
                return;
            case 3:
                str = "DELETE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = "HEAD";
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = "OPTIONS";
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = "TRACE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = HttpClientStack.HttpPatch.METHOD_NAME;
                httpURLConnection.setRequestMethod(str2);
                m1690(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1688(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException, AuthFailureError {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.addRequestProperty("Content-Type", request.getBodyContentType());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m1689(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static void m1690(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            m1688(httpURLConnection, request, body);
        }
    }

    @Override // com.mopub.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String str;
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.getHeaders());
        hashMap.putAll(map);
        if (this.f2191 != null) {
            str = this.f2191.rewriteUrl(url);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
        } else {
            str = url;
        }
        HttpURLConnection m1685 = m1685(new URL(str), request);
        for (String str2 : hashMap.keySet()) {
            m1685.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        m1687(m1685, request);
        int responseCode = m1685.getResponseCode();
        if (responseCode != -1) {
            return !m1689(request.getMethod(), responseCode) ? new HttpResponse(responseCode, m1686(m1685.getHeaderFields())) : new HttpResponse(responseCode, m1686(m1685.getHeaderFields()), m1685.getContentLength(), m1684(m1685));
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected HttpURLConnection m1691(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
