package com.mopub.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* loaded from: assets/classes2.dex */
public class NetworkDispatcher extends Thread {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final BlockingQueue<Request<?>> f2116;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Network f2117;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final Cache f2118;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final ResponseDelivery f2119;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private volatile boolean f2120 = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.f2116 = blockingQueue;
        this.f2117 = network;
        this.f2118 = cache;
        this.f2119 = responseDelivery;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1629() throws InterruptedException {
        Request<?> take = this.f2116.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            take.addMarker("network-queue-take");
            if (take.isCanceled()) {
                take.m1641("network-discard-cancelled");
                take.m1644();
                return;
            }
            m1630(take);
            NetworkResponse performRequest = this.f2117.performRequest(take);
            take.addMarker("network-http-complete");
            if (performRequest.notModified && take.hasHadResponseDelivered()) {
                take.m1641("not-modified");
                take.m1644();
                return;
            }
            Response<?> mo502 = take.mo502(performRequest);
            take.addMarker("network-parse-complete");
            if (take.shouldCache() && mo502.cacheEntry != null) {
                this.f2118.put(take.getCacheKey(), mo502.cacheEntry);
                take.addMarker("network-cache-written");
            }
            take.markDelivered();
            this.f2119.postResponse(take, mo502);
            take.m1639(mo502);
        } catch (VolleyError e) {
            e.m1646(SystemClock.elapsedRealtime() - elapsedRealtime);
            m1631(take, e);
            take.m1644();
        } catch (Exception e2) {
            VolleyLog.e(e2, "Unhandled exception %s", e2.toString());
            VolleyError volleyError = new VolleyError(e2);
            volleyError.m1646(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f2119.postError(take, volleyError);
            take.m1644();
        }
    }

    @TargetApi(14)
    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1630(Request<?> request) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m1631(Request<?> request, VolleyError volleyError) {
        this.f2119.postError(request, request.m1637(volleyError));
    }

    public void quit() {
        this.f2120 = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m1629();
            } catch (InterruptedException unused) {
                if (this.f2120) {
                    return;
                }
            }
        }
    }
}
