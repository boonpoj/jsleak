package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.mopub.common.BaseLifecycleListener;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubReward;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/classes2.dex */
public class GooglePlayServicesRewardedVideo extends CustomEventRewardedVideo implements RewardedVideoAdListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AtomicBoolean f857;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f858;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private RewardedVideoAd f859;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private LifecycleListener f860 = new BaseLifecycleListener() { // from class: com.mopub.mobileads.GooglePlayServicesRewardedVideo.1
        @Override // com.mopub.common.BaseLifecycleListener, com.mopub.common.LifecycleListener
        public void onPause(@NonNull Activity activity) {
            super.onPause(activity);
            if (GooglePlayServicesRewardedVideo.this.f859 != null) {
                GooglePlayServicesRewardedVideo.this.f859.pause(activity);
            }
        }

        @Override // com.mopub.common.BaseLifecycleListener, com.mopub.common.LifecycleListener
        public void onResume(@NonNull Activity activity) {
            super.onResume(activity);
            if (GooglePlayServicesRewardedVideo.this.f859 != null) {
                GooglePlayServicesRewardedVideo.this.f859.resume(activity);
            }
        }
    };

    public GooglePlayServicesRewardedVideo() {
        f857 = new AtomicBoolean(false);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private MoPubErrorCode m770(int i) {
        switch (i) {
            case 0:
                return MoPubErrorCode.INTERNAL_ERROR;
            case 1:
                return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            case 2:
                return MoPubErrorCode.NO_CONNECTION;
            case 3:
                return MoPubErrorCode.NO_FILL;
            default:
                return MoPubErrorCode.UNSPECIFIED;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    public boolean checkAndInitializeSdk(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        if (f857.getAndSet(true)) {
            return false;
        }
        if (TextUtils.isEmpty(map2.get("appid"))) {
            MobileAds.initialize(activity);
        } else {
            MobileAds.initialize(activity, map2.get("appid"));
        }
        if (TextUtils.isEmpty(map2.get("adunit"))) {
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(GooglePlayServicesRewardedVideo.class, GooglePlayServicesRewardedVideo.class.getSimpleName(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return false;
        }
        this.f858 = map2.get("adunit");
        this.f859 = MobileAds.getRewardedVideoAdInstance(activity);
        this.f859.setRewardedVideoAdListener(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public String getAdNetworkId() {
        return this.f858;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @Nullable
    protected LifecycleListener getLifecycleListener() {
        return this.f860;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    protected boolean hasVideoAvailable() {
        return this.f859 != null && this.f859.isLoaded();
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewarded(RewardItem rewardItem) {
        MoPubRewardedVideoManager.onRewardedVideoCompleted(GooglePlayServicesRewardedVideo.class, this.f858, MoPubReward.success(rewardItem.getType(), rewardItem.getAmount()));
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdClosed() {
        MoPubRewardedVideoManager.onRewardedVideoClosed(GooglePlayServicesRewardedVideo.class, this.f858);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdFailedToLoad(int i) {
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(GooglePlayServicesRewardedVideo.class, this.f858, m770(i));
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLeftApplication() {
        MoPubRewardedVideoManager.onRewardedVideoClicked(GooglePlayServicesRewardedVideo.class, this.f858);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdLoaded() {
        MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(GooglePlayServicesRewardedVideo.class, this.f858);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoAdOpened() {
    }

    public void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public void onRewardedVideoStarted() {
        MoPubRewardedVideoManager.onRewardedVideoStarted(GooglePlayServicesRewardedVideo.class, this.f858);
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    protected void showVideo() {
        if (hasVideoAvailable()) {
            this.f859.show();
        } else {
            MoPubRewardedVideoManager.onRewardedVideoPlaybackError(GooglePlayServicesRewardedVideo.class, this.f858, m770(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo654() {
        if (this.f859 != null) {
            this.f859.setRewardedVideoAdListener(null);
            this.f859 = null;
        }
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    protected void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        if (TextUtils.isEmpty(map2.get("adunit"))) {
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(GooglePlayServicesRewardedVideo.class, GooglePlayServicesRewardedVideo.class.getSimpleName(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        this.f858 = map2.get("adunit");
        if (this.f859 == null) {
            this.f859 = MobileAds.getRewardedVideoAdInstance(activity);
            this.f859.setRewardedVideoAdListener(this);
        }
        if (this.f859.isLoaded()) {
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(GooglePlayServicesRewardedVideo.class, this.f858);
        } else {
            this.f859.loadAd(this.f858, new AdRequest.Builder().setRequestAgent("MoPub").build());
        }
    }
}
