package ࢠ;

import java.io.Closeable;
/* renamed from: ࢠ.ࢦ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0459 implements Closeable {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Object f2910;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private C0460 f2911;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private Runnable f2912;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f2913;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f2910) {
            if (this.f2913) {
                return;
            }
            this.f2913 = true;
            this.f2911.m2300(this);
            this.f2911 = null;
            this.f2912 = null;
        }
    }
}
