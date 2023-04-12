package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.RewardedVastVideoInterstitial;
/* loaded from: assets/classes2.dex */
public class RewardedVideoBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static IntentFilter f974;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private RewardedVastVideoInterstitial.InterfaceC0209 f975;

    public RewardedVideoBroadcastReceiver(@Nullable RewardedVastVideoInterstitial.InterfaceC0209 interfaceC0209, long j) {
        super(j);
        this.f975 = interfaceC0209;
        getIntentFilter();
    }

    @Override // com.mopub.mobileads.BaseBroadcastReceiver
    @NonNull
    public IntentFilter getIntentFilter() {
        if (f974 == null) {
            f974 = new IntentFilter();
            f974.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
        return f974;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (this.f975 != null && shouldConsumeBroadcast(intent) && IntentActions.ACTION_REWARDED_VIDEO_COMPLETE.equals(intent.getAction())) {
            this.f975.onVideoComplete();
            unregister(this);
        }
    }
}
