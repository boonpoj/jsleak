package com.mopub.nativeads.factories;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import java.lang.reflect.Constructor;
/* loaded from: assets/classes2.dex */
public class CustomEventNativeFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static CustomEventNativeFactory f1896 = new CustomEventNativeFactory();

    public static CustomEventNative create(@Nullable String str) throws Exception {
        if (str != null) {
            return f1896.m1489(Class.forName(str).asSubclass(CustomEventNative.class));
        }
        return new MoPubCustomEventNative();
    }

    @Deprecated
    public static void setInstance(@NonNull CustomEventNativeFactory customEventNativeFactory) {
        Preconditions.checkNotNull(customEventNativeFactory);
        f1896 = customEventNativeFactory;
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    protected CustomEventNative m1489(@NonNull Class<? extends CustomEventNative> cls) throws Exception {
        Preconditions.checkNotNull(cls);
        Constructor<? extends CustomEventNative> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }
}
