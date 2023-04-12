package com.mopub.volley.toolbox;

import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import java.io.IOException;
import java.util.Map;
@Deprecated
/* loaded from: assets/classes2.dex */
public interface HttpStack {
    org.apache.http.HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
