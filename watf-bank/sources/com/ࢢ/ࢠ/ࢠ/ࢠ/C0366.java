package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.support.annotation.Nullable;
import android.webkit.WebView;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ވ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0366 extends AbstractC0383 implements InterfaceC0378 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0366(@Nullable WebView webView) {
        super(webView, false, false);
        C0379.m2046(3, "WebAdTracker", this, "Initializing.");
        if (webView == null) {
            String str = "WebAdTracker initialization not successful, WebView is null";
            C0379.m2046(3, "WebAdTracker", this, str);
            C0379.m2049("[ERROR] ", str);
            this.f2551 = new C0348("WebView is null");
            return;
        }
        try {
            super.m2062(webView);
            C0379.m2049("[SUCCESS] ", "WebAdTracker created for " + m2070());
        } catch (C0348 e) {
            this.f2551 = e;
        }
    }

    @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.AbstractC0383
    /* renamed from: ࢣ  reason: contains not printable characters */
    final String mo2027() {
        return "WebAdTracker";
    }
}
