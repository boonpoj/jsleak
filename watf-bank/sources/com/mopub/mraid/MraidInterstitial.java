package com.mopub.mraid;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
class MraidInterstitial extends ResponseBodyInterstitial {
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected String f1367;

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        MraidActivity.start(this.f960, this.f961, this.f1367, this.f962);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    /* renamed from: ࢠ */
    protected void mo772(@NonNull CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        MraidActivity.preRenderHtml(this, this.f960, customEventInterstitialListener, this.f1367, Long.valueOf(this.f962));
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    /* renamed from: ࢠ */
    protected void mo773(Map<String, String> map) {
        this.f1367 = map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
    }
}
