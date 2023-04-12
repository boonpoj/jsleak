package com.google.android.gms.internal;

import android.os.StrictMode;
import java.util.concurrent.Callable;
/* loaded from: assets/classes2.dex */
public class zzaps {
    public static <T> T zzb(Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            T call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable unused) {
            StrictMode.setThreadPolicy(threadPolicy);
            return null;
        }
    }
}
