package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;
@zzzv
/* loaded from: classes.dex */
public final class zzadu extends zzadq {
    private final RewardedVideoAdListener zzgz;

    public zzadu(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzgz = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdClosed() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdFailedToLoad(int i) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdLeftApplication() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdLoaded() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdOpened() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoStarted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void zza(zzadh zzadhVar) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewarded(new zzads(zzadhVar));
        }
    }
}
