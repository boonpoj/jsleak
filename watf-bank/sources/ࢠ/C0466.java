package ࢠ;
/* renamed from: ࢠ.ࢫ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0466<TResult> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0463<TResult> f2958 = new C0463<>();

    /* renamed from: ࢠ  reason: contains not printable characters */
    public C0463<TResult> m2331() {
        return this.f2958;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m2332(Exception exc) {
        return this.f2958.m2317(exc);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m2333(TResult tresult) {
        return this.f2958.m2318((C0463<TResult>) tresult);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2334(Exception exc) {
        if (!m2332(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2335(TResult tresult) {
        if (!m2333((C0466<TResult>) tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m2336() {
        return this.f2958.m2325();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m2337() {
        if (!m2336()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }
}
