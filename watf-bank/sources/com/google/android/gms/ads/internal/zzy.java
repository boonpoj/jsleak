package com.google.android.gms.ads.internal;
/* loaded from: classes.dex */
final class zzy implements Runnable {
    private /* synthetic */ zzx zzaot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzx zzxVar) {
        this.zzaot = zzxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar = this.zzaot;
        zzxVar.zzd(zzxVar.zzano.zzaud);
    }
}
