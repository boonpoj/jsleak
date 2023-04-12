package com.mopub.common;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.EnumSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.common.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0188 extends WebViewClient {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final EnumSet<UrlAction> f651 = EnumSet.of(UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK);
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private MoPubBrowser f652;

    public C0188(@NonNull MoPubBrowser moPubBrowser) {
        this.f652 = moPubBrowser;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f652.getBackButton().setImageDrawable((webView.canGoBack() ? Drawables.LEFT_ARROW : Drawables.UNLEFT_ARROW).createDrawable(this.f652));
        this.f652.getForwardButton().setImageDrawable((webView.canGoForward() ? Drawables.RIGHT_ARROW : Drawables.UNRIGHT_ARROW).createDrawable(this.f652));
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        MoPubLog.d("MoPubBrowser error: " + str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new UrlHandler.Builder().withSupportedUrlActions(f651).withoutMoPubBrowser().withResultActions(new UrlHandler.ResultActions() { // from class: com.mopub.common.ࢣ.1
            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingFailed(@NonNull String str2, @NonNull UrlAction urlAction) {
            }

            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingSucceeded(@NonNull String str2, @NonNull UrlAction urlAction) {
                if (urlAction.equals(UrlAction.OPEN_IN_APP_BROWSER)) {
                    C0188.this.f652.getWebView().loadUrl(str2);
                } else {
                    C0188.this.f652.finish();
                }
            }
        }).build().handleResolvedUrl(this.f652.getApplicationContext(), str, true, null);
    }
}
