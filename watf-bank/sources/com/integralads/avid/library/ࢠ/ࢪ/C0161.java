package com.integralads.avid.library.ࢠ.ࢪ;

import java.lang.ref.WeakReference;
/* renamed from: com.integralads.avid.library.ࢠ.ࢪ.ࢤ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0161<T> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private WeakReference<T> f253;

    public C0161(T t) {
        this.f253 = new WeakReference<>(t);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public T m322() {
        return this.f253.get();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m323(T t) {
        this.f253 = new WeakReference<>(t);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m324() {
        return m322() == null;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m325(Object obj) {
        T m322 = m322();
        return (m322 == null || obj == null || !m322.equals(obj)) ? false : true;
    }
}
