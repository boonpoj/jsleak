package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbhf;
/* loaded from: classes.dex */
public class zzq {
    private static zzq zzflp;
    private final Context mContext;

    private zzq(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzh zza(PackageInfo packageInfo, zzh... zzhVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzi zziVar = new zzi(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzhVarArr.length; i++) {
            if (zzhVarArr[i].equals(zziVar)) {
                return zzhVarArr[i];
            }
        }
        return null;
    }

    private static boolean zza(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? zza(packageInfo, zzk.zzflf) : zza(packageInfo, zzk.zzflf[0])) != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzb(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        zzi zziVar = new zzi(packageInfo.signatures[0].toByteArray());
        String str = packageInfo.packageName;
        boolean zzb = z ? zzg.zzb(str, zziVar) : zzg.zza(str, zziVar);
        if (!zzb) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("Cert not in list. atk=");
            sb.append(z);
            Log.d("GoogleSignatureVerifier", sb.toString());
        }
        return zzb;
    }

    public static zzq zzci(Context context) {
        zzbq.checkNotNull(context);
        synchronized (zzq.class) {
            if (zzflp == null) {
                zzg.zzcg(context);
                zzflp = new zzq(context);
            }
        }
        return zzflp;
    }

    private final boolean zzfy(String str) {
        try {
            PackageInfo packageInfo = zzbhf.zzdb(this.mContext).getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (zzp.zzch(this.mContext)) {
                return zzb(packageInfo, true);
            }
            boolean zzb = zzb(packageInfo, false);
            if (!zzb && zzb(packageInfo, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return zzb;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public final boolean zza(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (zzp.zzch(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public final boolean zzbq(int i) {
        String[] packagesForUid = zzbhf.zzdb(this.mContext).getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            for (String str : packagesForUid) {
                if (zzfy(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
