package com.google.android.gms.ads.internal.js;
/* loaded from: classes.dex */
final class zzr implements Runnable {
    private /* synthetic */ zzq zzcbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzq zzqVar) {
        this.zzcbj = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcbj.zzcbi.zzcbg.destroy();
    }
}
