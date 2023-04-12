package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzjg extends zzki {
    private final AdListener zzbde;

    public zzjg(AdListener adListener) {
        this.zzbde = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzbde;
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClicked() {
        this.zzbde.onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClosed() {
        this.zzbde.onAdClosed();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdFailedToLoad(int i) {
        this.zzbde.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdImpression() {
        this.zzbde.onAdImpression();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLeftApplication() {
        this.zzbde.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLoaded() {
        this.zzbde.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdOpened() {
        this.zzbde.onAdOpened();
    }
}
