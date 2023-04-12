package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;
/* loaded from: classes.dex */
class zzdqh implements zzdpw<zzdpp> {
    private static final Logger logger = Logger.getLogger(zzdqh.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdqh() throws GeneralSecurityException {
        zzdqe.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", new zzdqi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzd */
    public final zzdpp zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdrc zzi = zzdrc.zzi(zzfesVar);
            if (zzi instanceof zzdrc) {
                zzdrc zzdrcVar = zzi;
                zzdvk.zzt(zzdrcVar.getVersion(), 0);
                return new zzdut((zzdvf) zzdqe.zzb("type.googleapis.com/google.crypto.tink.AesCtrKey", zzdrcVar.zzbmb()), (zzdqa) zzdqe.zzb("type.googleapis.com/google.crypto.tink.HmacKey", zzdrcVar.zzbmc()), zzdrcVar.zzbmc().zzbod().zzbok());
            }
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpp zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdrc) {
            zzdrc zzdrcVar = (zzdrc) zzfheVar;
            zzdvk.zzt(zzdrcVar.getVersion(), 0);
            return new zzdut((zzdvf) zzdqe.zzb("type.googleapis.com/google.crypto.tink.AesCtrKey", zzdrcVar.zzbmb()), (zzdqa) zzdqe.zzb("type.googleapis.com/google.crypto.tink.HmacKey", zzdrcVar.zzbmc()), zzdrcVar.zzbmc().zzbod().zzbok());
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdre.zzj(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdre) {
            zzdre zzdreVar = (zzdre) zzfheVar;
            return zzdrc.zzbmd().zzb((zzdrg) zzdqe.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", zzdreVar.zzbmf())).zzb((zzdss) zzdqe.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzdreVar.zzbmg())).zzfi(0).zzcxt();
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").zzai(((zzdrc) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.SYMMETRIC).zzcxt();
    }
}
