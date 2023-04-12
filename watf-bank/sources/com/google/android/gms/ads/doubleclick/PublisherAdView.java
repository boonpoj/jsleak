package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzlv;
/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {
    private final zzlv zzaly;

    public PublisherAdView(Context context) {
        super(context);
        this.zzaly = new zzlv(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaly = new zzlv(this, attributeSet, true);
        zzbq.checkNotNull(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaly = new zzlv(this, attributeSet, true);
    }

    public final void destroy() {
        this.zzaly.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzaly.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzaly.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzaly.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzaly.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzaly.getAppEventListener();
    }

    public final String getMediationAdapterClassName() {
        return this.zzaly.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzaly.getOnCustomRenderedAdLoadedListener();
    }

    public final VideoController getVideoController() {
        return this.zzaly.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.zzaly.getVideoOptions();
    }

    public final boolean isLoading() {
        return this.zzaly.isLoading();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzaly.zza(publisherAdRequest.zzbg());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzakb.zzb("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public final void pause() {
        this.zzaly.pause();
    }

    public final void recordManualImpression() {
        this.zzaly.recordManualImpression();
    }

    public final void resume() {
        this.zzaly.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzaly.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzaly.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzaly.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzaly.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzaly.setCorrelator(correlator);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzaly.setManualImpressionsEnabled(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzaly.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzaly.setVideoOptions(videoOptions);
    }

    public final boolean zza(zzks zzksVar) {
        return this.zzaly.zza(zzksVar);
    }
}
