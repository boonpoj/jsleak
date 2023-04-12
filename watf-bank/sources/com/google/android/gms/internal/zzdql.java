package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class zzdql implements zzdpw<zzdpp> {
    private static zzdry zzblz() throws GeneralSecurityException {
        return zzdry.zzbne().zzfm(0).zzv(zzfes.zzaz(zzdvi.zzgh(32))).zzcxt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzd */
    public final zzdpp zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdry zzu = zzdry.zzu(zzfesVar);
            if (zzu instanceof zzdry) {
                zzdry zzdryVar = zzu;
                zzdvk.zzt(zzdryVar.getVersion(), 0);
                if (zzdryVar.zzbmj().size() == 32) {
                    return zzdug.zzak(zzdryVar.zzbmj().toByteArray());
                }
                throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
            }
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpp zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdry) {
            zzdry zzdryVar = (zzdry) zzfheVar;
            zzdvk.zzt(zzdryVar.getVersion(), 0);
            if (zzdryVar.zzbmj().size() == 32) {
                return zzdug.zzak(zzdryVar.zzbmj().toByteArray());
            }
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
        throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        return zzblz();
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        return zzblz();
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").zzai(zzblz().toByteString()).zzb(zzdsy.zzb.SYMMETRIC).zzcxt();
    }
}
