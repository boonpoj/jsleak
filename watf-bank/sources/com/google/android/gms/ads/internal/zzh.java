package com.google.android.gms.ads.internal;
/* loaded from: classes.dex */
final class zzh implements Runnable {
    private /* synthetic */ zzd zzany;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzd zzdVar) {
        this.zzany = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzany.zzann.resume();
    }
}
