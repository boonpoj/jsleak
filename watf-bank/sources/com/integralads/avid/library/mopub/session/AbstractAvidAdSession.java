package com.integralads.avid.library.mopub.session;

import android.app.Activity;
import android.view.View;
import com.integralads.avid.library.mopub.AvidManager;
import com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import java.util.UUID;
/* loaded from: assets/classes2.dex */
public abstract class AbstractAvidAdSession<T extends View> {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private String f47 = UUID.randomUUID().toString();

    public void endSession() {
        InternalAvidAdSession findInternalAvidAdSessionById = AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId());
        if (findInternalAvidAdSessionById != null) {
            findInternalAvidAdSessionById.onEnd();
        }
    }

    public String getAvidAdSessionId() {
        return this.f47;
    }

    public AvidDeferredAdSessionListener getAvidDeferredAdSessionListener() {
        InternalAvidAdSession findInternalAvidAdSessionById = AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId());
        AvidDeferredAdSessionListener avidDeferredAdSessionListener = findInternalAvidAdSessionById != null ? findInternalAvidAdSessionById.getAvidDeferredAdSessionListener() : null;
        if (avidDeferredAdSessionListener != null) {
            return avidDeferredAdSessionListener;
        }
        throw new IllegalStateException("The AVID ad session is not deferred. Please ensure you are only using AvidDeferredAdSessionListener for deferred AVID ad session.");
    }

    public void registerAdView(T t, Activity activity) {
        InternalAvidAdSession findInternalAvidAdSessionById = AvidManager.getInstance().findInternalAvidAdSessionById(this.f47);
        if (findInternalAvidAdSessionById != null) {
            findInternalAvidAdSessionById.registerAdView(t);
        }
        AvidManager.getInstance().registerActivity(activity);
    }

    public void registerFriendlyObstruction(View view) {
        InternalAvidAdSession findInternalAvidAdSessionById = AvidManager.getInstance().findInternalAvidAdSessionById(getAvidAdSessionId());
        if (findInternalAvidAdSessionById != null) {
            findInternalAvidAdSessionById.getObstructionsWhiteList().add(view);
        }
    }

    public void unregisterAdView(T t) {
        InternalAvidAdSession findInternalAvidAdSessionById = AvidManager.getInstance().findInternalAvidAdSessionById(this.f47);
        if (findInternalAvidAdSessionById != null) {
            findInternalAvidAdSessionById.unregisterAdView(t);
        }
    }
}
