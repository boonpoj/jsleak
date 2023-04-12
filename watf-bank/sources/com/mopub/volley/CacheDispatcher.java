package com.mopub.volley;

import android.os.Process;
import com.mopub.volley.Cache;
import com.mopub.volley.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* loaded from: assets/classes2.dex */
public class CacheDispatcher extends Thread {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final boolean f2092 = VolleyLog.DEBUG;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final BlockingQueue<Request<?>> f2093;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final BlockingQueue<Request<?>> f2094;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final Cache f2095;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private final ResponseDelivery f2096;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private volatile boolean f2097 = false;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final C0293 f2098 = new C0293(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.volley.CacheDispatcher$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0293 implements Request.InterfaceC0295 {

        /* renamed from: ࢠ  reason: contains not printable characters */
        private final Map<String, List<Request<?>>> f2101 = new HashMap();

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final CacheDispatcher f2102;

        C0293(CacheDispatcher cacheDispatcher) {
            this.f2102 = cacheDispatcher;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ࢠ  reason: contains not printable characters */
        public synchronized boolean m1627(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (!this.f2101.containsKey(cacheKey)) {
                this.f2101.put(cacheKey, null);
                request.m1638(this);
                if (VolleyLog.DEBUG) {
                    VolleyLog.d("new request, sending to network %s", cacheKey);
                }
                return false;
            }
            List<Request<?>> list = this.f2101.get(cacheKey);
            if (list == null) {
                list = new ArrayList<>();
            }
            request.addMarker("waiting-for-response");
            list.add(request);
            this.f2101.put(cacheKey, list);
            if (VolleyLog.DEBUG) {
                VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
            }
            return true;
        }

        @Override // com.mopub.volley.Request.InterfaceC0295
        public synchronized void onNoUsableResponseReceived(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.f2101.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.f2101.put(cacheKey, remove);
                remove2.m1638(this);
                try {
                    this.f2102.f2094.put(remove2);
                } catch (InterruptedException e) {
                    VolleyLog.e("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.f2102.quit();
                }
            }
        }

        @Override // com.mopub.volley.Request.InterfaceC0295
        public void onResponseReceived(Request<?> request, Response<?> response) {
            List<Request<?>> remove;
            if (response.cacheEntry == null || response.cacheEntry.isExpired()) {
                onNoUsableResponseReceived(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                remove = this.f2101.remove(cacheKey);
            }
            if (remove != null) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                }
                for (Request<?> request2 : remove) {
                    this.f2102.f2096.postResponse(request2, response);
                }
            }
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.f2093 = blockingQueue;
        this.f2094 = blockingQueue2;
        this.f2095 = cache;
        this.f2096 = responseDelivery;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1624() throws InterruptedException {
        final Request<?> take = this.f2093.take();
        take.addMarker("cache-queue-take");
        if (take.isCanceled()) {
            take.m1641("cache-discard-canceled");
            return;
        }
        Cache.Entry entry = this.f2095.get(take.getCacheKey());
        if (entry == null) {
            take.addMarker("cache-miss");
            if (this.f2098.m1627(take)) {
                return;
            }
            this.f2094.put(take);
        } else if (entry.isExpired()) {
            take.addMarker("cache-hit-expired");
            take.setCacheEntry(entry);
            if (this.f2098.m1627(take)) {
                return;
            }
            this.f2094.put(take);
        } else {
            take.addMarker("cache-hit");
            Response<?> mo502 = take.mo502(new NetworkResponse(entry.data, entry.responseHeaders));
            take.addMarker("cache-hit-parsed");
            if (entry.refreshNeeded()) {
                take.addMarker("cache-hit-refresh-needed");
                take.setCacheEntry(entry);
                mo502.intermediate = true;
                if (!this.f2098.m1627(take)) {
                    this.f2096.postResponse(take, mo502, new Runnable() { // from class: com.mopub.volley.CacheDispatcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CacheDispatcher.this.f2094.put(take);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                    return;
                }
            }
            this.f2096.postResponse(take, mo502);
        }
    }

    public void quit() {
        this.f2097 = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f2092) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f2095.initialize();
        while (true) {
            try {
                m1624();
            } catch (InterruptedException unused) {
                if (this.f2097) {
                    return;
                }
            }
        }
    }
}
