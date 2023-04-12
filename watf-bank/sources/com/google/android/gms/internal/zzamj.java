package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzamj implements Runnable {
    private /* synthetic */ zzama zzdhp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamj(zzami zzamiVar, zzama zzamaVar) {
        this.zzdhp = zzamaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdhp.zzrs();
    }
}
