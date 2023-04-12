package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzyj implements Runnable {
    private /* synthetic */ zzafo zzaox;
    private /* synthetic */ zzyi zzckc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyj(zzyi zzyiVar, zzafo zzafoVar) {
        this.zzckc = zzyiVar;
        this.zzaox = zzafoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzyb zzybVar;
        zzybVar = this.zzckc.zzcjj;
        zzybVar.zzb(this.zzaox);
    }
}
