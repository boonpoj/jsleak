package com.mopub.mraid;

import android.content.Context;
import android.support.annotation.Nullable;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.RewardedMraidActivity;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class RewardedMraidInterstitial extends MraidInterstitial {
    @Nullable

    /* renamed from: ࢥ  reason: contains not printable characters */
    private RewardedPlayableBroadcastReceiver f1401;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private int f1402;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f1403;

    /* loaded from: assets/classes2.dex */
    public interface RewardedMraidInterstitialListener extends CustomEventInterstitial.CustomEventInterstitialListener {
        void onMraidComplete();
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        super.loadInterstitial(context, customEventInterstitialListener, map, map2);
        if (customEventInterstitialListener instanceof RewardedMraidInterstitialListener) {
            this.f1401 = new RewardedPlayableBroadcastReceiver((RewardedMraidInterstitialListener) customEventInterstitialListener, this.f962);
            this.f1401.register(this.f1401, context);
        }
        Object obj = map.get(DataKeys.REWARDED_AD_DURATION_KEY);
        this.f1402 = obj instanceof Integer ? ((Integer) obj).intValue() : 30;
        Object obj2 = map.get(DataKeys.SHOULD_REWARD_ON_CLICK_KEY);
        this.f1403 = obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false;
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        super.onInvalidate();
        if (this.f1401 != null) {
            this.f1401.unregister(this.f1401);
        }
    }

    @Override // com.mopub.mraid.MraidInterstitial, com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        RewardedMraidActivity.start(this.f960, this.f961, this.f1367, this.f962, this.f1402, this.f1403);
    }
}
