package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.RequestManager.RequestFactory;
import com.mopub.volley.Request;
/* loaded from: assets/classes2.dex */
public abstract class RequestManager<T extends RequestFactory> {
    @Nullable

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected Request<?> f2079;
    @Nullable

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected T f2080;
    @Nullable

    /* renamed from: ࢣ  reason: contains not printable characters */
    protected BackoffPolicy f2081;
    @NonNull

    /* renamed from: ࢤ  reason: contains not printable characters */
    protected Handler f2082;

    /* loaded from: assets/classes2.dex */
    public interface RequestFactory {
    }

    public RequestManager(@NonNull Looper looper) {
        this.f2082 = new Handler(looper);
    }

    public void cancelRequest() {
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue != null && this.f2079 != null) {
            requestQueue.cancel(this.f2079);
        }
        m1615();
    }

    public boolean isAtCapacity() {
        return this.f2079 != null;
    }

    public void makeRequest(@NonNull T t, @NonNull BackoffPolicy backoffPolicy) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(backoffPolicy);
        cancelRequest();
        this.f2080 = t;
        this.f2081 = backoffPolicy;
        m1614();
    }

    @NonNull
    /* renamed from: ࢠ  reason: contains not printable characters */
    abstract Request<?> m1613();

    @VisibleForTesting
    /* renamed from: ࢢ  reason: contains not printable characters */
    void m1614() {
        this.f2079 = m1613();
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue == null) {
            MoPubLog.d("MoPubRequest queue is null. Clearing request.");
            m1615();
        } else if (this.f2081.getRetryCount() == 0) {
            requestQueue.add(this.f2079);
        } else {
            requestQueue.addDelayedRequest(this.f2079, this.f2081.getBackoffMs());
        }
    }

    @VisibleForTesting
    /* renamed from: ࢣ  reason: contains not printable characters */
    void m1615() {
        this.f2079 = null;
        this.f2080 = null;
        this.f2081 = null;
    }
}
