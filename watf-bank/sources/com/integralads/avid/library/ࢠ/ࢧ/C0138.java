package com.integralads.avid.library.ࢠ.ࢧ;

import org.json.JSONObject;
/* renamed from: com.integralads.avid.library.ࢠ.ࢧ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0138 {
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m253() {
        return m259("publishReadyEventForDeferredAdSession()");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m254(String str) {
        return m259("setNativeViewState(" + str + ")");
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m255(String str, String str2) {
        return m259("publishVideoEvent(" + JSONObject.quote(str) + "," + str2 + ")");
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m256(String str) {
        return m259("setAppState(" + JSONObject.quote(str) + ")");
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public static String m257(String str) {
        return m259("publishVideoEvent(" + JSONObject.quote(str) + ")");
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public static String m258(String str) {
        return m259("setAvidAdSessionContext(" + str + ")");
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    public static String m259(String str) {
        return "javascript: if(window.avidbridge!==undefined){avidbridge." + str + "}";
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    public static String m260(String str) {
        return "javascript: " + str;
    }
}
