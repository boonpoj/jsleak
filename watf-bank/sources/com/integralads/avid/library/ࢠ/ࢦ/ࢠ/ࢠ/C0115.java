package com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ;

import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidJavascriptInterface;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.C0116;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0112;
import com.integralads.avid.library.ࢠ.ࢪ.C0160;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0115 implements C0112.InterfaceC0113 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0116 f196;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final C0160 f197 = new C0160(null);

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final C0108 f198;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private C0112 f199;

    public C0115(C0116 c0116, C0108 c0108) {
        this.f196 = c0116;
        this.f198 = c0108;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m228() {
        if (this.f199 != null) {
            this.f199.m226((C0112.InterfaceC0113) null);
            this.f199 = null;
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.C0112.InterfaceC0113
    /* renamed from: ࢠ */
    public void mo227() {
        this.f198.m212((WebView) this.f197.m322());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m229(WebView webView) {
        if (this.f197.m322() == webView) {
            return;
        }
        this.f198.m212((WebView) null);
        m228();
        this.f197.m323((C0160) webView);
        if (webView != null) {
            this.f199 = new C0112(this.f196);
            this.f199.m226(this);
            webView.addJavascriptInterface(this.f199, AvidJavascriptInterface.AVID_OBJECT);
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m230() {
        m229(null);
    }
}
