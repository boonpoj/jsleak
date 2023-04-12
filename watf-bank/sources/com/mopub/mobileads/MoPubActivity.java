package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.WebViewCacheService;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;
import java.io.Serializable;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: assets/classes2.dex */
public class MoPubActivity extends AbstractActivityC0235 {
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private HtmlInterstitialWebView f872;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ExternalViewabilitySessionManager f873;

    /* renamed from: com.mopub.mobileads.MoPubActivity$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    class C0204 implements CustomEventInterstitial.CustomEventInterstitialListener {
        C0204() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialClicked() {
            EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, MoPubActivity.this.m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialDismissed() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
            EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, MoPubActivity.this.m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
            MoPubActivity.this.finish();
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialImpression() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialLoaded() {
            if (MoPubActivity.this.f872 != null) {
                MoPubActivity.this.f872.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
            }
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onInterstitialShown() {
        }

        @Override // com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener
        public void onLeaveApplication() {
        }
    }

    public static void start(Context context, String str, AdReport adReport, String str2, CreativeOrientation creativeOrientation, long j) {
        try {
            context.startActivity(m774(context, str, adReport, str2, creativeOrientation, j));
        } catch (ActivityNotFoundException unused) {
            Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static Intent m774(Context context, String str, AdReport adReport, String str2, CreativeOrientation creativeOrientation, long j) {
        Intent intent = new Intent(context, MoPubActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.CLICKTHROUGH_URL_KEY, str2);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.CREATIVE_ORIENTATION_KEY, creativeOrientation);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m776(Interstitial interstitial, Context context, AdReport adReport, final CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String str, String str2, long j) {
        HtmlInterstitialWebView create = HtmlInterstitialWebViewFactory.create(context.getApplicationContext(), adReport, customEventInterstitialListener, str2);
        create.enablePlugins(false);
        create.m734();
        create.setWebViewClient(new WebViewClient() { // from class: com.mopub.mobileads.MoPubActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str3) {
                if ("mopub://finishLoad".equals(str3)) {
                    CustomEventInterstitial.CustomEventInterstitialListener.this.onInterstitialLoaded();
                    return true;
                } else if ("mopub://failLoad".equals(str3)) {
                    CustomEventInterstitial.CustomEventInterstitialListener.this.onInterstitialFailed(null);
                    return true;
                } else {
                    return true;
                }
            }
        });
        ExternalViewabilitySessionManager externalViewabilitySessionManager = new ExternalViewabilitySessionManager(context);
        externalViewabilitySessionManager.createDisplaySession(context, create, true);
        create.m714(str);
        WebViewCacheService.storeWebViewConfig(Long.valueOf(j), interstitial, create, externalViewabilitySessionManager);
    }

    @Override // com.mopub.mobileads.AbstractActivityC0235
    public View getAdView() {
        WebViewCacheService.Config popWebViewConfig;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(DataKeys.CLICKTHROUGH_URL_KEY);
        String stringExtra2 = intent.getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        Long l = m1065();
        if (l == null || (popWebViewConfig = WebViewCacheService.popWebViewConfig(l)) == null || !(popWebViewConfig.getWebView() instanceof HtmlInterstitialWebView)) {
            MoPubLog.d("WebView cache miss. Recreating the WebView.");
            this.f872 = HtmlInterstitialWebViewFactory.create(getApplicationContext(), this.f1245, new C0204(), stringExtra);
            this.f873 = new ExternalViewabilitySessionManager(this);
            this.f873.createDisplaySession(this, this.f872, true);
            this.f872.m714(stringExtra2);
        } else {
            this.f872 = (HtmlInterstitialWebView) popWebViewConfig.getWebView();
            this.f872.init(new C0204(), stringExtra, this.f1245 != null ? this.f1245.getDspCreativeId() : null);
            this.f872.enablePlugins(true);
            this.f872.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
            this.f873 = popWebViewConfig.getViewabilityManager();
        }
        return this.f872;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.AbstractActivityC0235, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra(DataKeys.CREATIVE_ORIENTATION_KEY);
        DeviceUtils.lockOrientation(this, (serializableExtra == null || !(serializableExtra instanceof CreativeOrientation)) ? CreativeOrientation.UNDEFINED : (CreativeOrientation) serializableExtra);
        if (this.f873 != null) {
            this.f873.startDeferredDisplaySession(this);
        }
        EventForwardingBroadcastReceiver.broadcastAction(this, m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.AbstractActivityC0235, android.app.Activity
    public void onDestroy() {
        if (this.f873 != null) {
            this.f873.endDisplaySession();
            this.f873 = null;
        }
        if (this.f872 != null) {
            this.f872.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
            this.f872.destroy();
        }
        EventForwardingBroadcastReceiver.broadcastAction(this, m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
        super.onDestroy();
    }
}
