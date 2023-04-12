package ࢠ;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
/* renamed from: ࢠ.ࢧ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0460 implements Closeable {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Object f2914;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final List<C0459> f2915;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ScheduledFuture<?> f2916;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f2917;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f2918;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m2298() {
        if (this.f2918) {
            throw new IllegalStateException("Object already closed");
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m2299() {
        if (this.f2916 != null) {
            this.f2916.cancel(true);
            this.f2916 = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f2914) {
            if (this.f2918) {
                return;
            }
            m2299();
            for (C0459 c0459 : this.f2915) {
                c0459.close();
            }
            this.f2915.clear();
            this.f2918 = true;
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m2301()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2300(C0459 c0459) {
        synchronized (this.f2914) {
            m2298();
            this.f2915.remove(c0459);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m2301() {
        boolean z;
        synchronized (this.f2914) {
            m2298();
            z = this.f2917;
        }
        return z;
    }
}
