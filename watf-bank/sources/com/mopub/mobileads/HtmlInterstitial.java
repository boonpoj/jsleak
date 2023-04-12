package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class HtmlInterstitial extends ResponseBodyInterstitial {

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f867;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private String f868;
    @NonNull

    /* renamed from: ࢦ  reason: contains not printable characters */
    private CreativeOrientation f869;

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        MoPubActivity.start(this.f960, this.f867, this.f961, this.f868, this.f869, this.f962);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void mo772(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubActivity.m776(this, this.f960, this.f961, customEventInterstitialListener, this.f867, this.f868, this.f962);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void mo773(Map<String, String> map) {
        this.f867 = map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.f868 = map.get(DataKeys.CLICKTHROUGH_URL_KEY);
        this.f869 = CreativeOrientation.fromHeader(map.get(DataKeys.CREATIVE_ORIENTATION_KEY));
    }
}
