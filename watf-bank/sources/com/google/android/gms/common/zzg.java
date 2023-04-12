package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbb;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamite.DynamiteModule;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzg {
    private static zzba zzfky;
    private static final Object zzfkz = new Object();
    private static Context zzfla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(String str, zzh zzhVar) {
        return zza(str, zzhVar, false);
    }

    private static boolean zza(String str, zzh zzhVar, boolean z) {
        if (zzafz()) {
            zzbq.checkNotNull(zzfla);
            try {
                return zzfky.zza(new zzn(str, zzhVar, z), com.google.android.gms.dynamic.zzn.zzz(zzfla.getPackageManager()));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return false;
            }
        }
        return false;
    }

    private static boolean zzafz() {
        if (zzfky != null) {
            return true;
        }
        zzbq.checkNotNull(zzfla);
        synchronized (zzfkz) {
            if (zzfky == null) {
                try {
                    zzfky = zzbb.zzan(DynamiteModule.zza(zzfla, DynamiteModule.zzgwz, "com.google.android.gms.googlecertificates").zzhb("com.google.android.gms.common.GoogleCertificatesImpl"));
                } catch (DynamiteModule.zzc e) {
                    Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(String str, zzh zzhVar) {
        return zza(str, zzhVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzcg(Context context) {
        synchronized (zzg.class) {
            if (zzfla != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzfla = context.getApplicationContext();
            }
        }
    }
}
