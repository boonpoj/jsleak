package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzxx implements Runnable {
    private /* synthetic */ zzxw zzcjq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxx(zzxw zzxwVar) {
        this.zzcjq = zzxwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcjq.onStop();
    }
}
