package com.mopub.mraid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.BaseBroadcastReceiver;
import com.mopub.mraid.RewardedMraidInterstitial;
/* loaded from: assets/classes2.dex */
public class RewardedPlayableBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static IntentFilter f1404;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private RewardedMraidInterstitial.RewardedMraidInterstitialListener f1405;

    public RewardedPlayableBroadcastReceiver(@Nullable RewardedMraidInterstitial.RewardedMraidInterstitialListener rewardedMraidInterstitialListener, long j) {
        super(j);
        this.f1405 = rewardedMraidInterstitialListener;
        getIntentFilter();
    }

    @Override // com.mopub.mobileads.BaseBroadcastReceiver
    @NonNull
    public IntentFilter getIntentFilter() {
        if (f1404 == null) {
            f1404 = new IntentFilter();
            f1404.addAction(IntentActions.ACTION_REWARDED_PLAYABLE_COMPLETE);
        }
        return f1404;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (this.f1405 != null && shouldConsumeBroadcast(intent) && IntentActions.ACTION_REWARDED_PLAYABLE_COMPLETE.equals(intent.getAction())) {
            this.f1405.onMraidComplete();
            unregister(this);
        }
    }
}
