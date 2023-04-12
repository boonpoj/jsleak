package com.mopub.mraid;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.MraidControllerFactory;
import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidController;
import java.util.Map;
/* loaded from: assets/classes2.dex */
class MraidBanner extends CustomEventBanner {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private MraidController f1291;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private CustomEventBanner.CustomEventBannerListener f1292;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private MraidWebViewDebugListener f1293;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ExternalViewabilitySessionManager f1294;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f1295 = false;

    MraidBanner() {
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private boolean m1119(@NonNull Map<String, String> map) {
        return map.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    @VisibleForTesting
    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f1293 = mraidWebViewDebugListener;
        if (this.f1291 != null) {
            this.f1291.setDebugListener(mraidWebViewDebugListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ */
    public void mo698() {
        if (this.f1294 != null) {
            this.f1294.endDisplaySession();
            this.f1294 = null;
        }
        if (this.f1291 != null) {
            this.f1291.setMraidListener(null);
            this.f1291.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢠ */
    public void mo699(@NonNull final Context context, @NonNull CustomEventBanner.CustomEventBannerListener customEventBannerListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        this.f1292 = customEventBannerListener;
        if (!m1119(map2)) {
            this.f1292.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            return;
        }
        String str = map2.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        Object obj = map.get(DataKeys.BANNER_IMPRESSION_PIXEL_COUNT_ENABLED);
        if (obj instanceof Boolean) {
            this.f1295 = ((Boolean) obj).booleanValue();
        }
        try {
            this.f1291 = MraidControllerFactory.create(context, (AdReport) map.get(DataKeys.AD_REPORT_KEY), PlacementType.INLINE);
            this.f1291.setDebugListener(this.f1293);
            this.f1291.setMraidListener(new MraidController.MraidListener() { // from class: com.mopub.mraid.MraidBanner.1
                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onClose() {
                    MraidBanner.this.f1292.onBannerCollapsed();
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onExpand() {
                    MraidBanner.this.f1292.onBannerExpanded();
                    MraidBanner.this.f1292.onBannerClicked();
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onFailedToLoad() {
                    MraidBanner.this.f1292.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onLoaded(View view) {
                    AdViewController.setShouldHonorServerDimensions(view);
                    MraidBanner.this.f1292.onBannerLoaded(view);
                }

                @Override // com.mopub.mraid.MraidController.MraidListener
                public void onOpen() {
                    MraidBanner.this.f1292.onBannerClicked();
                }
            });
            this.f1291.fillContent(null, str, new MraidController.MraidWebViewCacheListener() { // from class: com.mopub.mraid.MraidBanner.2
                @Override // com.mopub.mraid.MraidController.MraidWebViewCacheListener
                public void onReady(@NonNull MraidBridge.MraidWebView mraidWebView, @Nullable ExternalViewabilitySessionManager externalViewabilitySessionManager) {
                    mraidWebView.getSettings().setJavaScriptEnabled(true);
                    if (context instanceof Activity) {
                        MraidBanner.this.f1294 = new ExternalViewabilitySessionManager(context);
                        MraidBanner.this.f1294.createDisplaySession(context, mraidWebView, MraidBanner.this.f1295);
                    }
                }
            });
        } catch (ClassCastException e) {
            MoPubLog.w("MRAID banner creating failed:", e);
            this.f1292.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.CustomEventBanner
    /* renamed from: ࢢ */
    public void mo737() {
        if (this.f1291 == null) {
            return;
        }
        this.f1291.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
        if (!this.f1295 || this.f1294 == null) {
            return;
        }
        Activity activity = this.f1291.m1194().get();
        if (activity != null) {
            this.f1294.startDeferredDisplaySession(activity);
        } else {
            MoPubLog.d("Lost the activity for deferred Viewability tracking. Dropping session.");
        }
    }
}
