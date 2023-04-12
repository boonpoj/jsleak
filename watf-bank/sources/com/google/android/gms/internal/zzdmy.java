package com.google.android.gms.internal;
/* loaded from: classes.dex */
public final class zzdmy {
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
