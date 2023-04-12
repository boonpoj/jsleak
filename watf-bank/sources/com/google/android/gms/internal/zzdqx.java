package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrg;
import com.google.android.gms.internal.zzdrs;
import com.google.android.gms.internal.zzdss;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* loaded from: classes.dex */
final class zzdqx implements zzduj {
    private final String zzlti;
    private final int zzltj;
    private zzdrs zzltk;
    private zzdrc zzltl;
    private int zzltm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdqx(zzdtd zzdtdVar) throws GeneralSecurityException {
        this.zzlti = zzdtdVar.zzbon();
        if (this.zzlti.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdru zzt = zzdru.zzt(zzdtdVar.zzboo());
                this.zzltk = (zzdrs) zzdqe.zzb(zzdtdVar);
                this.zzltj = zzt.getKeySize();
            } catch (zzfge e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (!this.zzlti.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            String valueOf = String.valueOf(this.zzlti);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        } else {
            try {
                zzdre zzj = zzdre.zzj(zzdtdVar.zzboo());
                this.zzltl = (zzdrc) zzdqe.zzb(zzdtdVar);
                this.zzltm = zzj.zzbmf().getKeySize();
                this.zzltj = this.zzltm + zzj.zzbmg().getKeySize();
            } catch (zzfge e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzduj
    public final zzdpp zzae(byte[] bArr) throws GeneralSecurityException {
        zzdrc zzcxt;
        if (this.zzlti.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            zzcxt = zzdrs.zzbmy().zza((zzdrs.zza) this.zzltk).zzs(zzfes.zzaz(bArr)).zzcxt();
        } else if (!this.zzlti.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new GeneralSecurityException("unknown DEM key type");
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzltm);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzltm, this.zzltj);
            zzcxt = zzdrc.zzbmd().zzfi(this.zzltl.getVersion()).zzb(zzdrg.zzbmk().zza((zzdrg.zza) this.zzltl.zzbmb()).zzm(zzfes.zzaz(copyOfRange)).zzcxt()).zzb(zzdss.zzboe().zza((zzdss.zza) this.zzltl.zzbmc()).zzaf(zzfes.zzaz(copyOfRange2)).zzcxt()).zzcxt();
        }
        return (zzdpp) zzdqe.zzb(this.zzlti, zzcxt);
    }

    @Override // com.google.android.gms.internal.zzduj
    public final int zzbma() {
        return this.zzltj;
    }
}
