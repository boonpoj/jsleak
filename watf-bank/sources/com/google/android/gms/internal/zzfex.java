package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfex {
    private final byte[] buffer;
    private final zzffg zzpfl;

    private zzfex(int i) {
        this.buffer = new byte[i];
        this.zzpfl = zzffg.zzbc(this.buffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfex(int i, zzfet zzfetVar) {
        this(i);
    }

    public final zzfes zzcvr() {
        this.zzpfl.zzcwt();
        return new zzfez(this.buffer);
    }

    public final zzffg zzcvs() {
        return this.zzpfl;
    }
}
