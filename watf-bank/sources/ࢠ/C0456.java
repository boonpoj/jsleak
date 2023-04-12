package ࢠ;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* renamed from: ࢠ.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0456 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final C0456 f2904 = new C0456();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ExecutorService f2905;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final ScheduledExecutorService f2906;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Executor f2907;

    /* renamed from: ࢠ.ࢤ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class ExecutorC0457 implements Executor {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private ThreadLocal<Integer> f2908;

        private ExecutorC0457() {
            this.f2908 = new ThreadLocal<>();
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private int m2295() {
            Integer num = this.f2908.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f2908.set(Integer.valueOf(intValue));
            return intValue;
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        private int m2296() {
            Integer num = this.f2908.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f2908.remove();
            } else {
                this.f2908.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (m2295() <= 15) {
                    runnable.run();
                } else {
                    C0456.m2292().execute(runnable);
                }
                m2296();
            } catch (Throwable th) {
                m2296();
                throw th;
            }
        }
    }

    private C0456() {
        this.f2905 = !m2294() ? Executors.newCachedThreadPool() : C0451.m2287();
        this.f2906 = Executors.newSingleThreadScheduledExecutor();
        this.f2907 = new ExecutorC0457();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static ExecutorService m2292() {
        return f2904.f2905;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static Executor m2293() {
        return f2904.f2907;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean m2294() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
