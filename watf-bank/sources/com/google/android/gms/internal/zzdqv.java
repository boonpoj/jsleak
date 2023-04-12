package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
final class zzdqv {
    public static zzdur zza(zzdso zzdsoVar) throws GeneralSecurityException {
        int i = zzdqw.zzltg[zzdsoVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return zzdur.NIST_P521;
                }
                String valueOf = String.valueOf(zzdsoVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
            return zzdur.NIST_P384;
        }
        return zzdur.NIST_P256;
    }

    public static zzdus zza(zzdsa zzdsaVar) throws GeneralSecurityException {
        int i = zzdqw.zzlth[zzdsaVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return zzdus.COMPRESSED;
            }
            String valueOf = String.valueOf(zzdsaVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("unknown point format: ");
            sb.append(valueOf);
            throw new GeneralSecurityException(sb.toString());
        }
        return zzdus.UNCOMPRESSED;
    }

    public static String zza(zzdsq zzdsqVar) throws NoSuchAlgorithmException {
        int i = zzdqw.zzltf[zzdsqVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "HmacSha512";
                }
                String valueOf = String.valueOf(zzdsqVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
            }
            return "HmacSha256";
        }
        return "HmacSha1";
    }

    public static void zza(zzdsg zzdsgVar) throws GeneralSecurityException {
        zzdup.zza(zza(zzdsgVar.zzbnl().zzbny()));
        zza(zzdsgVar.zzbnl().zzbnz());
        if (zzdsgVar.zzbnn() == zzdsa.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzdqe.zza(zzdsgVar.zzbnm().zzbng());
    }
}
