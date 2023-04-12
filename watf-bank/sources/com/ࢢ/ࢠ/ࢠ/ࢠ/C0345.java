package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.support.annotation.NonNull;
import android.webkit.WebView;
import com.ࢢ.ࢠ.ࢠ.ࢠ.AbstractC0373;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0349;
import com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ.C0370;
import java.lang.ref.WeakReference;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ހ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0345 extends AbstractC0371 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0345() throws C0348 {
        if (((C0385) C0385.m2030()).m2074()) {
            return;
        }
        String str = "Failed to initialize MoatFactory, SDK was not started";
        C0379.m2046(3, "Factory", this, str);
        C0379.m2049("[ERROR] ", str);
        throw new C0348("Failed to initialize MoatFactory");
    }

    @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.AbstractC0371
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final InterfaceC0378 mo1949(@NonNull WebView webView) {
        try {
            final WeakReference weakReference = new WeakReference(webView);
            return (InterfaceC0378) C0349.m1977(new C0349.InterfaceC0350<InterfaceC0378>() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ހ.1
                @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.C0349.InterfaceC0350
                /* renamed from: ࢠ  reason: contains not printable characters */
                public final C0370<InterfaceC0378> mo1950() {
                    WebView webView2 = (WebView) weakReference.get();
                    String str = "Attempting to create WebAdTracker for " + C0379.m2045(webView2);
                    C0379.m2046(3, "Factory", this, str);
                    C0379.m2049("[INFO] ", str);
                    return C0370.m2034(new C0366(webView2));
                }
            }, InterfaceC0378.class);
        } catch (Exception e) {
            C0348.m1974(e);
            return new AbstractC0373.C0376();
        }
    }
}
