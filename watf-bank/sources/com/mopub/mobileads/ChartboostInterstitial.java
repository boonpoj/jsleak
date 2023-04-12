package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.chartboost.sdk.Chartboost;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
class ChartboostInterstitial extends CustomEventInterstitial {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f800 = ChartboostShared.LOCATION_DEFAULT;

    ChartboostInterstitial() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(@NonNull Context context, @NonNull CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(customEventInterstitialListener);
        Preconditions.checkNotNull(map);
        Preconditions.checkNotNull(map2);
        if (context instanceof Activity) {
            if (map2.containsKey("location")) {
                String str = map2.get("location");
                if (TextUtils.isEmpty(str)) {
                    str = this.f800;
                }
                this.f800 = str;
            }
            if (!ChartboostShared.getDelegate().hasInterstitialLocation(this.f800) || ChartboostShared.getDelegate().getInterstitialListener(this.f800) == customEventInterstitialListener) {
                Activity activity = (Activity) context;
                try {
                    ChartboostShared.initializeSdk(activity, map2);
                    ChartboostShared.getDelegate().registerInterstitialListener(this.f800, customEventInterstitialListener);
                    Chartboost.onCreate(activity);
                    Chartboost.onStart(activity);
                    if (Chartboost.hasInterstitial(this.f800)) {
                        ChartboostShared.getDelegate().didCacheInterstitial(this.f800);
                        return;
                    } else {
                        Chartboost.cacheInterstitial(this.f800);
                        return;
                    }
                } catch (IllegalStateException | NullPointerException unused) {
                    customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                    return;
                }
            }
        }
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        ChartboostShared.getDelegate().unregisterInterstitialListener(this.f800);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        Chartboost.showInterstitial(this.f800);
    }
}
