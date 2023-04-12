package com.integralads.avid.library.mopub.session.internal.trackingwebview;

import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidWebViewClient;
import com.integralads.avid.library.mopub.weakreference.AvidWebView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: assets/classes2.dex */
public class AvidTrackingWebViewManager implements AvidJavaScriptResourceInjector, AvidWebViewClient.AvidWebViewClientListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AvidWebView f91;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final AvidWebViewClient f92;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f93 = 0;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final ArrayList<String> f94 = new ArrayList<>();

    public AvidTrackingWebViewManager(WebView webView) {
        this.f91 = new AvidWebView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        this.f92 = new AvidWebViewClient();
        this.f92.setListener(this);
        webView.setWebViewClient(this.f92);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m63(String str) {
        this.f91.injectJavaScript("(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();".replace("%SCRIPT_SRC%", str));
    }

    @Override // com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidJavaScriptResourceInjector
    public void injectJavaScriptResource(String str) {
        if (this.f93 == 2) {
            m63(str);
        } else {
            this.f94.add(str);
        }
    }

    public void loadHTML() {
        WebView webView = (WebView) this.f91.get();
        if (webView == null || this.f93 != 0) {
            return;
        }
        this.f93 = 1;
        webView.loadData("<html><body></body></html>", "text/html", null);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidWebViewClient.AvidWebViewClientListener
    public void webViewDidLoadData() {
        this.f93 = 2;
        Iterator<String> it = this.f94.iterator();
        while (it.hasNext()) {
            m63(it.next());
        }
        this.f94.clear();
    }
}
