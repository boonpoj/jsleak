package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbz {
    static zzdpv zzzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzab() {
        if (zzzb != null) {
            return true;
        }
        String str = (String) zzkb.zzif().zzd(zznh.zzbnt);
        if (str.length() == 0) {
            return false;
        }
        try {
            try {
                zzdpx zzad = zzdqb.zzad(zzbu.zza(str, true));
                for (zzdtf zzdtfVar : zzdqs.zzlta.zzbqf()) {
                    if (zzdtfVar.zzbon().isEmpty()) {
                        throw new GeneralSecurityException("Missing type_url.");
                    }
                    if (zzdtfVar.zzbov().isEmpty()) {
                        throw new GeneralSecurityException("Missing primitive_name.");
                    }
                    if (zzdtfVar.zzboy().isEmpty()) {
                        throw new GeneralSecurityException("Missing catalogue_name.");
                    }
                    zzdqe.zza(zzdtfVar.zzbon(), zzdqe.zzog(zzdtfVar.zzboy()).zzd(zzdtfVar.zzbon(), zzdtfVar.zzbov(), zzdtfVar.zzbow()), zzdtfVar.zzbox());
                }
                zzzb = zzdqt.zza(zzad);
                return zzzb != null;
            } catch (GeneralSecurityException e) {
                return false;
            }
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }
}
