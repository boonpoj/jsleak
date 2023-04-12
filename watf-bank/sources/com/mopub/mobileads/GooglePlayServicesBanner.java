package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.mopub.common.util.Views;
import com.mopub.mobileads.CustomEventBanner;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class GooglePlayServicesBanner extends CustomEventBanner {
    public static final String AD_HEIGHT_KEY = "adHeight";
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String AD_WIDTH_KEY = "adWidth";
    public static final String LOCATION_KEY = "location";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private CustomEventBanner.CustomEventBannerListener f851;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AdView f852;

    /* renamed from: com.mopub.mobileads.GooglePlayServicesBanner$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private class C0200 extends AdListener {
        private C0200() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private MoPubErrorCode m765(int i) {
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
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int i) {
            if (GooglePlayServicesBanner.this.f851 != null) {
                GooglePlayServicesBanner.this.f851.onBannerFailed(m765(i));
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            if (GooglePlayServicesBanner.this.f851 != null) {
                GooglePlayServicesBanner.this.f851.onBannerLoaded(GooglePlayServicesBanner.this.f852);
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            if (GooglePlayServicesBanner.this.f851 != null) {
                GooglePlayServicesBanner.this.f851.onBannerClicked();
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AdSize m761(int i, int i2) {
        if (i > AdSize.BANNER.getWidth() || i2 > AdSize.BANNER.getHeight()) {
            if (i > AdSize.MEDIUM_RECTANGLE.getWidth() || i2 > AdSize.MEDIUM_RECTANGLE.getHeight()) {
                if (i > AdSize.FULL_BANNER.getWidth() || i2 > AdSize.FULL_BANNER.getHeight()) {
                    if (i > AdSize.LEADERBOARD.getWidth() || i2 > AdSize.LEADERBOARD.getHeight()) {
                        return null;
                    }
                    return AdSize.LEADERBOARD;
                }
                return AdSize.FULL_BANNER;
            }
            return AdSize.MEDIUM_RECTANGLE;
        }
        return AdSize.BANNER;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m763(Map<String, String> map) {
        try {
            Integer.parseInt(map.get(AD_WIDTH_KEY));
            Integer.parseInt(map.get(AD_HEIGHT_KEY));
            return map.containsKey("adUnitID");
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ */
    public void mo698() {
        Views.removeFromParent(this.f852);
        if (this.f852 != null) {
            this.f852.setAdListener(null);
            this.f852.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ */
    public void mo699(Context context, CustomEventBanner.CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2) {
        CustomEventBanner.CustomEventBannerListener customEventBannerListener2;
        MoPubErrorCode moPubErrorCode;
        this.f851 = customEventBannerListener;
        if (m763(map2)) {
            int parseInt = Integer.parseInt(map2.get(AD_WIDTH_KEY));
            int parseInt2 = Integer.parseInt(map2.get(AD_HEIGHT_KEY));
            this.f852 = new AdView(context);
            this.f852.setAdListener(new C0200());
            this.f852.setAdUnitId(map2.get("adUnitID"));
            AdSize m761 = m761(parseInt, parseInt2);
            if (m761 != null) {
                this.f852.setAdSize(m761);
                try {
                    this.f852.loadAd(new AdRequest.Builder().setRequestAgent("MoPub").build());
                    return;
                } catch (NoClassDefFoundError unused) {
                    customEventBannerListener2 = this.f851;
                    moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
                }
            }
        }
        customEventBannerListener2 = this.f851;
        moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
        customEventBannerListener2.onBannerFailed(moPubErrorCode);
    }
}
