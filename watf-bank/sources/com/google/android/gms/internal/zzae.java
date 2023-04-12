package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class zzae {
    private static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable("Volley", 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
      assets/classes2.dex
     */
    /* loaded from: classes.dex */
    public static class zza {
        public static final boolean zzbl = zzae.DEBUG;
        private final List<zzaf> zzbm = new ArrayList();
        private boolean zzbn = false;

        protected final void finalize() throws Throwable {
            if (this.zzbn) {
                return;
            }
            zzc("Request on the loose");
            zzae.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public final synchronized void zza(String str, long j) {
            if (this.zzbn) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzbm.add(new zzaf(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void zzc(String str) {
            this.zzbn = true;
            long j = this.zzbm.size() == 0 ? 0L : this.zzbm.get(this.zzbm.size() - 1).time - this.zzbm.get(0).time;
            if (j <= 0) {
                return;
            }
            long j2 = this.zzbm.get(0).time;
            zzae.zzb("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzaf zzafVar : this.zzbm) {
                long j3 = zzafVar.time;
                zzae.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zzafVar.zzbo), zzafVar.name);
                j2 = j3;
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(zzae.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
