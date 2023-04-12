package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzfiw extends zzfit {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzme;
        int zzaj;
        int zzi;
        if (i2 == 0) {
            zzme = zzfis.zzme(i);
            return zzme;
        } else if (i2 == 1) {
            zzaj = zzfis.zzaj(i, zzfiq.zzb(bArr, j));
            return zzaj;
        } else if (i2 == 2) {
            zzi = zzfis.zzi(i, zzfiq.zzb(bArr, j), zzfiq.zzb(bArr, j + 1));
            return zzi;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00aa, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int zzb(byte[] r11, long r12, int r14) {
        /*
            r0 = 0
            r1 = 1
            r3 = 16
            if (r14 >= r3) goto L9
            r3 = 0
            goto L1b
        L9:
            r4 = r12
            r3 = 0
        Lb:
            if (r3 >= r14) goto L1a
            long r6 = r4 + r1
            byte r4 = com.google.android.gms.internal.zzfiq.zzb(r11, r4)
            if (r4 >= 0) goto L16
            goto L1b
        L16:
            int r3 = r3 + 1
            r4 = r6
            goto Lb
        L1a:
            r3 = r14
        L1b:
            int r14 = r14 - r3
            long r3 = (long) r3
            long r12 = r12 + r3
        L1e:
            r3 = 0
        L1f:
            if (r14 <= 0) goto L2f
            long r3 = r12 + r1
            byte r12 = com.google.android.gms.internal.zzfiq.zzb(r11, r12)
            if (r12 < 0) goto L32
            int r14 = r14 + (-1)
            r9 = r3
            r3 = r12
            r12 = r9
            goto L1f
        L2f:
            r9 = r12
            r12 = r3
            r3 = r9
        L32:
            if (r14 != 0) goto L35
            return r0
        L35:
            int r14 = r14 + (-1)
            r13 = -32
            r5 = -65
            r6 = -1
            if (r12 >= r13) goto L50
            if (r14 != 0) goto L41
            return r12
        L41:
            int r14 = r14 + (-1)
            r13 = -62
            if (r12 < r13) goto L4f
            long r12 = r3 + r1
            byte r3 = com.google.android.gms.internal.zzfiq.zzb(r11, r3)
            if (r3 <= r5) goto L1e
        L4f:
            return r6
        L50:
            r7 = -16
            if (r12 >= r7) goto L7b
            r7 = 2
            if (r14 >= r7) goto L5c
            int r11 = zza(r11, r12, r3, r14)
            return r11
        L5c:
            int r14 = r14 + (-2)
            long r7 = r3 + r1
            byte r3 = com.google.android.gms.internal.zzfiq.zzb(r11, r3)
            if (r3 > r5) goto L7a
            r4 = -96
            if (r12 != r13) goto L6c
            if (r3 < r4) goto L7a
        L6c:
            r13 = -19
            if (r12 != r13) goto L72
            if (r3 >= r4) goto L7a
        L72:
            long r12 = r7 + r1
            byte r3 = com.google.android.gms.internal.zzfiq.zzb(r11, r7)
            if (r3 <= r5) goto L1e
        L7a:
            return r6
        L7b:
            r13 = 3
            if (r14 >= r13) goto L83
            int r11 = zza(r11, r12, r3, r14)
            return r11
        L83:
            int r14 = r14 + (-3)
            long r7 = r3 + r1
            byte r13 = com.google.android.gms.internal.zzfiq.zzb(r11, r3)
            if (r13 > r5) goto Laa
            int r12 = r12 << 28
            int r13 = r13 + 112
            int r12 = r12 + r13
            int r12 = r12 >> 30
            if (r12 != 0) goto Laa
            long r12 = r7 + r1
            byte r3 = com.google.android.gms.internal.zzfiq.zzb(r11, r7)
            if (r3 > r5) goto Laa
            long r3 = r12 + r1
            byte r12 = com.google.android.gms.internal.zzfiq.zzb(r11, r12)
            if (r12 <= r5) goto La7
            goto Laa
        La7:
            r12 = r3
            goto L1e
        Laa:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfiw.zzb(byte[], long, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzfit
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        if ((i2 | i3 | (bArr.length - i3)) >= 0) {
            long j = i2;
            return zzb(bArr, j, (int) (i3 - j));
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.zzfit
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzfiq.zza(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= c || j4 >= j5) {
                if (charAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    zzfiq.zza(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                    zzfiq.zza(bArr, j6, (byte) ((charAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                    if (j4 > j5 - 4) {
                        if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(charAt3);
                            sb2.append(" at index ");
                            sb2.append(j4);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        throw new zzfiv(i4, length);
                    }
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char charAt4 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j7 = j4 + 1;
                            zzfiq.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                            long j8 = j7 + 1;
                            zzfiq.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j9 = j8 + 1;
                            zzfiq.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                            j3 = 1;
                            j2 = j9 + 1;
                            zzfiq.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    throw new zzfiv(i4 - 1, length);
                } else {
                    long j10 = j4 + j;
                    zzfiq.zza(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    zzfiq.zza(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzfiq.zza(bArr, j11, (byte) ((charAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                zzfiq.zza(bArr, j4, (byte) charAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c = 128;
            long j122 = j3;
            j4 = j2;
            j = j122;
        }
        return (int) j4;
    }
}
