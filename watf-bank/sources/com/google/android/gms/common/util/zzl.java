package com.google.android.gms.common.util;
/* loaded from: classes.dex */
public final class zzl {
    public static String zza(byte[] bArr, int i, int i2, boolean z) {
        String str;
        if (bArr == null || bArr.length == 0 || i2 <= 0 || i2 > bArr.length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((((i2 + 16) - 1) / 16) * 57);
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        while (i3 > 0) {
            if (i4 == 0) {
                str = i2 < 65536 ? String.format("%04X:", Integer.valueOf(i5)) : String.format("%08X:", Integer.valueOf(i5));
            } else {
                str = i4 == 8 ? " -" : " -";
                sb.append(String.format(" %02X", Integer.valueOf(bArr[i5] & 255)));
                i3--;
                i4++;
                if (i4 != 16 || i3 == 0) {
                    sb.append('\n');
                    i4 = 0;
                }
                i5++;
            }
            sb.append(str);
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i5] & 255)));
            i3--;
            i4++;
            if (i4 != 16) {
            }
            sb.append('\n');
            i4 = 0;
            i5++;
        }
        return sb.toString();
    }
}
