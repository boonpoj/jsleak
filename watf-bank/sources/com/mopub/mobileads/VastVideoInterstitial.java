package com.mopub.mobileads;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.CacheService;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.factories.VastManagerFactory;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
class VastVideoInterstitial extends ResponseBodyInterstitial implements VastManager.VastManagerListener {

    /* renamed from: ࢤ  reason: contains not printable characters */
    private CustomEventInterstitial.CustomEventInterstitialListener f1081;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f1082;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private VastManager f1083;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private VastVideoConfig f1084;
    @Nullable

    /* renamed from: ࢨ  reason: contains not printable characters */
    private JSONObject f1085;
    @Nullable

    /* renamed from: ࢩ  reason: contains not printable characters */
    private Map<String, String> f1086;

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        if (this.f1083 != null) {
            this.f1083.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig == null) {
            this.f1081.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        }
        this.f1084 = vastVideoConfig;
        this.f1084.addVideoTrackers(this.f1085);
        this.f1084.addExternalViewabilityTrackers(this.f1086);
        this.f1081.onInterstitialLoaded();
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        MraidVideoPlayerActivity.m716(this.f960, this.f1084, this.f962);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    /* renamed from: ࢠ */
    protected void mo772(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        this.f1081 = customEventInterstitialListener;
        if (!CacheService.initializeDiskCache(this.f960)) {
            this.f1081.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
            return;
        }
        this.f1083 = VastManagerFactory.create(this.f960);
        this.f1083.prepareVastVideoConfiguration(this.f1082, this, this.f961.getDspCreativeId(), this.f960);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    /* renamed from: ࢠ */
    protected void mo773(Map<String, String> map) {
        this.f1082 = map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        String str = map.get(DataKeys.EXTERNAL_VIDEO_VIEWABILITY_TRACKERS_KEY);
        try {
            this.f1086 = Json.jsonStringToMap(str);
        } catch (JSONException unused) {
            MoPubLog.d("Failed to parse video viewability trackers to JSON: " + str);
        }
        String str2 = map.get(DataKeys.VIDEO_TRACKERS_KEY);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.f1085 = new JSONObject(str2);
        } catch (JSONException e) {
            MoPubLog.d("Failed to parse video trackers to JSON: " + str2, e);
            this.f1085 = null;
        }
    }
}
