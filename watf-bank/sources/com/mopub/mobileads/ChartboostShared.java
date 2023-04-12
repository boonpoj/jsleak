package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Model.CBError;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventRewardedVideo;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: assets/classes2.dex */
public class ChartboostShared {
    public static final String APP_ID_KEY = "appId";
    public static final String APP_SIGNATURE_KEY = "appSignature";
    public static final String LOCATION_DEFAULT = "Default";
    public static final String LOCATION_KEY = "location";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile ChartboostSingletonDelegate f806 = new ChartboostSingletonDelegate();
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static String f807;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static String f808;

    /* loaded from: assets/classes2.dex */
    public static class ChartboostSingletonDelegate extends ChartboostDelegate implements CustomEventRewardedVideo.CustomEventRewardedVideoListener {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static final CustomEventInterstitial.CustomEventInterstitialListener f809 = new CustomEventInterstitial.CustomEventInterstitialListener() { // from class: com.mopub.mobileads.ChartboostShared.ChartboostSingletonDelegate.1
            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onInterstitialClicked() {
            }

            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onInterstitialDismissed() {
            }

            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
            }

            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onInterstitialImpression() {
            }

            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onInterstitialLoaded() {
            }

            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onInterstitialShown() {
            }

            @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
            public void onLeaveApplication() {
            }
        };

        /* renamed from: ࢢ  reason: contains not printable characters */
        private Map<String, CustomEventInterstitial.CustomEventInterstitialListener> f810 = Collections.synchronizedMap(new TreeMap());

        /* renamed from: ࢣ  reason: contains not printable characters */
        private Set<String> f811 = Collections.synchronizedSet(new TreeSet());

        public void didCacheInterstitial(String str) {
            MoPubLog.d("Chartboost interstitial loaded successfully.");
            getInterstitialListener(str).onInterstitialLoaded();
        }

        public void didCacheRewardedVideo(String str) {
            super.didCacheRewardedVideo(str);
            if (this.f811.contains(str)) {
                MoPubLog.d("Chartboost rewarded video cached for location " + str + ".");
                MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(ChartboostRewardedVideo.class, str);
                this.f811.remove(str);
            }
        }

        public void didClickInterstitial(String str) {
            MoPubLog.d("Chartboost interstitial ad clicked.");
            getInterstitialListener(str).onInterstitialClicked();
        }

        public void didClickRewardedVideo(String str) {
            super.didClickRewardedVideo(str);
            MoPubRewardedVideoManager.onRewardedVideoClicked(ChartboostRewardedVideo.class, str);
            MoPubLog.d("Chartboost rewarded video clicked for location " + str + ".");
        }

        public void didCloseInterstitial(String str) {
            MoPubLog.d("Chartboost interstitial ad closed.");
        }

        public void didCloseRewardedVideo(String str) {
            super.didCloseRewardedVideo(str);
            MoPubLog.d("Chartboost rewarded video closed for location " + str + ".");
        }

        public void didCompleteRewardedVideo(String str, int i) {
            super.didCompleteRewardedVideo(str, i);
            MoPubLog.d("Chartboost rewarded video completed for location " + str + " with reward amount " + i);
            MoPubRewardedVideoManager.onRewardedVideoCompleted(ChartboostRewardedVideo.class, str, MoPubReward.success("", i));
        }

        public void didDismissInterstitial(String str) {
            MoPubLog.d("Chartboost interstitial ad dismissed.");
            getInterstitialListener(str).onInterstitialDismissed();
        }

        public void didDismissRewardedVideo(String str) {
            super.didDismissRewardedVideo(str);
            MoPubRewardedVideoManager.onRewardedVideoClosed(ChartboostRewardedVideo.class, str);
            MoPubLog.d("Chartboost rewarded video dismissed for location " + str + ".");
        }

        public void didDisplayInterstitial(String str) {
            MoPubLog.d("Chartboost interstitial ad shown.");
            getInterstitialListener(str).onInterstitialShown();
        }

        public void didDisplayRewardedVideo(String str) {
            super.didDisplayRewardedVideo(str);
            MoPubLog.d("Chartboost rewarded video displayed for location " + str + ".");
            MoPubRewardedVideoManager.onRewardedVideoStarted(ChartboostRewardedVideo.class, str);
        }

        public void didFailToLoadInterstitial(String str, CBError.CBImpressionError cBImpressionError) {
            String str2;
            if (cBImpressionError != null) {
                str2 = "Error: " + cBImpressionError.name();
            } else {
                str2 = "";
            }
            Log.d("MoPub", "Chartboost interstitial ad failed to load." + str2);
            getInterstitialListener(str).onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }

        public void didFailToLoadRewardedVideo(String str, CBError.CBImpressionError cBImpressionError) {
            String str2;
            super.didFailToLoadRewardedVideo(str, cBImpressionError);
            if (cBImpressionError != null) {
                str2 = " with error: " + cBImpressionError.name();
            } else {
                str2 = "";
            }
            if (this.f811.contains(str)) {
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_DOWNLOAD_ERROR;
                MoPubLog.d("Chartboost rewarded video cache failed for location " + str + str2);
                if (CBError.CBImpressionError.INVALID_LOCATION.equals(cBImpressionError)) {
                    moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
                }
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(ChartboostRewardedVideo.class, str, moPubErrorCode);
                this.f811.remove(str);
            }
        }

        @NonNull
        public CustomEventInterstitial.CustomEventInterstitialListener getInterstitialListener(@NonNull String str) {
            CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener = this.f810.get(str);
            return customEventInterstitialListener != null ? customEventInterstitialListener : f809;
        }

        public boolean hasInterstitialLocation(@NonNull String str) {
            return this.f810.containsKey(str);
        }

        public void registerInterstitialListener(@NonNull String str, @NonNull CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(customEventInterstitialListener);
            this.f810.put(str, customEventInterstitialListener);
        }

        public void registerRewardedVideoLocation(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f811.add(str);
        }

        public boolean shouldDisplayMoreApps(String str) {
            return false;
        }

        public boolean shouldRequestMoreApps(String str) {
            return false;
        }

        public void unregisterInterstitialListener(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f810.remove(str);
        }

        public void unregisterRewardedVideoLocation(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f811.remove(str);
        }
    }

    @NonNull
    public static ChartboostSingletonDelegate getDelegate() {
        return f806;
    }

    public static synchronized boolean initializeSdk(@NonNull Activity activity, @NonNull Map<String, String> map) {
        synchronized (ChartboostShared.class) {
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(map);
            Chartboost.setPIDataUseConsent(activity.getApplicationContext(), MoPub.canCollectPersonalInformation() ? Chartboost.CBPIDataUseConsent.YES_BEHAVIORAL : Chartboost.CBPIDataUseConsent.NO_BEHAVIORAL);
            if (map.containsKey("appId")) {
                if (map.containsKey(APP_SIGNATURE_KEY)) {
                    String str = map.get("appId");
                    String str2 = map.get(APP_SIGNATURE_KEY);
                    if (str.equals(f807) && str2.equals(f808)) {
                        return false;
                    }
                    f807 = str;
                    f808 = str2;
                    Chartboost.startWithAppId(activity, f807, f808);
                    Chartboost.setMediation(Chartboost.CBMediation.CBMediationMoPub, "5.4.1");
                    Chartboost.setDelegate(f806);
                    Chartboost.setShouldRequestInterstitialsInFirstSession(true);
                    Chartboost.setAutoCacheAds(false);
                    Chartboost.setShouldDisplayLoadingViewForMoreApps(false);
                    return true;
                }
                throw new IllegalStateException("Chartboost rewarded video initialization failed due to missing application signature.");
            }
            throw new IllegalStateException("Chartboost rewarded video initialization failed due to missing application ID.");
        }
    }
}
