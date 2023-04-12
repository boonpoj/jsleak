package com.ࢠ.ࢠ;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.ࢠ.ࢠ.C0333;
import java.lang.ref.WeakReference;
import java.util.List;
/* renamed from: com.ࢠ.ࢠ.ޅ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0310 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0333 f2295;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private ࢤ f2296;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private ࢧ f2297;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private ࢦ f2298;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Object f2299;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private InterfaceC0312 f2300;

    /* renamed from: com.ࢠ.ࢠ.ޅ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0311 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private C0333 f2304 = null;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private C0333 f2305 = null;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private String f2306 = null;

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
            if (r2 == com.ࢠ.ࢠ.ࢦ.ࢣ) goto L50;
         */
        /* renamed from: ࢢ  reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.ࢠ.ࢠ.C0333 m1784() {
            /*
                r15 = this;
                java.util.List r0 = r15.m1785()
                r1 = 0
                if (r0 == 0) goto Lc5
                boolean r2 = r0.isEmpty()
                if (r2 == 0) goto Lf
                goto Lc5
            Lf:
                com.ࢠ.ࢠ.ࢦ r2 = r15.m1786()
                com.ࢠ.ࢠ.ࢧ r3 = com.ࢠ.ࢠ.ࢧ.ࢠ
                boolean r3 = r0.contains(r3)
                if (r3 != 0) goto L2f
                com.ࢠ.ࢠ.ࢧ r3 = com.ࢠ.ࢠ.ࢧ.ࢣ
                boolean r3 = r0.contains(r3)
                if (r3 == 0) goto L24
                goto L2f
            L24:
                com.ࢠ.ࢠ.ࢧ r3 = com.ࢠ.ࢠ.ࢧ.ࢢ
                boolean r3 = r0.contains(r3)
                if (r3 == 0) goto L40
                com.ࢠ.ࢠ.ࢦ r2 = com.ࢠ.ࢠ.ࢦ.ࢣ
                goto L40
            L2f:
                com.ࢠ.ࢠ.ࢧ r3 = com.ࢠ.ࢠ.ࢧ.ࢢ
                boolean r3 = r0.contains(r3)
                if (r3 == 0) goto L38
                return r1
            L38:
                if (r2 == 0) goto Lc5
                com.ࢠ.ࢠ.ࢦ r3 = com.ࢠ.ࢠ.ࢦ.ࢣ
                if (r2 != r3) goto L40
                goto Lc5
            L40:
                com.ࢠ.ࢠ.ࢥ$ࢠ r9 = new com.ࢠ.ࢠ.ࢥ$ࢠ
                r9.<init>()
                r10 = 0
                com.ࢠ.ࢠ.ࢧ[] r3 = new com.ࢠ.ࢠ.ࢧ[r10]
                java.lang.Object[] r3 = r0.toArray(r3)
                com.ࢠ.ࢠ.ࢧ[] r3 = (com.ࢠ.ࢠ.ࢧ[]) r3
                r9.m1866(r3)
                r9.m1864(r2)
                java.util.List r11 = r15.m1787()
                java.util.List r3 = r15.m1788()
                if (r3 != 0) goto L5f
                return r1
            L5f:
                java.util.Iterator r12 = r3.iterator()
                r13 = 1
                r3 = 1
            L65:
                boolean r4 = r12.hasNext()
                if (r4 == 0) goto Lbd
                java.lang.Object r4 = r12.next()
                com.ࢠ.ࢠ.ࢥ$ࢢ r4 = (com.ࢠ.ࢠ.C0333.C0335) r4
                com.ࢠ.ࢠ.ࢧ r5 = r4.f2368
                boolean r5 = r0.contains(r5)
                r5 = r5 ^ r13
                if (r11 == 0) goto L89
                boolean r6 = r11.isEmpty()
                if (r6 != 0) goto L89
                com.ࢠ.ࢠ.ࢤ r6 = r4.f2366
                boolean r6 = r11.contains(r6)
                if (r6 != 0) goto L89
                r5 = 1
            L89:
                com.ࢠ.ࢠ.ࢦ r6 = r4.f2370
                boolean r6 = r2.equals(r6)
                if (r6 != 0) goto La6
                com.ࢠ.ࢠ.ࢧ r6 = com.ࢠ.ࢠ.ࢧ.ࢠ
                com.ࢠ.ࢠ.ࢧ r7 = r4.f2368
                boolean r6 = r6.equals(r7)
                if (r6 != 0) goto La5
                com.ࢠ.ࢠ.ࢧ r6 = com.ࢠ.ࢠ.ࢧ.ࢣ
                com.ࢠ.ࢠ.ࢧ r7 = r4.f2368
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto La6
            La5:
                r5 = 1
            La6:
                if (r5 != 0) goto L65
                com.ࢠ.ࢠ.ࢤ r5 = r4.f2366
                com.ࢠ.ࢠ.ࢧ r6 = r4.f2368
                com.ࢠ.ࢠ.ࢦ r7 = r4.f2370
                int r8 = r4.f2367
                java.lang.String[] r14 = r4.f2369
                r3 = r9
                r4 = r5
                r5 = r6
                r6 = r7
                r7 = r8
                r8 = r14
                r3.m1863(r4, r5, r6, r7, r8)
                r3 = 0
                goto L65
            Lbd:
                if (r3 == 0) goto Lc0
                return r1
            Lc0:
                com.ࢠ.ࢠ.ࢥ r0 = r9.m1867()
                return r0
            Lc5:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ࢠ.ࢠ.C0310.C0311.m1784():com.ࢠ.ࢠ.ࢥ");
        }

        /* renamed from: ࢣ  reason: contains not printable characters */
        private List<ࢧ> m1785() {
            List<ࢧ> m1856 = this.f2304 != null ? this.f2304.m1856() : null;
            if (m1856 == null || m1856.isEmpty()) {
                if (this.f2305 != null) {
                    m1856 = this.f2305.m1856();
                }
                if (m1856 == null || !m1856.isEmpty()) {
                }
                return m1856;
            }
            return m1856;
        }

        /* renamed from: ࢤ  reason: contains not printable characters */
        private ࢦ m1786() {
            ࢦ m1857 = this.f2304 != null ? this.f2304.m1857() : null;
            if (m1857 != null) {
                return m1857;
            }
            if (this.f2305 != null) {
                m1857 = this.f2305.m1857();
            }
            if (m1857 != null) {
            }
            return m1857;
        }

        /* renamed from: ࢥ  reason: contains not printable characters */
        private List<ࢤ> m1787() {
            List<ࢤ> m1855 = this.f2304 != null ? this.f2304.m1855() : null;
            if (m1855 == null || m1855.isEmpty()) {
                if (this.f2305 != null) {
                    m1855 = this.f2305.m1855();
                }
                if (m1855 == null || !m1855.isEmpty()) {
                }
                return m1855;
            }
            return m1855;
        }

        /* renamed from: ࢦ  reason: contains not printable characters */
        private List<C0333.C0335> m1788() {
            List<C0333.C0335> m1858 = this.f2304 != null ? this.f2304.m1858() : null;
            if (m1858 == null || m1858.isEmpty()) {
                if (this.f2305 != null) {
                    m1858 = this.f2305.m1858();
                }
                return (m1858 == null || m1858.isEmpty()) ? C0307.m1757() : m1858;
            }
            return m1858;
        }

        /* JADX WARN: Removed duplicated region for block: B:81:0x0248 A[Catch: Throwable -> 0x0276, TryCatch #3 {Throwable -> 0x0276, blocks: (B:33:0x00ee, B:34:0x010f, B:36:0x0115, B:39:0x012b, B:41:0x013f, B:44:0x0147, B:49:0x015d, B:51:0x0170, B:54:0x0177, B:56:0x017d, B:58:0x0187, B:59:0x018a, B:60:0x018d, B:64:0x0197, B:66:0x019f, B:68:0x01a7, B:79:0x0240, B:81:0x0248, B:83:0x0250, B:84:0x025e, B:72:0x01b4, B:73:0x01ef, B:75:0x01f9, B:77:0x0201, B:85:0x026a), top: B:100:0x00ee }] */
        /* renamed from: ࢧ  reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.ࢠ.ࢠ.C0333 m1789() {
            /*
                Method dump skipped, instructions count: 635
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ࢠ.ࢠ.C0310.C0311.m1789():com.ࢠ.ࢠ.ࢥ");
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0311 m1790(C0333 c0333) {
            this.f2305 = c0333;
            return this;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0311 m1791(@NonNull String str) {
            this.f2306 = str;
            return this;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0310 m1792() {
            if (TextUtils.isEmpty(this.f2306)) {
                return null;
            }
            if (C0328.m1838().m1841(this.f2306 + "_enable", true).booleanValue()) {
                this.f2304 = m1789();
                C0333 m1784 = m1784();
                if (m1784 == null) {
                    return null;
                }
                return new C0310(m1784);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢠ.ࢠ.ޅ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0312 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void mo1793();

        /* renamed from: ࢠ  reason: contains not printable characters */
        void mo1794(Context context, List<C0333.C0335> list, ࢦ r3, AbstractC0332 abstractC0332);
    }

    private C0310() {
        this.f2295 = null;
        this.f2299 = null;
        this.f2300 = null;
    }

    private C0310(C0333 c0333) {
        this.f2295 = null;
        this.f2299 = null;
        this.f2300 = null;
        this.f2295 = c0333;
        this.f2298 = this.f2295.m1857();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1780(@NonNull Context context, @Nullable final AbstractC0332 abstractC0332) {
        m1783();
        List<C0333.C0335> m1858 = this.f2295.m1858();
        if (m1858 == null || m1858.isEmpty()) {
            return;
        }
        if (this.f2300 == null) {
            this.f2300 = new C0317();
        }
        this.f2300.mo1794(context, m1858, this.f2298, new AbstractC0332() { // from class: com.ࢠ.ࢠ.ޅ.1

            /* renamed from: ࢠ  reason: contains not printable characters */
            WeakReference<AbstractC0332> f2301;

            {
                this.f2301 = new WeakReference<>(abstractC0332);
            }

            @Override // com.ࢠ.ࢠ.AbstractC0332
            /* renamed from: ࢠ */
            public void mo1736(ࢤ r2, ࢧ r3, Object obj, Object... objArr) {
                C0310.this.f2296 = r2;
                C0310.this.f2297 = r3;
                C0310.this.f2299 = obj;
                AbstractC0332 abstractC03322 = this.f2301.get();
                if (abstractC03322 != null) {
                    abstractC03322.mo1736(r2, r3, obj, objArr);
                }
            }

            @Override // com.ࢠ.ࢠ.AbstractC0332
            /* renamed from: ࢠ */
            public void mo1737(String str) {
                AbstractC0332 abstractC03322 = this.f2301.get();
                if (abstractC03322 != null) {
                    abstractC03322.mo1737(str);
                }
            }
        });
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1781(ViewGroup viewGroup, @Nullable AbstractC0330 abstractC0330) {
        if (this.f2299 == null) {
            return;
        }
        if (ࢤ.ࢠ.equals(this.f2296)) {
            C0336.m1875(this.f2299, viewGroup, this.f2298, abstractC0330);
        } else if (ࢤ.ࢢ.equals(this.f2296)) {
            C0308.m1768(this.f2299, viewGroup, this.f2298, abstractC0330);
        } else if (ࢤ.ࢥ.equals(this.f2296)) {
            C0319.m1823(this.f2299, viewGroup, this.f2298, abstractC0330);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public boolean m1782() {
        if (this.f2299 == null) {
            return false;
        }
        if (ࢤ.ࢠ.equals(this.f2296)) {
            return C0336.m1876(this.f2299);
        }
        if (ࢤ.ࢢ.equals(this.f2296)) {
            return C0308.m1769(this.f2299);
        }
        if (ࢤ.ࢥ.equals(this.f2296)) {
            return C0319.m1824(this.f2299);
        }
        return false;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1783() {
        if (this.f2300 != null) {
            this.f2300.mo1793();
        }
        if (this.f2299 == null) {
            return;
        }
        if (ࢤ.ࢠ.equals(this.f2296)) {
            C0336.m1877(this.f2299);
        } else if (ࢤ.ࢢ.equals(this.f2296)) {
            C0308.m1771(this.f2299);
        } else if (ࢤ.ࢥ.equals(this.f2296)) {
            C0319.m1827(this.f2299);
        }
        this.f2299 = null;
    }
}
