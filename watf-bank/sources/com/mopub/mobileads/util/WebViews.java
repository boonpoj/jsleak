package com.mopub.mobileads.util;

import android.os.Build;
import android.support.annotation.NonNull;
import android.webkit.CookieManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
/* loaded from: assets/classes2.dex */
public class WebViews {
    public static void manageThirdPartyCookies(@NonNull WebView webView) {
        Preconditions.checkNotNull(webView);
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, MoPub.canCollectPersonalInformation());
        }
    }

    public static void manageWebCookies() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (MoPub.canCollectPersonalInformation()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        if (Build.VERSION.SDK_INT < 21) {
            cookieManager.removeSessionCookie();
            cookieManager.removeAllCookie();
            return;
        }
        cookieManager.removeSessionCookies(null);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    public static void onPause(@NonNull WebView webView, boolean z) {
        if (z) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    public static void setDisableJSChromeClient(@NonNull WebView webView) {
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.mopub.mobileads.util.WebViews.1
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(@NonNull WebView webView2, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
                MoPubLog.d(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(@NonNull WebView webView2, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
                MoPubLog.d(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(@NonNull WebView webView2, @NonNull String str, @NonNull String str2, @NonNull JsResult jsResult) {
                MoPubLog.d(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(@NonNull WebView webView2, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JsPromptResult jsPromptResult) {
                MoPubLog.d(str2);
                jsPromptResult.confirm();
                return true;
            }
        });
    }
}
