package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqj implements zzdpw<zzdpp> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzd */
    public final zzdpp zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdrm zzo = zzdrm.zzo(zzfesVar);
            if (zzo instanceof zzdrm) {
                zzdrm zzdrmVar = zzo;
                zzdvk.zzt(zzdrmVar.getVersion(), 0);
                zzdvk.zzgi(zzdrmVar.zzbmj().size());
                if (zzdrmVar.zzbms().zzbmp() != 12 && zzdrmVar.zzbms().zzbmp() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
                return new zzdty(zzdrmVar.zzbmj().toByteArray(), zzdrmVar.zzbms().zzbmp());
            }
            throw new GeneralSecurityException("expected AesEaxKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpp zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdrm) {
            zzdrm zzdrmVar = (zzdrm) zzfheVar;
            zzdvk.zzt(zzdrmVar.getVersion(), 0);
            zzdvk.zzgi(zzdrmVar.zzbmj().size());
            if (zzdrmVar.zzbms().zzbmp() == 12 || zzdrmVar.zzbms().zzbmp() == 16) {
                return new zzdty(zzdrmVar.zzbmj().toByteArray(), zzdrmVar.zzbms().zzbmp());
            }
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        throw new GeneralSecurityException("expected AesEaxKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdro.zzq(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdro) {
            zzdro zzdroVar = (zzdro) zzfheVar;
            zzdvk.zzgi(zzdroVar.getKeySize());
            if (zzdroVar.zzbms().zzbmp() == 12 || zzdroVar.zzbms().zzbmp() == 16) {
                return zzdrm.zzbmt().zzp(zzfes.zzaz(zzdvi.zzgh(zzdroVar.getKeySize()))).zzb(zzdroVar.zzbms()).zzfk(0).zzcxt();
            }
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.AesEaxKey").zzai(((zzdrm) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.SYMMETRIC).zzcxt();
    }
}
