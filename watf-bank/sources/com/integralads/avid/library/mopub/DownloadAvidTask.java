package com.integralads.avid.library.mopub;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.integralads.avid.library.mopub.utils.AvidLogs;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/* loaded from: assets/classes2.dex */
public class DownloadAvidTask extends AsyncTask<String, Void, String> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private DownloadAvidTaskListener f33;

    /* loaded from: assets/classes2.dex */
    public interface DownloadAvidTaskListener {
        void failedToLoadAvid();

        void onLoadAvid(String str);
    }

    public DownloadAvidTaskListener getListener() {
        return this.f33;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.f33 != null) {
            this.f33.failedToLoadAvid();
        }
    }

    public void setListener(DownloadAvidTaskListener downloadAvidTaskListener) {
        this.f33 = downloadAvidTaskListener;
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
                AvidLogs.e("AvidLoader: URL is empty");
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
                                AvidLogs.e("AvidLoader: can not close Stream", e);
                                return null;
                            }
                        }
                        stringWriter.write(new String(bArr, 0, read));
                    }
                } catch (MalformedURLException unused) {
                    AvidLogs.e("AvidLoader: something is wrong with the URL '" + str + "'");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            AvidLogs.e("AvidLoader: can not close Stream", e2);
                        }
                    }
                    return null;
                } catch (IOException e3) {
                    e = e3;
                    AvidLogs.e("AvidLoader: IO error " + e.getLocalizedMessage());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            AvidLogs.e("AvidLoader: can not close Stream", e4);
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
                        AvidLogs.e("AvidLoader: can not close Stream", e6);
                        return null;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(String str) {
        if (this.f33 != null) {
            if (TextUtils.isEmpty(str)) {
                this.f33.failedToLoadAvid();
            } else {
                this.f33.onLoadAvid(str);
            }
        }
    }
}
