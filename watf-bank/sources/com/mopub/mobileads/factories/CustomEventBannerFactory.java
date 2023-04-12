package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;
/* loaded from: assets/classes2.dex */
public class CustomEventBannerFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static CustomEventBannerFactory f1175 = new CustomEventBannerFactory();

    public static CustomEventBanner create(String str) throws Exception {
        return f1175.m1002(str);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerFactory customEventBannerFactory) {
        f1175 = customEventBannerFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected CustomEventBanner m1002(String str) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(CustomEventBanner.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (CustomEventBanner) declaredConstructor.newInstance(new Object[0]);
    }
}
