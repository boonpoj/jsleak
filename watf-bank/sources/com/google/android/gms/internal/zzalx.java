package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzalx implements Runnable {
    private /* synthetic */ zzalr zzdgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalx(zzalr zzalrVar) {
        this.zzdgk = zzalrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzama zzamaVar;
        zzama zzamaVar2;
        zzama zzamaVar3;
        zzamaVar = this.zzdgk.zzdgj;
        if (zzamaVar != null) {
            zzamaVar2 = this.zzdgk.zzdgj;
            zzamaVar2.onPaused();
            zzamaVar3 = this.zzdgk.zzdgj;
            zzamaVar3.zzrr();
        }
    }
}
