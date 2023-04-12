package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0343;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0379 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    WebView f2538;

    /* renamed from: ࢢ  reason: contains not printable characters */
    C0343 f2539;

    /* renamed from: ࢣ  reason: contains not printable characters */
    final String f2540;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final int f2541;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f2542;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢧ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static final class EnumC0380 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        public static final int f2544 = 1;

        /* renamed from: ࢢ  reason: contains not printable characters */
        public static final int f2545 = 2;

        static {
            int[] iArr = {1, 2};
        }
    }

    C0379() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public C0379(Application application, int i) {
        this.f2541 = i;
        this.f2542 = false;
        this.f2540 = String.format(Locale.ROOT, "_moatTracker%d", Integer.valueOf((int) (Math.random() * 1.0E8d)));
        this.f2538 = new WebView(application);
        WebSettings settings = this.f2538.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setSaveFormData(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        try {
            this.f2539 = new C0343(this.f2538, i == EnumC0380.f2545 ? C0343.EnumC0344.f2437 : C0343.EnumC0344.f2436);
        } catch (C0348 e) {
            C0348.m1974(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m2045(View view) {
        if (view != null) {
            return view.getClass().getSimpleName() + "@" + view.hashCode();
        }
        return "null";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2046(int i, String str, Object obj, String str2) {
        if (C0355.m2002().f2487) {
            if (obj == null) {
                Log.println(i, VastExtensionXmlManager.MOAT + str, String.format("message = %s", str2));
                return;
            }
            Log.println(i, VastExtensionXmlManager.MOAT + str, String.format("id = %s, message = %s", Integer.valueOf(obj.hashCode()), str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2047(String str, Object obj, String str2) {
        if (C0355.m2002().f2488) {
            String str3 = VastExtensionXmlManager.MOAT + str;
            Object[] objArr = new Object[2];
            objArr[0] = obj == null ? "null" : Integer.valueOf(obj.hashCode());
            objArr[1] = str2;
            Log.println(2, str3, String.format("id = %s, message = %s", objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2048(String str, Object obj, String str2, Exception exc) {
        if (C0355.m2002().f2487) {
            Log.e(VastExtensionXmlManager.MOAT + str, String.format("id = %s, message = %s", Integer.valueOf(obj.hashCode()), str2), exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2049(String str, String str2) {
        if (C0355.m2002().f2487 || !((C0385) AbstractC0368.m2030()).f2564) {
            return;
        }
        int i = str.equals("[ERROR] ") ? 6 : 2;
        Log.println(i, "MoatAnalytics", str + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m2052(String str) {
        if (this.f2541 == EnumC0380.f2544) {
            this.f2538.setWebViewClient(new WebViewClient() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢧ.1
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str2) {
                    if (C0379.this.f2542) {
                        return;
                    }
                    try {
                        C0379.this.f2542 = true;
                        C0379.this.f2539.m1944();
                    } catch (Exception e) {
                        C0348.m1974(e);
                    }
                }
            });
            WebView webView = this.f2538;
            webView.loadData("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/" + str + "/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>", "text/html", "utf-8");
        }
    }
}
