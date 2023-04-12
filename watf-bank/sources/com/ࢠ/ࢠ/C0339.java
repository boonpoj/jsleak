package com.ࢠ.ࢠ;

import com.ࢠ.ࢠ.C0310;
import com.ࢠ.ࢠ.C0333;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.ࢠ.ࢠ.ࢫ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0339 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile C0339 f2385;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private String f2388;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f2386 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private C0341 f2387 = null;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private C0310 f2389 = null;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static String m1897() {
        return C0309.m1774("atJh6+eujv8DNnDpWLia1A");
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public static String m1901() {
        return "atJh6+eujv8DNnDpWLia1A";
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public static C0339 m1902() {
        if (f2385 == null) {
            synchronized (C0339.class) {
                if (f2385 == null) {
                    f2385 = new C0339();
                }
            }
        }
        return f2385;
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private List<ࢤ> m1905() {
        ArrayList arrayList = new ArrayList();
        for (ࢤ r2 : C0303.f2246) {
            if (C0306.m1748().m1749(r2) < C0338.m1885().m1887(r2)) {
                arrayList.add(r2);
            }
        }
        return arrayList;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1906(final int i) {
        if (this.f2389 != null) {
            this.f2389.m1783();
            this.f2389 = null;
        }
        if (this.f2387 != null) {
            this.f2387.m1915();
            this.f2387 = null;
        }
        List<ࢤ> m1905 = m1905();
        if (m1905 == null || m1905.isEmpty()) {
            return;
        }
        this.f2388 = C0303.m1718() + m1897();
        this.f2389 = new C0310.C0311().m1791(this.f2388).m1790(new C0333.C0334().m1866(ࢧ.ࢣ).m1864(ࢦ.ࢢ).m1865((ࢤ[]) m1905.toArray(new ࢤ[0])).m1867()).m1792();
        if (this.f2389 == null) {
            return;
        }
        this.f2389.m1780(C0337.m1878(), new AbstractC0332() { // from class: com.ࢠ.ࢠ.ࢫ.1
            @Override // com.ࢠ.ࢠ.AbstractC0332
            /* renamed from: ࢠ */
            public void mo1736(ࢤ r3, ࢧ r4, Object obj, Object... objArr) {
                super.mo1736(r3, r4, obj, objArr);
                if (C0339.this.m1907()) {
                    return;
                }
                C0339.this.f2387 = new C0341(C0337.m1878(), i, C0339.this.f2386);
                C0339.this.f2386 = !C0339.this.f2386;
                C0339.this.f2389.m1781(C0339.this.f2387.m1911(r3), new AbstractC0330() { // from class: com.ࢠ.ࢠ.ࢫ.1.1
                    @Override // com.ࢠ.ࢠ.AbstractC0330
                    /* renamed from: ࢠ */
                    public void mo1738(ࢤ r5, ࢧ r6, String str, Object... objArr2) {
                        super.mo1738(r5, r6, str, objArr2);
                        C0306.m1748().m1750(C0306.m1748().m1752() + 1);
                        C0306.m1748().m1751(r5, C0306.m1748().m1749(r5) + 1);
                        C0331.m1851(C0339.this.f2388, r5, r6);
                        C0331.m1853(C0339.this.f2388, r5, r6);
                        if (C0306.m1748().m1749(r5) >= C0338.m1885().m1887(r5)) {
                            C0331.m1850(C0339.this.f2388, r5);
                        }
                    }

                    @Override // com.ࢠ.ࢠ.AbstractC0330
                    /* renamed from: ࢢ */
                    public void mo1739(ࢤ r5, ࢧ r6, String str, Object... objArr2) {
                        super.mo1739(r5, r6, str, objArr2);
                        if (C0339.this.f2387 != null) {
                            C0339.this.f2387.m1912();
                        }
                        C0306.m1748().m1754(r5, C0306.m1748().m1753(r5) + 1);
                        C0331.m1852(C0339.this.f2388, r5, r6);
                        C0331.m1854(C0339.this.f2388, r5, r6);
                    }

                    @Override // com.ࢠ.ࢠ.AbstractC0330
                    /* renamed from: ࢣ */
                    public void mo1740(ࢤ r1, ࢧ r2, String str, Object... objArr2) {
                        super.mo1740(r1, r2, str, objArr2);
                        if (C0339.this.f2387 != null) {
                            C0339.this.f2387.m1915();
                            C0339.this.f2387 = null;
                        }
                        if (C0339.this.f2389 != null) {
                            C0339.this.f2389.m1783();
                            C0339.this.f2389 = null;
                        }
                    }
                });
            }

            @Override // com.ࢠ.ࢠ.AbstractC0332
            /* renamed from: ࢠ */
            public void mo1737(String str) {
                if (C0339.this.f2387 != null) {
                    C0339.this.f2387.m1915();
                    C0339.this.f2387 = null;
                }
                if (C0339.this.f2389 != null) {
                    C0339.this.f2389.m1783();
                    C0339.this.f2389 = null;
                }
            }
        });
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m1907() {
        return (this.f2387 == null || this.f2387.m1914() || this.f2389 == null) ? false : true;
    }
}
