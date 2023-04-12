package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* loaded from: classes.dex */
final class zzan implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel zzaqm;
    private /* synthetic */ zzam zzaqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzam zzamVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzaqn = zzamVar;
        this.zzaqm = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbs.zzeg();
        com.google.android.gms.ads.internal.overlay.zzl.zza(this.zzaqn.zzaqk.zzano.zzair, this.zzaqm, true);
    }
}
