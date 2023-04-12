package com.ࢠ.ࢠ;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.UUID;
/* renamed from: com.ࢠ.ࢠ.ކ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0313 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile C0313 f2307 = null;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static String f2308 = "y1kS/ZF4uyeLlvc7g89naQ";

    /* renamed from: ࢢ  reason: contains not printable characters */
    private volatile String f2309;

    private C0313() {
        this.f2309 = "";
        String m1800 = m1800();
        if (TextUtils.isEmpty(m1800)) {
            m1801();
        } else {
            this.f2309 = m1800;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0313 m1795() {
        if (f2307 == null) {
            synchronized (C0313.class) {
                if (f2307 == null) {
                    f2307 = new C0313();
                }
            }
        }
        return f2307;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1798(String str) {
        C0318.m1810().m1815(f2308, str);
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private String m1800() {
        return C0318.m1810().m1813(f2308, "");
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m1801() {
        new Thread(new Runnable() { // from class: com.ࢠ.ࢠ.ކ.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String id = AdvertisingIdClient.getAdvertisingIdInfo(C0337.m1878()).getId();
                    C0313.this.f2309 = UUID.nameUUIDFromBytes(id.getBytes("UTF-8")).toString();
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(C0313.this.f2309)) {
                    C0313.this.f2309 = UUID.randomUUID().toString();
                }
                C0313.this.m1798(C0313.this.f2309);
            }
        }).start();
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public String m1802() {
        return this.f2309;
    }
}
