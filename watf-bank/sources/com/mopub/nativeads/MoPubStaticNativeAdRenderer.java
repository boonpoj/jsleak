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
public class MoPubStaticNativeAdRenderer implements MoPubAdRenderer<StaticNativeAd> {
    @NonNull
    @VisibleForTesting

    /* renamed from: ࢠ  reason: contains not printable characters */
    final WeakHashMap<View, C0288> f1709 = new WeakHashMap<>();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final ViewBinder f1710;

    public MoPubStaticNativeAdRenderer(@NonNull ViewBinder viewBinder) {
        this.f1710 = viewBinder;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1419(@NonNull C0288 c0288, int i) {
        if (c0288.f1960 != null) {
            c0288.f1960.setVisibility(i);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1420(@NonNull C0288 c0288, @NonNull StaticNativeAd staticNativeAd) {
        NativeRendererHelper.addTextView(c0288.f1961, staticNativeAd.getTitle());
        NativeRendererHelper.addTextView(c0288.f1962, staticNativeAd.getText());
        NativeRendererHelper.addTextView(c0288.f1963, staticNativeAd.getCallToAction());
        NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), c0288.f1964);
        NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), c0288.f1965);
        NativeRendererHelper.addPrivacyInformationIcon(c0288.f1966, staticNativeAd.getPrivacyInformationIconImageUrl(), staticNativeAd.getPrivacyInformationIconClickThroughUrl());
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    @NonNull
    public View createAdView(@NonNull Context context, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(this.f1710.f1880, viewGroup, false);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public void renderAdView(@NonNull View view, @NonNull StaticNativeAd staticNativeAd) {
        C0288 c0288 = this.f1709.get(view);
        if (c0288 == null) {
            c0288 = C0288.m1552(view, this.f1710);
            this.f1709.put(view, c0288);
        }
        m1420(c0288, staticNativeAd);
        NativeRendererHelper.updateExtras(c0288.f1960, this.f1710.f1887, staticNativeAd.getExtras());
        m1419(c0288, 0);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public boolean supports(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof StaticNativeAd;
    }
}
