package com.google.android.gms.ads.internal.js;
/* loaded from: classes.dex */
final class zzv implements Runnable {
    private /* synthetic */ zzu zzcbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzu zzuVar) {
        this.zzcbl = zzuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcbl.zzcbg.destroy();
    }
}
