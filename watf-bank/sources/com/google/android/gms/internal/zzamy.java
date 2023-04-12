package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzamy implements Runnable {
    private /* synthetic */ zzamx zzdjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamy(zzamx zzamxVar) {
        this.zzdjy = zzamxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzbs.zzfb().zzb(this.zzdjy);
    }
}
