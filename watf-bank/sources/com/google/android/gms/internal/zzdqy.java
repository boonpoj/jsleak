package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
final class zzdqy implements zzdpw<zzdqa> {
    private static void zza(zzdsw zzdswVar) throws GeneralSecurityException {
        if (zzdswVar.zzbok() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = zzdqz.zzltf[zzdswVar.zzboj().ordinal()];
        if (i == 1) {
            if (zzdswVar.zzbok() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 2) {
            if (zzdswVar.zzbok() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i != 3) {
            throw new GeneralSecurityException("unknown hash type");
        } else {
            if (zzdswVar.zzbok() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzh */
    public final zzdqa zza(zzfes zzfesVar) throws GeneralSecurityException {
        zzdvg zzdvgVar;
        try {
            zzdss zzae = zzdss.zzae(zzfesVar);
            if (zzae instanceof zzdss) {
                zzdss zzdssVar = zzae;
                zzdvk.zzt(zzdssVar.getVersion(), 0);
                if (zzdssVar.zzbmj().size() >= 16) {
                    zza(zzdssVar.zzbod());
                    zzdsq zzboj = zzdssVar.zzbod().zzboj();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(zzdssVar.zzbmj().toByteArray(), "HMAC");
                    int zzbok = zzdssVar.zzbod().zzbok();
                    int i = zzdqz.zzltf[zzboj.ordinal()];
                    if (i == 1) {
                        zzdvgVar = new zzdvg("HMACSHA1", secretKeySpec, zzbok);
                    } else if (i == 2) {
                        zzdvgVar = new zzdvg("HMACSHA256", secretKeySpec, zzbok);
                    } else if (i != 3) {
                        throw new GeneralSecurityException("unknown hash");
                    } else {
                        zzdvgVar = new zzdvg("HMACSHA512", secretKeySpec, zzbok);
                    }
                    return zzdvgVar;
                }
                throw new GeneralSecurityException("key too short");
            }
            throw new GeneralSecurityException("expected HmacKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdqa zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdss) {
            zzdss zzdssVar = (zzdss) zzfheVar;
            zzdvk.zzt(zzdssVar.getVersion(), 0);
            if (zzdssVar.zzbmj().size() >= 16) {
                zza(zzdssVar.zzbod());
                zzdsq zzboj = zzdssVar.zzbod().zzboj();
                SecretKeySpec secretKeySpec = new SecretKeySpec(zzdssVar.zzbmj().toByteArray(), "HMAC");
                int zzbok = zzdssVar.zzbod().zzbok();
                int i = zzdqz.zzltf[zzboj.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return new zzdvg("HMACSHA512", secretKeySpec, zzbok);
                        }
                        throw new GeneralSecurityException("unknown hash");
                    }
                    return new zzdvg("HMACSHA256", secretKeySpec, zzbok);
                }
                return new zzdvg("HMACSHA1", secretKeySpec, zzbok);
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdsu.zzag(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdsu) {
            zzdsu zzdsuVar = (zzdsu) zzfheVar;
            if (zzdsuVar.getKeySize() >= 16) {
                zza(zzdsuVar.zzbod());
                return zzdss.zzboe().zzfs(0).zzc(zzdsuVar.zzbod()).zzaf(zzfes.zzaz(zzdvi.zzgh(zzdsuVar.getKeySize()))).zzcxt();
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.HmacKey").zzai(((zzdss) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.SYMMETRIC).zzcxt();
    }
}
