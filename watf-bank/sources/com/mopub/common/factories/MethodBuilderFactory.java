package com.mopub.common.factories;

import com.mopub.common.util.Reflection;
/* loaded from: assets/classes2.dex */
public class MethodBuilderFactory {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected static MethodBuilderFactory f461 = new MethodBuilderFactory();

    public static Reflection.MethodBuilder create(Object obj, String str) {
        return f461.m480(obj, str);
    }

    @Deprecated
    public static void setInstance(MethodBuilderFactory methodBuilderFactory) {
        f461 = methodBuilderFactory;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected Reflection.MethodBuilder m480(Object obj, String str) {
        return new Reflection.MethodBuilder(obj, str);
    }
}
