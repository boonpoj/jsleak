package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.mopub.common.DataKeys;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/* loaded from: assets/classes2.dex */
public class AppLovinInterstitial extends CustomEventInterstitial implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdLoadListener, AppLovinAdVideoPlaybackListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final Handler f764 = new Handler(Looper.getMainLooper());

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static final Map<String, Queue<AppLovinAd>> f765 = new HashMap();

    /* renamed from: ࢦ  reason: contains not printable characters */
    private static final Object f766 = new Object();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AppLovinSdk f767;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private CustomEventInterstitial.CustomEventInterstitialListener f768;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Context f769;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f770;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f771;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private AppLovinAd f772;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppLovinAd m700(String str) {
        AppLovinAd appLovinAd;
        Object obj = f766;
        synchronized (f766) {
            appLovinAd = null;
            Queue<AppLovinAd> queue = f765.get(str);
            if (queue != null && !queue.isEmpty()) {
                appLovinAd = queue.poll();
            }
        }
        return appLovinAd;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppLovinSdk m701(Map<String, String> map, Context context) {
        String str = map != null ? map.get("sdk_key") : null;
        return !TextUtils.isEmpty(str) ? AppLovinSdk.getInstance(str, new AppLovinSdkSettings(), context) : AppLovinSdk.getInstance(context);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m704(AppLovinAd appLovinAd, String str) {
        Object obj = f766;
        synchronized (f766) {
            Queue<AppLovinAd> queue = f765.get(str);
            if (queue == null) {
                queue = new LinkedList<>();
                f765.put(str, queue);
            }
            queue.offer(appLovinAd);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m705(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f764.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public static MoPubErrorCode m706(int i) {
        return i == 204 ? MoPubErrorCode.NETWORK_NO_FILL : i == -1 ? MoPubErrorCode.UNSPECIFIED : i == -103 ? MoPubErrorCode.NO_CONNECTION : i == -102 ? MoPubErrorCode.NETWORK_TIMEOUT : MoPubErrorCode.UNSPECIFIED;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        MoPubLog.d("Interstitial clicked");
        if (this.f768 != null) {
            this.f768.onLeaveApplication();
        }
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        MoPubLog.d("Interstitial displayed");
        if (this.f768 != null) {
            this.f768.onInterstitialShown();
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        MoPubLog.d("Interstitial dismissed");
        if (this.f768 != null) {
            this.f768.onInterstitialDismissed();
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        MoPubLog.d("Interstitial did load ad: " + appLovinAd.getAdIdNumber());
        if (this.f771) {
            this.f772 = appLovinAd;
        } else {
            m704(appLovinAd, this.f770);
        }
        m705(new Runnable() { // from class: com.mopub.mobileads.AppLovinInterstitial.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AppLovinInterstitial.this.f768 != null) {
                        AppLovinInterstitial.this.f768.onInterstitialLoaded();
                    }
                } catch (Throwable th) {
                    MoPubLog.e("Unable to notify listener of successful ad load.", th);
                }
            }
        });
    }

    public void failedToReceiveAd(final int i) {
        MoPubLog.d("Interstitial failed to load with error: " + i);
        m705(new Runnable() { // from class: com.mopub.mobileads.AppLovinInterstitial.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AppLovinInterstitial.this.f768 != null) {
                        AppLovinInterstitial.this.f768.onInterstitialFailed(AppLovinInterstitial.m706(i));
                    }
                } catch (Throwable th) {
                    MoPubLog.e("Unable to notify listener of failure to receive ad.", th);
                }
            }
        });
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), context);
        this.f768 = customEventInterstitialListener;
        this.f769 = context;
        this.f767 = m701(map2, context);
        this.f767.setPluginVersion("MoPub-3.1.0");
        this.f767.setMediationProvider(com.integralads.avid.library.mopub.BuildConfig.SDK_NAME);
        String str = map2.get(DataKeys.ADM_KEY);
        boolean z = !TextUtils.isEmpty(str);
        MoPubLog.d("Requesting AppLovin interstitial with serverExtras: " + map2 + ", localExtras: " + map + " and has adMarkup: " + z);
        if (z) {
            this.f771 = true;
            this.f767.getAdService().loadNextAdForAdToken(str, this);
            return;
        }
        String str2 = map2.get("zone_id");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.f770 = str2;
        AppLovinAd m700 = m700(this.f770);
        if (m700 == null) {
            if (TextUtils.isEmpty(this.f770)) {
                this.f767.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, this);
                return;
            } else {
                this.f767.getAdService().loadNextAdForZoneId(this.f770, this);
                return;
            }
        }
        MoPubLog.d("Found preloaded ad for zone: {" + this.f770 + "}");
        adReceived(m700);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        AppLovinAd m700 = (!this.f771 || this.f772 == null) ? m700(this.f770) : this.f772;
        if (m700 == null) {
            MoPubLog.d("Failed to show an AppLovin interstitial before one was loaded");
            if (this.f768 != null) {
                this.f768.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                return;
            }
            return;
        }
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f767, this.f769);
        create.setAdDisplayListener(this);
        create.setAdClickListener(this);
        create.setAdVideoPlaybackListener(this);
        create.showAndRender(m700);
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        MoPubLog.d("Interstitial video playback began");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        MoPubLog.d("Interstitial video playback ended at playback percent: " + d);
    }
}
