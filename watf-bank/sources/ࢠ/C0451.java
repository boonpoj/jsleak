package ࢠ;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0451 {

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Executor f2896 = new ExecutorC0452();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static final C0451 f2894 = new C0451();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static final int f2895 = Runtime.getRuntime().availableProcessors();

    /* renamed from: ࢠ  reason: contains not printable characters */
    static final int f2892 = f2895 + 1;

    /* renamed from: ࢢ  reason: contains not printable characters */
    static final int f2893 = (f2895 * 2) + 1;

    /* renamed from: ࢠ.ࢠ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class ExecutorC0452 implements Executor {
        private ExecutorC0452() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private C0451() {
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static ExecutorService m2287() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f2892, f2893, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m2288(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2288(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static Executor m2289() {
        return f2894.f2896;
    }
}
