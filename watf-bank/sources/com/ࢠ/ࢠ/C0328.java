package com.ࢠ.ࢠ;

import android.text.TextUtils;
import com.flurry.android.FlurryConfig;
import com.flurry.android.FlurryConfigListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* renamed from: com.ࢠ.ࢠ.ލ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0328 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile C0328 f2352;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private FlurryConfig f2353;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private Map<String, Object> f2354 = new HashMap();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final long f2355 = 10800000;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private long f2356 = 0;

    private C0328() {
        this.f2353 = null;
        this.f2353 = FlurryConfig.getInstance();
        this.f2353.registerListener(new FlurryConfigListener() { // from class: com.ࢠ.ࢠ.ލ.1
            public void onActivateComplete(boolean z) {
                C0328.this.f2354.clear();
                C0328.this.f2354.put(String.valueOf(new Random(System.currentTimeMillis()).nextInt(1000)), Integer.valueOf(new Random(System.currentTimeMillis()).nextInt(1000)));
            }

            public void onFetchError(boolean z) {
            }

            public void onFetchNoChange() {
            }

            public void onFetchSuccess() {
                C0328.this.f2353.activateConfig();
            }
        });
        m1840();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0328 m1838() {
        if (f2352 == null) {
            synchronized (C0328.class) {
                if (f2352 == null) {
                    f2352 = new C0328();
                }
            }
        }
        return f2352;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m1840() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f2356;
        if (j < 0) {
            j = 0;
        }
        boolean z = true;
        if (!this.f2354.isEmpty() ? j <= 10800000 : j < 40000) {
            z = false;
        }
        if (z) {
            this.f2356 = currentTimeMillis;
            this.f2353.fetchConfig();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public Boolean m1841(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f2354.containsKey(str)) {
            Object obj = this.f2354.get(str);
            return obj instanceof Boolean ? (Boolean) obj : Boolean.valueOf(z);
        }
        boolean z2 = this.f2353.getBoolean(str, z);
        if (z2 != z) {
            this.f2354.put(str, Boolean.valueOf(z2));
        }
        return Boolean.valueOf(z2);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public Long m1842(String str, Long l) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f2354.containsKey(str)) {
            Object obj = this.f2354.get(str);
            if (obj instanceof Long) {
                return (Long) obj;
            }
            return null;
        }
        Long valueOf = Long.valueOf(this.f2353.getLong(str, l.longValue()));
        if (valueOf != l) {
            this.f2354.put(str, valueOf);
            return valueOf;
        }
        return valueOf;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public String m1843(String str) {
        m1840();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f2354.containsKey(str)) {
            Object obj = this.f2354.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        String string = this.f2353.getString(str, (String) null);
        if (string != null) {
            this.f2354.put(str, string);
            return string;
        }
        return null;
    }
}
