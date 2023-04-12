package com.ࢠ.ࢠ;

import android.content.Context;
import com.ࢠ.ࢠ.C0310;
import com.ࢠ.ࢠ.C0333;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢠ.ࢠ.ވ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0317 extends AbstractC0332 implements C0310.InterfaceC0312 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private WeakReference<Context> f2313;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Iterator<C0333.C0335> f2314;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ࢦ f2315;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AbstractC0332 f2316 = null;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private ࢤ f2317 = null;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private ࢧ f2318 = null;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Object f2319 = null;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1808() {
        String str = "";
        boolean z = false;
        if (this.f2313.get() == null) {
            str = "context is empty";
        } else if (this.f2314.hasNext()) {
            z = true;
        } else {
            str = "all networks failed";
        }
        if (!z) {
            if (this.f2316 != null) {
                this.f2316.mo1737(str);
                return;
            }
            return;
        }
        C0333.C0335 next = this.f2314.next();
        ࢤ r1 = next.f2366;
        ࢧ r2 = next.f2368;
        String m1868 = next.m1868();
        Object obj = null;
        if (ࢤ.ࢠ.equals(r1)) {
            obj = C0336.m1871(this.f2313.get(), r2, this.f2315, m1868, this);
        } else if (ࢤ.ࢢ.equals(r1)) {
            obj = C0308.m1762(this.f2313.get(), r2, this.f2315, m1868, this);
        } else if (ࢤ.ࢥ.equals(r1)) {
            obj = C0319.m1818(this.f2313.get(), r2, this.f2315, m1868, this);
        }
        if (obj == null) {
            m1808();
            return;
        }
        this.f2317 = r1;
        this.f2318 = r2;
        this.f2319 = obj;
    }

    @Override // com.ࢠ.ࢠ.C0310.InterfaceC0312
    /* renamed from: ࢠ */
    public void mo1793() {
        if (this.f2319 != null) {
            if (ࢤ.ࢠ.equals(this.f2317)) {
                C0336.m1877(this.f2319);
            } else if (ࢤ.ࢢ.equals(this.f2317)) {
                C0308.m1771(this.f2319);
            } else if (ࢤ.ࢥ.equals(this.f2317)) {
                C0319.m1827(this.f2319);
            }
        }
        this.f2317 = null;
        this.f2318 = null;
        this.f2319 = null;
    }

    @Override // com.ࢠ.ࢠ.C0310.InterfaceC0312
    /* renamed from: ࢠ */
    public void mo1794(Context context, List<C0333.C0335> list, ࢦ r4, AbstractC0332 abstractC0332) {
        this.f2313 = new WeakReference<>(context);
        Collections.sort(list, new Comparator<C0333.C0335>() { // from class: com.ࢠ.ࢠ.ވ.1
            @Override // java.util.Comparator
            /* renamed from: ࢠ  reason: contains not printable characters */
            public int compare(C0333.C0335 c0335, C0333.C0335 c03352) {
                return c03352.f2367 - c0335.f2367;
            }
        });
        this.f2314 = list.iterator();
        this.f2315 = r4;
        this.f2316 = abstractC0332;
        mo1793();
        m1808();
    }

    @Override // com.ࢠ.ࢠ.AbstractC0332
    /* renamed from: ࢠ */
    public void mo1736(ࢤ r2, ࢧ r3, Object obj, Object... objArr) {
        this.f2317 = null;
        this.f2318 = null;
        this.f2319 = null;
        if (this.f2316 != null) {
            this.f2316.mo1736(r2, r3, obj, objArr);
        }
    }

    @Override // com.ࢠ.ࢠ.AbstractC0332
    /* renamed from: ࢠ */
    public void mo1737(String str) {
        mo1793();
        m1808();
    }
}
