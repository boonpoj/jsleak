package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class zzdtx implements zzdvf {
    private final SecretKeySpec zzlyc;
    private final int zzlyd;
    private final int zzlye = zzduu.zzlzp.zzos("AES/CTR/NoPadding").getBlockSize();

    public zzdtx(byte[] bArr, int i) throws GeneralSecurityException {
        this.zzlyc = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.zzlye) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzlyd = i;
    }

    @Override // com.google.android.gms.internal.zzdvf
    public final byte[] zzag(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzlyd;
        if (length > Integer.MAX_VALUE - i) {
            int i2 = Integer.MAX_VALUE - i;
            StringBuilder sb = new StringBuilder(43);
            sb.append("plaintext length can not exceed ");
            sb.append(i2);
            throw new GeneralSecurityException(sb.toString());
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] zzgh = zzdvi.zzgh(i);
        System.arraycopy(zzgh, 0, bArr2, 0, this.zzlyd);
        int length2 = bArr.length;
        int i3 = this.zzlyd;
        Cipher zzos = zzduu.zzlzp.zzos("AES/CTR/NoPadding");
        byte[] bArr3 = new byte[this.zzlye];
        System.arraycopy(zzgh, 0, bArr3, 0, this.zzlyd);
        zzos.init(1, this.zzlyc, new IvParameterSpec(bArr3));
        if (zzos.doFinal(bArr, 0, length2, bArr2, i3) == length2) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
