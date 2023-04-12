package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;
/* loaded from: classes.dex */
final class zzwm implements com.google.android.gms.ads.internal.overlay.zzn {
    private /* synthetic */ zzwl zzcgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwm(zzwl zzwlVar) {
        this.zzcgd = zzwlVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
        zzakb.zzbx("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
        zzakb.zzbx("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zzcg() {
        MediationInterstitialListener mediationInterstitialListener;
        zzakb.zzbx("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.zzcgd.zzcgc;
        mediationInterstitialListener.onAdClosed(this.zzcgd);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zzch() {
        MediationInterstitialListener mediationInterstitialListener;
        zzakb.zzbx("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.zzcgd.zzcgc;
        mediationInterstitialListener.onAdOpened(this.zzcgd);
    }
}
