package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class zzdvd {
    public static byte[] zza(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws GeneralSecurityException {
        Mac zzos = zzduu.zzlzq.zzos(str);
        if (i > zzos.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2 == null || bArr2.length == 0) {
            zzos.init(new SecretKeySpec(new byte[zzos.getMacLength()], str));
        } else {
            zzos.init(new SecretKeySpec(bArr2, str));
        }
        byte[] bArr4 = new byte[i];
        zzos.init(new SecretKeySpec(zzos.doFinal(bArr), str));
        byte[] bArr5 = new byte[0];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            zzos.update(bArr5);
            zzos.update(bArr3);
            zzos.update((byte) i2);
            bArr5 = zzos.doFinal();
            if (bArr5.length + i3 >= i) {
                System.arraycopy(bArr5, 0, bArr4, i3, i - i3);
                return bArr4;
            }
            System.arraycopy(bArr5, 0, bArr4, i3, bArr5.length);
            i3 += bArr5.length;
            i2++;
        }
    }
}
