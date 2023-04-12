package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubRewardedAd;
import com.mopub.mobileads.RewardedVastVideoInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class MoPubRewardedVideo extends MoPubRewardedAd {
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private RewardedVastVideoInterstitial f908 = new RewardedVastVideoInterstitial();

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideo$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0207 extends MoPubRewardedAd.MoPubRewardedAdListener implements RewardedVastVideoInterstitial.InterfaceC0209 {
        public C0207() {
            super(MoPubRewardedVideo.class);
        }

        @Override // com.mopub.mobileads.RewardedVastVideoInterstitial.InterfaceC0209
        public void onVideoComplete() {
            if (MoPubRewardedVideo.this.m798() == null) {
                MoPubLog.d("No rewarded video was loaded, so no reward is possible");
            } else {
                MoPubRewardedVideoManager.onRewardedVideoCompleted(this.f900, MoPubRewardedVideo.this.getAdNetworkId(), MoPubReward.success(MoPubRewardedVideo.this.m798(), MoPubRewardedVideo.this.m799()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public String getAdNetworkId() {
        return this.f895 != null ? this.f895 : "mopub_rewarded_video_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.MoPubRewardedAd, com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo654() {
        if (this.f908 != null) {
            this.f908.onInvalidate();
        }
        this.f908 = null;
        super.mo654();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.MoPubRewardedAd, com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        super.mo655(activity, map, map2);
        if (this.f908 == null) {
            MoPubLog.w("mRewardedVastVideoInterstitial is null. Has this class been invalidated?");
        } else {
            this.f908.loadInterstitial(activity, new C0207(), map, map2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢤ */
    public void mo757() {
        if (!mo756() || this.f908 == null) {
            MoPubLog.d("Unable to show MoPub rewarded video");
            return;
        }
        MoPubLog.d("Showing MoPub rewarded video.");
        this.f908.showInterstitial();
    }
}
