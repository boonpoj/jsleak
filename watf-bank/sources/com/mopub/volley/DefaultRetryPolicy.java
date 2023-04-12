package com.mopub.volley;
/* loaded from: assets/classes2.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private int f2103;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private int f2104;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final int f2105;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final float f2106;

    public DefaultRetryPolicy() {
        this(DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f2103 = i;
        this.f2105 = i2;
        this.f2106 = f;
    }

    public float getBackoffMultiplier() {
        return this.f2106;
    }

    @Override // com.mopub.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.f2104;
    }

    @Override // com.mopub.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.f2103;
    }

    @Override // com.mopub.volley.RetryPolicy
    public void retry(VolleyError volleyError) throws VolleyError {
        this.f2104++;
        this.f2103 = (int) (this.f2103 + (this.f2103 * this.f2106));
        if (!m1628()) {
            throw volleyError;
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected boolean m1628() {
        return this.f2104 <= this.f2105;
    }
}
