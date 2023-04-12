package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzadg implements Runnable {
    private /* synthetic */ zzafp zzanv;
    private /* synthetic */ zzade zzcvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadg(zzade zzadeVar, zzafp zzafpVar) {
        this.zzcvc = zzadeVar;
        this.zzanv = zzafpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcvc.zzb(new zzafo(this.zzanv, null, null, null, null, null, null, null));
    }
}
