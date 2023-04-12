package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.util.WeakHashMap;
/* renamed from: com.mopub.nativeads.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0281 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final WeakHashMap<View, NativeAd> f1931 = new WeakHashMap<>();

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.ࢥ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    enum EnumC0282 {
        EMPTY,
        AD
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static View m1514(@Nullable View view, @Nullable ViewGroup viewGroup, @NonNull Context context, @Nullable NativeAd nativeAd) {
        if (view != null) {
            m1515(view);
        }
        if (nativeAd != null && !nativeAd.isDestroyed()) {
            if (view == null || !EnumC0282.AD.equals(view.getTag())) {
                view = nativeAd.createAdView(context, viewGroup);
                view.setTag(EnumC0282.AD);
            }
            m1516(view, nativeAd);
            nativeAd.renderAdView(view);
            return view;
        }
        MoPubLog.d("NativeAd null or invalid. Returning empty view");
        if (view == null || !EnumC0282.EMPTY.equals(view.getTag())) {
            View view2 = new View(context);
            view2.setTag(EnumC0282.EMPTY);
            view2.setVisibility(8);
            return view2;
        }
        return view;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1515(@NonNull View view) {
        NativeAd nativeAd = f1931.get(view);
        if (nativeAd != null) {
            nativeAd.clear(view);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1516(@NonNull View view, @NonNull NativeAd nativeAd) {
        f1931.put(view, nativeAd);
        nativeAd.prepare(view);
    }
}
