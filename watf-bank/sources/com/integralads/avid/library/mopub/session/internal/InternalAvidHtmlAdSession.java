package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
/* loaded from: assets/classes2.dex */
public abstract class InternalAvidHtmlAdSession extends InternalAvidAdSession<WebView> {
    public InternalAvidHtmlAdSession(Context context, String str, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, str, externalAvidAdSessionContext);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public WebView getWebView() {
        return getView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    /* renamed from: ࢢ */
    public void mo50() {
        super.mo50();
        m52();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    /* renamed from: ࢣ */
    public void mo51() {
        super.mo51();
        m52();
    }
}
