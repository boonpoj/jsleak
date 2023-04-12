package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzduf {
    private zzdub zzlym;
    private int[] zzlyn;
    private int[] zzlyo;
    private int[] zzlyp = new int[16];
    private int zzlyq = 0;
    private boolean zzlyr = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduf(zzdub zzdubVar, byte[] bArr, int i) {
        this.zzlym = zzdubVar;
        this.zzlyn = zzdubVar.zzd(bArr, i);
        this.zzlyo = zzdubVar.zze(this.zzlyn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] zzbqj() {
        this.zzlyr = true;
        int[] iArr = this.zzlyo;
        int i = this.zzlyq;
        System.arraycopy(iArr, i, this.zzlyp, 0, 16 - i);
        this.zzlym.zzg(this.zzlyn);
        this.zzlyo = this.zzlym.zze(this.zzlyn);
        int[] iArr2 = this.zzlyo;
        int[] iArr3 = this.zzlyp;
        int i2 = this.zzlyq;
        System.arraycopy(iArr2, 0, iArr3, 16 - i2, i2);
        return this.zzlyp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzge(int i) {
        if (this.zzlyr) {
            throw new IllegalStateException("first can only be called once and before next().");
        }
        this.zzlyr = true;
        this.zzlyq = 8;
        ByteBuffer order = ByteBuffer.allocate(32).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(this.zzlyo, 0, 8);
        return order.array();
    }
}
