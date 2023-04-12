package com.google.android.gms.ads.internal;
/* loaded from: classes.dex */
final class zzg implements Runnable {
    private /* synthetic */ zzd zzany;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzd zzdVar) {
        this.zzany = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzany.zzann.pause();
    }
}
