package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzamf implements Runnable {
    private /* synthetic */ zzamd zzdhh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamf(zzamd zzamdVar) {
        this.zzdhh = zzamdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdhh.zza("surfaceDestroyed", new String[0]);
    }
}
