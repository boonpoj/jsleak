package com.mopub.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.flurry.android.FlurryAgentListener;
import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeListener;
import com.flurry.android.ads.FlurryAdTargeting;
import com.mopub.mobileads.FlurryAgentWrapper;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.NativeImageHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public final class FlurryCustomEventNative extends CustomEventNative {
    public static final String EXTRA_APP_CATEGORY = "flurry_appcategorytext";
    public static final String EXTRA_SEC_ADVERTISER_NAME = "flurry_advertisername";
    public static final String EXTRA_SEC_BRANDING_LOGO = "flurry_brandingimage";
    public static final String EXTRA_STAR_RATING_IMG = "flurry_starratingimage";
    public static final String LOCAL_EXTRA_TEST_MODE = "enableTestMode";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f1508 = "FlurryCustomEventNative";

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static final List<FlurryAdNative> f1509 = new ArrayList();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private FlurryAgentListener f1510;

    /* renamed from: com.mopub.nativeads.FlurryCustomEventNative$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static abstract class AbstractC0260 implements FlurryAdNativeListener {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final C0261 f1516;

        AbstractC0260(@NonNull C0261 c0261) {
            this.f1516 = c0261;
        }

        public void onAppExit(FlurryAdNative flurryAdNative) {
        }

        public void onClicked(FlurryAdNative flurryAdNative) {
        }

        public void onCloseFullscreen(FlurryAdNative flurryAdNative) {
        }

        public void onCollapsed(FlurryAdNative flurryAdNative) {
        }

        public void onError(FlurryAdNative flurryAdNative, FlurryAdErrorType flurryAdErrorType, int i) {
            FlurryCustomEventNative.f1509.remove(flurryAdNative);
        }

        public void onExpanded(FlurryAdNative flurryAdNative) {
        }

        public void onFetched(FlurryAdNative flurryAdNative) {
            FlurryCustomEventNative.m1309(this.f1516, flurryAdNative);
            FlurryCustomEventNative.f1509.remove(flurryAdNative);
        }

        public void onImpressionLogged(FlurryAdNative flurryAdNative) {
        }

        public void onShowFullscreen(FlurryAdNative flurryAdNative) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.FlurryCustomEventNative$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0261 extends BaseNativeAd {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Context f1518;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final CustomEventNative.CustomEventNativeListener f1519;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final FlurryAdNative f1520;
        @Nullable

        /* renamed from: ࢥ  reason: contains not printable characters */
        private String f1522;
        @Nullable

        /* renamed from: ࢦ  reason: contains not printable characters */
        private String f1523;
        @Nullable

        /* renamed from: ࢧ  reason: contains not printable characters */
        private String f1524;
        @Nullable

        /* renamed from: ࢨ  reason: contains not printable characters */
        private String f1525;
        @Nullable

        /* renamed from: ࢩ  reason: contains not printable characters */
        private String f1526;
        @Nullable

        /* renamed from: ࢪ  reason: contains not printable characters */
        private String f1527;
        @Nullable

        /* renamed from: ࢫ  reason: contains not printable characters */
        private String f1528;
        @Nullable

        /* renamed from: ࢬ  reason: contains not printable characters */
        private Double f1529;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final FlurryAdNativeListener f1521 = new AbstractC0260(this) { // from class: com.mopub.nativeads.FlurryCustomEventNative.ࢢ.1
            @Override // com.mopub.nativeads.FlurryCustomEventNative.AbstractC0260
            public void onClicked(FlurryAdNative flurryAdNative) {
                super.onClicked(flurryAdNative);
                C0261.this.m1298();
            }

            @Override // com.mopub.nativeads.FlurryCustomEventNative.AbstractC0260
            public void onError(FlurryAdNative flurryAdNative, FlurryAdErrorType flurryAdErrorType, int i) {
                super.onError(flurryAdNative, flurryAdErrorType, i);
                C0261.this.f1519.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
            }

            @Override // com.mopub.nativeads.FlurryCustomEventNative.AbstractC0260
            public void onImpressionLogged(FlurryAdNative flurryAdNative) {
                super.onImpressionLogged(flurryAdNative);
                C0261.this.m1296();
            }
        };
        @NonNull

        /* renamed from: ֏  reason: contains not printable characters */
        private final Map<String, Object> f1517 = new HashMap();

        C0261(@NonNull Context context, @NonNull FlurryAdNative flurryAdNative, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener) {
            this.f1518 = context;
            this.f1520 = flurryAdNative;
            this.f1519 = customEventNativeListener;
        }

        public void addExtra(@NonNull String str, @Nullable Object obj) {
            this.f1517.put(str, obj);
        }

        @Override // com.mopub.nativeads.BaseNativeAd
        public void clear(@NonNull View view) {
            this.f1520.removeTrackingView();
        }

        @Override // com.mopub.nativeads.BaseNativeAd
        public void destroy() {
            this.f1520.destroy();
            FlurryAgentWrapper.getInstance().endSession(this.f1518);
        }

        public synchronized void fetchAd() {
            this.f1520.setListener(this.f1521);
            this.f1520.fetchAd();
        }

        @Nullable
        public String getAdvertiserName() {
            return this.f1524;
        }

        @Nullable
        public String getCallToAction() {
            return this.f1525;
        }

        @NonNull
        public Map<String, Object> getExtras() {
            return this.f1517;
        }

        @Nullable
        public String getIconImageUrl() {
            return this.f1527;
        }

        @NonNull
        public List<String> getImageUrls() {
            ArrayList arrayList = new ArrayList(2);
            String mainImageUrl = getMainImageUrl();
            if (mainImageUrl != null) {
                arrayList.add(mainImageUrl);
            }
            String iconImageUrl = getIconImageUrl();
            if (iconImageUrl != null) {
                arrayList.add(iconImageUrl);
            }
            String sponsoredMarkerImageUrl = getSponsoredMarkerImageUrl();
            if (sponsoredMarkerImageUrl != null) {
                arrayList.add(sponsoredMarkerImageUrl);
            }
            return arrayList;
        }

        @Nullable
        public String getMainImageUrl() {
            return this.f1526;
        }

        @Nullable
        public String getSponsoredMarkerImageUrl() {
            return this.f1528;
        }

        @Nullable
        public Double getStarRating() {
            return this.f1529;
        }

        @Nullable
        public String getText() {
            return this.f1523;
        }

        @Nullable
        public String getTitle() {
            return this.f1522;
        }

        public boolean isAppInstallAd() {
            return (this.f1520.getAsset("secRatingImg") == null && this.f1520.getAsset("secHqRatingImg") == null && this.f1520.getAsset("appCategory") == null) ? false : true;
        }

        public void onNativeAdLoaded() {
            this.f1519.onNativeAdLoaded(this);
        }

        public void precacheImages() {
            NativeImageHelper.preCacheImages(this.f1518, getImageUrls(), new NativeImageHelper.ImageListener() { // from class: com.mopub.nativeads.FlurryCustomEventNative.ࢢ.2
                @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
                public void onImagesCached() {
                    C0261.this.f1519.onNativeAdLoaded(C0261.this);
                }

                @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
                public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
                    C0261.this.f1519.onNativeAdFailed(nativeErrorCode);
                }
            });
        }

        @Override // com.mopub.nativeads.BaseNativeAd
        public void prepare(@NonNull View view) {
            this.f1520.setTrackingView(view);
        }

        public void setAdvertiserName(@Nullable String str) {
            this.f1524 = str;
        }

        public void setCallToAction(@Nullable String str) {
            this.f1525 = str;
        }

        public void setIconImageUrl(@Nullable String str) {
            this.f1527 = str;
        }

        public void setMainImageUrl(@Nullable String str) {
            this.f1526 = str;
        }

        public void setSponsoredMarkerImageUrl(@Nullable String str) {
            this.f1528 = str;
        }

        public void setStarRating(@Nullable Double d) {
            this.f1529 = d;
        }

        public void setText(@Nullable String str) {
            this.f1523 = str;
        }

        public void setTitle(@Nullable String str) {
            this.f1522 = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m1311(@NonNull ViewGroup viewGroup) {
            this.f1520.getAsset("videoUrl").loadAssetIntoView(viewGroup);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢥ  reason: contains not printable characters */
        public boolean m1312() {
            return this.f1520.isVideoAd();
        }
    }

    @Nullable
    /* renamed from: ࢠ  reason: contains not printable characters */
    private static Double m1303(@Nullable String str) {
        String[] split;
        if (str != null) {
            if (str.split("/").length == 2) {
                try {
                    double intValue = Integer.valueOf(split[0]).intValue() / Integer.valueOf(split[1]).intValue();
                    Double.isNaN(intValue);
                    return Double.valueOf(intValue * 5.0d);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1304(@NonNull Context context, String str, @NonNull Map<String, Object> map, @NonNull CustomEventNative.CustomEventNativeListener customEventNativeListener) {
        FlurryAdNative flurryAdNative = new FlurryAdNative(context, str);
        if (map.containsKey(LOCAL_EXTRA_TEST_MODE) && (map.get(LOCAL_EXTRA_TEST_MODE) instanceof Boolean)) {
            new FlurryAdTargeting().setEnableTestAds(((Boolean) map.get(LOCAL_EXTRA_TEST_MODE)).booleanValue());
        }
        C0261 c0261 = new C0261(context, flurryAdNative, customEventNativeListener);
        f1509.add(flurryAdNative);
        c0261.fetchAd();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m1307(Map<String, String> map) {
        return (TextUtils.isEmpty(map.get(FlurryAgentWrapper.PARAM_API_KEY)) || TextUtils.isEmpty(map.get(FlurryAgentWrapper.PARAM_AD_SPACE_NAME))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[Catch: all -> 0x00f6, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0015, B:9:0x001c, B:11:0x0024, B:13:0x002e, B:14:0x0035, B:16:0x0057, B:18:0x0061, B:19:0x0068, B:21:0x007b, B:23:0x0083, B:25:0x008d, B:26:0x0093, B:32:0x00b0, B:34:0x00b8, B:35:0x00c1, B:37:0x00c9, B:27:0x0097, B:29:0x009f, B:31:0x00a9, B:38:0x00d4, B:40:0x00dc, B:41:0x00e3, B:43:0x00ed, B:44:0x00f1), top: B:50:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9 A[Catch: all -> 0x00f6, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0015, B:9:0x001c, B:11:0x0024, B:13:0x002e, B:14:0x0035, B:16:0x0057, B:18:0x0061, B:19:0x0068, B:21:0x007b, B:23:0x0083, B:25:0x008d, B:26:0x0093, B:32:0x00b0, B:34:0x00b8, B:35:0x00c1, B:37:0x00c9, B:27:0x0097, B:29:0x009f, B:31:0x00a9, B:38:0x00d4, B:40:0x00dc, B:41:0x00e3, B:43:0x00ed, B:44:0x00f1), top: B:50:0x0003 }] */
    /* renamed from: ࢢ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void m1309(@android.support.annotation.NonNull com.mopub.nativeads.FlurryCustomEventNative.C0261 r3, @android.support.annotation.NonNull com.flurry.android.ads.FlurryAdNative r4) {
        /*
            java.lang.Class<com.mopub.nativeads.FlurryCustomEventNative> r0 = com.mopub.nativeads.FlurryCustomEventNative.class
            monitor-enter(r0)
            java.lang.String r1 = "secHqImage"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto L1c
            java.lang.String r2 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf6
            if (r2 != 0) goto L1c
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setMainImageUrl(r1)     // Catch: java.lang.Throwable -> Lf6
        L1c:
            java.lang.String r1 = "secImage"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto L35
            java.lang.String r2 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf6
            if (r2 != 0) goto L35
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setIconImageUrl(r1)     // Catch: java.lang.Throwable -> Lf6
        L35:
            java.lang.String r1 = "headline"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setTitle(r1)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r1 = "summary"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setText(r1)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r1 = "secHqBrandingLogo"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto L68
            java.lang.String r2 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf6
            if (r2 != 0) goto L68
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setSponsoredMarkerImageUrl(r1)     // Catch: java.lang.Throwable -> Lf6
        L68:
            java.lang.String r1 = "source"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setAdvertiserName(r1)     // Catch: java.lang.Throwable -> Lf6
            boolean r1 = r3.isAppInstallAd()     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto Ld4
            java.lang.String r1 = "secHqRatingImg"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto L97
            java.lang.String r2 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf6
            if (r2 != 0) goto L97
            java.lang.String r2 = "flurry_starratingimage"
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
        L93:
            r3.addExtra(r2, r1)     // Catch: java.lang.Throwable -> Lf6
            goto Lb0
        L97:
            java.lang.String r1 = "secRatingImg"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto Lb0
            java.lang.String r2 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf6
            if (r2 != 0) goto Lb0
            java.lang.String r2 = "flurry_starratingimage"
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            goto L93
        Lb0:
            java.lang.String r1 = "appCategory"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto Lc1
            java.lang.String r2 = "flurry_appcategorytext"
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.addExtra(r2, r1)     // Catch: java.lang.Throwable -> Lf6
        Lc1:
            java.lang.String r1 = "appRating"
            com.flurry.android.ads.FlurryAdNativeAsset r1 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r1 == 0) goto Ld4
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> Lf6
            java.lang.Double r1 = m1303(r1)     // Catch: java.lang.Throwable -> Lf6
            r3.setStarRating(r1)     // Catch: java.lang.Throwable -> Lf6
        Ld4:
            java.lang.String r1 = "callToAction"
            com.flurry.android.ads.FlurryAdNativeAsset r4 = r4.getAsset(r1)     // Catch: java.lang.Throwable -> Lf6
            if (r4 == 0) goto Le3
            java.lang.String r4 = r4.getValue()     // Catch: java.lang.Throwable -> Lf6
            r3.setCallToAction(r4)     // Catch: java.lang.Throwable -> Lf6
        Le3:
            java.util.List r4 = r3.getImageUrls()     // Catch: java.lang.Throwable -> Lf6
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> Lf6
            if (r4 == 0) goto Lf1
            r3.onNativeAdLoaded()     // Catch: java.lang.Throwable -> Lf6
            goto Lf4
        Lf1:
            r3.precacheImages()     // Catch: java.lang.Throwable -> Lf6
        Lf4:
            monitor-exit(r0)
            return
        Lf6:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.FlurryCustomEventNative.m1309(com.mopub.nativeads.FlurryCustomEventNative$ࢢ, com.flurry.android.ads.FlurryAdNative):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.nativeads.CustomEventNative
    /* renamed from: ࢠ */
    public void mo1268(@NonNull final Context context, @NonNull final CustomEventNative.CustomEventNativeListener customEventNativeListener, @NonNull final Map<String, Object> map, @NonNull Map<String, String> map2) {
        if (!m1307(map2)) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        String str = map2.get(FlurryAgentWrapper.PARAM_API_KEY);
        final String str2 = map2.get(FlurryAgentWrapper.PARAM_AD_SPACE_NAME);
        if (FlurryAgentWrapper.getInstance().isSessionActive() || this.f1510 != null) {
            m1304(context, str2, map, customEventNativeListener);
            return;
        }
        this.f1510 = new FlurryAgentListener() { // from class: com.mopub.nativeads.FlurryCustomEventNative.1
            public void onSessionStarted() {
                FlurryCustomEventNative.this.m1304(context, str2, map, customEventNativeListener);
            }
        };
        FlurryAgentWrapper.getInstance().startSession(context, str, this.f1510);
    }
}
