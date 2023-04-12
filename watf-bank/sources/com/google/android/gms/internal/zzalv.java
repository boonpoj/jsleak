package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzalv implements Runnable {
    private /* synthetic */ zzalr zzdgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalv(zzalr zzalrVar) {
        this.zzdgk = zzalrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzama zzamaVar;
        zzama zzamaVar2;
        zzamaVar = this.zzdgk.zzdgj;
        if (zzamaVar != null) {
            zzamaVar2 = this.zzdgk.zzdgj;
            zzamaVar2.zzrn();
        }
    }
}
