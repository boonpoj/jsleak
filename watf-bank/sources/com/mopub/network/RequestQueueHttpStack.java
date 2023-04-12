package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HttpResponse;
import com.mopub.volley.toolbox.HurlStack;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: assets/classes2.dex */
public class RequestQueueHttpStack extends HurlStack {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final String f2083;

    public RequestQueueHttpStack(@NonNull String str) {
        this(str, null);
    }

    public RequestQueueHttpStack(@NonNull String str, @Nullable HurlStack.UrlRewriter urlRewriter) {
        this(str, urlRewriter, null);
    }

    public RequestQueueHttpStack(@NonNull String str, @Nullable HurlStack.UrlRewriter urlRewriter, @Nullable SSLSocketFactory sSLSocketFactory) {
        super(urlRewriter, sSLSocketFactory);
        this.f2083 = str;
    }

    @Override // com.mopub.volley.toolbox.HurlStack, com.mopub.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(@NonNull Request<?> request, @Nullable Map<String, String> map) throws IOException, AuthFailureError {
        if (map == null || map.isEmpty()) {
            map = new TreeMap<>();
        }
        map.put(ResponseHeader.USER_AGENT.getKey(), this.f2083);
        return super.executeRequest(request, map);
    }
}
