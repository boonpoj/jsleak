package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzame implements Runnable {
    private /* synthetic */ zzamd zzdhh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzame(zzamd zzamdVar) {
        this.zzdhh = zzamdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdhh.zza("surfaceCreated", new String[0]);
    }
}
