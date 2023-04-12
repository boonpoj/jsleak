package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
@VisibleForTesting
/* loaded from: assets/classes2.dex */
public class UrlResolutionTask extends AsyncTask<String, Void, String> {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InterfaceC0172 f440;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.UrlResolutionTask$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0172 {
        void onFailure(@NonNull String str, @Nullable Throwable th);

        void onSuccess(@NonNull String str);
    }

    UrlResolutionTask(@NonNull InterfaceC0172 interfaceC0172) {
        this.f440 = interfaceC0172;
    }

    public static void getResolvedUrl(@NonNull String str, @NonNull InterfaceC0172 interfaceC0172) {
        try {
            AsyncTasks.safeExecuteOnExecutor(new UrlResolutionTask(interfaceC0172), str);
        } catch (Exception e) {
            interfaceC0172.onFailure("Failed to resolve url", e);
        }
    }

    @Nullable
    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static String m470(@NonNull String str, @NonNull HttpURLConnection httpURLConnection) throws IOException, URISyntaxException {
        URI uri = new URI(str);
        int responseCode = httpURLConnection.getResponseCode();
        String headerField = httpURLConnection.getHeaderField("location");
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return uri.resolve(headerField).toString();
        } catch (IllegalArgumentException unused) {
            MoPubLog.d("Invalid URL redirection. baseUrl=" + str + "\n redirectUrl=" + headerField);
            throw new URISyntaxException(headerField, "Unable to parse invalid URL");
        } catch (NullPointerException e) {
            MoPubLog.d("Invalid URL redirection. baseUrl=" + str + "\n redirectUrl=" + headerField);
            throw e;
        }
    }

    @Nullable
    /* renamed from: ࢢ  reason: contains not printable characters */
    private String m471(@NonNull String str) throws IOException, URISyntaxException {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                String m470 = m470(str, httpURLConnection);
                if (httpURLConnection != null) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            MoPubLog.d("IOException when closing httpUrlConnection. Ignoring.");
                        }
                    }
                    httpURLConnection.disconnect();
                }
                return m470;
            } catch (Throwable th) {
                th = th;
                if (httpURLConnection != null) {
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused2) {
                            MoPubLog.d("IOException when closing httpUrlConnection. Ignoring.");
                        }
                    }
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f440.onFailure("Task for resolving url was cancelled", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    public String doInBackground(@Nullable String... strArr) {
        if (strArr != null && strArr.length != 0) {
            int i = 0;
            try {
                String str = strArr[0];
                String str2 = null;
                while (str != null && i < 10) {
                    if (!UrlAction.OPEN_IN_APP_BROWSER.shouldTryHandlingUrl(Uri.parse(str)) || UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(Uri.parse(str))) {
                        return str;
                    }
                    i++;
                    str2 = str;
                    str = m471(str);
                }
                return str2;
            } catch (IOException | NullPointerException | URISyntaxException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void onPostExecute(@Nullable String str) {
        super.onPostExecute(str);
        if (isCancelled() || str == null) {
            onCancelled();
        } else {
            this.f440.onSuccess(str);
        }
    }
}
