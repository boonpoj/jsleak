package ࢠ;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* renamed from: ࢠ.ࢪ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0463<TResult> {

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static volatile InterfaceC0465 f2926;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f2928;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f2929;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private TResult f2930;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private Exception f2931;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f2932;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private C0467 f2933;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static final ExecutorService f2923 = C0456.m2292();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static final Executor f2925 = C0456.m2293();

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static final Executor f2924 = C0451.m2289();

    /* renamed from: ֏  reason: contains not printable characters */
    private static C0463<?> f2919 = new C0463<>((Object) null);

    /* renamed from: ؠ  reason: contains not printable characters */
    private static C0463<Boolean> f2920 = new C0463<>(true);

    /* renamed from: ހ  reason: contains not printable characters */
    private static C0463<Boolean> f2921 = new C0463<>(false);

    /* renamed from: ށ  reason: contains not printable characters */
    private static C0463<?> f2922 = new C0463<>(true);

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Object f2927 = new Object();

    /* renamed from: ࢬ  reason: contains not printable characters */
    private List<InterfaceC0461<TResult, Void>> f2934 = new ArrayList();

    /* renamed from: ࢠ.ࢪ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0464 extends C0466<TResult> {
        C0464() {
        }
    }

    /* renamed from: ࢠ.ࢪ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0465 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void m2330(C0463<?> c0463, C0450 c0450);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0463() {
    }

    private C0463(TResult tresult) {
        m2318((C0463<TResult>) tresult);
    }

    private C0463(boolean z) {
        if (z) {
            m2325();
        } else {
            m2318((C0463<TResult>) null);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static InterfaceC0465 m2302() {
        return f2926;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static <TResult> C0463<TResult> m2303(Exception exc) {
        C0466 c0466 = new C0466();
        c0466.m2334(exc);
        return c0466.m2331();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static <TResult> C0463<TResult> m2304(TResult tresult) {
        if (tresult == null) {
            return (C0463<TResult>) f2919;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (C0463<TResult>) f2920 : (C0463<TResult>) f2921;
        }
        C0466 c0466 = new C0466();
        c0466.m2335((C0466) tresult);
        return c0466.m2331();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static <TResult> C0463<TResult>.C0464 m2306() {
        C0463 c0463 = new C0463();
        c0463.getClass();
        return new C0464();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public static <TContinuationResult, TResult> void m2308(final C0466<TContinuationResult> c0466, final InterfaceC0461<TResult, TContinuationResult> interfaceC0461, final C0463<TResult> c0463, Executor executor, final C0458 c0458) {
        try {
            executor.execute(new Runnable() { // from class: ࢠ.ࢪ.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (C0458.this != null && C0458.this.m2297()) {
                        c0466.m2337();
                        return;
                    }
                    try {
                        c0466.m2335((C0466) interfaceC0461.then(c0463));
                    } catch (CancellationException unused) {
                        c0466.m2337();
                    } catch (Exception e) {
                        c0466.m2334(e);
                    }
                }
            });
        } catch (Exception e) {
            c0466.m2334(new C0462(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public static <TContinuationResult, TResult> void m2309(final C0466<TContinuationResult> c0466, final InterfaceC0461<TResult, C0463<TContinuationResult>> interfaceC0461, final C0463<TResult> c0463, Executor executor, final C0458 c0458) {
        try {
            executor.execute(new Runnable() { // from class: ࢠ.ࢪ.5
                @Override // java.lang.Runnable
                public void run() {
                    if (C0458.this != null && C0458.this.m2297()) {
                        c0466.m2337();
                        return;
                    }
                    try {
                        C0463 c04632 = (C0463) interfaceC0461.then(c0463);
                        if (c04632 == null) {
                            c0466.m2335((C0466) null);
                        } else {
                            c04632.m2312((InterfaceC0461) new InterfaceC0461<TContinuationResult, Void>() { // from class: ࢠ.ࢪ.5.1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // ࢠ.InterfaceC0461
                                /* renamed from: ࢠ  reason: contains not printable characters */
                                public Void then(C0463<TContinuationResult> c04633) {
                                    if (C0458.this != null && C0458.this.m2297()) {
                                        c0466.m2337();
                                        return null;
                                    }
                                    if (c04633.m2321()) {
                                        c0466.m2337();
                                    } else if (c04633.m2322()) {
                                        c0466.m2334(c04633.m2324());
                                    } else {
                                        c0466.m2335((C0466) c04633.m2323());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException unused) {
                        c0466.m2337();
                    } catch (Exception e) {
                        c0466.m2334(e);
                    }
                }
            });
        } catch (Exception e) {
            c0466.m2334(new C0462(e));
        }
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    public static <TResult> C0463<TResult> m2310() {
        return (C0463<TResult>) f2922;
    }

    /* renamed from: ࢪ  reason: contains not printable characters */
    private void m2311() {
        synchronized (this.f2927) {
            for (InterfaceC0461<TResult, Void> interfaceC0461 : this.f2934) {
                try {
                    interfaceC0461.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f2934 = null;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public <TContinuationResult> C0463<TContinuationResult> m2312(InterfaceC0461<TResult, TContinuationResult> interfaceC0461) {
        return m2314(interfaceC0461, f2925, null);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public <TContinuationResult> C0463<TContinuationResult> m2313(InterfaceC0461<TResult, C0463<TContinuationResult>> interfaceC0461, Executor executor) {
        return m2316(interfaceC0461, executor, null);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public <TContinuationResult> C0463<TContinuationResult> m2314(final InterfaceC0461<TResult, TContinuationResult> interfaceC0461, final Executor executor, final C0458 c0458) {
        boolean m2320;
        final C0466 c0466 = new C0466();
        synchronized (this.f2927) {
            m2320 = m2320();
            if (!m2320) {
                this.f2934.add(new InterfaceC0461<TResult, Void>() { // from class: ࢠ.ࢪ.1
                    @Override // ࢠ.InterfaceC0461
                    /* renamed from: ࢠ  reason: contains not printable characters */
                    public Void then(C0463<TResult> c0463) {
                        C0463.m2308(c0466, interfaceC0461, c0463, executor, c0458);
                        return null;
                    }
                });
            }
        }
        if (m2320) {
            m2308(c0466, interfaceC0461, this, executor, c0458);
        }
        return c0466.m2331();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public <TContinuationResult> C0463<TContinuationResult> m2315(InterfaceC0461<TResult, TContinuationResult> interfaceC0461) {
        return m2319(interfaceC0461, f2925, null);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public <TContinuationResult> C0463<TContinuationResult> m2316(final InterfaceC0461<TResult, C0463<TContinuationResult>> interfaceC0461, final Executor executor, final C0458 c0458) {
        boolean m2320;
        final C0466 c0466 = new C0466();
        synchronized (this.f2927) {
            m2320 = m2320();
            if (!m2320) {
                this.f2934.add(new InterfaceC0461<TResult, Void>() { // from class: ࢠ.ࢪ.2
                    @Override // ࢠ.InterfaceC0461
                    /* renamed from: ࢠ  reason: contains not printable characters */
                    public Void then(C0463<TResult> c0463) {
                        C0463.m2309(c0466, interfaceC0461, c0463, executor, c0458);
                        return null;
                    }
                });
            }
        }
        if (m2320) {
            m2309(c0466, interfaceC0461, this, executor, c0458);
        }
        return c0466.m2331();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m2317(Exception exc) {
        synchronized (this.f2927) {
            if (this.f2928) {
                return false;
            }
            this.f2928 = true;
            this.f2931 = exc;
            this.f2932 = false;
            this.f2927.notifyAll();
            m2311();
            if (!this.f2932 && m2302() != null) {
                this.f2933 = new C0467(this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m2318(TResult tresult) {
        synchronized (this.f2927) {
            if (this.f2928) {
                return false;
            }
            this.f2928 = true;
            this.f2930 = tresult;
            this.f2927.notifyAll();
            m2311();
            return true;
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public <TContinuationResult> C0463<TContinuationResult> m2319(final InterfaceC0461<TResult, TContinuationResult> interfaceC0461, Executor executor, final C0458 c0458) {
        return m2313(new InterfaceC0461<TResult, C0463<TContinuationResult>>() { // from class: ࢠ.ࢪ.3
            @Override // ࢠ.InterfaceC0461
            /* renamed from: ࢠ  reason: contains not printable characters */
            public C0463<TContinuationResult> then(C0463<TResult> c0463) {
                return (c0458 == null || !c0458.m2297()) ? c0463.m2322() ? C0463.m2303(c0463.m2324()) : c0463.m2321() ? C0463.m2310() : c0463.m2312((InterfaceC0461) interfaceC0461) : C0463.m2310();
            }
        }, executor);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public boolean m2320() {
        boolean z;
        synchronized (this.f2927) {
            z = this.f2928;
        }
        return z;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m2321() {
        boolean z;
        synchronized (this.f2927) {
            z = this.f2929;
        }
        return z;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    public boolean m2322() {
        boolean z;
        synchronized (this.f2927) {
            z = m2324() != null;
        }
        return z;
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    public TResult m2323() {
        TResult tresult;
        synchronized (this.f2927) {
            tresult = this.f2930;
        }
        return tresult;
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    public Exception m2324() {
        Exception exc;
        synchronized (this.f2927) {
            if (this.f2931 != null) {
                this.f2932 = true;
                if (this.f2933 != null) {
                    this.f2933.m2338();
                    this.f2933 = null;
                }
            }
            exc = this.f2931;
        }
        return exc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public boolean m2325() {
        synchronized (this.f2927) {
            if (this.f2928) {
                return false;
            }
            this.f2928 = true;
            this.f2929 = true;
            this.f2927.notifyAll();
            m2311();
            return true;
        }
    }
}
