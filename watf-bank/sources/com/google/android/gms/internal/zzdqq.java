package com.google.android.gms.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
/* loaded from: classes.dex */
final class zzdqq implements zzdpw<zzdpv> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzdpw
    /* renamed from: zzg */
    public final zzdpv zza(zzfes zzfesVar) throws GeneralSecurityException {
        try {
            zzdsk zzab = zzdsk.zzab(zzfesVar);
            if (zzab instanceof zzdsk) {
                zzdsk zzdskVar = zzab;
                zzdvk.zzt(zzdskVar.getVersion(), 0);
                zzdqv.zza(zzdskVar.zzbnj());
                zzdsg zzbnj = zzdskVar.zzbnj();
                zzdsm zzbnl = zzbnj.zzbnl();
                zzdur zza = zzdqv.zza(zzbnl.zzbny());
                byte[] byteArray = zzdskVar.zzbnt().toByteArray();
                byte[] byteArray2 = zzdskVar.zzbnu().toByteArray();
                ECParameterSpec zza2 = zzdup.zza(zza);
                ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
                zzdup.zza(eCPoint, zza2.getCurve());
                return new zzdul((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza2)), zzbnl.zzboa().toByteArray(), zzdqv.zza(zzbnl.zzbnz()), zzdqv.zza(zzbnj.zzbnn()), new zzdqx(zzbnj.zzbnm().zzbng()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        } catch (zzfge e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final /* synthetic */ zzdpv zza(zzfhe zzfheVar) throws GeneralSecurityException {
        if (zzfheVar instanceof zzdsk) {
            zzdsk zzdskVar = (zzdsk) zzfheVar;
            zzdvk.zzt(zzdskVar.getVersion(), 0);
            zzdqv.zza(zzdskVar.zzbnj());
            zzdsg zzbnj = zzdskVar.zzbnj();
            zzdsm zzbnl = zzbnj.zzbnl();
            zzdur zza = zzdqv.zza(zzbnl.zzbny());
            byte[] byteArray = zzdskVar.zzbnt().toByteArray();
            byte[] byteArray2 = zzdskVar.zzbnu().toByteArray();
            ECParameterSpec zza2 = zzdup.zza(zza);
            ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
            zzdup.zza(eCPoint, zza2.getCurve());
            return new zzdul((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza2)), zzbnl.zzboa().toByteArray(), zzdqv.zza(zzbnl.zzbnz()), zzdqv.zza(zzbnj.zzbnn()), new zzdqx(zzbnj.zzbnm().zzbng()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfes zzfesVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzfhe zzb(zzfhe zzfheVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.zzdpw
    public final zzdsy zzc(zzfes zzfesVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }
}
