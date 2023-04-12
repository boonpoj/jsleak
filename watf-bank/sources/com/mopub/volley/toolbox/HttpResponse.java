package com.mopub.volley.toolbox;

import com.mopub.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/classes2.dex */
public final class HttpResponse {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final int f2187;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final List<Header> f2188;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final int f2189;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private final InputStream f2190;

    public HttpResponse(int i, List<Header> list) {
        this(i, list, -1, null);
    }

    public HttpResponse(int i, List<Header> list, int i2, InputStream inputStream) {
        this.f2187 = i;
        this.f2188 = list;
        this.f2189 = i2;
        this.f2190 = inputStream;
    }

    public final InputStream getContent() {
        return this.f2190;
    }

    public final int getContentLength() {
        return this.f2189;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.f2188);
    }

    public final int getStatusCode() {
        return this.f2187;
    }
}
