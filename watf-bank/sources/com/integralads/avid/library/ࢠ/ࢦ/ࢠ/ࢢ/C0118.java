package com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ;

import android.webkit.WebView;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.C0119;
import com.integralads.avid.library.ࢠ.ࢪ.C0160;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0118 implements InterfaceC0117, C0119.InterfaceC0120 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0160 f204;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final C0119 f205;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private int f206 = 0;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final ArrayList<String> f207 = new ArrayList<>();

    public C0118(WebView webView) {
        this.f204 = new C0160(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        this.f205 = new C0119();
        this.f205.m238(this);
        webView.setWebViewClient(this.f205);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m235(String str) {
        this.f204.m320("(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();".replace("%SCRIPT_SRC%", str));
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m236() {
        WebView webView = (WebView) this.f204.m322();
        if (webView == null || this.f206 != 0) {
            return;
        }
        this.f206 = 1;
        webView.loadData("<html><body></body></html>", "text/html", null);
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.InterfaceC0117
    /* renamed from: ࢠ */
    public void mo234(String str) {
        if (this.f206 == 2) {
            m235(str);
        } else {
            this.f207.add(str);
        }
    }

    @Override // com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢢ.C0119.InterfaceC0120
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void mo237() {
        this.f206 = 2;
        Iterator<String> it = this.f207.iterator();
        while (it.hasNext()) {
            m235(it.next());
        }
        this.f207.clear();
    }
}
