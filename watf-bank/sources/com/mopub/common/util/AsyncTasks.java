package com.mopub.common.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
public class AsyncTasks {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Executor f610;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Handler f611;

    static {
        m582();
    }

    public static <P> void safeExecuteOnExecutor(@NonNull final AsyncTask<P, ?, ?> asyncTask, @Nullable final P... pArr) {
        Preconditions.checkNotNull(asyncTask, "Unable to execute null AsyncTask.");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            asyncTask.executeOnExecutor(f610, pArr);
            return;
        }
        MoPubLog.d("Posting AsyncTask to main thread for execution.");
        f611.post(new Runnable() { // from class: com.mopub.common.util.AsyncTasks.1
            @Override // java.lang.Runnable
            public void run() {
                asyncTask.executeOnExecutor(AsyncTasks.f610, pArr);
            }
        });
    }

    @VisibleForTesting
    public static void setExecutor(Executor executor) {
        f610 = executor;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static void m582() {
        f610 = AsyncTask.THREAD_POOL_EXECUTOR;
        f611 = new Handler(Looper.getMainLooper());
    }
}
