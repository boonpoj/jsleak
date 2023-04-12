package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtv;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
public final class zzdqs {
    public static final zzdtv zzlta = zzdtv.zzbqg().zza((zzdtv.zza) zzdqg.zzlta).zzb(zzdpr.zza("TinkHybrid", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).zzb(zzdpr.zza("TinkHybrid", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).zzor("TINK_HYBRID_1_0_0").zzcxt();

    static {
        try {
            zzdqe.zza("TinkHybrid", new zzdqr());
            zzdqg.zzbly();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
