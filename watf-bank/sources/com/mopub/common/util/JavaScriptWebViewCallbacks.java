package com.mopub.common.util;
/* loaded from: assets/classes2.dex */
public enum JavaScriptWebViewCallbacks {
    WEB_VIEW_DID_APPEAR("webviewDidAppear();"),
    WEB_VIEW_DID_CLOSE("webviewDidClose();");
    

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f623;

    JavaScriptWebViewCallbacks(String str) {
        this.f623 = str;
    }

    public String getJavascript() {
        return this.f623;
    }

    public String getUrl() {
        return "javascript:" + this.f623;
    }
}
