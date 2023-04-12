package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class ResponseBodyInterstitial extends CustomEventInterstitial {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected Context f960;

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected AdReport f961;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected long f962;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private EventForwardingBroadcastReceiver f963;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean m854(Map<String, String> map) {
        return map.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        this.f960 = context;
        if (!m854(map2)) {
            customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        mo773(map2);
        try {
            this.f961 = (AdReport) map.get(DataKeys.AD_REPORT_KEY);
            Long l = (Long) map.get(DataKeys.BROADCAST_IDENTIFIER_KEY);
            if (l == null) {
                MoPubLog.e("Broadcast Identifier was not set in localExtras");
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                return;
            }
            this.f962 = l.longValue();
            this.f963 = new EventForwardingBroadcastReceiver(customEventInterstitialListener, this.f962);
            this.f963.register(this.f963, context);
            mo772(customEventInterstitialListener);
        } catch (ClassCastException unused) {
            MoPubLog.e("LocalExtras contained an incorrect type.");
            customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        if (this.f963 != null) {
            this.f963.unregister(this.f963);
            this.f963 = null;
        }
    }

    @Override // com.mopub.mobileads.CustomEventInterstitial
    public abstract void showInterstitial();

    /* renamed from: ࢠ */
    protected abstract void mo772(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener);

    /* renamed from: ࢠ */
    protected abstract void mo773(Map<String, String> map);
}
