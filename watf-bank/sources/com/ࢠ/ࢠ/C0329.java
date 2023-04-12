package com.ࢠ.ࢠ;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.flurry.android.FlurryAgent;
import java.util.Map;
/* renamed from: com.ࢠ.ࢠ.ގ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0329 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AppEventsLogger f2358 = null;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static volatile boolean f2359 = false;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1844() {
        if (f2359) {
            return;
        }
        synchronized (C0329.class) {
            if (!f2359) {
                String m1802 = C0313.m1795().m1802();
                if (!TextUtils.isEmpty(m1802)) {
                    FlurryAgent.setUserId(m1802);
                    f2359 = true;
                }
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1845(Application application, String str) {
        new FlurryAgent.Builder().withLogEnabled(false).withLogLevel(7).withCaptureUncaughtExceptions(true).withContinueSessionMillis(10000L).build(application, str);
        m1844();
        FacebookSdk.sdkInitialize(application);
        f2358 = AppEventsLogger.newLogger(application);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1846(String str, String str2, String str3, String str4, double d) {
        Bundle bundle = new Bundle();
        bundle.putString("fb_content", str);
        bundle.putString("fb_content_id", str2);
        bundle.putString("fb_content_type", str3);
        bundle.putString("fb_currency", str4);
        f2358.logEvent("fb_mobile_add_to_cart", d, bundle);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m1847(String str, Map<String, String> map) {
        m1844();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (map != null) {
            FlurryAgent.logEvent(str, map);
        } else {
            FlurryAgent.logEvent(str);
        }
        if (map == null) {
            f2358.logEvent(str);
            return;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        f2358.logEvent(str, bundle);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static void m1848(String str, String str2, String str3, String str4, double d) {
        Bundle bundle = new Bundle();
        bundle.putString("fb_content", str);
        bundle.putString("fb_content_id", str2);
        bundle.putString("fb_content_type", str3);
        bundle.putString("fb_currency", str4);
        f2358.logEvent("fb_mobile_purchase", d, bundle);
    }
}
