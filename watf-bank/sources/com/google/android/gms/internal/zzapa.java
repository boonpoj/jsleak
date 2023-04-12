package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzapa {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzapa(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzapa zzc(zzjn zzjnVar) {
        return zzjnVar.zzbel ? new zzapa(3, 0, 0) : zzjnVar.zzbeo ? new zzapa(2, 0, 0) : zzjnVar.zzben ? zzuf() : zzi(zzjnVar.widthPixels, zzjnVar.heightPixels);
    }

    public static zzapa zzi(int i, int i2) {
        return new zzapa(1, i, i2);
    }

    public static zzapa zzuf() {
        return new zzapa(0, 0, 0);
    }

    public static zzapa zzug() {
        return new zzapa(4, 0, 0);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzuh() {
        return this.type == 3;
    }

    public final boolean zzui() {
        return this.type == 0;
    }

    public final boolean zzuj() {
        return this.type == 4;
    }
}
