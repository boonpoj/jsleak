package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.internal.zzbhf;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: classes.dex */
public class zzf {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zzf zzfkx = new zzf();

    zzf() {
    }

    public static Intent zza(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            return (context == null || !com.google.android.gms.common.util.zzi.zzct(context)) ? zzak.zzt("com.google.android.gms", zzu(context, str)) : zzak.zzaln();
        } else if (i != 3) {
            return null;
        } else {
            return zzak.zzgk("com.google.android.gms");
        }
    }

    public static zzf zzafy() {
        return zzfkx;
    }

    public static void zzcd(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzp.zzbp(context);
    }

    public static void zzce(Context context) {
        zzp.zzce(context);
    }

    public static int zzcf(Context context) {
        return zzp.zzcf(context);
    }

    public static boolean zze(Context context, int i) {
        return zzp.zze(context, i);
    }

    private static String zzu(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(zzbhf.zzdb(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, null);
    }

    public String getErrorString(int i) {
        return zzp.getErrorString(i);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = zzp.isGooglePlayServicesAvailable(context);
        if (zzp.zze(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int i) {
        return zzp.isUserRecoverableError(i);
    }

    public final PendingIntent zza(Context context, int i, int i2, String str) {
        Intent zza = zza(context, i, str);
        if (zza == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, zza, SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    @Deprecated
    public final Intent zzbp(int i) {
        return zza(null, i, null);
    }
}
