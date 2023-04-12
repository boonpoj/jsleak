package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import java.util.EnumSet;
/* renamed from: com.mopub.mobileads.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
class C0237 extends WebViewClient {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final EnumSet<UrlAction> f1256 = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK);

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Context f1257;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final String f1258;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final HtmlWebViewListener f1259;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final BaseHtmlWebView f1260;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final String f1261;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0237(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView baseHtmlWebView, String str, String str2) {
        this.f1259 = htmlWebViewListener;
        this.f1260 = baseHtmlWebView;
        this.f1261 = str;
        this.f1258 = str2;
        this.f1257 = baseHtmlWebView.getContext();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        new UrlHandler.Builder().withDspCreativeId(this.f1258).withSupportedUrlActions(this.f1256).withResultActions(new UrlHandler.ResultActions() { // from class: com.mopub.mobileads.ࢦ.2
            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingFailed(@NonNull String str2, @NonNull UrlAction urlAction) {
            }

            @Override // com.mopub.common.UrlHandler.ResultActions
            public void urlHandlingSucceeded(@NonNull String str2, @NonNull UrlAction urlAction) {
                if (C0237.this.f1260.wasClicked()) {
                    C0237.this.f1259.onClicked();
                    C0237.this.f1260.onResetUserClick();
                }
            }
        }).withMoPubSchemeListener(new UrlHandler.MoPubSchemeListener() { // from class: com.mopub.mobileads.ࢦ.1
            @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
            public void onClose() {
                C0237.this.f1259.onCollapsed();
            }

            @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
            public void onFailLoad() {
                C0237.this.f1260.stopLoading();
                C0237.this.f1259.onFailed(MoPubErrorCode.UNSPECIFIED);
            }

            @Override // com.mopub.common.UrlHandler.MoPubSchemeListener
            public void onFinishLoad() {
                C0237.this.f1259.onLoaded(C0237.this.f1260);
            }
        }).build().handleUrl(this.f1257, str, this.f1260.wasClicked());
        return true;
    }
}
