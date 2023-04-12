package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0355;
import com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ.C0370;
import java.lang.ref.WeakReference;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢪ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
final class C0384 {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static InterfaceC0378 f2562;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static WeakReference<Activity> f2563 = new WeakReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2072(Activity activity) {
        try {
            if (C0355.m2002().f2486 == C0355.EnumC0357.f2500) {
                return;
            }
            String name = activity.getClass().getName();
            C0379.m2046(3, "GMAInterstitialHelper", activity, "Activity name: " + name);
            if (!name.contains(AdActivity.CLASS_NAME)) {
                if (f2562 != null) {
                    C0379.m2046(3, "GMAInterstitialHelper", f2563.get(), "Stopping to track GMA interstitial");
                    f2562.mo2041();
                    f2562 = null;
                }
                f2563 = new WeakReference<>(null);
            } else if (f2563.get() == null || f2563.get() != activity) {
                View decorView = activity.getWindow().getDecorView();
                if (decorView instanceof ViewGroup) {
                    C0370<WebView> m2028 = C0367.m2028((ViewGroup) decorView, true);
                    if (!m2028.m2038()) {
                        C0379.m2046(3, "GMAInterstitialHelper", activity, "Sorry, no WebView in this activity");
                        return;
                    }
                    f2563 = new WeakReference<>(activity);
                    C0379.m2046(3, "GMAInterstitialHelper", f2563.get(), "Starting to track GMA interstitial");
                    InterfaceC0378 mo1949 = AbstractC0371.m2039().mo1949(m2028.m2036());
                    f2562 = mo1949;
                    mo1949.mo2040();
                }
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }
}
