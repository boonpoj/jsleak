package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;
/* loaded from: assets/classes2.dex */
public class CustomEventInterstitialFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static CustomEventInterstitialFactory f1177 = new CustomEventInterstitialFactory();

    public static CustomEventInterstitial create(String str) throws Exception {
        return f1177.m1004(str);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialFactory customEventInterstitialFactory) {
        f1177 = customEventInterstitialFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected CustomEventInterstitial m1004(String str) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (CustomEventInterstitial) declaredConstructor.newInstance(new Object[0]);
    }
}
