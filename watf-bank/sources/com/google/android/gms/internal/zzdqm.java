package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqm implements zzdpw<zzdpp> {
    private static zzdpp zzc(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdtl) {
            zzdtl zzdtlVar = (zzdtl) zzfheVar;
            zzdvk.zzt(zzdtlVar.getVersion(), 0);
            String zzbpv = zzdtlVar.zzbps().zzbpv();
            return zzdpz.zzof(zzbpv).zzoe(zzbpv);
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }

    private static zzdpp zzd(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzc(zzdtl.zzaj(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpp zza(zzfes zzfesVar) throws GeneralSecurityException {
        return zzd(zzfesVar);
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpp zza(zzfhe zzfheVar) throws GeneralSecurityException {
        return zzc(zzfheVar);
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdtn.zzak(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdtn) {
            return zzdtl.zzbpt().zzb((zzdtn) zzfheVar).zzgb(0).zzcxt();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.KmsAeadKey").zzai(((zzdtl) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.REMOTE).zzcxt();
    }
}
