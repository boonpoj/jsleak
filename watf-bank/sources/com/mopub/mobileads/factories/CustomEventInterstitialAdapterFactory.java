package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class CustomEventInterstitialAdapterFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static CustomEventInterstitialAdapterFactory f1176 = new CustomEventInterstitialAdapterFactory();

    public static CustomEventInterstitialAdapter create(MoPubInterstitial moPubInterstitial, String str, Map<String, String> map, long j, AdReport adReport) {
        return f1176.m1003(moPubInterstitial, str, map, j, adReport);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialAdapterFactory customEventInterstitialAdapterFactory) {
        f1176 = customEventInterstitialAdapterFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected CustomEventInterstitialAdapter m1003(MoPubInterstitial moPubInterstitial, String str, Map<String, String> map, long j, AdReport adReport) {
        return new CustomEventInterstitialAdapter(moPubInterstitial, str, map, j, adReport);
    }
}
