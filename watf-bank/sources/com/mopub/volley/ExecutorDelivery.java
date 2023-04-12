package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
public class ExecutorDelivery implements ResponseDelivery {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Executor f2107;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mopub.volley.ExecutorDelivery$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class RunnableC0294 implements Runnable {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private final Request f2111;

        /* renamed from: ࢣ  reason: contains not printable characters */
        private final Response f2112;

        /* renamed from: ࢤ  reason: contains not printable characters */
        private final Runnable f2113;

        public RunnableC0294(Request request, Response response, Runnable runnable) {
            this.f2111 = request;
            this.f2112 = response;
            this.f2113 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2111.isCanceled()) {
                this.f2111.m1641("canceled-at-delivery");
                return;
            }
            if (this.f2112.isSuccess()) {
                this.f2111.deliverResponse(this.f2112.result);
            } else {
                this.f2111.deliverError(this.f2112.error);
            }
            if (this.f2112.intermediate) {
                this.f2111.addMarker("intermediate-response");
            } else {
                this.f2111.m1641("done");
            }
            if (this.f2113 != null) {
                this.f2113.run();
            }
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.f2107 = new Executor() { // from class: com.mopub.volley.ExecutorDelivery.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public ExecutorDelivery(Executor executor) {
        this.f2107 = executor;
    }

    @Override // com.mopub.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f2107.execute(new RunnableC0294(request, Response.error(volleyError), null));
    }

    @Override // com.mopub.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    @Override // com.mopub.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f2107.execute(new RunnableC0294(request, response, runnable));
    }
}
