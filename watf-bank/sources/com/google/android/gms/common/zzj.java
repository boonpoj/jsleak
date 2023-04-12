package com.google.android.gms.common;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
abstract class zzj extends zzh {
    private static final WeakReference<byte[]> zzfle = new WeakReference<>(null);
    private WeakReference<byte[]> zzfld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(byte[] bArr) {
        super(bArr);
        this.zzfld = zzfle;
    }

    @Override // com.google.android.gms.common.zzh
    final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzfld.get();
            if (bArr == null) {
                bArr = zzagc();
                this.zzfld = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] zzagc();
}
