package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzale<T> extends zzalf<T> {
    private final T zzdfk;

    private zzale(T t) {
        this.zzdfk = t;
    }

    public static <T> zzale<T> zzj(T t) {
        return new zzale<>(t);
    }

    public final void zzrf() {
        set(this.zzdfk);
    }
}
