package com.integralads.avid.library.mopub.weakreference;

import java.lang.ref.WeakReference;
/* loaded from: assets/classes2.dex */
public class ObjectWrapper<T> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private WeakReference<T> f120;

    public ObjectWrapper(T t) {
        this.f120 = new WeakReference<>(t);
    }

    public boolean contains(Object obj) {
        T t = get();
        return (t == null || obj == null || !t.equals(obj)) ? false : true;
    }

    public T get() {
        return this.f120.get();
    }

    public boolean isEmpty() {
        return get() == null;
    }

    public void set(T t) {
        this.f120 = new WeakReference<>(t);
    }
}
