package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.video.AvidVideoPlaybackListenerImpl;
/* loaded from: assets/classes2.dex */
public class InternalAvidManagedVideoAdSession extends InternalAvidManagedAdSession {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private AvidVideoPlaybackListenerImpl f68;

    public InternalAvidManagedVideoAdSession(Context context, String str, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, str, externalAvidAdSessionContext);
        this.f68 = new AvidVideoPlaybackListenerImpl(this, getAvidBridgeManager());
    }

    public AvidVideoPlaybackListenerImpl getAvidVideoPlaybackListener() {
        return this.f68;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public MediaType getMediaType() {
        return MediaType.VIDEO;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public SessionType getSessionType() {
        return SessionType.MANAGED_VIDEO;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession
    public void onEnd() {
        this.f68.destroy();
        super.onEnd();
    }
}
