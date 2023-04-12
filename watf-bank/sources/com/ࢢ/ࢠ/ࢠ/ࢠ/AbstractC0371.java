package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.webkit.WebView;
import com.ࢢ.ࢠ.ࢠ.ࢠ.AbstractC0373;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢢ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0371 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static AbstractC0371 m2039() {
        try {
            return new C0345();
        } catch (Exception e) {
            C0348.m1974(e);
            return new AbstractC0373.C0375();
        }
    }

    @UiThread
    /* renamed from: ࢠ */
    public abstract InterfaceC0378 mo1949(@NonNull WebView webView);
}
