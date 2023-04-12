package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzadf implements Runnable {
    private /* synthetic */ zzade zzcvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadf(zzade zzadeVar) {
        this.zzcvc = zzadeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcvc.zzi(1);
    }
}
