package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidJavascriptInterface;
import com.integralads.avid.library.mopub.weakreference.AvidWebView;
/* loaded from: assets/classes2.dex */
public class AvidWebViewManager implements AvidJavascriptInterface.AvidJavascriptInterfaceCallback {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InternalAvidAdSessionContext f87;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final AvidWebView f88 = new AvidWebView(null);

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final AvidBridgeManager f89;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AvidJavascriptInterface f90;

    public AvidWebViewManager(InternalAvidAdSessionContext internalAvidAdSessionContext, AvidBridgeManager avidBridgeManager) {
        this.f87 = internalAvidAdSessionContext;
        this.f89 = avidBridgeManager;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m62() {
        if (this.f90 != null) {
            this.f90.setCallback(null);
            this.f90 = null;
        }
    }

    public void destroy() {
        setWebView(null);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.jsbridge.AvidJavascriptInterface.AvidJavascriptInterfaceCallback
    public void onAvidAdSessionContextInvoked() {
        this.f89.setWebView((WebView) this.f88.get());
    }

    public void setWebView(WebView webView) {
        if (this.f88.get() == webView) {
            return;
        }
        this.f89.setWebView(null);
        m62();
        this.f88.set(webView);
        if (webView != null) {
            this.f90 = new AvidJavascriptInterface(this.f87);
            this.f90.setCallback(this);
            webView.addJavascriptInterface(this.f90, AvidJavascriptInterface.AVID_OBJECT);
        }
    }
}
