package com.mopub.volley;

import com.mopub.volley.Cache;
/* loaded from: assets/classes2.dex */
public class Response<T> {
    public final Cache.Entry cacheEntry;
    public final VolleyError error;
    public boolean intermediate;
    public final T result;

    /* loaded from: assets/classes2.dex */
    public interface ErrorListener {
        void onErrorResponse(VolleyError volleyError);
    }

    /* loaded from: assets/classes2.dex */
    public interface Listener<T> {
        void onResponse(T t);
    }

    private Response(VolleyError volleyError) {
        this.intermediate = false;
        this.result = null;
        this.cacheEntry = null;
        this.error = volleyError;
    }

    private Response(T t, Cache.Entry entry) {
        this.intermediate = false;
        this.result = t;
        this.cacheEntry = entry;
        this.error = null;
    }

    public static <T> Response<T> error(VolleyError volleyError) {
        return new Response<>(volleyError);
    }

    public static <T> Response<T> success(T t, Cache.Entry entry) {
        return new Response<>(t, entry);
    }

    public boolean isSuccess() {
        return this.error == null;
    }
}
