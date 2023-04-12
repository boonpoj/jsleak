package com.mopub.mobileads;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.chartboost.sdk.Chartboost;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MediationSettings;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventRewardedVideo;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class ChartboostRewardedVideo extends CustomEventRewardedVideo {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final LifecycleListener f801 = new C0196();
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String f802 = ChartboostShared.LOCATION_DEFAULT;
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Handler f803 = new Handler();

    /* loaded from: assets/classes2.dex */
    public static final class ChartboostMediationSettings implements MediationSettings {
        @NonNull

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f805;

        public ChartboostMediationSettings(@NonNull String str) {
            this.f805 = str;
        }

        @NonNull
        public String getCustomId() {
            return this.f805;
        }
    }

    /* renamed from: com.mopub.mobileads.ChartboostRewardedVideo$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static final class C0196 implements LifecycleListener {
        private C0196() {
        }

        @Override // com.mopub.common.LifecycleListener
        public void onBackPressed(@NonNull Activity activity) {
            Chartboost.onBackPressed();
        }

        @Override // com.mopub.common.LifecycleListener
        public void onCreate(@NonNull Activity activity) {
            Chartboost.onCreate(activity);
        }

        @Override // com.mopub.common.LifecycleListener
        public void onDestroy(@NonNull Activity activity) {
            Chartboost.onDestroy(activity);
        }

        @Override // com.mopub.common.LifecycleListener
        public void onPause(@NonNull Activity activity) {
            Chartboost.onPause(activity);
        }

        @Override // com.mopub.common.LifecycleListener
        public void onRestart(@NonNull Activity activity) {
        }

        @Override // com.mopub.common.LifecycleListener
        public void onResume(@NonNull Activity activity) {
            Chartboost.onResume(activity);
        }

        @Override // com.mopub.common.LifecycleListener
        public void onStart(@NonNull Activity activity) {
            Chartboost.onStart(activity);
        }

        @Override // com.mopub.common.LifecycleListener
        public void onStop(@NonNull Activity activity) {
            Chartboost.onStop(activity);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m736(String str) {
        String customId;
        ChartboostMediationSettings chartboostMediationSettings = (ChartboostMediationSettings) MoPubRewardedVideoManager.getGlobalMediationSettings(ChartboostMediationSettings.class);
        ChartboostMediationSettings chartboostMediationSettings2 = (ChartboostMediationSettings) MoPubRewardedVideoManager.getInstanceMediationSettings(ChartboostMediationSettings.class, str);
        if (chartboostMediationSettings2 != null) {
            customId = chartboostMediationSettings2.getCustomId();
        } else if (chartboostMediationSettings == null) {
            return;
        } else {
            customId = chartboostMediationSettings.getCustomId();
        }
        Chartboost.setCustomId(customId);
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    public boolean checkAndInitializeSdk(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        ChartboostShared.initializeSdk(activity, map2);
        return true;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public String getAdNetworkId() {
        return this.f802;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public LifecycleListener getLifecycleListener() {
        return f801;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    @NonNull
    public CustomEventRewardedVideo.CustomEventRewardedVideoListener getVideoListenerForSdk() {
        return ChartboostShared.getDelegate();
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    public boolean hasVideoAvailable() {
        return Chartboost.hasRewardedVideo(this.f802);
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    public void showVideo() {
        if (hasVideoAvailable()) {
            Chartboost.showRewardedVideo(this.f802);
        } else {
            MoPubLog.d("Attempted to show Chartboost rewarded video before it was available.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo654() {
        ChartboostShared.getDelegate().unregisterRewardedVideoLocation(this.f802);
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    protected void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        if (map2.containsKey("location")) {
            String str = map2.get("location");
            if (TextUtils.isEmpty(str)) {
                str = this.f802;
            }
            this.f802 = str;
        }
        ChartboostShared.getDelegate().registerRewardedVideoLocation(this.f802);
        m736((String) map.get(DataKeys.AD_UNIT_ID_KEY));
        this.f803.post(new Runnable() { // from class: com.mopub.mobileads.ChartboostRewardedVideo.1
            @Override // java.lang.Runnable
            public void run() {
                if (Chartboost.hasRewardedVideo(ChartboostRewardedVideo.this.f802)) {
                    ChartboostShared.getDelegate().didCacheRewardedVideo(ChartboostRewardedVideo.this.f802);
                } else {
                    Chartboost.cacheRewardedVideo(ChartboostRewardedVideo.this.f802);
                }
            }
        });
    }
}
