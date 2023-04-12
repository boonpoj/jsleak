package com.integralads.avid.library.mopub.deferred;

import com.integralads.avid.library.mopub.base.AvidBaseListenerImpl;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
/* loaded from: assets/classes2.dex */
public class AvidDeferredAdSessionListenerImpl extends AvidBaseListenerImpl implements AvidDeferredAdSessionListener {
    public AvidDeferredAdSessionListenerImpl(InternalAvidAdSession internalAvidAdSession, AvidBridgeManager avidBridgeManager) {
        super(internalAvidAdSession, avidBridgeManager);
    }

    @Override // com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListener
    public void recordReadyEvent() {
        m43();
        if (m41().isReady()) {
            throw new IllegalStateException("The AVID ad session is already ready. Please ensure you are only calling recordReadyEvent once for the deferred AVID ad session.");
        }
        m42().publishReadyEventForDeferredAdSession();
        m41().onReady();
    }
}
