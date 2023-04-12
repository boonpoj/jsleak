package com.google.android.gms.internal;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
abstract class zzdue extends zzdub {
    private zzdue(byte[] bArr) {
        super(bArr);
    }

    private static void zza(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(int[] iArr, byte[] bArr) {
        int[] zza = zza(ByteBuffer.wrap(bArr));
        System.arraycopy(zza, 0, iArr, 4, zza.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzh(int[] iArr) {
        System.arraycopy(zzlyk, 0, iArr, 0, zzlyk.length);
    }

    @Override // com.google.android.gms.internal.zzdub
    final void zzf(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }
}
