package com.integralads.avid.library.mopub.registration;

import android.view.View;
import com.integralads.avid.library.mopub.session.AbstractAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionListener;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: assets/classes2.dex */
public class AvidAdSessionRegistry implements InternalAvidAdSessionListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AvidAdSessionRegistry f42 = new AvidAdSessionRegistry();

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AvidAdSessionRegistryListener f45;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final HashMap<String, InternalAvidAdSession> f43 = new HashMap<>();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final HashMap<String, AbstractAvidAdSession> f44 = new HashMap<>();

    /* renamed from: ࢥ  reason: contains not printable characters */
    private int f46 = 0;

    public static AvidAdSessionRegistry getInstance() {
        return f42;
    }

    public AbstractAvidAdSession findAvidAdSessionById(String str) {
        return this.f44.get(str);
    }

    public InternalAvidAdSession findInternalAvidAdSessionById(String str) {
        return this.f43.get(str);
    }

    public InternalAvidAdSession findInternalAvidAdSessionByView(View view) {
        for (InternalAvidAdSession internalAvidAdSession : this.f43.values()) {
            if (internalAvidAdSession.doesManageView(view)) {
                return internalAvidAdSession;
            }
        }
        return null;
    }

    public Collection<AbstractAvidAdSession> getAvidAdSessions() {
        return this.f44.values();
    }

    public Collection<InternalAvidAdSession> getInternalAvidAdSessions() {
        return this.f43.values();
    }

    public AvidAdSessionRegistryListener getListener() {
        return this.f45;
    }

    public boolean hasActiveSessions() {
        return this.f46 > 0;
    }

    public boolean isEmpty() {
        return this.f44.isEmpty();
    }

    public void registerAvidAdSession(AbstractAvidAdSession abstractAvidAdSession, InternalAvidAdSession internalAvidAdSession) {
        this.f44.put(abstractAvidAdSession.getAvidAdSessionId(), abstractAvidAdSession);
        this.f43.put(abstractAvidAdSession.getAvidAdSessionId(), internalAvidAdSession);
        internalAvidAdSession.setListener(this);
        if (this.f44.size() != 1 || this.f45 == null) {
            return;
        }
        this.f45.registryHasSessionsChanged(this);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionListener
    public void sessionDidEnd(InternalAvidAdSession internalAvidAdSession) {
        this.f44.remove(internalAvidAdSession.getAvidAdSessionId());
        this.f43.remove(internalAvidAdSession.getAvidAdSessionId());
        internalAvidAdSession.setListener(null);
        if (this.f44.size() != 0 || this.f45 == null) {
            return;
        }
        this.f45.registryHasSessionsChanged(this);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionListener
    public void sessionHasBecomeActive(InternalAvidAdSession internalAvidAdSession) {
        this.f46++;
        if (this.f46 != 1 || this.f45 == null) {
            return;
        }
        this.f45.registryHasActiveSessionsChanged(this);
    }

    @Override // com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionListener
    public void sessionHasResignedActive(InternalAvidAdSession internalAvidAdSession) {
        this.f46--;
        if (this.f46 != 0 || this.f45 == null) {
            return;
        }
        this.f45.registryHasActiveSessionsChanged(this);
    }

    public void setListener(AvidAdSessionRegistryListener avidAdSessionRegistryListener) {
        this.f45 = avidAdSessionRegistryListener;
    }
}
