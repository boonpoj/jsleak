package com.ࢠ.ࢠ;

import java.util.Random;
import org.json.JSONArray;
/* renamed from: com.ࢠ.ࢠ.ࢪ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0338 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile C0338 f2384;

    private C0338() {
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0338 m1885() {
        if (f2384 == null) {
            synchronized (C0338.class) {
                if (f2384 == null) {
                    f2384 = new C0338();
                }
            }
        }
        return f2384;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public long m1886(int i) {
        try {
            return new JSONArray(C0328.m1838().m1843(C0303.m1718() + "_" + C0309.m1774("ZffQsVUEwWvbvUExaXeOBg"))).optLong(i, 100L);
        } catch (Throwable unused) {
            return 100L;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public long m1887(ࢤ r4) {
        return C0328.m1838().m1842(C0303.m1718() + "_" + C0309.m1774("TJ6wljs5FDMqJhv2UeUckw") + "_" + C0309.m1774(r4.toString()), (Long) 10L).longValue();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public boolean m1888() {
        return C0328.m1838().m1841(C0303.m1718() + "_" + C0309.m1774("lZ6LJm9oT5QrzQzrUCmJkQ"), false).booleanValue();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public long m1889() {
        return C0328.m1838().m1842(C0303.m1718() + "_" + C0309.m1774("ar9qGUU2uBNFziv50nlmkA"), (Long) 7200L).longValue();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public long m1890() {
        return C0328.m1838().m1842(C0303.m1718() + "_" + C0309.m1774("TJ6wljs5FDMqJhv2UeUckw"), (Long) 30L).longValue();
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    public long m1891() {
        return C0328.m1838().m1842(C0303.m1718() + C0339.m1897() + "_" + C0309.m1774("D/9V8vDRkJ+7Nx3gPGwT8w"), Long.valueOf(new Random(System.currentTimeMillis()).nextInt(8))).longValue();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    public long m1892() {
        return C0328.m1838().m1842(C0303.m1718() + C0304.m1723() + "_" + C0309.m1774("gvwyRgxt+U6avK82nxVvKw"), Long.valueOf(new Random(System.currentTimeMillis()).nextInt(20) + 1)).longValue();
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    public long m1893() {
        return C0328.m1838().m1842(C0303.m1718() + C0339.m1897() + "_" + C0309.m1774("ZffQsVUEwWvbvUExaXeOBg"), (Long) 25L).longValue();
    }

    /* renamed from: ࢨ  reason: contains not printable characters */
    public boolean m1894() {
        return C0328.m1838().m1841(C0309.m1774("lT+AgEMha0jZYJoXkCG9hA"), false).booleanValue();
    }
}
