package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: assets/classes2.dex */
public class RequestFuture<T> implements Response.ErrorListener, Response.Listener<T>, Future<T> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private Request<?> f2239;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f2240 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private T f2241;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private VolleyError f2242;

    private RequestFuture() {
    }

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0026 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:12:0x0011, B:16:0x0022, B:18:0x0026, B:20:0x002a, B:23:0x002e, B:24:0x0033, B:25:0x0034, B:26:0x003b, B:13:0x0015, B:15:0x001d, B:27:0x003c, B:28:0x0043), top: B:32:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0034 A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:12:0x0011, B:16:0x0022, B:18:0x0026, B:20:0x002a, B:23:0x002e, B:24:0x0033, B:25:0x0034, B:26:0x003b, B:13:0x0015, B:15:0x001d, B:27:0x003c, B:28:0x0043), top: B:32:0x0001 }] */
    /* renamed from: ࢠ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized T m1715(java.lang.Long r6) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r5 = this;
            monitor-enter(r5)
            com.mopub.volley.VolleyError r0 = r5.f2242     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L3c
            boolean r0 = r5.f2240     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto Ld
            T r6 = r5.f2241     // Catch: java.lang.Throwable -> L44
            monitor-exit(r5)
            return r6
        Ld:
            r0 = 0
            if (r6 != 0) goto L15
        L11:
            r5.wait(r0)     // Catch: java.lang.Throwable -> L44
            goto L22
        L15:
            long r2 = r6.longValue()     // Catch: java.lang.Throwable -> L44
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L22
            long r0 = r6.longValue()     // Catch: java.lang.Throwable -> L44
            goto L11
        L22:
            com.mopub.volley.VolleyError r6 = r5.f2242     // Catch: java.lang.Throwable -> L44
            if (r6 != 0) goto L34
            boolean r6 = r5.f2240     // Catch: java.lang.Throwable -> L44
            if (r6 == 0) goto L2e
            T r6 = r5.f2241     // Catch: java.lang.Throwable -> L44
            monitor-exit(r5)
            return r6
        L2e:
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException     // Catch: java.lang.Throwable -> L44
            r6.<init>()     // Catch: java.lang.Throwable -> L44
            throw r6     // Catch: java.lang.Throwable -> L44
        L34:
            java.util.concurrent.ExecutionException r6 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L44
            com.mopub.volley.VolleyError r0 = r5.f2242     // Catch: java.lang.Throwable -> L44
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L44
            throw r6     // Catch: java.lang.Throwable -> L44
        L3c:
            java.util.concurrent.ExecutionException r6 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L44
            com.mopub.volley.VolleyError r0 = r5.f2242     // Catch: java.lang.Throwable -> L44
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L44
            throw r6     // Catch: java.lang.Throwable -> L44
        L44:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.RequestFuture.m1715(java.lang.Long):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f2239 == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f2239.cancel();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return m1715(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m1715(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.f2239 == null) {
            return false;
        }
        return this.f2239.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f2240 && this.f2242 == null) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.f2242 = volleyError;
        notifyAll();
    }

    @Override // com.mopub.volley.Response.Listener
    public synchronized void onResponse(T t) {
        this.f2240 = true;
        this.f2241 = t;
        notifyAll();
    }

    public void setRequest(Request<?> request) {
        this.f2239 = request;
    }
}
