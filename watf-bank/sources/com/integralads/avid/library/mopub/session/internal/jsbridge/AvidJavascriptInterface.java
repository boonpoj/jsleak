package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
/* loaded from: assets/classes2.dex */
public class AvidJavascriptInterface {
    public static final String AVID_OBJECT = "avid";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InternalAvidAdSessionContext f83;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Handler f84 = new Handler();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AvidJavascriptInterfaceCallback f85;

    /* loaded from: assets/classes2.dex */
    public interface AvidJavascriptInterfaceCallback {
        void onAvidAdSessionContextInvoked();
    }

    /* renamed from: com.integralads.avid.library.mopub.session.internal.jsbridge.AvidJavascriptInterface$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    class RunnableC0083 implements Runnable {
        RunnableC0083() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AvidJavascriptInterface.this.f85 != null) {
                AvidJavascriptInterface.this.f85.onAvidAdSessionContextInvoked();
                AvidJavascriptInterface.this.f85 = null;
            }
        }
    }

    public AvidJavascriptInterface(InternalAvidAdSessionContext internalAvidAdSessionContext) {
        this.f83 = internalAvidAdSessionContext;
    }

    @JavascriptInterface
    public String getAvidAdSessionContext() {
        this.f84.post(new RunnableC0083());
        return this.f83.getStubContext().toString();
    }

    public AvidJavascriptInterfaceCallback getCallback() {
        return this.f85;
    }

    public void setCallback(AvidJavascriptInterfaceCallback avidJavascriptInterfaceCallback) {
        this.f85 = avidJavascriptInterfaceCallback;
    }
}
