package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;
/* loaded from: assets/classes2.dex */
public class MoPubNetworkError extends VolleyError {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Reason f2048;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Integer f2049;

    /* loaded from: assets/classes2.dex */
    public enum Reason {
        WARMING_UP,
        NO_FILL,
        BAD_HEADER_DATA,
        BAD_BODY,
        TRACKING_FAILURE,
        UNSPECIFIED
    }

    public MoPubNetworkError(@NonNull Reason reason) {
        this.f2048 = reason;
        this.f2049 = null;
    }

    public MoPubNetworkError(@NonNull NetworkResponse networkResponse, @NonNull Reason reason) {
        super(networkResponse);
        this.f2048 = reason;
        this.f2049 = null;
    }

    public MoPubNetworkError(@NonNull String str, @NonNull Reason reason) {
        this(str, reason, (Integer) null);
    }

    public MoPubNetworkError(@NonNull String str, @NonNull Reason reason, @Nullable Integer num) {
        super(str);
        this.f2048 = reason;
        this.f2049 = num;
    }

    public MoPubNetworkError(@NonNull String str, @NonNull Throwable th, @NonNull Reason reason) {
        super(str, th);
        this.f2048 = reason;
        this.f2049 = null;
    }

    public MoPubNetworkError(@NonNull Throwable th, @NonNull Reason reason) {
        super(th);
        this.f2048 = reason;
        this.f2049 = null;
    }

    @NonNull
    public Reason getReason() {
        return this.f2048;
    }

    @Nullable
    public Integer getRefreshTimeMillis() {
        return this.f2049;
    }
}
