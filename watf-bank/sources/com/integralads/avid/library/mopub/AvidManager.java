package com.integralads.avid.library.mopub;

import android.app.Activity;
import android.content.Context;
import com.integralads.avid.library.mopub.AvidLoader;
import com.integralads.avid.library.mopub.AvidStateWatcher;
import com.integralads.avid.library.mopub.activity.AvidActivityStack;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistryListener;
import com.integralads.avid.library.mopub.session.AbstractAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
/* loaded from: assets/classes2.dex */
public class AvidManager implements AvidLoader.AvidLoaderListener, AvidStateWatcher.AvidStateWatcherListener, AvidAdSessionRegistryListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AvidManager f14 = new AvidManager();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static Context f15;

    public static AvidManager getInstance() {
        return f14;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m14() {
        AvidStateWatcher.getInstance().setStateWatcherListener(this);
        AvidStateWatcher.getInstance().start();
        if (AvidStateWatcher.getInstance().isActive()) {
            AvidTreeWalker.getInstance().start();
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m15() {
        AvidActivityStack.getInstance().cleanup();
        AvidTreeWalker.getInstance().stop();
        AvidStateWatcher.getInstance().stop();
        AvidLoader.getInstance().unregisterAvidLoader();
        f15 = null;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private boolean m16() {
        return !AvidAdSessionRegistry.getInstance().isEmpty();
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m17() {
        AvidAdSessionRegistry.getInstance().setListener(null);
        for (InternalAvidAdSession internalAvidAdSession : AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions()) {
            internalAvidAdSession.getAvidBridgeManager().onAvidJsReady();
        }
        AvidAdSessionRegistry.getInstance().setListener(this);
    }

    public AbstractAvidAdSession findAvidAdSessionById(String str) {
        return AvidAdSessionRegistry.getInstance().findAvidAdSessionById(str);
    }

    public InternalAvidAdSession findInternalAvidAdSessionById(String str) {
        return AvidAdSessionRegistry.getInstance().findInternalAvidAdSessionById(str);
    }

    public void init(Context context) {
        if (f15 == null) {
            f15 = context.getApplicationContext();
            AvidStateWatcher.getInstance().init(f15);
            AvidAdSessionRegistry.getInstance().setListener(this);
            AvidJSONUtil.init(f15);
        }
    }

    @Override // com.integralads.avid.library.mopub.AvidStateWatcher.AvidStateWatcherListener
    public void onAppStateChanged(boolean z) {
        if (z) {
            AvidTreeWalker.getInstance().start();
        } else {
            AvidTreeWalker.getInstance().pause();
        }
    }

    @Override // com.integralads.avid.library.mopub.AvidLoader.AvidLoaderListener
    public void onAvidLoaded() {
        if (m16()) {
            m17();
            if (AvidAdSessionRegistry.getInstance().hasActiveSessions()) {
                m14();
            }
        }
    }

    public void registerActivity(Activity activity) {
        AvidActivityStack.getInstance().addActivity(activity);
    }

    public void registerAvidAdSession(AbstractAvidAdSession abstractAvidAdSession, InternalAvidAdSession internalAvidAdSession) {
        AvidAdSessionRegistry.getInstance().registerAvidAdSession(abstractAvidAdSession, internalAvidAdSession);
    }

    @Override // com.integralads.avid.library.mopub.registration.AvidAdSessionRegistryListener
    public void registryHasActiveSessionsChanged(AvidAdSessionRegistry avidAdSessionRegistry) {
        if (avidAdSessionRegistry.hasActiveSessions() && AvidBridge.isAvidJsReady()) {
            m14();
        } else {
            m15();
        }
    }

    @Override // com.integralads.avid.library.mopub.registration.AvidAdSessionRegistryListener
    public void registryHasSessionsChanged(AvidAdSessionRegistry avidAdSessionRegistry) {
        if (avidAdSessionRegistry.isEmpty() || AvidBridge.isAvidJsReady()) {
            return;
        }
        AvidLoader.getInstance().setListener(this);
        AvidLoader.getInstance().registerAvidLoader(f15);
    }
}
