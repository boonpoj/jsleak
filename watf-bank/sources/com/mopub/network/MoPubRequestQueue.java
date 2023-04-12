package com.mopub.network;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public class MoPubRequestQueue extends RequestQueue {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Map<Request<?>, C0290> f2053;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.network.MoPubRequestQueue$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0290 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        final int f2058;
        @NonNull

        /* renamed from: ࢢ  reason: contains not printable characters */
        final Handler f2059;
        @NonNull

        /* renamed from: ࢣ  reason: contains not printable characters */
        final Runnable f2060;

        C0290(MoPubRequestQueue moPubRequestQueue, @NonNull Request<?> request, int i) {
            this(request, i, new Handler());
        }

        @VisibleForTesting
        C0290(final Request<?> request, @NonNull int i, Handler handler) {
            this.f2058 = i;
            this.f2059 = handler;
            this.f2060 = new Runnable() { // from class: com.mopub.network.MoPubRequestQueue.ࢠ.1
                @Override // java.lang.Runnable
                public void run() {
                    MoPubRequestQueue.this.f2053.remove(request);
                    MoPubRequestQueue.this.add(request);
                }
            };
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        void m1602() {
            this.f2059.postDelayed(this.f2060, this.f2058);
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        void m1603() {
            this.f2059.removeCallbacks(this.f2060);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoPubRequestQueue(Cache cache, Network network) {
        super(cache, network);
        this.f2053 = new HashMap(10);
    }

    public void addDelayedRequest(@NonNull Request<?> request, int i) {
        Preconditions.checkNotNull(request);
        m1601(request, new C0290(this, request, i));
    }

    public void cancel(@NonNull final Request<?> request) {
        Preconditions.checkNotNull(request);
        cancelAll(new RequestQueue.RequestFilter() { // from class: com.mopub.network.MoPubRequestQueue.2
            @Override // com.mopub.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request2) {
                return request == request2;
            }
        });
    }

    @Override // com.mopub.volley.RequestQueue
    public void cancelAll(@NonNull RequestQueue.RequestFilter requestFilter) {
        Preconditions.checkNotNull(requestFilter);
        super.cancelAll(requestFilter);
        Iterator<Map.Entry<Request<?>, C0290>> it = this.f2053.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Request<?>, C0290> next = it.next();
            if (requestFilter.apply(next.getKey())) {
                next.getKey().cancel();
                next.getValue().m1603();
                it.remove();
            }
        }
    }

    @Override // com.mopub.volley.RequestQueue
    public void cancelAll(@NonNull final Object obj) {
        Preconditions.checkNotNull(obj);
        super.cancelAll(obj);
        cancelAll(new RequestQueue.RequestFilter() { // from class: com.mopub.network.MoPubRequestQueue.1
            @Override // com.mopub.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m1601(@NonNull Request<?> request, @NonNull C0290 c0290) {
        Preconditions.checkNotNull(c0290);
        if (this.f2053.containsKey(request)) {
            cancel(request);
        }
        c0290.m1602();
        this.f2053.put(request, c0290);
    }
}
