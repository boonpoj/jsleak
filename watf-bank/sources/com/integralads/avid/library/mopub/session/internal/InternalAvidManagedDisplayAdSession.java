package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
/* loaded from: assets/classes2.dex */
public class InternalAvidManagedDisplayAdSession extends InternalAvidManagedAdSession {
    public InternalAvidManagedDisplayAdSession(Context context, String str, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, str, externalAvidAdSessionContext);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public MediaType getMediaType() {
        return MediaType.DISPLAY;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public SessionType getSessionType() {
        return SessionType.MANAGED_DISPLAY;
    }
}
