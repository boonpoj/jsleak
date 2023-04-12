package com.mopub.mobileads;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.CacheService;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: assets/classes2.dex */
public class VideoDownloader {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Deque<WeakReference<AsyncTaskC0214>> f1157 = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.VideoDownloader$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0213 {
        void onComplete(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mobileads.VideoDownloader$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class AsyncTaskC0214 extends AsyncTask<String, Void, Boolean> {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final InterfaceC0213 f1158;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final WeakReference<AsyncTaskC0214> f1159 = new WeakReference<>(this);

        @VisibleForTesting
        AsyncTaskC0214(@NonNull InterfaceC0213 interfaceC0213) {
            this.f1158 = interfaceC0213;
            VideoDownloader.f1157.add(this.f1159);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            MoPubLog.d("VideoDownloader task was cancelled.");
            VideoDownloader.f1157.remove(this.f1159);
            this.f1158.onComplete(false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public Boolean doInBackground(String... strArr) {
            HttpURLConnection httpURLConnection;
            BufferedInputStream bufferedInputStream;
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                MoPubLog.d("VideoDownloader task tried to execute null or empty url.");
                return false;
            }
            String str = strArr[0];
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    httpURLConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
                    try {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
                bufferedInputStream = null;
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    int contentLength = httpURLConnection.getContentLength();
                    if (contentLength > 26214400) {
                        MoPubLog.d(String.format("VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).", Integer.valueOf(contentLength), 26214400));
                        Streams.closeStream(bufferedInputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    }
                    Boolean valueOf = Boolean.valueOf(CacheService.putToDiskCache(str, bufferedInputStream));
                    Streams.closeStream(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return valueOf;
                }
                MoPubLog.d("VideoDownloader encountered unexpected statusCode: " + responseCode);
                Streams.closeStream(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream2 = bufferedInputStream;
                MoPubLog.d("VideoDownloader task threw an internal exception.", e);
                Streams.closeStream(bufferedInputStream2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                Streams.closeStream(bufferedInputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void onPostExecute(Boolean bool) {
            if (isCancelled()) {
                onCancelled();
                return;
            }
            VideoDownloader.f1157.remove(this.f1159);
            if (bool == null) {
                this.f1158.onComplete(false);
            } else {
                this.f1158.onComplete(bool.booleanValue());
            }
        }
    }

    private VideoDownloader() {
    }

    public static void cache(@Nullable String str, @NonNull InterfaceC0213 interfaceC0213) {
        Preconditions.checkNotNull(interfaceC0213);
        if (str == null) {
            MoPubLog.d("VideoDownloader attempted to cache video with null url.");
            interfaceC0213.onComplete(false);
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0214(interfaceC0213), str);
        } catch (Exception unused) {
            interfaceC0213.onComplete(false);
        }
    }

    public static void cancelAllDownloaderTasks() {
        for (WeakReference<AsyncTaskC0214> weakReference : f1157) {
            m991(weakReference);
        }
        f1157.clear();
    }

    public static void cancelLastDownloadTask() {
        if (f1157.isEmpty()) {
            return;
        }
        m991(f1157.peekLast());
        f1157.removeLast();
    }

    @VisibleForTesting
    @Deprecated
    public static void clearDownloaderTasks() {
        f1157.clear();
    }

    @VisibleForTesting
    @Deprecated
    public static Deque<WeakReference<AsyncTaskC0214>> getDownloaderTasks() {
        return f1157;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m991(@Nullable WeakReference<AsyncTaskC0214> weakReference) {
        AsyncTaskC0214 asyncTaskC0214;
        if (weakReference == null || (asyncTaskC0214 = weakReference.get()) == null) {
            return false;
        }
        return asyncTaskC0214.cancel(true);
    }
}
