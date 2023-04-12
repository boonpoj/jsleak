package com.mopub.volley;
/* loaded from: assets/classes2.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private long f2153;

    public VolleyError() {
        this.networkResponse = null;
    }

    public VolleyError(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.f2153;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m1646(long j) {
        this.f2153 = j;
    }
}
