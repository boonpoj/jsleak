package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzbhf;
/* loaded from: classes.dex */
public final class zzbf {
    private static Object sLock = new Object();
    private static boolean zzcls;
    private static String zzgbc;
    private static int zzgbd;

    public static String zzcp(Context context) {
        zzcr(context);
        return zzgbc;
    }

    public static int zzcq(Context context) {
        zzcr(context);
        return zzgbd;
    }

    private static void zzcr(Context context) {
        Bundle bundle;
        synchronized (sLock) {
            if (zzcls) {
                return;
            }
            zzcls = true;
            try {
                bundle = zzbhf.zzdb(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            zzgbc = bundle.getString("com.google.app.id");
            zzgbd = bundle.getInt("com.google.android.gms.version");
        }
    }
}
