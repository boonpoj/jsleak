package com.mopub.volley.toolbox;

import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: assets/classes2.dex */
public class HttpClientStack implements HttpStack {

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected final HttpClient f2186;

    /* loaded from: assets/classes2.dex */
    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "PATCH";

        public HttpPatch() {
        }

        public HttpPatch(String str) {
            setURI(URI.create(str));
        }

        public HttpPatch(URI uri) {
            setURI(uri);
        }

        public String getMethod() {
            return METHOD_NAME;
        }
    }

    public HttpClientStack(HttpClient httpClient) {
        this.f2186 = httpClient;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static HttpUriRequest m1676(Request<?> request, Map<String, String> map) throws AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    HttpPost httpPost = new HttpPost(request.getUrl());
                    httpPost.addHeader("Content-Type", request.getPostBodyContentType());
                    httpPost.setEntity(new ByteArrayEntity(postBody));
                    return httpPost;
                }
                return new HttpGet(request.getUrl());
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.getUrl());
                httpPost2.addHeader("Content-Type", request.getBodyContentType());
                m1677((HttpEntityEnclosingRequestBase) httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.getUrl());
                httpPut.addHeader("Content-Type", request.getBodyContentType());
                m1677((HttpEntityEnclosingRequestBase) httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.getUrl());
            case 4:
                return new HttpHead(request.getUrl());
            case 5:
                return new HttpOptions(request.getUrl());
            case 6:
                return new HttpTrace(request.getUrl());
            case 7:
                HttpPatch httpPatch = new HttpPatch(request.getUrl());
                httpPatch.addHeader("Content-Type", request.getBodyContentType());
                m1677(httpPatch, request);
                return httpPatch;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1677(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static void m1678(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // com.mopub.volley.toolbox.HttpStack
    public org.apache.http.HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest m1676 = m1676(request, map);
        m1678(m1676, map);
        m1678(m1676, request.getHeaders());
        m1679(m1676);
        HttpParams params = m1676.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return this.f2186.execute(m1676);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m1679(HttpUriRequest httpUriRequest) throws IOException {
    }
}
