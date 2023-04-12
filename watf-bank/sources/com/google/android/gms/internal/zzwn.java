package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
/* loaded from: classes.dex */
final class zzwn implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel zzaqm;
    private /* synthetic */ zzwl zzcgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwn(zzwl zzwlVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzcgd = zzwlVar;
        this.zzaqm = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        com.google.android.gms.ads.internal.zzbs.zzeg();
        activity = this.zzcgd.zzcgb;
        com.google.android.gms.ads.internal.overlay.zzl.zza(activity, this.zzaqm, true);
    }
}
