package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagc implements Runnable {
    private /* synthetic */ zzagb zzdae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagc(zzagb zzagbVar) {
        this.zzdae = zzagbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdae.zzdac = Thread.currentThread();
        this.zzdae.zzdm();
    }
}
