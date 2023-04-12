package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;
/* loaded from: classes.dex */
public final class zzx {
    public static boolean zzb(Context context, int i, String str) {
        return zzbhf.zzdb(context).zzf(i, str);
    }

    public static boolean zzf(Context context, int i) {
        if (zzb(context, i, "com.google.android.gms")) {
            try {
                return com.google.android.gms.common.zzq.zzci(context).zza(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            } catch (PackageManager.NameNotFoundException e) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
                return false;
            }
        }
        return false;
    }
}
