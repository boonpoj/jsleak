package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzlx;
/* loaded from: classes.dex */
public final class PublisherInterstitialAd {
    private final zzlx zzama;

    public PublisherInterstitialAd(Context context) {
        this.zzama = new zzlx(context, this);
        zzbq.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzama.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzama.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzama.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzama.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzama.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzama.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzama.isLoading();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzama.zza(publisherAdRequest.zzbg());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzama.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzama.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzama.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzama.setCorrelator(correlator);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzama.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzama.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzama.show();
    }
}
