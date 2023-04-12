package com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ;

import android.webkit.WebView;
import android.webkit.WebViewClient;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0119 extends WebViewClient {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private InterfaceC0120 f208;

    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.ࢣ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0120 {
        /* renamed from: ࢢ */
        void mo237();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f208 != null) {
            this.f208.mo237();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m238(InterfaceC0120 interfaceC0120) {
        this.f208 = interfaceC0120;
    }
}
