package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.mopub.common.DataKeys;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Views;
import com.mopub.mobileads.CustomEventBanner;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class AppLovinBanner extends CustomEventBanner {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Handler f757 = new Handler(Looper.getMainLooper());

    /* renamed from: ࢢ  reason: contains not printable characters */
    private CustomEventBanner.CustomEventBannerListener f758;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AppLovinAdView f759;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AppLovinAdSize m692(Map<String, Object> map) {
        String str;
        if (map == null || map.isEmpty()) {
            MoPubLog.d("No serverExtras provided");
            return null;
        }
        try {
            int intValue = ((Integer) map.get(DataKeys.AD_WIDTH)).intValue();
            int intValue2 = ((Integer) map.get(DataKeys.AD_HEIGHT)).intValue();
            if (intValue <= 0 || intValue2 <= 0) {
                str = "Invalid width (" + intValue + ") and height (" + intValue2 + ") provided";
            } else {
                MoPubLog.d("Valid width (" + intValue + ") and height (" + intValue2 + ") provided");
                int abs = Math.abs(50 - intValue2);
                int abs2 = Math.abs(90 - intValue2);
                if (abs <= 10) {
                    return AppLovinAdSize.BANNER;
                }
                if (abs2 <= 16) {
                    return AppLovinAdSize.LEADER;
                }
                if (intValue2 <= AppLovinAdSize.MREC.getHeight()) {
                    return AppLovinAdSize.MREC;
                }
                str = "Provided dimensions does not meet the dimensions required of banner or mrec ads";
            }
            MoPubLog.d(str);
        } catch (Throwable th) {
            MoPubLog.d("Encountered error while parsing width and height from serverExtras", th);
        }
        return null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppLovinSdk m693(Map<String, String> map, Context context) {
        String str = map != null ? map.get("sdk_key") : null;
        return !TextUtils.isEmpty(str) ? AppLovinSdk.getInstance(str, new AppLovinSdkSettings(), context) : AppLovinSdk.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static MoPubErrorCode m697(int i) {
        return i == 204 ? MoPubErrorCode.NETWORK_NO_FILL : i == -1 ? MoPubErrorCode.UNSPECIFIED : i == -103 ? MoPubErrorCode.NO_CONNECTION : i == -102 ? MoPubErrorCode.NETWORK_TIMEOUT : MoPubErrorCode.UNSPECIFIED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo698() {
        Views.removeFromParent(this.f759);
        if (this.f759 != null) {
            this.f759.setAdLoadListener((AppLovinAdLoadListener) null);
            this.f759.setAdDisplayListener((AppLovinAdDisplayListener) null);
            this.f759.setAdClickListener((AppLovinAdClickListener) null);
            this.f759.destroy();
            this.f759 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo699(Context context, CustomEventBanner.CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2) {
        this.f758 = customEventBannerListener;
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), context);
        AppLovinAdSize m692 = m692(map);
        if (m692 == null) {
            MoPubLog.d("Unable to request AppLovin banner");
            if (this.f758 != null) {
                this.f758.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            return;
        }
        boolean z = !TextUtils.isEmpty(map2.get(DataKeys.ADM_KEY));
        MoPubLog.d("Requesting AppLovin banner with serverExtras: " + map2 + ", localExtras: " + map + " and has ad markup: " + z);
        AppLovinSdk m693 = m693(map2, context);
        m693.setPluginVersion("MoPub-3.1.0");
        m693.setMediationProvider(com.integralads.avid.library.mopub.BuildConfig.SDK_NAME);
        if (z) {
            MoPubLog.d("mopub mediation for Applovin doesn't support adMarkup now");
            if (this.f758 != null) {
                this.f758.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            return;
        }
        String str = map2.get("zone_id");
        if (m692.equals(AppLovinAdSize.MREC)) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            this.f759 = new AppLovinAdView(m692, context);
        } else {
            this.f759 = new AppLovinAdView(m692, str, context);
        }
        this.f759.setAdLoadListener(new AppLovinAdLoadListener() { // from class: com.mopub.mobileads.AppLovinBanner.1
            public void adReceived(AppLovinAd appLovinAd) {
                MoPubLog.d("Successfully loaded banner ad");
                try {
                    if (AppLovinBanner.this.f758 != null) {
                        AppLovinBanner.this.f758.onBannerLoaded(AppLovinBanner.this.f759);
                    }
                } catch (Throwable th) {
                    MoPubLog.e("Unable to notify listener of successful ad load.", th);
                }
            }

            public void failedToReceiveAd(int i) {
                MoPubLog.d("Failed to load banner ad with code: " + i);
                try {
                    if (AppLovinBanner.this.f758 != null) {
                        AppLovinBanner.this.f758.onBannerFailed(AppLovinBanner.m697(i));
                    }
                } catch (Throwable th) {
                    MoPubLog.e("Unable to notify listener of failure to receive ad.", th);
                }
            }
        });
        this.f759.setAdDisplayListener(new AppLovinAdDisplayListener() { // from class: com.mopub.mobileads.AppLovinBanner.2
            public void adDisplayed(AppLovinAd appLovinAd) {
                MoPubLog.d("Banner displayed");
            }

            public void adHidden(AppLovinAd appLovinAd) {
                MoPubLog.d("Banner dismissed");
            }
        });
        this.f759.setAdClickListener(new AppLovinAdClickListener() { // from class: com.mopub.mobileads.AppLovinBanner.3
            public void adClicked(AppLovinAd appLovinAd) {
                MoPubLog.d("Banner clicked");
                if (AppLovinBanner.this.f758 != null) {
                    AppLovinBanner.this.f758.onBannerClicked();
                }
            }
        });
        this.f759.setAdViewEventListener(new AppLovinAdViewEventListener() { // from class: com.mopub.mobileads.AppLovinBanner.4
            public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                MoPubLog.d("Banner closed fullscreen");
                if (AppLovinBanner.this.f758 != null) {
                    AppLovinBanner.this.f758.onBannerCollapsed();
                }
            }

            public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
            }

            public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                MoPubLog.d("Banner left application");
            }

            public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                MoPubLog.d("Banner opened fullscreen");
                if (AppLovinBanner.this.f758 != null) {
                    AppLovinBanner.this.f758.onBannerExpanded();
                }
            }
        });
        this.f759.loadNextAd();
    }
}
