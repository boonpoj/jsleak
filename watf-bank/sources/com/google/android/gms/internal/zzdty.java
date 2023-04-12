package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class zzdty implements zzdpp {
    private final SecretKeySpec zzlyc;
    private final byte[] zzlyf;
    private final byte[] zzlyg;
    private final int zzlyh;

    public zzdty(byte[] bArr, int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzlyh = i;
        this.zzlyc = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, this.zzlyc);
        this.zzlyf = zzah(cipher.doFinal(new byte[16]));
        this.zzlyg = zzah(this.zzlyf);
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zze(bArr3, this.zzlyf));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        byte[] bArr4 = doFinal;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr4[i5] = (byte) (bArr4[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArr4 = cipher.doFinal(bArr4);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zze(copyOfRange, this.zzlyf);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzlyg, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zze(bArr4, bArr2));
    }

    private static byte[] zzah(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    private static byte[] zze(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.zzdpp
    public final byte[] zzd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzlyh;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr3 = new byte[bArr.length + i + 16];
            byte[] zzgh = zzdvi.zzgh(i);
            System.arraycopy(zzgh, 0, bArr3, 0, this.zzlyh);
            Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
            cipher.init(1, this.zzlyc);
            byte[] zza = zza(cipher, 0, zzgh, 0, zzgh.length);
            byte[] zza2 = zza(cipher, 1, bArr2, 0, bArr2.length);
            Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
            cipher2.init(1, this.zzlyc, new IvParameterSpec(zza));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzlyh);
            byte[] zza3 = zza(cipher, 2, bArr3, this.zzlyh, bArr.length);
            int length2 = bArr.length + this.zzlyh;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[length2 + i2] = (byte) ((zza2[i2] ^ zza[i2]) ^ zza3[i2]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
