package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
/* loaded from: classes.dex */
final class zzdqp implements zzdpw<zzdpu> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzf */
    public final zzdpu zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdsi zzx = zzdsi.zzx(zzfesVar);
            if (zzx instanceof zzdsi) {
                zzdsi zzdsiVar = zzx;
                zzdvk.zzt(zzdsiVar.getVersion(), 0);
                zzdqv.zza(zzdsiVar.zzbnq().zzbnj());
                zzdsg zzbnj = zzdsiVar.zzbnq().zzbnj();
                zzdsm zzbnl = zzbnj.zzbnl();
                zzdur zza = zzdqv.zza(zzbnl.zzbny());
                byte[] byteArray = zzdsiVar.zzbmj().toByteArray();
                return new zzduk((ECPrivateKey) KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzdup.zza(zza))), zzbnl.zzboa().toByteArray(), zzdqv.zza(zzbnl.zzbnz()), zzdqv.zza(zzbnj.zzbnn()), new zzdqx(zzbnj.zzbnm().zzbng()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpu zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdsi) {
            zzdsi zzdsiVar = (zzdsi) zzfheVar;
            zzdvk.zzt(zzdsiVar.getVersion(), 0);
            zzdqv.zza(zzdsiVar.zzbnq().zzbnj());
            zzdsg zzbnj = zzdsiVar.zzbnq().zzbnj();
            zzdsm zzbnl = zzbnj.zzbnl();
            zzdur zza = zzdqv.zza(zzbnl.zzbny());
            byte[] byteArray = zzdsiVar.zzbmj().toByteArray();
            return new zzduk((ECPrivateKey) KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzdup.zza(zza))), zzbnl.zzboa().toByteArray(), zzdqv.zza(zzbnl.zzbnz()), zzdqv.zza(zzbnj.zzbnn()), new zzdqx(zzbnj.zzbnm().zzbng()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            return zzb(zzdse.zzw(zzfesVar));
        } catch (zzfge e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdse) {
            zzdse zzdseVar = (zzdse) zzfheVar;
            zzdqv.zza(zzdseVar.zzbnj());
            ECParameterSpec zza = zzdup.zza(zzdqv.zza(zzdseVar.zzbnj().zzbnl().zzbny()));
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(zza);
            KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
            ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
            return zzdsi.zzbnr().zzfo(0).zzb(zzdsk.zzbnv().zzfp(0).zzc(zzdseVar.zzbnj()).zzac(zzfes.zzaz(w.getAffineX().toByteArray())).zzad(zzfes.zzaz(w.getAffineY().toByteArray())).zzcxt()).zzy(zzfes.zzaz(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray())).zzcxt();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        return zzdsy.zzboq().zzoj("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zzai(((zzdsi) zzb(zzfesVar)).toByteString()).zzb(zzdsy.zzb.ASYMMETRIC_PRIVATE).zzcxt();
    }
}
