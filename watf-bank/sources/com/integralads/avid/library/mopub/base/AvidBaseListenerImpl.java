package com.integralads.avid.library.mopub.base;

import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
/* loaded from: assets/classes2.dex */
public abstract class AvidBaseListenerImpl {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private InternalAvidAdSession f36;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AvidBridgeManager f37;

    public AvidBaseListenerImpl(InternalAvidAdSession internalAvidAdSession, AvidBridgeManager avidBridgeManager) {
        this.f36 = internalAvidAdSession;
        this.f37 = avidBridgeManager;
    }

    public void destroy() {
        this.f36 = null;
        this.f37 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public InternalAvidAdSession m41() {
        return this.f36;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public AvidBridgeManager m42() {
        return this.f37;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m43() {
        if (this.f36 == null) {
            throw new IllegalStateException("The AVID ad session is ended. Please ensure you are not recording events after the session has ended.");
        }
    }
}
