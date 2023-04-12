package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;
/* loaded from: classes.dex */
public final class zzdun {
    private ECPublicKey zzlyz;

    public zzdun(ECPublicKey eCPublicKey) {
        this.zzlyz = eCPublicKey;
    }

    public final zzduo zza(String str, byte[] bArr, byte[] bArr2, int i, zzdus zzdusVar) throws GeneralSecurityException {
        byte[] bArr3;
        ECParameterSpec params = this.zzlyz.getParams();
        KeyPairGenerator zzos = zzduu.zzlzu.zzos("EC");
        zzos.initialize(params);
        KeyPair generateKeyPair = zzos.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
        zzdup.zza(this.zzlyz.getW(), this.zzlyz.getParams().getCurve());
        KeyAgreement zzos2 = zzduu.zzlzt.zzos("ECDH");
        zzos2.init((ECPrivateKey) generateKeyPair.getPrivate());
        zzos2.doPhase(this.zzlyz, true);
        byte[] generateSecret = zzos2.generateSecret();
        EllipticCurve curve = eCPublicKey.getParams().getCurve();
        ECPoint w = eCPublicKey.getW();
        zzdup.zza(w, curve);
        int zzb = zzdup.zzb(curve);
        int i2 = zzduq.zzlzc[zzdusVar.ordinal()];
        if (i2 == 1) {
            int i3 = (zzb * 2) + 1;
            byte[] bArr4 = new byte[i3];
            byte[] byteArray = w.getAffineX().toByteArray();
            byte[] byteArray2 = w.getAffineY().toByteArray();
            System.arraycopy(byteArray2, 0, bArr4, i3 - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr4, (zzb + 1) - byteArray.length, byteArray.length);
            bArr4[0] = 4;
            bArr3 = bArr4;
        } else if (i2 != 2) {
            String valueOf = String.valueOf(zzdusVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("invalid format:");
            sb.append(valueOf);
            throw new GeneralSecurityException(sb.toString());
        } else {
            int i4 = zzb + 1;
            bArr3 = new byte[i4];
            byte[] byteArray3 = w.getAffineX().toByteArray();
            System.arraycopy(byteArray3, 0, bArr3, i4 - byteArray3.length, byteArray3.length);
            bArr3[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
        }
        return new zzduo(bArr3, zzdvd.zza(str, zzdua.zzc(bArr3, generateSecret), bArr, bArr2, i));
    }
}
