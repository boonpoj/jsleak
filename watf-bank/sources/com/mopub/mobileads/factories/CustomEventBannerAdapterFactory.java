package com.mopub.mobileads.factories;

import android.support.annotation.NonNull;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class CustomEventBannerAdapterFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static CustomEventBannerAdapterFactory f1174 = new CustomEventBannerAdapterFactory();

    public static CustomEventBannerAdapter create(@NonNull MoPubView moPubView, @NonNull String str, @NonNull Map<String, String> map, long j, @NonNull AdReport adReport) {
        return f1174.m1001(moPubView, str, map, j, adReport);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerAdapterFactory customEventBannerAdapterFactory) {
        f1174 = customEventBannerAdapterFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected CustomEventBannerAdapter m1001(@NonNull MoPubView moPubView, @NonNull String str, @NonNull Map<String, String> map, long j, @NonNull AdReport adReport) {
        return new CustomEventBannerAdapter(moPubView, str, map, j, adReport);
    }
}
