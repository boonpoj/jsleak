package com.google.android.gms.internal;

import java.util.Arrays;
/* loaded from: classes.dex */
final class zzdvh {
    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    private static long zzc(byte[] bArr, int i, int i2) {
        return (zze(bArr, i) >> i2) & 67108863;
    }

    private static long zze(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zzf(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long zzc = zzc(bArr, 0, 0) & 67108863;
            int i = 2;
            int i2 = 3;
            long zzc2 = zzc(bArr, 3, 2) & 67108611;
            long zzc3 = zzc(bArr, 6, 4) & 67092735;
            long zzc4 = zzc(bArr, 9, 6) & 66076671;
            long zzc5 = zzc(bArr, 12, 8) & 1048575;
            long j = zzc2 * 5;
            long j2 = zzc3 * 5;
            long j3 = zzc4 * 5;
            long j4 = zzc5 * 5;
            byte[] bArr3 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (i3 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i3);
                System.arraycopy(bArr2, i3, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, 17, (byte) 0);
                }
                long zzc6 = j9 + zzc(bArr3, 0, 0);
                long zzc7 = j5 + zzc(bArr3, i2, i);
                long zzc8 = j6 + zzc(bArr3, 6, 4);
                long zzc9 = j7 + zzc(bArr3, 9, 6);
                long zzc10 = j8 + (zzc(bArr3, 12, 8) | (bArr3[16] << 24));
                long j10 = (zzc6 * zzc) + (zzc7 * j4) + (zzc8 * j3) + (zzc9 * j2) + (zzc10 * j);
                long j11 = (zzc6 * zzc2) + (zzc7 * zzc) + (zzc8 * j4) + (zzc9 * j3) + (zzc10 * j2) + (j10 >> 26);
                long j12 = (zzc6 * zzc3) + (zzc7 * zzc2) + (zzc8 * zzc) + (zzc9 * j4) + (zzc10 * j3) + (j11 >> 26);
                long j13 = (zzc6 * zzc4) + (zzc7 * zzc3) + (zzc8 * zzc2) + (zzc9 * zzc) + (zzc10 * j4) + (j12 >> 26);
                long j14 = (zzc6 * zzc5) + (zzc7 * zzc4) + (zzc8 * zzc3) + (zzc9 * zzc2) + (zzc10 * zzc) + (j13 >> 26);
                long j15 = (j10 & 67108863) + ((j14 >> 26) * 5);
                j5 = (j11 & 67108863) + (j15 >> 26);
                i3 += 16;
                j6 = j12 & 67108863;
                j7 = j13 & 67108863;
                j8 = j14 & 67108863;
                j9 = j15 & 67108863;
                i = 2;
                i2 = 3;
            }
            long j16 = j6 + (j5 >> 26);
            long j17 = j16 & 67108863;
            long j18 = j7 + (j16 >> 26);
            long j19 = j18 & 67108863;
            long j20 = j8 + (j18 >> 26);
            long j21 = j20 & 67108863;
            long j22 = j9 + ((j20 >> 26) * 5);
            long j23 = j22 & 67108863;
            long j24 = (j5 & 67108863) + (j22 >> 26);
            long j25 = j23 + 5;
            long j26 = j25 & 67108863;
            long j27 = (j25 >> 26) + j24;
            long j28 = j17 + (j27 >> 26);
            long j29 = j19 + (j28 >> 26);
            long j30 = j29 & 67108863;
            long j31 = (j21 + (j29 >> 26)) - 67108864;
            long j32 = j31 >> 63;
            long j33 = j23 & j32;
            long j34 = j24 & j32;
            long j35 = j17 & j32;
            long j36 = j19 & j32;
            long j37 = j21 & j32;
            long j38 = j32 ^ (-1);
            long j39 = (j27 & 67108863 & j38) | j34;
            long j40 = (j28 & 67108863 & j38) | j35;
            long j41 = (j30 & j38) | j36;
            long j42 = (j31 & j38) | j37;
            long zze = (((j39 << 26) | j33 | (j26 & j38)) & 4294967295L) + zze(bArr, 16);
            long j43 = zze & 4294967295L;
            long zze2 = (((j39 >> 6) | (j40 << 20)) & 4294967295L) + zze(bArr, 20) + (zze >> 32);
            long j44 = zze2 & 4294967295L;
            long zze3 = (((j40 >> 12) | (j41 << 14)) & 4294967295L) + zze(bArr, 24) + (zze2 >> 32);
            long j45 = zze3 & 4294967295L;
            byte[] bArr4 = new byte[16];
            zza(bArr4, j43, 0);
            zza(bArr4, j44, 4);
            zza(bArr4, j45, 8);
            zza(bArr4, ((((j41 >> 18) | (j42 << 8)) & 4294967295L) + zze(bArr, 28) + (zze3 >> 32)) & 4294967295L, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
