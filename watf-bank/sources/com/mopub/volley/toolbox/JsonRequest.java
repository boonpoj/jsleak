package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;
/* loaded from: assets/classes2.dex */
public abstract class JsonRequest<T> extends Request<T> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f2225 = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Object f2226;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private Response.Listener<T> f2227;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final String f2228;

    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.f2226 = new Object();
        this.f2227 = listener;
        this.f2228 = str2;
    }

    @Deprecated
    public JsonRequest(String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, str, str2, listener, errorListener);
    }

    @Override // com.mopub.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f2226) {
            this.f2227 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    public void deliverResponse(T t) {
        Response.Listener<T> listener;
        synchronized (this.f2226) {
            listener = this.f2227;
        }
        if (listener != null) {
            listener.onResponse(t);
        }
    }

    @Override // com.mopub.volley.Request
    public byte[] getBody() {
        try {
            if (this.f2228 == null) {
                return null;
            }
            return this.f2228.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.f2228, "utf-8");
            return null;
        }
    }

    @Override // com.mopub.volley.Request
    public String getBodyContentType() {
        return f2225;
    }

    @Override // com.mopub.volley.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.mopub.volley.Request
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    public abstract Response<T> mo502(NetworkResponse networkResponse);
}
