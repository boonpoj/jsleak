package com.integralads.avid.library.ࢠ;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.integralads.avid.library.ࢠ.ࢧ.C0141;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/* renamed from: com.integralads.avid.library.ࢠ.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class AsyncTaskC0137 extends AsyncTask<String, Void, String> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private InterfaceC0139 f225;

    /* renamed from: com.integralads.avid.library.ࢠ.ࢧ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0139 {
        /* renamed from: ࢠ */
        void mo110(String str);

        /* renamed from: ࢣ */
        void mo112();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.f225 != null) {
            this.f225.mo112();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String doInBackground(String... strArr) {
        BufferedInputStream bufferedInputStream;
        String str = strArr[0];
        InputStream inputStream = null;
        try {
            if (TextUtils.isEmpty(str)) {
                C0141.m276("AvidLoader: URL is empty");
                return null;
            }
            try {
                URLConnection openConnection = new URL(str).openConnection();
                openConnection.connect();
                bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
                try {
                    StringWriter stringWriter = new StringWriter();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            String obj = stringWriter.toString();
                            try {
                                bufferedInputStream.close();
                                return obj;
                            } catch (IOException e) {
                                C0141.m277("AvidLoader: can not close Stream", e);
                                return null;
                            }
                        }
                        stringWriter.write(new String(bArr, 0, read));
                    }
                } catch (MalformedURLException unused) {
                    C0141.m276("AvidLoader: something is wrong with the URL '" + str + "'");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            C0141.m277("AvidLoader: can not close Stream", e2);
                        }
                    }
                    return null;
                } catch (IOException e3) {
                    e = e3;
                    C0141.m276("AvidLoader: IO error " + e.getLocalizedMessage());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            C0141.m277("AvidLoader: can not close Stream", e4);
                        }
                    }
                    return null;
                }
            } catch (MalformedURLException unused2) {
                bufferedInputStream = null;
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        C0141.m277("AvidLoader: can not close Stream", e6);
                        return null;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m251(InterfaceC0139 interfaceC0139) {
        this.f225 = interfaceC0139;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(String str) {
        if (this.f225 != null) {
            if (TextUtils.isEmpty(str)) {
                this.f225.mo112();
            } else {
                this.f225.mo110(str);
            }
        }
    }
}
