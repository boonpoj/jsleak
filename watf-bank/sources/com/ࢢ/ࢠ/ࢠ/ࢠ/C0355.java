package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0355 {

    /* renamed from: ࢨ  reason: contains not printable characters */
    private static C0355 f2482;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private static final Queue<C0361> f2483 = new ConcurrentLinkedQueue();

    /* renamed from: ࢪ  reason: contains not printable characters */
    private Handler f2493;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private long f2491 = 1800000;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private long f2492 = 60000;

    /* renamed from: ࢠ  reason: contains not printable characters */
    volatile int f2486 = EnumC0357.f2500;

    /* renamed from: ࢢ  reason: contains not printable characters */
    volatile boolean f2487 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    volatile boolean f2488 = false;

    /* renamed from: ࢤ  reason: contains not printable characters */
    volatile int f2489 = 200;

    /* renamed from: ࢥ  reason: contains not printable characters */
    volatile int f2490 = 10;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private final AtomicBoolean f2494 = new AtomicBoolean(false);

    /* renamed from: ࢬ  reason: contains not printable characters */
    private volatile long f2495 = 0;

    /* renamed from: ֏  reason: contains not printable characters */
    private final AtomicInteger f2484 = new AtomicInteger(0);

    /* renamed from: ؠ  reason: contains not printable characters */
    private final AtomicBoolean f2485 = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static final class EnumC0357 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        public static final int f2500 = 1;

        /* renamed from: ࢢ  reason: contains not printable characters */
        public static final int f2501 = 2;

        static {
            int[] iArr = {1, 2};
        }
    }

    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0358 {
        /* renamed from: ࢤ */
        void mo1981() throws C0348;
    }

    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    interface InterfaceC0359 {
        /* renamed from: ࢠ */
        void mo2014(C0386 c0386) throws C0348;
    }

    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ$ࢤ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    class RunnableC0360 implements Runnable {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Handler f2502;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final String f2503;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final AnonymousClass1.C03561 f2504;

        private RunnableC0360(String str, Handler handler, AnonymousClass1.C03561 c03561) {
            this.f2504 = c03561;
            this.f2502 = handler;
            this.f2503 = "https://z.moatads.com/" + str + "/android/" + "35d482907bc2811c2e46b96f16eb5f9fe00185f3".substring(0, 7) + "/status.json";
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private String m2016() {
            try {
                return C0346.m1951(this.f2503 + "?ts=" + System.currentTimeMillis() + "&v=2.4.1").m2036();
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String m2016 = m2016();
                final C0386 c0386 = new C0386(m2016);
                C0355.this.f2487 = c0386.m2081();
                C0355.this.f2488 = c0386.m2082();
                C0355.this.f2489 = c0386.m2083();
                C0355.this.f2490 = c0386.m2084();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ.ࢤ.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            mo2014(c0386);
                        } catch (Exception e) {
                            C0348.m1974(e);
                        }
                    }
                });
                C0355.this.f2495 = System.currentTimeMillis();
                C0355.this.f2485.compareAndSet(true, false);
                if (m2016 != null) {
                    C0355.this.f2484.set(0);
                } else if (C0355.this.f2484.incrementAndGet() < 10) {
                    C0355.this.m2003(C0355.this.f2492);
                }
            } catch (Exception e) {
                C0348.m1974(e);
            }
            this.f2502.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ$ࢥ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0361 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        final Long f2508;

        /* renamed from: ࢢ  reason: contains not printable characters */
        final InterfaceC0358 f2509;

        C0361(Long l, InterfaceC0358 interfaceC0358) {
            this.f2508 = l;
            this.f2509 = interfaceC0358;
        }
    }

    private C0355() {
        try {
            this.f2493 = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static synchronized C0355 m2002() {
        C0355 c0355;
        synchronized (C0355.class) {
            if (f2482 == null) {
                f2482 = new C0355();
            }
            c0355 = f2482;
        }
        return c0355;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2003(final long j) {
        if (this.f2485.compareAndSet(false, true)) {
            C0379.m2046(3, "OnOff", this, "Performing status check.");
            new Thread() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ.1
                /* JADX WARN: Type inference failed for: r4v0, types: [com.ࢢ.ࢠ.ࢠ.ࢠ.ކ$1$1] */
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    handler.postDelayed(new RunnableC0360("CHA", handler, new InterfaceC0359() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ.1.1
                        @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.C0355.InterfaceC0359
                        /* renamed from: ࢠ  reason: contains not printable characters */
                        public final void mo2014(C0386 c0386) throws C0348 {
                            synchronized (C0355.f2483) {
                                boolean z = ((C0385) AbstractC0368.m2030()).f2564;
                                if (C0355.this.f2486 != c0386.m2085() || (C0355.this.f2486 == EnumC0357.f2500 && z)) {
                                    C0355.this.f2486 = c0386.m2085();
                                    if (C0355.this.f2486 == EnumC0357.f2500 && z) {
                                        C0355.this.f2486 = EnumC0357.f2501;
                                    }
                                    if (C0355.this.f2486 == EnumC0357.f2501) {
                                        C0379.m2046(3, "OnOff", this, "Moat enabled - Version 2.4.1");
                                    }
                                    for (C0361 c0361 : C0355.f2483) {
                                        if (C0355.this.f2486 == EnumC0357.f2501) {
                                            c0361.f2509.mo1981();
                                        }
                                    }
                                }
                                while (!C0355.f2483.isEmpty()) {
                                    C0355.f2483.remove();
                                }
                            }
                        }
                    }), j);
                    Looper.loop();
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public static void m2011() {
        synchronized (f2483) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<C0361> it = f2483.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - it.next().f2508.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f2483.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f2483.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m2012(InterfaceC0358 interfaceC0358) throws C0348 {
        if (this.f2486 == EnumC0357.f2501) {
            interfaceC0358.mo1981();
            return;
        }
        m2011();
        f2483.add(new C0361(Long.valueOf(System.currentTimeMillis()), interfaceC0358));
        if (this.f2494.compareAndSet(false, true)) {
            this.f2493.postDelayed(new Runnable() { // from class: com.ࢢ.ࢠ.ࢠ.ࢠ.ކ.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (C0355.f2483.size() > 0) {
                            C0355.m2011();
                            C0355.this.f2493.postDelayed(this, 60000L);
                            return;
                        }
                        C0355.this.f2494.compareAndSet(true, false);
                        C0355.this.f2493.removeCallbacks(this);
                    } catch (Exception e) {
                        C0348.m1974(e);
                    }
                }
            }, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final void m2013() {
        if (System.currentTimeMillis() - this.f2495 > this.f2491) {
            m2003(0L);
        }
    }
}
