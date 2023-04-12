package com.google.android.gms.common;

import java.util.Arrays;
/* loaded from: classes.dex */
final class zzi extends zzh {
    private final byte[] zzflc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zzflc = bArr;
    }

    @Override // com.google.android.gms.common.zzh
    final byte[] getBytes() {
        return this.zzflc;
    }
}
