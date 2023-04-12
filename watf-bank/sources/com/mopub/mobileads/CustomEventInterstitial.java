package com.mopub.mobileads;

import android.content.Context;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class CustomEventInterstitial implements Interstitial {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean f827 = true;

    /* loaded from: assets/classes2.dex */
    public interface CustomEventInterstitialListener {
        void onInterstitialClicked();

        void onInterstitialDismissed();

        void onInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onInterstitialImpression();

        void onInterstitialLoaded();

        void onInterstitialShown();

        void onLeaveApplication();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onInvalidate();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void showInterstitial();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m745(boolean z) {
        this.f827 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m746() {
        return this.f827;
    }
}
