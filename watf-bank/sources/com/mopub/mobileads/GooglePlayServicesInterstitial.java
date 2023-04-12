package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class GooglePlayServicesInterstitial extends CustomEventInterstitial {
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String LOCATION_KEY = "location";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private CustomEventInterstitial.CustomEventInterstitialListener f854;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private InterstitialAd f855;

    /* renamed from: com.mopub.mobileads.GooglePlayServicesInterstitial$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0201 extends AdListener {
        private C0201() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private MoPubErrorCode m768(int i) {
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

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            if (GooglePlayServicesInterstitial.this.f854 != null) {
                GooglePlayServicesInterstitial.this.f854.onInterstitialDismissed();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int i) {
            if (GooglePlayServicesInterstitial.this.f854 != null) {
                GooglePlayServicesInterstitial.this.f854.onInterstitialFailed(m768(i));
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
            if (GooglePlayServicesInterstitial.this.f854 != null) {
                GooglePlayServicesInterstitial.this.f854.onInterstitialClicked();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            if (GooglePlayServicesInterstitial.this.f854 != null) {
                GooglePlayServicesInterstitial.this.f854.onInterstitialLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            if (GooglePlayServicesInterstitial.this.f854 != null) {
                GooglePlayServicesInterstitial.this.f854.onInterstitialShown();
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m767(Map<String, String> map) {
        return map.containsKey("adUnitID");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener2;
        MoPubErrorCode moPubErrorCode;
        this.f854 = customEventInterstitialListener;
        if (m767(map2)) {
            this.f855 = new InterstitialAd(context);
            this.f855.setAdListener(new C0201());
            this.f855.setAdUnitId(map2.get("adUnitID"));
            try {
                this.f855.loadAd(new AdRequest.Builder().setRequestAgent("MoPub").build());
                return;
            } catch (NoClassDefFoundError unused) {
                customEventInterstitialListener2 = this.f854;
                moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            }
        } else {
            customEventInterstitialListener2 = this.f854;
            moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
        }
        customEventInterstitialListener2.onInterstitialFailed(moPubErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        if (this.f855 != null) {
            this.f855.setAdListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        if (this.f855.isLoaded()) {
            this.f855.show();
        }
    }
}
