package com.integralads.avid.library.mopub.session.internal.trackingwebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: assets/classes2.dex */
public class AvidWebViewClient extends WebViewClient {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AvidWebViewClientListener f95;

    /* loaded from: assets/classes2.dex */
    public interface AvidWebViewClientListener {
        void webViewDidLoadData();
    }

    public AvidWebViewClientListener getListener() {
        return this.f95;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f95 != null) {
            this.f95.webViewDidLoadData();
        }
    }

    public void setListener(AvidWebViewClientListener avidWebViewClientListener) {
        this.f95 = avidWebViewClientListener;
    }
}
