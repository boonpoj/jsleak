package com.mopub.mraid;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.resource.MraidJavascript;
import java.io.ByteArrayInputStream;
import java.util.Locale;
/* loaded from: assets/classes2.dex */
public class MraidWebViewClient extends WebViewClient {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static final String f1390 = "javascript:" + MraidJavascript.JAVASCRIPT_SOURCE;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private WebResourceResponse m1232() {
        return new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(f1390.getBytes()));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(@NonNull WebView webView, @NonNull String str) {
        return m1233(str) ? m1232() : super.shouldInterceptRequest(webView, str);
    }

    @VisibleForTesting
    /* renamed from: ࢠ  reason: contains not printable characters */
    boolean m1233(@NonNull String str) {
        return "mraid.js".equals(Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment());
    }
}
