package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.AppLovinNativeMediaView;
import com.mopub.nativeads.CustomEventNative;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class AppLovinMediationNative extends CustomEventNative {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Handler f1444 = new Handler(Looper.getMainLooper());

    /* renamed from: com.mopub.nativeads.AppLovinMediationNative$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0257 extends BaseNativeAd {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private AppLovinSdk f1445;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private CustomEventNative.CustomEventNativeListener f1446;

        /* renamed from: ࢥ  reason: contains not printable characters */
        private Context f1449;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private AppLovinNativeAd f1448 = null;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final Map<String, Object> f1447 = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.nativeads.AppLovinMediationNative$ࢠ$1  reason: invalid class name */
        /* loaded from: assets/classes2.dex */
        public class AnonymousClass1 implements AppLovinNativeAdLoadListener {
            AnonymousClass1() {
            }

            public void onNativeAdsFailedToLoad(int i) {
                MoPubLog.d("AppLovin native mediation, Failed to load native ad with code: " + i);
                if (C0257.this.f1446 != null) {
                    C0257.this.f1446.onNativeAdFailed(AppLovinMediationNative.m1266(i));
                }
            }

            public void onNativeAdsLoaded(List<AppLovinNativeAd> list) {
                C0257.this.f1445.getNativeAdService().precacheResources(list.get(0), new AppLovinNativeAdPrecacheListener() { // from class: com.mopub.nativeads.AppLovinMediationNative.ࢠ.1.1
                    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                        MoPubLog.d("AppLovin native mediation, Failed to precache native ad image with code: " + i);
                        if (C0257.this.f1446 != null) {
                            C0257.this.f1446.onNativeAdFailed(AppLovinMediationNative.m1266(i));
                        }
                    }

                    public void onNativeAdImagesPrecached(final AppLovinNativeAd appLovinNativeAd) {
                        AppLovinMediationNative.m1267(new Runnable() { // from class: com.mopub.nativeads.AppLovinMediationNative.ࢠ.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(appLovinNativeAd.getVideoUrl())) {
                                    C0257.this.m1270(appLovinNativeAd);
                                    if (C0257.this.f1446 != null) {
                                        C0257.this.f1446.onNativeAdLoaded(C0257.this);
                                    }
                                }
                            }
                        });
                    }

                    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
                        MoPubLog.d("AppLovin native mediation, Failed to precache native ad video with code: " + i);
                        if (C0257.this.f1446 != null) {
                            C0257.this.f1446.onNativeAdFailed(AppLovinMediationNative.m1266(i));
                        }
                    }

                    public void onNativeAdVideoPreceached(final AppLovinNativeAd appLovinNativeAd) {
                        AppLovinMediationNative.m1267(new Runnable() { // from class: com.mopub.nativeads.AppLovinMediationNative.ࢠ.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                C0257.this.m1270(appLovinNativeAd);
                                if (C0257.this.f1446 != null) {
                                    C0257.this.f1446.onNativeAdLoaded(C0257.this);
                                }
                            }
                        });
                    }
                });
            }
        }

        public C0257(Context context, AppLovinSdk appLovinSdk, CustomEventNative.CustomEventNativeListener customEventNativeListener) {
            this.f1449 = null;
            this.f1449 = context.getApplicationContext();
            this.f1445 = appLovinSdk;
            this.f1446 = customEventNativeListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m1270(AppLovinNativeAd appLovinNativeAd) {
            this.f1448 = appLovinNativeAd;
        }

        public void adIsClicked(View view) {
            if (this.f1448 != null) {
                m1298();
                this.f1448.launchClickTarget(view.getContext());
            }
        }

        public final void addExtra(String str, Object obj) {
            if (Preconditions.NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
                this.f1447.put(str, obj);
            }
        }

        @Override // com.mopub.nativeads.BaseNativeAd
        public void clear(@NonNull View view) {
        }

        @Override // com.mopub.nativeads.BaseNativeAd
        public void destroy() {
            this.f1448 = null;
        }

        public String getCta() {
            return this.f1448 != null ? this.f1448.getCtaText() : "";
        }

        public final Object getExtra(String str) {
            if (Preconditions.NoThrow.checkNotNull(str, "getExtra key is not allowed to be null")) {
                return this.f1447.get(str);
            }
            return null;
        }

        public final Map<String, Object> getExtras() {
            return new HashMap(this.f1447);
        }

        public String getIconImageUrl() {
            if (this.f1448 != null) {
                return this.f1448.getIconUrl();
            }
            return null;
        }

        public AppLovinNativeMediaView getMediaView() {
            if (this.f1448 == null || !(this.f1448.isImagePrecached() || this.f1448.isVideoPrecached())) {
                return null;
            }
            AppLovinNativeMediaView appLovinNativeMediaView = new AppLovinNativeMediaView(this.f1449);
            appLovinNativeMediaView.setAd(this.f1448);
            appLovinNativeMediaView.setVideoState(new AppLovinNativeMediaView.AppLovinNativeVideoState());
            appLovinNativeMediaView.setSdk(this.f1445);
            appLovinNativeMediaView.setUiHandler(new Handler(Looper.getMainLooper()));
            appLovinNativeMediaView.setUpView();
            appLovinNativeMediaView.autoplayVideo();
            return appLovinNativeMediaView;
        }

        public Drawable getRatingImage() {
            String replace = Float.toString(this.f1448 == null ? 0.0f : this.f1448.getStarRating()).replace(".", "_");
            return this.f1449.getResources().getDrawable(this.f1449.getResources().getIdentifier("applovin_star_sprite_" + replace, "drawable", this.f1449.getPackageName()));
        }

        public String getText() {
            return this.f1448 != null ? this.f1448.getDescriptionText() : "";
        }

        public String getTitle() {
            return this.f1448 != null ? this.f1448.getTitle() : "";
        }

        public void loadAd() {
            this.f1445.getNativeAdService().loadNextAd(new AnonymousClass1());
        }

        @Override // com.mopub.nativeads.BaseNativeAd
        public void prepare(@NonNull View view) {
            if (this.f1448 != null) {
                this.f1448.trackImpression(new AppLovinPostbackListener() { // from class: com.mopub.nativeads.AppLovinMediationNative.ࢠ.2
                    public void onPostbackFailure(String str, int i) {
                    }

                    public void onPostbackSuccess(String str) {
                        if (C0257.this.f1446 != null) {
                            C0257.this.m1296();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppLovinSdk m1263(Map<String, String> map, Context context) {
        String str = map != null ? map.get("sdk_key") : null;
        return !TextUtils.isEmpty(str) ? AppLovinSdk.getInstance(str, new AppLovinSdkSettings(), context) : AppLovinSdk.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static NativeErrorCode m1266(int i) {
        return i == 204 ? NativeErrorCode.NETWORK_NO_FILL : i == -1 ? NativeErrorCode.UNSPECIFIED : i == -103 ? NativeErrorCode.CONNECTION_ERROR : (i == -200 || i == -201 || i == -202) ? NativeErrorCode.IMAGE_DOWNLOAD_FAILURE : i == -102 ? NativeErrorCode.NETWORK_TIMEOUT : NativeErrorCode.UNSPECIFIED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1267(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f1444.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo1268(@NonNull Context context, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), context);
        AppLovinSdk m1263 = m1263(map2, context);
        m1263.setPluginVersion("MoPub-3.1.0");
        m1263.setMediationProvider(BuildConfig.SDK_NAME);
        new C0257(context, m1263, customEventNativeListener).loadAd();
    }
}
