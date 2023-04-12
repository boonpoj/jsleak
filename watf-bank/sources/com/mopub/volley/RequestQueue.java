package com.mopub.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: assets/classes2.dex */
public class RequestQueue {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final AtomicInteger f2141;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Set<Request<?>> f2142;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final PriorityBlockingQueue<Request<?>> f2143;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final PriorityBlockingQueue<Request<?>> f2144;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final Cache f2145;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final Network f2146;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final ResponseDelivery f2147;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final NetworkDispatcher[] f2148;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private CacheDispatcher f2149;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private final List<RequestFinishedListener> f2150;

    /* loaded from: assets/classes2.dex */
    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    /* loaded from: assets/classes2.dex */
    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    public RequestQueue(Cache cache, Network network, int i) {
        this(cache, network, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network, int i, ResponseDelivery responseDelivery) {
        this.f2141 = new AtomicInteger();
        this.f2142 = new HashSet();
        this.f2143 = new PriorityBlockingQueue<>();
        this.f2144 = new PriorityBlockingQueue<>();
        this.f2150 = new ArrayList();
        this.f2145 = cache;
        this.f2146 = network;
        this.f2148 = new NetworkDispatcher[i];
        this.f2147 = responseDelivery;
    }

    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f2142) {
            this.f2142.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        (!request.shouldCache() ? this.f2144 : this.f2143).add(request);
        return request;
    }

    public <T> void addRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.f2150) {
            this.f2150.add(requestFinishedListener);
        }
    }

    public void cancelAll(RequestFilter requestFilter) {
        synchronized (this.f2142) {
            for (Request<?> request : this.f2142) {
                if (requestFilter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void cancelAll(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        cancelAll(new RequestFilter() { // from class: com.mopub.volley.RequestQueue.1
            @Override // com.mopub.volley.RequestQueue.RequestFilter
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }

    public Cache getCache() {
        return this.f2145;
    }

    public int getSequenceNumber() {
        return this.f2141.incrementAndGet();
    }

    public <T> void removeRequestFinishedListener(RequestFinishedListener<T> requestFinishedListener) {
        synchronized (this.f2150) {
            this.f2150.remove(requestFinishedListener);
        }
    }

    public void start() {
        stop();
        this.f2149 = new CacheDispatcher(this.f2143, this.f2144, this.f2145, this.f2147);
        this.f2149.start();
        for (int i = 0; i < this.f2148.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f2144, this.f2146, this.f2145, this.f2147);
            this.f2148[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        NetworkDispatcher[] networkDispatcherArr;
        if (this.f2149 != null) {
            this.f2149.quit();
        }
        for (NetworkDispatcher networkDispatcher : this.f2148) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public <T> void m1645(Request<T> request) {
        synchronized (this.f2142) {
            this.f2142.remove(request);
        }
        synchronized (this.f2150) {
            for (RequestFinishedListener requestFinishedListener : this.f2150) {
                requestFinishedListener.onRequestFinished(request);
            }
        }
    }
}
