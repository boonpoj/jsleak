package com.integralads.avid.library.ࢠ.ࢪ;

import android.webkit.WebView;
import com.integralads.avid.library.ࢠ.ࢧ.C0138;
/* renamed from: com.integralads.avid.library.ࢠ.ࢪ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0160 extends C0159<WebView> {
    public C0160(WebView webView) {
        super(webView);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m320(String str) {
        m321(C0138.m260(str));
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m321(String str) {
        WebView webView = (WebView) m322();
        if (webView != null) {
            webView.loadUrl(str);
        }
    }
}
