package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
class RewardedVastVideoInterstitial extends VastVideoInterstitial {
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private RewardedVideoBroadcastReceiver f973;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.RewardedVastVideoInterstitial$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0209 extends CustomEventInterstitial.CustomEventInterstitialListener {
        void onVideoComplete();
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        super.loadInterstitial(context, customEventInterstitialListener, map, map2);
        if (customEventInterstitialListener instanceof InterfaceC0209) {
            this.f973 = new RewardedVideoBroadcastReceiver((InterfaceC0209) customEventInterstitialListener, this.f962);
            this.f973.register(this.f973, context);
        }
    }

    @Override // com.mopub.mobileads.VastVideoInterstitial, com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        super.onInvalidate();
        if (this.f973 != null) {
            this.f973.unregister(this.f973);
        }
    }

    @Override // com.mopub.mobileads.VastVideoInterstitial, com.mopub.mobileads.VastManager.VastManagerListener
    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig != null) {
            vastVideoConfig.setIsRewardedVideo(true);
        }
        super.onVastVideoConfigurationPrepared(vastVideoConfig);
    }
}
