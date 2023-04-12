package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.factories.HtmlBannerWebViewFactory;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class HtmlBanner extends CustomEventBanner {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private HtmlBannerWebView f862;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ExternalViewabilitySessionManager f863;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean f864 = false;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private WeakReference<Activity> f865;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m771(Map<String, String> map) {
        return map.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ */
    public void mo698() {
        if (this.f863 != null) {
            this.f863.endDisplaySession();
            this.f863 = null;
        }
        if (this.f862 != null) {
            this.f862.destroy();
            this.f862 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ */
    public void mo699(Context context, CustomEventBanner.CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2) {
        Object obj = map.get(DataKeys.BANNER_IMPRESSION_PIXEL_COUNT_ENABLED);
        if (obj instanceof Boolean) {
            this.f864 = ((Boolean) obj).booleanValue();
        }
        if (!m771(map2)) {
            customEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        String str = map2.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        try {
            this.f862 = HtmlBannerWebViewFactory.create(context, (AdReport) map.get(DataKeys.AD_REPORT_KEY), customEventBannerListener, map2.get(DataKeys.CLICKTHROUGH_URL_KEY));
            AdViewController.setShouldHonorServerDimensions(this.f862);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                this.f865 = new WeakReference<>(activity);
                this.f863 = new ExternalViewabilitySessionManager(activity);
                this.f863.createDisplaySession(activity, this.f862, this.f864);
            } else {
                MoPubLog.d("Unable to start viewability session for HTML banner: Context provided was not an Activity.");
            }
            this.f862.m714(str);
        } catch (ClassCastException unused) {
            MoPubLog.e("LocalExtras contained an incorrect type.");
            customEventBannerListener.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢢ */
    public void mo737() {
        if (this.f862 == null) {
            return;
        }
        this.f862.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
        if (!this.f864 || this.f863 == null || this.f865 == null) {
            return;
        }
        Activity activity = this.f865.get();
        if (activity != null) {
            this.f863.startDeferredDisplaySession(activity);
        } else {
            MoPubLog.d("Lost the activity for deferred Viewability tracking. Dropping session.");
        }
    }
}
