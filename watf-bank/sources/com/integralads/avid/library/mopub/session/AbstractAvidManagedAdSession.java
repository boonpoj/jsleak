package com.integralads.avid.library.mopub.session;

import android.view.View;
import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.session.internal.InternalAvidManagedAdSession;
/* loaded from: assets/classes2.dex */
public abstract class AbstractAvidManagedAdSession extends AbstractAvidAdSession<View> {
    public void injectJavaScriptResource(String str) {
        InternalAvidManagedAdSession internalAvidManagedAdSession = (InternalAvidManagedAdSession) AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId());
        if (internalAvidManagedAdSession != null) {
            internalAvidManagedAdSession.getJavaScriptResourceInjector().injectJavaScriptResource(str);
        }
    }
}
