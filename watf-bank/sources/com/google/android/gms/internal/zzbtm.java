package com.google.android.gms.internal;
/* loaded from: assets/classes2.dex */
public class zzbtm {
    private final byte[] zzcqh = new byte[256];
    private int zzcqi;
    private int zzcqj;

    public zzbtm(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzcqh[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.zzcqh[i3] + bArr[i3 % bArr.length]) & 255;
            byte b = this.zzcqh[i3];
            this.zzcqh[i3] = this.zzcqh[i2];
            this.zzcqh[i2] = b;
        }
        this.zzcqi = 0;
        this.zzcqj = 0;
    }

    public void zzY(byte[] bArr) {
        int i = this.zzcqi;
        int i2 = this.zzcqj;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzcqh[i]) & 255;
            byte b = this.zzcqh[i];
            this.zzcqh[i] = this.zzcqh[i2];
            this.zzcqh[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzcqh[(this.zzcqh[i] + this.zzcqh[i2]) & 255]);
        }
        this.zzcqi = i;
        this.zzcqj = i2;
    }
}
