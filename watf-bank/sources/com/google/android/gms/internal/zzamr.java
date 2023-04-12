package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zzamr implements Runnable {
    private boolean zzayv = false;
    private zzamd zzdjq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamr(zzamd zzamdVar) {
        this.zzdjq = zzamdVar;
    }

    private final void zzsp() {
        zzahn.zzdaw.removeCallbacks(this);
        zzahn.zzdaw.postDelayed(this, 250L);
    }

    public final void pause() {
        this.zzayv = true;
    }

    public final void resume() {
        this.zzayv = false;
        zzsp();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzayv) {
            return;
        }
        this.zzdjq.zzrx();
        zzsp();
    }
}
