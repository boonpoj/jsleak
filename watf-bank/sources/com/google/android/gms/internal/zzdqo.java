package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqo implements zzdpw<zzdpp> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzd */
    public final zzdpp zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdtp zzal = zzdtp.zzal(zzfesVar);
            if (zzal instanceof zzdtp) {
                zzdtp zzdtpVar = zzal;
                zzdvk.zzt(zzdtpVar.getVersion(), 0);
                String zzbqb = zzdtpVar.zzbpy().zzbqb();
                return new zzdqn(zzdtpVar.zzbpy().zzbqc(), zzdpz.zzof(zzbqb).zzoe(zzbqb));
            }
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpp zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdtp) {
            zzdtp zzdtpVar = (zzdtp) zzfheVar;
            zzdvk.zzt(zzdtpVar.getVersion(), 0);
            String zzbqb = zzdtpVar.zzbpy().zzbqb();
            return new zzdqn(zzdtpVar.zzbpy().zzbqc(), zzdpz.zzof(zzbqb).zzoe(zzbqb));
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdtr.zzam(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdtr) {
            return zzdtp.zzbpz().zzb((zzdtr) zzfheVar).zzgc(0).zzcxt();
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").zzai(((zzdtp) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.REMOTE).zzcxt();
    }
}
