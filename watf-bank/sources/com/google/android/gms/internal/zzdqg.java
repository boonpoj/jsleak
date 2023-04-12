package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtv;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
public final class zzdqg {
    public static final zzdtv zzlta = zzdtv.zzbqg().zza((zzdtv.zza) zzdrb.zzlta).zzb(zzdpr.zza("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).zzb(zzdpr.zza("TinkAead", "Aead", "AesEaxKey", 0, true)).zzb(zzdpr.zza("TinkAead", "Aead", "AesGcmKey", 0, true)).zzb(zzdpr.zza("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).zzb(zzdpr.zza("TinkAead", "Aead", "KmsAeadKey", 0, true)).zzb(zzdpr.zza("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).zzor("TINK_AEAD_1_0_0").zzcxt();

    static {
        try {
            zzbly();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzbly() throws GeneralSecurityException {
        zzdqe.zza("TinkAead", new zzdqf());
        zzdrb.zzbly();
    }
}
