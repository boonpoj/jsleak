package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidWebViewClient;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.network.Networking;
import net.sqlcipher.database.SQLiteDatabase;
/* loaded from: assets/classes2.dex */
public class MraidActivity extends AbstractActivityC0235 {
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private MraidController f948;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    private MraidWebViewDebugListener f949;
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ExternalViewabilitySessionManager f950;

    public static void preRenderHtml(@NonNull Interstitial interstitial, @NonNull Context context, @NonNull CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, @Nullable String str, @NonNull Long l) {
        Preconditions.checkNotNull(interstitial);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(customEventInterstitialListener);
        Preconditions.checkNotNull(l);
        m850(interstitial, customEventInterstitialListener, str, new MraidBridge.MraidWebView(context), l);
    }

    public static void start(@NonNull Context context, @Nullable AdReport adReport, @Nullable String str, long j) {
        try {
            context.startActivity(m847(context, adReport, str, j));
        } catch (ActivityNotFoundException unused) {
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static Intent m847(@NonNull Context context, @Nullable AdReport adReport, @Nullable String str, long j) {
        Intent intent = new Intent(context, MraidActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return intent;
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    static void m850(@NonNull Interstitial interstitial, @NonNull final CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, @Nullable String str, @NonNull BaseWebView baseWebView, @NonNull Long l) {
        Preconditions.checkNotNull(interstitial);
        Preconditions.checkNotNull(customEventInterstitialListener);
        Preconditions.checkNotNull(baseWebView);
        Preconditions.checkNotNull(l);
        baseWebView.enablePlugins(false);
        baseWebView.m734();
        baseWebView.setWebViewClient(new MraidWebViewClient() { // from class: com.mopub.mobileads.MraidActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                CustomEventInterstitial.CustomEventInterstitialListener.this.onInterstitialLoaded();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str2, String str3) {
                super.onReceivedError(webView, i, str2, str3);
                CustomEventInterstitial.CustomEventInterstitialListener.this.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                if ("mopub://failLoad".equals(str2)) {
                    CustomEventInterstitial.CustomEventInterstitialListener.this.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                    return true;
                }
                return true;
            }
        });
        Context context = baseWebView.getContext();
        ExternalViewabilitySessionManager externalViewabilitySessionManager = new ExternalViewabilitySessionManager(context);
        externalViewabilitySessionManager.createDisplaySession(context, baseWebView, true);
        baseWebView.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "UTF-8", null);
        WebViewCacheService.storeWebViewConfig(l, interstitial, baseWebView, externalViewabilitySessionManager);
    }

    @Override // com.mopub.mobileads.AbstractActivityC0235
    public View getAdView() {
        String stringExtra = getIntent().getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        if (stringExtra == null) {
            MoPubLog.w("MraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        }
        this.f948 = new MraidController(this, this.f1245, PlacementType.INTERSTITIAL);
        this.f948.setDebugListener(this.f949);
        this.f948.setMraidListener(new MraidController.MraidListener() { // from class: com.mopub.mobileads.MraidActivity.2
            @Override // com.mopub.mraid.MraidController.MraidListener
            public void onClose() {
                MraidActivity.this.f948.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
                MraidActivity.this.finish();
            }

            @Override // com.mopub.mraid.MraidController.MraidListener
            public void onExpand() {
            }

            @Override // com.mopub.mraid.MraidController.MraidListener
            public void onFailedToLoad() {
                MoPubLog.d("MraidActivity failed to load. Finishing the activity");
                if (MraidActivity.this.m1065() != null) {
                    EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, MraidActivity.this.m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
                }
                MraidActivity.this.finish();
            }

            @Override // com.mopub.mraid.MraidController.MraidListener
            public void onLoaded(View view) {
                MraidActivity.this.f948.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
            }

            @Override // com.mopub.mraid.MraidController.MraidListener
            public void onOpen() {
                if (MraidActivity.this.m1065() != null) {
                    EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, MraidActivity.this.m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
                }
            }
        });
        this.f948.setUseCustomCloseListener(new MraidController.UseCustomCloseListener() { // from class: com.mopub.mobileads.MraidActivity.3
            @Override // com.mopub.mraid.MraidController.UseCustomCloseListener
            public void useCustomCloseChanged(boolean z) {
                if (z) {
                    MraidActivity.this.m1067();
                } else {
                    MraidActivity.this.m1066();
                }
            }
        });
        this.f948.fillContent(m1065(), stringExtra, new MraidController.MraidWebViewCacheListener() { // from class: com.mopub.mobileads.MraidActivity.4
            @Override // com.mopub.mraid.MraidController.MraidWebViewCacheListener
            public void onReady(@NonNull MraidBridge.MraidWebView mraidWebView, @Nullable ExternalViewabilitySessionManager externalViewabilitySessionManager) {
                if (externalViewabilitySessionManager != null) {
                    MraidActivity.this.f950 = externalViewabilitySessionManager;
                    return;
                }
                MraidActivity.this.f950 = new ExternalViewabilitySessionManager(MraidActivity.this);
                MraidActivity.this.f950.createDisplaySession(MraidActivity.this, mraidWebView, true);
            }
        });
        return this.f948.getAdContainer();
    }

    @Override // com.mopub.mobileads.AbstractActivityC0235, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (this.f950 != null) {
            this.f950.startDeferredDisplaySession(this);
        }
        if (m1065() != null) {
            EventForwardingBroadcastReceiver.broadcastAction(this, m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        }
        getWindow().setFlags(16777216, 16777216);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.mobileads.AbstractActivityC0235, android.app.Activity
    public void onDestroy() {
        if (this.f950 != null) {
            this.f950.endDisplaySession();
            this.f950 = null;
        }
        if (this.f948 != null) {
            this.f948.destroy();
        }
        if (m1065() != null) {
            EventForwardingBroadcastReceiver.broadcastAction(this, m1065().longValue(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        if (this.f948 != null) {
            this.f948.pause(isFinishing());
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f948 != null) {
            this.f948.resume();
        }
    }

    @VisibleForTesting
    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.f949 = mraidWebViewDebugListener;
        if (this.f948 != null) {
            this.f948.setDebugListener(mraidWebViewDebugListener);
        }
    }
}
