package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidJavaScriptResourceInjector;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidTrackingWebViewManager;
/* loaded from: assets/classes2.dex */
public abstract class InternalAvidManagedAdSession extends InternalAvidAdSession<View> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AvidTrackingWebViewManager f66;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final WebView f67;

    public InternalAvidManagedAdSession(Context context, String str, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, str, externalAvidAdSessionContext);
        this.f67 = new WebView(context.getApplicationContext());
        this.f66 = new AvidTrackingWebViewManager(this.f67);
    }

    public AvidJavaScriptResourceInjector getJavaScriptResourceInjector() {
        return this.f66;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public WebView getWebView() {
        return this.f67;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public void onStart() {
        super.onStart();
        m52();
        this.f66.loadHTML();
    }
}
