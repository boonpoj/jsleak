package com.mopub.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class VolleyLog {
    public static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable(TAG, 2);

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f2154 = VolleyLog.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.VolleyLog$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0296 {
        public static final boolean ENABLED = VolleyLog.DEBUG;

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final List<C0297> f2155 = new ArrayList();

        /* renamed from: ࢢ  reason: contains not printable characters */
        private boolean f2156 = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.mopub.volley.VolleyLog$ࢠ$ࢠ  reason: contains not printable characters */
        /* loaded from: assets/classes2.dex */
        public static class C0297 {
            public final String name;
            public final long thread;
            public final long time;

            public C0297(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private long m1648() {
            if (this.f2155.size() == 0) {
                return 0L;
            }
            return this.f2155.get(this.f2155.size() - 1).time - this.f2155.get(0).time;
        }

        public synchronized void add(String str, long j) {
            if (this.f2156) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f2155.add(new C0297(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() throws Throwable {
            if (this.f2156) {
                return;
            }
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void finish(String str) {
            this.f2156 = true;
            long m1648 = m1648();
            if (m1648 <= 0) {
                return;
            }
            long j = this.f2155.get(0).time;
            VolleyLog.d("(%-4d ms) %s", Long.valueOf(m1648), str);
            for (C0297 c0297 : this.f2155) {
                long j2 = c0297.time;
                VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0297.thread), c0297.name);
                j = j2;
            }
        }
    }

    public static void d(String str, Object... objArr) {
        Log.d(TAG, m1647(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, m1647(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Log.e(TAG, m1647(str, objArr), th);
    }

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
        DEBUG = Log.isLoggable(TAG, 2);
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, m1647(str, objArr));
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, m1647(str, objArr));
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, m1647(str, objArr), th);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static String m1647(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (!stackTrace[i].getClassName().equals(f2154)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
