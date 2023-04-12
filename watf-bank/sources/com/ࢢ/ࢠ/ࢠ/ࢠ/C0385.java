package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0355;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0379;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢫ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0385 extends AbstractC0368 implements C0355.InterfaceC0358 {
    @Nullable

    /* renamed from: ࢤ  reason: contains not printable characters */
    C0379 f2567;

    /* renamed from: ࢥ  reason: contains not printable characters */
    WeakReference<Context> f2568;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private String f2570;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private C0372 f2571;

    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean f2564 = false;

    /* renamed from: ࢢ  reason: contains not printable characters */
    boolean f2565 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    boolean f2566 = false;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private boolean f2569 = false;

    @UiThread
    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m2073() {
        if (this.f2567 == null) {
            this.f2567 = new C0379(C0381.m2054(), C0379.EnumC0380.f2544);
            this.f2567.m2052(this.f2570);
            C0379.m2046(3, "Analytics", this, "Preparing native display tracking with partner code " + this.f2570);
            C0379.m2049("[SUCCESS] ", "Prepared for native display tracking with partner code " + this.f2570);
        }
    }

    @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.AbstractC0368
    /* renamed from: ࢠ */
    public final void mo2031(C0372 c0372, Application application) {
        try {
            if (this.f2569) {
                C0379.m2046(3, "Analytics", this, "Moat SDK has already been started.");
                return;
            }
            this.f2571 = c0372;
            C0355.m2002().m2013();
            this.f2566 = c0372.f2536;
            if (application == null) {
                throw new C0348("Moat Analytics SDK didn't start, application was null");
            }
            if (c0372.f2537 && C0352.m1988(application.getApplicationContext())) {
                this.f2564 = true;
            }
            this.f2568 = new WeakReference<>(application.getApplicationContext());
            this.f2569 = true;
            this.f2565 = c0372.f2535;
            C0381.m2055(application);
            C0355.m2002().m2012(this);
            if (!c0372.f2534) {
                C0352.m1987(application);
            }
            C0379.m2049("[SUCCESS] ", "Moat Analytics SDK Version 2.4.1 started");
        } catch (Exception e) {
            C0348.m1974(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final boolean m2074() {
        return this.f2569;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public final boolean m2075() {
        return this.f2571 != null && this.f2571.f2536;
    }

    @Override // com.ࢢ.ࢠ.ࢠ.ࢠ.C0355.InterfaceC0358
    /* renamed from: ࢤ */
    public final void mo1981() throws C0348 {
        C0348.m1973();
        C0347.m1954();
        if (this.f2570 != null) {
            try {
                m2073();
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }
    }
}
