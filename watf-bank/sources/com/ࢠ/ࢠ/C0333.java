package com.ࢠ.ࢠ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/* renamed from: com.ࢠ.ࢠ.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0333 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private C0334 f2361;

    /* renamed from: com.ࢠ.ࢠ.ࢥ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static final class C0334 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private List<ࢤ> f2362 = null;

        /* renamed from: ࢢ  reason: contains not printable characters */
        private List<ࢧ> f2363 = null;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private ࢦ f2364 = null;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private List<C0335> f2365 = new ArrayList();

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0334 m1863(ࢤ r2, ࢧ r3, ࢦ r4, int i, String[] strArr) {
            C0335 c0335 = new C0335();
            c0335.f2366 = r2;
            c0335.f2367 = i;
            c0335.f2368 = r3;
            c0335.f2369 = strArr;
            c0335.f2370 = r4;
            this.f2365.add(c0335);
            return this;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0334 m1864(ࢦ r1) {
            this.f2364 = r1;
            return this;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0334 m1865(ࢤ... r1) {
            this.f2362 = Arrays.asList(r1);
            return this;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0334 m1866(ࢧ... r1) {
            this.f2363 = Arrays.asList(r1);
            return this;
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public C0333 m1867() {
            return new C0333(this);
        }
    }

    /* renamed from: com.ࢠ.ࢠ.ࢥ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    static class C0335 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        ࢤ f2366;

        /* renamed from: ࢢ  reason: contains not printable characters */
        int f2367;

        /* renamed from: ࢣ  reason: contains not printable characters */
        ࢧ f2368;

        /* renamed from: ࢤ  reason: contains not printable characters */
        String[] f2369;

        /* renamed from: ࢥ  reason: contains not printable characters */
        ࢦ f2370;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public String m1868() {
            if (this.f2369 == null || this.f2369.length == 0) {
                return null;
            }
            return this.f2369[new Random(System.currentTimeMillis()).nextInt(this.f2369.length)];
        }
    }

    private C0333(C0334 c0334) {
        this.f2361 = c0334;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public List<ࢤ> m1855() {
        return this.f2361.f2362;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public List<ࢧ> m1856() {
        return this.f2361.f2363;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public ࢦ m1857() {
        return this.f2361.f2364;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public List<C0335> m1858() {
        return this.f2361.f2365;
    }
}
