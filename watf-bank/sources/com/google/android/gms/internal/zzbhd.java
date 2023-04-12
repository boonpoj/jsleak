package com.google.android.gms.internal;

import android.content.Context;
/* loaded from: classes.dex */
public final class zzbhd {
    private static Context zzgfe;
    private static Boolean zzgff;

    public static synchronized boolean zzcz(Context context) {
        boolean z;
        synchronized (zzbhd.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzgfe != null && zzgff != null && zzgfe == applicationContext) {
                return zzgff.booleanValue();
            }
            zzgff = null;
            if (!com.google.android.gms.common.util.zzq.isAtLeastO()) {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    zzgff = true;
                } catch (ClassNotFoundException e) {
                    z = false;
                }
                zzgfe = applicationContext;
                return zzgff.booleanValue();
            }
            z = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            zzgff = z;
            zzgfe = applicationContext;
            return zzgff.booleanValue();
        }
    }
}
