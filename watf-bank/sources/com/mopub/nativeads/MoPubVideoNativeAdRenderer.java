package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;
/* loaded from: assets/classes2.dex */
public class MoPubVideoNativeAdRenderer implements MoPubAdRenderer<VideoNativeAd> {
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    final WeakHashMap<View, C0278> f1733 = new WeakHashMap<>();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final MediaViewBinder f1734;

    public MoPubVideoNativeAdRenderer(@NonNull MediaViewBinder mediaViewBinder) {
        this.f1734 = mediaViewBinder;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1433(@NonNull C0278 c0278, int i) {
        if (c0278.f1909 != null) {
            c0278.f1909.setVisibility(i);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1434(@NonNull C0278 c0278, @NonNull VideoNativeAd videoNativeAd) {
        NativeRendererHelper.addTextView(c0278.f1911, videoNativeAd.getTitle());
        NativeRendererHelper.addTextView(c0278.f1912, videoNativeAd.getText());
        NativeRendererHelper.addCtaButton(c0278.f1914, c0278.f1909, videoNativeAd.getCallToAction());
        if (c0278.f1910 != null) {
            NativeImageHelper.loadImageView(videoNativeAd.getMainImageUrl(), c0278.f1910.getMainImageView());
        }
        NativeImageHelper.loadImageView(videoNativeAd.getIconImageUrl(), c0278.f1913);
        NativeRendererHelper.addPrivacyInformationIcon(c0278.f1915, videoNativeAd.getPrivacyInformationIconImageUrl(), videoNativeAd.getPrivacyInformationIconClickThroughUrl());
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    @NonNull
    public View createAdView(@NonNull Context context, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(this.f1734.f1590, viewGroup, false);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public void renderAdView(@NonNull View view, @NonNull VideoNativeAd videoNativeAd) {
        C0278 c0278 = this.f1733.get(view);
        if (c0278 == null) {
            c0278 = C0278.m1497(view, this.f1734);
            this.f1733.put(view, c0278);
        }
        m1434(c0278, videoNativeAd);
        NativeRendererHelper.updateExtras(c0278.f1909, this.f1734.f1597, videoNativeAd.getExtras());
        m1433(c0278, 0);
        videoNativeAd.render((MediaLayout) view.findViewById(this.f1734.f1591));
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public boolean supports(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof VideoNativeAd;
    }
}
