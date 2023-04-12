package com.ࢢ.ࢠ.ࢠ.ࢠ;

import com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ.C0370;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ށ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0346 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0370<String> m1951(String str) {
        InputStream inputStream = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() >= 400) {
                    return C0370.m2033();
                }
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    C0370<String> m2034 = C0370.m2034(m1952(inputStream2));
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    return m2034;
                } catch (IOException unused2) {
                    inputStream = inputStream2;
                    C0370<String> m2033 = C0370.m2033();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return m2033;
                } catch (Throwable th) {
                    inputStream = inputStream2;
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused5) {
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m1952(InputStream inputStream) throws IOException {
        char[] cArr = new char[256];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        int i = 0;
        do {
            int read = inputStreamReader.read(cArr, 0, 256);
            if (read <= 0) {
                break;
            }
            i += read;
            sb.append(cArr, 0, read);
        } while (i < 1024);
        return sb.toString();
    }
}
