package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubRewardedAd;
import com.mopub.mraid.RewardedMraidInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class MoPubRewardedPlayable extends MoPubRewardedAd {
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private RewardedMraidInterstitial f906 = new RewardedMraidInterstitial();

    /* renamed from: com.mopub.mobileads.MoPubRewardedPlayable$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0206 extends MoPubRewardedAd.MoPubRewardedAdListener implements RewardedMraidInterstitial.RewardedMraidInterstitialListener {
        public C0206() {
            super(MoPubRewardedPlayable.class);
        }

        @Override // com.mopub.mraid.RewardedMraidInterstitial.RewardedMraidInterstitialListener
        public void onMraidComplete() {
            if (MoPubRewardedPlayable.this.m798() == null) {
                MoPubLog.d("No rewarded video was loaded, so no reward is possible");
            } else {
                MoPubRewardedVideoManager.onRewardedVideoCompleted(this.f900, MoPubRewardedPlayable.this.getAdNetworkId(), MoPubReward.success(MoPubRewardedPlayable.this.m798(), MoPubRewardedPlayable.this.m799()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public String getAdNetworkId() {
        return this.f895 != null ? this.f895 : "mopub_rewarded_playable_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.MoPubRewardedAd, com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo654() {
        if (this.f906 != null) {
            this.f906.onInvalidate();
        }
        this.f906 = null;
        super.mo654();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.MoPubRewardedAd, com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        super.mo655(activity, map, map2);
        if (this.f906 == null) {
            MoPubLog.w("mRewardedMraidInterstitial is null. Has this class been invalidated?");
        } else {
            this.f906.loadInterstitial(activity, new C0206(), map, map2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢤ */
    public void mo757() {
        if (!mo756() || this.f906 == null) {
            MoPubLog.d("MoPub rewarded playable not loaded. Unable to show playable.");
            return;
        }
        MoPubLog.d("Showing MoPub rewarded playable.");
        this.f906.showInterstitial();
    }
}
