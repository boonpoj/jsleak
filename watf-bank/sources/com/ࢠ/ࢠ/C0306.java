package com.ࢠ.ࢠ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* renamed from: com.ࢠ.ࢠ.ށ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0306 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0306 f2268;

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0306 m1748() {
        if (f2268 == null) {
            synchronized (C0306.class) {
                if (f2268 == null) {
                    f2268 = new C0306();
                }
            }
        }
        return f2268;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public long m1749(ࢤ r6) {
        String m1813 = C0318.m1810().m1813(C0303.m1720() + "_TMjp9Y5C5AH1LeX3EdgbpA/FL66oYearsGN8K0c6LQQ", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
        if (simpleDateFormat.format(new Date(System.currentTimeMillis())).equalsIgnoreCase(m1813)) {
            return C0318.m1810().m1812(C0303.m1720() + "_0CZGaO0e9sJBx/hZb65cmg_" + r6.toString(), 0L);
        }
        return 0L;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1750(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
        C0318.m1810().m1815(C0303.m1720() + "_TMjp9Y5C5AH1LeX3EdgbpA/FL66oYearsGN8K0c6LQQ", simpleDateFormat.format(new Date(System.currentTimeMillis())));
        C0318.m1810().m1814(C0303.m1720() + "_0CZGaO0e9sJBx/hZb65cmg", j);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1751(ࢤ r3, long j) {
        C0318.m1810().m1814(C0303.m1720() + "_0CZGaO0e9sJBx/hZb65cmg_" + r3.toString(), j);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public long m1752() {
        String str = C0303.m1720() + "_0CZGaO0e9sJBx/hZb65cmg";
        String m1813 = C0318.m1810().m1813(C0303.m1720() + "_TMjp9Y5C5AH1LeX3EdgbpA/FL66oYearsGN8K0c6LQQ", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
        if (simpleDateFormat.format(new Date(System.currentTimeMillis())).equalsIgnoreCase(m1813)) {
            return C0318.m1810().m1812(str, 0L);
        }
        m1750(0L);
        for (ࢤ r1 : C0303.f2246) {
            m1751(r1, 0L);
            m1754(r1, 0L);
        }
        return 0L;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public long m1753(ࢤ r4) {
        return C0318.m1810().m1812(C0303.m1720() + C0339.m1901() + "_YQwwR/gLDTy+zc5GBaMbKSJaCQORCC0zuiaSxSljPQ8_" + r4.toString(), 0L);
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1754(ࢤ r3, long j) {
        C0318.m1810().m1814(C0303.m1720() + C0339.m1901() + "_YQwwR/gLDTy+zc5GBaMbKSJaCQORCC0zuiaSxSljPQ8_" + r3.toString(), j);
    }
}
