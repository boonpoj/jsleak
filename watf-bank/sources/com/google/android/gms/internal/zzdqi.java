package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdqi implements zzdpw<zzdvf> {
    private static void zza(zzdrk zzdrkVar) throws GeneralSecurityException {
        if (zzdrkVar.zzbmp() < 12 || zzdrkVar.zzbmp() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zze */
    public final zzdtx zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdrg zzl = zzdrg.zzl(zzfesVar);
            if (zzl instanceof zzdrg) {
                zzdrg zzdrgVar = zzl;
                zzdvk.zzt(zzdrgVar.getVersion(), 0);
                zzdvk.zzgi(zzdrgVar.zzbmj().size());
                zza(zzdrgVar.zzbmi());
                return new zzdtx(zzdrgVar.zzbmj().toByteArray(), zzdrgVar.zzbmi().zzbmp());
            }
            throw new GeneralSecurityException("expected AesCtrKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdvf zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdrg) {
            zzdrg zzdrgVar = (zzdrg) zzfheVar;
            zzdvk.zzt(zzdrgVar.getVersion(), 0);
            zzdvk.zzgi(zzdrgVar.zzbmj().size());
            zza(zzdrgVar.zzbmi());
            return new zzdtx(zzdrgVar.zzbmj().toByteArray(), zzdrgVar.zzbmi().zzbmp());
        }
        throw new GeneralSecurityException("expected AesCtrKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdri.zzn(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdri) {
            zzdri zzdriVar = (zzdri) zzfheVar;
            zzdvk.zzgi(zzdriVar.getKeySize());
            zza(zzdriVar.zzbmi());
            return zzdrg.zzbmk().zzc(zzdriVar.zzbmi()).zzm(zzfes.zzaz(zzdvi.zzgh(zzdriVar.getKeySize()))).zzfj(0).zzcxt();
        }
        throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.AesCtrKey").zzai(((zzdrg) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.SYMMETRIC).zzcxt();
    }
}
