package com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ;

import java.util.NoSuchElementException;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ.ࢢ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0370<T> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final C0370<?> f2532 = new C0370<>();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final T f2533;

    private C0370() {
        this.f2533 = null;
    }

    private C0370(T t) {
        if (t == null) {
            throw new NullPointerException("Optional of null value.");
        }
        this.f2533 = t;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static <T> C0370<T> m2033() {
        return (C0370<T>) f2532;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static <T> C0370<T> m2034(T t) {
        return new C0370<>(t);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static <T> C0370<T> m2035(T t) {
        return t == null ? m2033() : m2034(t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0370) {
            C0370 c0370 = (C0370) obj;
            return this.f2533 == c0370.f2533 || !(this.f2533 == null || c0370.f2533 == null || !this.f2533.equals(c0370.f2533));
        }
        return false;
    }

    public final int hashCode() {
        if (this.f2533 == null) {
            return 0;
        }
        return this.f2533.hashCode();
    }

    public final String toString() {
        return this.f2533 != null ? String.format("Optional[%s]", this.f2533) : "Optional.empty";
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public final T m2036() {
        if (this.f2533 != null) {
            return this.f2533;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public final T m2037(T t) {
        return this.f2533 != null ? this.f2533 : t;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public final boolean m2038() {
        return this.f2533 != null;
    }
}
