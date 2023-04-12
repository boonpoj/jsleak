package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import com.mopub.common.IntentActions;
import com.mopub.mobileads.CustomEventInterstitial;
/* loaded from: assets/classes2.dex */
public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static IntentFilter f839;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final CustomEventInterstitial.CustomEventInterstitialListener f840;

    public EventForwardingBroadcastReceiver(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, long j) {
        super(j);
        this.f840 = customEventInterstitialListener;
        getIntentFilter();
    }

    @Override // com.mopub.mobileads.BaseBroadcastReceiver
    @NonNull
    public IntentFilter getIntentFilter() {
        if (f839 == null) {
            f839 = new IntentFilter();
            f839.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            f839.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            f839.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            f839.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
        }
        return f839;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f840 != null && shouldConsumeBroadcast(intent)) {
            String action = intent.getAction();
            if (IntentActions.ACTION_INTERSTITIAL_FAIL.equals(action)) {
                this.f840.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            } else if (IntentActions.ACTION_INTERSTITIAL_SHOW.equals(action)) {
                this.f840.onInterstitialShown();
            } else if (IntentActions.ACTION_INTERSTITIAL_DISMISS.equals(action)) {
                this.f840.onInterstitialDismissed();
                unregister(this);
            } else if (IntentActions.ACTION_INTERSTITIAL_CLICK.equals(action)) {
                this.f840.onInterstitialClicked();
            }
        }
    }
}
