package ࢠ;

import ࢠ.C0463;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ࢠ.ࢬ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0467 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0463<?> f2959;

    public C0467(C0463<?> c0463) {
        this.f2959 = c0463;
    }

    protected void finalize() throws Throwable {
        C0463.InterfaceC0465 m2302;
        try {
            C0463<?> c0463 = this.f2959;
            if (c0463 != null && (m2302 = C0463.m2302()) != null) {
                m2302.m2330(c0463, new C0450(c0463.m2324()));
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2338() {
        this.f2959 = null;
    }
}
