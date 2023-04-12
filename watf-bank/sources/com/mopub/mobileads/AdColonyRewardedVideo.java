package com.mopub.mobileads;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.mopub.common.BaseLifecycleListener;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.Json;
import com.mopub.mobileads.CustomEventRewardedVideo;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: assets/classes2.dex */
public class AdColonyRewardedVideo extends CustomEventRewardedVideo {
    public static final String ALL_ZONE_IDS_KEY = "allZoneIds";
    public static final String APP_ID_KEY = "appId";
    public static final String CLIENT_OPTIONS_KEY = "clientOptions";
    public static final String ZONE_ID_KEY = "zoneId";

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static String[] f705;

    /* renamed from: ࢠ  reason: contains not printable characters */
    com.adcolony.sdk.ࢨ f709;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private C0195 f711;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static final String[] f702 = {"ZONE_ID_1", "ZONE_ID_2", "..."};

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static boolean f703 = false;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static LifecycleListener f704 = new BaseLifecycleListener();

    /* renamed from: ࢪ  reason: contains not printable characters */
    private static WeakHashMap<String, com.adcolony.sdk.ࢨ> f706 = new WeakHashMap<>();
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private String f710 = "YOUR_CURRENT_ZONE_ID";

    /* renamed from: ࢨ  reason: contains not printable characters */
    private com.adcolony.sdk.ࢢ f712 = new com.adcolony.sdk.ࢢ();

    /* renamed from: ࢩ  reason: contains not printable characters */
    private com.adcolony.sdk.ࢤ f713 = new com.adcolony.sdk.ࢤ();
    @NonNull

    /* renamed from: ࢫ  reason: contains not printable characters */
    private String f714 = "";

    /* renamed from: ࢬ  reason: contains not printable characters */
    private boolean f715 = false;

    /* renamed from: ֏  reason: contains not printable characters */
    private final Handler f707 = new Handler();

    /* renamed from: ؠ  reason: contains not printable characters */
    private final ScheduledThreadPoolExecutor f708 = new ScheduledThreadPoolExecutor(1);

    /* loaded from: assets/classes2.dex */
    public static final class AdColonyGlobalMediationSettings implements MediationSettings {
        @Nullable

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final String f718;

        public AdColonyGlobalMediationSettings(@Nullable String str) {
            this.f718 = str;
        }

        @Nullable
        public String getUserId() {
            return this.f718;
        }
    }

    /* loaded from: assets/classes2.dex */
    public static final class AdColonyInstanceMediationSettings implements MediationSettings {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final boolean f719;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final boolean f720;

        public AdColonyInstanceMediationSettings(boolean z, boolean z2) {
            this.f719 = z;
            this.f720 = z2;
        }

        public boolean withConfirmationDialog() {
            return this.f719;
        }

        public boolean withResultsDialog() {
            return this.f720;
        }
    }

    /* renamed from: com.mopub.mobileads.AdColonyRewardedVideo$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    private static class C0195 extends com.adcolony.sdk.ࢩ implements com.adcolony.sdk.֏, CustomEventRewardedVideo.CustomEventRewardedVideoListener {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private com.adcolony.sdk.ࢢ f721;

        C0195(com.adcolony.sdk.ࢢ r1) {
            this.f721 = r1;
        }

        public void onClicked(@NonNull com.adcolony.sdk.ࢨ r2) {
            MoPubRewardedVideoManager.onRewardedVideoClicked(AdColonyRewardedVideo.class, r2.ࢣ());
        }

        public void onClosed(@NonNull com.adcolony.sdk.ࢨ r2) {
            MoPubRewardedVideoManager.onRewardedVideoClosed(AdColonyRewardedVideo.class, r2.ࢣ());
        }

        public void onExpiring(@NonNull com.adcolony.sdk.ࢨ r3) {
            com.adcolony.sdk.ࢠ.ࢠ(r3.ࢣ(), r3.ࢢ(), this.f721);
        }

        public void onOpened(@NonNull com.adcolony.sdk.ࢨ r2) {
            MoPubRewardedVideoManager.onRewardedVideoStarted(AdColonyRewardedVideo.class, r2.ࢣ());
        }

        public void onRequestFilled(@NonNull com.adcolony.sdk.ࢨ r3) {
            AdColonyRewardedVideo.f706.put(r3.ࢣ(), r3);
        }

        public void onRequestNotFilled(@NonNull com.adcolony.sdk.ؠ r3) {
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(AdColonyRewardedVideo.class, r3.ࢠ(), MoPubErrorCode.NETWORK_NO_FILL);
        }

        public void onReward(@NonNull com.adcolony.sdk.ࢬ r3) {
            MoPubRewardedVideoManager.onRewardedVideoCompleted(AdColonyRewardedVideo.class, r3.ࢣ(), r3.ࢤ() ? MoPubReward.success(r3.ࢢ(), r3.ࢠ()) : MoPubReward.failure());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m641(String str) {
        return f706.get(str) != null;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m642(Map<String, String> map) {
        return map != null && map.containsKey("clientOptions") && map.containsKey("appId") && map.containsKey("allZoneIds") && map.containsKey("zoneId");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static boolean m643(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            return true;
        }
        if (strArr2 == null) {
            return false;
        }
        if (strArr.length != strArr2.length) {
            return true;
        }
        Arrays.sort(strArr);
        Arrays.sort(strArr2);
        return !Arrays.equals(strArr, strArr2);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private String[] m646(Map<String, String> map) {
        String[] jsonArrayToStringArray = Json.jsonArrayToStringArray(map.get("allZoneIds"));
        return jsonArrayToStringArray.length == 0 ? new String[]{""} : jsonArrayToStringArray;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m648() {
        this.f712.ࢠ(m651());
        this.f712.ࢢ(m652());
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean m649() {
        return !com.adcolony.sdk.ࢠ.ࢢ().isEmpty();
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private void m650() {
        AdColonyGlobalMediationSettings adColonyGlobalMediationSettings = (AdColonyGlobalMediationSettings) MoPubRewardedVideoManager.getGlobalMediationSettings(AdColonyGlobalMediationSettings.class);
        if (adColonyGlobalMediationSettings == null || adColonyGlobalMediationSettings.getUserId() == null) {
            return;
        }
        this.f713.ࢢ(adColonyGlobalMediationSettings.getUserId());
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean m651() {
        AdColonyInstanceMediationSettings adColonyInstanceMediationSettings = (AdColonyInstanceMediationSettings) MoPubRewardedVideoManager.getInstanceMediationSettings(AdColonyInstanceMediationSettings.class, this.f714);
        return adColonyInstanceMediationSettings != null && adColonyInstanceMediationSettings.withConfirmationDialog();
    }

    /* renamed from: ࢩ  reason: contains not printable characters */
    private boolean m652() {
        AdColonyInstanceMediationSettings adColonyInstanceMediationSettings = (AdColonyInstanceMediationSettings) MoPubRewardedVideoManager.getInstanceMediationSettings(AdColonyInstanceMediationSettings.class, this.f714);
        return adColonyInstanceMediationSettings != null && adColonyInstanceMediationSettings.withResultsDialog();
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    private void m653() {
        Runnable runnable = new Runnable() { // from class: com.mopub.mobileads.AdColonyRewardedVideo.1
            @Override // java.lang.Runnable
            public void run() {
                if (AdColonyRewardedVideo.this.m641(AdColonyRewardedVideo.this.f710)) {
                    AdColonyRewardedVideo.this.f709 = (com.adcolony.sdk.ࢨ) AdColonyRewardedVideo.f706.get(AdColonyRewardedVideo.this.f710);
                    AdColonyRewardedVideo.this.f715 = false;
                    AdColonyRewardedVideo.this.f708.shutdownNow();
                    AdColonyRewardedVideo.this.f707.post(new Runnable() { // from class: com.mopub.mobileads.AdColonyRewardedVideo.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!AdColonyRewardedVideo.this.hasVideoAvailable()) {
                                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(AdColonyRewardedVideo.class, AdColonyRewardedVideo.this.f710, MoPubErrorCode.NETWORK_NO_FILL);
                                return;
                            }
                            Log.d("AdColonyRewardedVideo", "AdColony rewarded ad has been successfully loaded.");
                            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(AdColonyRewardedVideo.class, AdColonyRewardedVideo.this.f710);
                        }
                    });
                }
            }
        };
        if (this.f715) {
            return;
        }
        this.f708.scheduleAtFixedRate(runnable, 1L, 1L, TimeUnit.SECONDS);
        this.f715 = true;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    public boolean checkAndInitializeSdk(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        synchronized (AdColonyRewardedVideo.class) {
            if (f703) {
                return false;
            }
            String str = "version=YOUR_APP_VERSION_HERE,store:google";
            String str2 = "YOUR_AD_COLONY_APP_ID_HERE";
            String[] strArr = f702;
            if (m642(map2)) {
                str = map2.get("clientOptions");
                str2 = map2.get("appId");
                strArr = m646(map2);
            }
            this.f713 = com.adcolony.sdk.ࢤ.ࢤ(str);
            if (!m649()) {
                f705 = strArr;
                com.adcolony.sdk.ࢠ.ࢠ(activity, this.f713, str2, strArr);
            }
            f703 = true;
            return true;
        }
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public String getAdNetworkId() {
        return this.f710;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @Nullable
    public LifecycleListener getLifecycleListener() {
        return f704;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    @Nullable
    public CustomEventRewardedVideo.CustomEventRewardedVideoListener getVideoListenerForSdk() {
        return this.f711;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    public boolean hasVideoAvailable() {
        return (this.f709 == null || this.f709.ࢤ()) ? false : true;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    public void showVideo() {
        if (hasVideoAvailable()) {
            this.f709.ࢠ();
        } else {
            MoPubRewardedVideoManager.onRewardedVideoPlaybackError(AdColonyRewardedVideo.class, this.f710, MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo654() {
        this.f708.shutdownNow();
        com.adcolony.sdk.ࢨ r0 = f706.get(this.f710);
        if (r0 != null) {
            r0.ࢠ((com.adcolony.sdk.ࢩ) null);
            r0.ࢥ();
            f706.remove(this.f710);
        }
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        if (m642(map2)) {
            this.f710 = map2.get("zoneId");
            String str = map2.get("appId");
            String[] m646 = m646(map2);
            PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
            this.f713 = com.adcolony.sdk.ࢤ.ࢤ(map2.get("clientOptions"));
            this.f713 = this.f713 == null ? new com.adcolony.sdk.ࢤ() : this.f713;
            if (personalInformationManager != null && personalInformationManager.gdprApplies() != null && personalInformationManager.gdprApplies().booleanValue()) {
                this.f713.ࢠ("explicit_consent_given", true).ࢠ("consent_response", MoPub.canCollectPersonalInformation());
            }
            m650();
            if (m643(f705, m646)) {
                com.adcolony.sdk.ࢠ.ࢠ(activity, this.f713, str, m646);
                f705 = m646;
            } else {
                com.adcolony.sdk.ࢠ.ࢠ(this.f713);
            }
        }
        Object obj = map.get(DataKeys.AD_UNIT_ID_KEY);
        if (obj != null && (obj instanceof String)) {
            this.f714 = (String) obj;
        }
        f706.put(this.f710, null);
        m648();
        this.f711 = new C0195(this.f712);
        com.adcolony.sdk.ࢠ.ࢠ(this.f711);
        com.adcolony.sdk.ࢠ.ࢠ(this.f710, this.f711, this.f712);
        m653();
    }
}
