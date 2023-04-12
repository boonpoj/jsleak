package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import java.io.UnsupportedEncodingException;
/* loaded from: assets/classes2.dex */
public class StringRequest extends Request<String> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final Object f2243;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Response.Listener<String> f2244;

    public StringRequest(int i, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.f2243 = new Object();
        this.f2244 = listener;
    }

    public StringRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(0, str, listener, errorListener);
    }

    @Override // com.mopub.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f2243) {
            this.f2244 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ */
    public Response<String> mo502(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mopub.volley.Request
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void deliverResponse(String str) {
        Response.Listener<String> listener;
        synchronized (this.f2243) {
            listener = this.f2244;
        }
        if (listener != null) {
            listener.onResponse(str);
        }
    }
}
