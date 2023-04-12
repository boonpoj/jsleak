package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
/* loaded from: assets/classes2.dex */
public class ClearCacheRequest extends Request<Object> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Cache f2170;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Runnable f2171;

    public ClearCacheRequest(Cache cache, Runnable runnable) {
        super(0, null, null);
        this.f2170 = cache;
        this.f2171 = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    public void deliverResponse(Object obj) {
    }

    @Override // com.mopub.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // com.mopub.volley.Request
    public boolean isCanceled() {
        this.f2170.clear();
        if (this.f2171 != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.f2171);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    public Response<Object> mo502(NetworkResponse networkResponse) {
        return null;
    }
}
