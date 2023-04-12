package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import com.google.android.gms.internal.zzdth;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
public final class zzdqb {
    @Deprecated
    public static final zzdpx zzad(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdth zzaf = zzdth.zzaf(bArr);
            for (zzdth.zzb zzbVar : zzaf.zzbpd()) {
                if (zzbVar.zzbph().zzbop() == zzdsy.zzb.UNKNOWN_KEYMATERIAL || zzbVar.zzbph().zzbop() == zzdsy.zzb.SYMMETRIC || zzbVar.zzbph().zzbop() == zzdsy.zzb.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzdpx.zza(zzaf);
        } catch (zzfge e) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
