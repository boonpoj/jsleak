package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class AppLovinRewardedVideo extends CustomEventRewardedVideo implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdLoadListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Map<String, AppLovinIncentivizedInterstitial> f776 = new HashMap();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f777;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AppLovinSdk f778;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AppLovinIncentivizedInterstitial f779;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Activity f780;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f781;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private MoPubReward f782;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f783;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private AppLovinAd f784;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private String f785 = "";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppLovinIncentivizedInterstitial m707(String str, Activity activity, AppLovinSdk appLovinSdk) {
        if (f776.containsKey(str)) {
            return f776.get(str);
        }
        AppLovinIncentivizedInterstitial create = ("".equals(str) || "token".equals(str)) ? AppLovinIncentivizedInterstitial.create(activity) : AppLovinIncentivizedInterstitial.create(str, appLovinSdk);
        f776.put(str, create);
        return create;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppLovinSdk m708(Map<String, String> map, Context context) {
        String str = map != null ? map.get("sdk_key") : null;
        return !TextUtils.isEmpty(str) ? AppLovinSdk.getInstance(str, new AppLovinSdkSettings(), context) : AppLovinSdk.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static MoPubErrorCode m710(int i) {
        return i == 204 ? MoPubErrorCode.NETWORK_NO_FILL : i == -1 ? MoPubErrorCode.UNSPECIFIED : i == -103 ? MoPubErrorCode.NO_CONNECTION : i == -102 ? MoPubErrorCode.NETWORK_TIMEOUT : MoPubErrorCode.UNSPECIFIED;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        MoPubLog.d("Rewarded video clicked");
        MoPubRewardedVideoManager.onRewardedVideoClicked(getClass(), getAdNetworkId());
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        MoPubLog.d("Rewarded video displayed");
        MoPubRewardedVideoManager.onRewardedVideoStarted(getClass(), getAdNetworkId());
    }

    public void adHidden(AppLovinAd appLovinAd) {
        MoPubLog.d("Rewarded video dismissed");
        if (this.f781 && this.f782 != null) {
            MoPubLog.d("Rewarded" + this.f782.getAmount() + " " + this.f782.getLabel());
            MoPubRewardedVideoManager.onRewardedVideoCompleted(getClass(), getAdNetworkId(), this.f782);
        }
        MoPubRewardedVideoManager.onRewardedVideoClosed(getClass(), getAdNetworkId());
    }

    public void adReceived(AppLovinAd appLovinAd) {
        MoPubLog.d("Rewarded video did load ad: " + appLovinAd.getAdIdNumber());
        if (this.f783) {
            this.f784 = appLovinAd;
        }
        this.f780.runOnUiThread(new Runnable() { // from class: com.mopub.mobileads.AppLovinRewardedVideo.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(AppLovinRewardedVideo.this.getClass(), AppLovinRewardedVideo.this.getAdNetworkId());
                } catch (Throwable th) {
                    MoPubLog.e("Unable to notify listener of successful ad load.", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    public boolean checkAndInitializeSdk(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), activity.getApplicationContext());
        MoPubLog.d("Initializing AppLovin rewarded video...");
        if (this.f777) {
            return false;
        }
        this.f778 = m708(map2, activity);
        this.f778.setPluginVersion("MoPub-3.1.0");
        this.f778.setMediationProvider(com.integralads.avid.library.mopub.BuildConfig.SDK_NAME);
        this.f777 = true;
        return true;
    }

    public void failedToReceiveAd(final int i) {
        MoPubLog.d("Rewarded video failed to load with error: " + i);
        this.f780.runOnUiThread(new Runnable() { // from class: com.mopub.mobileads.AppLovinRewardedVideo.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MoPubRewardedVideoManager.onRewardedVideoLoadFailure(AppLovinRewardedVideo.this.getClass(), AppLovinRewardedVideo.this.getAdNetworkId(), AppLovinRewardedVideo.m710(i));
                } catch (Throwable th) {
                    MoPubLog.e("Unable to notify listener of failure to receive ad.", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @NonNull
    public String getAdNetworkId() {
        return this.f785;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    @Nullable
    protected LifecycleListener getLifecycleListener() {
        return null;
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    protected boolean hasVideoAvailable() {
        return this.f783 ? this.f784 != null : this.f779 != null && this.f779.isAdReadyToDisplay();
    }

    @Override // com.mopub.mobileads.CustomEventRewardedVideo
    protected void showVideo() {
        if (!hasVideoAvailable()) {
            MoPubLog.d("Failed to show an AppLovin rewarded video before one was loaded");
            MoPubRewardedVideoManager.onRewardedVideoPlaybackError(getClass(), getAdNetworkId(), MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
            return;
        }
        this.f781 = false;
        this.f782 = null;
        if (this.f783) {
            this.f779.show(this.f784, this.f780, this, this, this, this);
        } else {
            this.f779.show(this.f780, (String) null, this, this, this, this);
        }
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        MoPubLog.d("User declined to view rewarded video");
        MoPubRewardedVideoManager.onRewardedVideoClosed(getClass(), getAdNetworkId());
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        MoPubLog.d("Rewarded video validation request for ad did exceed quota with response: " + map);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        MoPubLog.d("Rewarded video validation request was rejected with response: " + map);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        String str = (String) map.get("currency");
        int parseDouble = (int) Double.parseDouble((String) map.get("amount"));
        MoPubLog.d("Verified " + parseDouble + " " + str);
        this.f782 = MoPubReward.success(str, parseDouble);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        MoPubLog.d("Rewarded video validation request for ad failed with error code: " + i);
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        MoPubLog.d("Rewarded video playback began");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        MoPubLog.d("Rewarded video playback ended at playback percent: " + d);
        this.f781 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    public void mo654() {
    }

    @Override // com.mopub.mobileads.CustomEventRewardedAd
    /* renamed from: ࢠ */
    protected void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception {
        String str;
        this.f780 = activity;
        String str2 = map2.get(DataKeys.ADM_KEY);
        boolean z = !TextUtils.isEmpty(str2);
        MoPubLog.d("Requesting AppLovin banner with serverExtras: " + map2 + ", localExtras: " + map + " and has ad markup: " + z);
        if (z) {
            str = "token";
        } else if (TextUtils.isEmpty(map2.get("zone_id"))) {
            str = "";
        } else {
            this.f785 = map2.get("zone_id");
            str = this.f785;
        }
        this.f779 = m707(str, activity, this.f778);
        if (!z) {
            this.f779.preload(this);
            return;
        }
        this.f783 = true;
        this.f778.getAdService().loadNextAdForAdToken(str2, this);
    }
}
