package com.google.android.gms.internal;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzaoq extends zzaos {
    public zzaoq(zzanh zzanhVar, boolean z) {
        super(zzanhVar, z);
    }

    @Override // com.google.android.gms.internal.zzani, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
