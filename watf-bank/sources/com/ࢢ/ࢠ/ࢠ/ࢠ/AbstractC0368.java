package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.app.Application;
import com.ࢢ.ࢠ.ࢠ.ࢠ.AbstractC0373;
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢠ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0368 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AbstractC0368 f2531;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static synchronized AbstractC0368 m2030() {
        AbstractC0368 abstractC0368;
        synchronized (AbstractC0368.class) {
            if (f2531 == null) {
                try {
                    f2531 = new C0385();
                } catch (Exception e) {
                    C0348.m1974(e);
                    f2531 = new AbstractC0373.C0374();
                }
            }
            abstractC0368 = f2531;
        }
        return abstractC0368;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public abstract void mo2031(C0372 c0372, Application application);
}
