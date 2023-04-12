package com.mopub.network;

import com.mopub.volley.VolleyError;
/* loaded from: assets/classes2.dex */
public abstract class BackoffPolicy {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected int f2043;

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected int f2044;

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected int f2045;

    public abstract void backoff(VolleyError volleyError) throws VolleyError;

    public int getBackoffMs() {
        return this.f2043;
    }

    public int getRetryCount() {
        return this.f2044;
    }

    public boolean hasAttemptRemaining() {
        return this.f2044 < this.f2045;
    }
}
