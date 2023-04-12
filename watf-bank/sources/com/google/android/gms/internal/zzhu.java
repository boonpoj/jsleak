package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhu {
    public static int zzaa(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        int length = bytes.length;
        int i = (length & (-4)) + 0;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            int i4 = ((bytes[i3] & 255) | ((bytes[i3 + 1] & 255) << 8) | ((bytes[i3 + 2] & 255) << 16) | (bytes[i3 + 3] << 24)) * (-862048943);
            int i5 = i2 ^ (((i4 << 15) | (i4 >>> 17)) * 461845907);
            i2 = (((i5 >>> 19) | (i5 << 13)) * 5) - 430675100;
        }
        int i6 = length & 3;
        if (i6 != 1) {
            if (i6 != 2) {
                r2 = i6 == 3 ? (bytes[i + 2] & 255) << 16 : 0;
                int i7 = i2 ^ length;
                int i8 = (i7 ^ (i7 >>> 16)) * (-2048144789);
                int i9 = (i8 ^ (i8 >>> 13)) * (-1028477387);
                return i9 ^ (i9 >>> 16);
            }
            r2 |= (bytes[i + 1] & 255) << 8;
        }
        int i10 = ((bytes[i] & 255) | r2) * (-862048943);
        i2 ^= ((i10 >>> 17) | (i10 << 15)) * 461845907;
        int i72 = i2 ^ length;
        int i82 = (i72 ^ (i72 >>> 16)) * (-2048144789);
        int i92 = (i82 ^ (i82 >>> 13)) * (-1028477387);
        return i92 ^ (i92 >>> 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x007f, code lost:
        if (((r6 >= 65382 && r6 <= 65437) || (r6 >= 65441 && r6 <= 65500)) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c4, code lost:
        if (r4 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d1, code lost:
        if (r4 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d3, code lost:
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00d4, code lost:
        r4 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] zzb(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhu.zzb(java.lang.String, boolean):java.lang.String[]");
    }
}
