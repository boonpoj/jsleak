package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.AvidBridge;
import com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListener;
import com.integralads.avid.library.mopub.deferred.AvidDeferredAdSessionListenerImpl;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidWebViewManager;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import com.integralads.avid.library.mopub.utils.AvidTimestamp;
import com.integralads.avid.library.mopub.weakreference.AvidView;
/* loaded from: assets/classes2.dex */
public abstract class InternalAvidAdSession<T extends View> implements AvidBridgeManager.AvidBridgeManagerListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InternalAvidAdSessionContext f50;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private AvidBridgeManager f51;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AvidWebViewManager f52;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private AvidView<T> f53;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private AvidDeferredAdSessionListenerImpl f54;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private InternalAvidAdSessionListener f55;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private boolean f56;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private boolean f57;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final ObstructionsWhiteList f58;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private EnumC0082 f59;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private double f60;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public enum EnumC0082 {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_HIDDEN
    }

    public InternalAvidAdSession(Context context, String str, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        this.f50 = new InternalAvidAdSessionContext(context, str, getSessionType().toString(), getMediaType().toString(), externalAvidAdSessionContext);
        this.f51 = new AvidBridgeManager(this.f50);
        this.f51.setListener(this);
        this.f52 = new AvidWebViewManager(this.f50, this.f51);
        this.f53 = new AvidView<>(null);
        this.f56 = !externalAvidAdSessionContext.isDeferred();
        if (!this.f56) {
            this.f54 = new AvidDeferredAdSessionListenerImpl(this, this.f51);
        }
        this.f58 = new ObstructionsWhiteList();
        m47();
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m47() {
        this.f60 = AvidTimestamp.getCurrentTime();
        this.f59 = EnumC0082.AD_STATE_IDLE;
    }

    @Override // com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager.AvidBridgeManagerListener
    public void avidBridgeManagerDidInjectAvidJs() {
        m53();
    }

    public boolean doesManageView(View view) {
        return this.f53.contains(view);
    }

    public ExternalAvidAdSessionContext getAvidAdSessionContext() {
        return this.f50.getAvidAdSessionContext();
    }

    public String getAvidAdSessionId() {
        return this.f50.getAvidAdSessionId();
    }

    public AvidBridgeManager getAvidBridgeManager() {
        return this.f51;
    }

    public AvidDeferredAdSessionListener getAvidDeferredAdSessionListener() {
        return this.f54;
    }

    public InternalAvidAdSessionListener getListener() {
        return this.f55;
    }

    public abstract MediaType getMediaType();

    public ObstructionsWhiteList getObstructionsWhiteList() {
        return this.f58;
    }

    public abstract SessionType getSessionType();

    public T getView() {
        return (T) this.f53.get();
    }

    public abstract WebView getWebView();

    public boolean isActive() {
        return this.f57;
    }

    public boolean isEmpty() {
        return this.f53.isEmpty();
    }

    public boolean isReady() {
        return this.f56;
    }

    public void onEnd() {
        m48();
        if (this.f54 != null) {
            this.f54.destroy();
        }
        this.f51.destroy();
        this.f52.destroy();
        this.f56 = false;
        m53();
        if (this.f55 != null) {
            this.f55.sessionDidEnd(this);
        }
    }

    public void onReady() {
        this.f56 = true;
        m53();
    }

    public void onStart() {
    }

    public void publishEmptyNativeViewStateCommand(String str, double d) {
        if (d <= this.f60 || this.f59 == EnumC0082.AD_STATE_HIDDEN) {
            return;
        }
        this.f51.callAvidbridge(str);
        this.f59 = EnumC0082.AD_STATE_HIDDEN;
    }

    public void publishNativeViewStateCommand(String str, double d) {
        if (d > this.f60) {
            this.f51.callAvidbridge(str);
            this.f59 = EnumC0082.AD_STATE_VISIBLE;
        }
    }

    public void registerAdView(T t) {
        if (doesManageView(t)) {
            return;
        }
        m47();
        this.f53.set(t);
        mo50();
        m53();
    }

    public void setListener(InternalAvidAdSessionListener internalAvidAdSessionListener) {
        this.f55 = internalAvidAdSessionListener;
    }

    public void setScreenMode(boolean z) {
        if (isActive()) {
            this.f51.publishAppState(z ? AvidBridge.APP_STATE_ACTIVE : AvidBridge.APP_STATE_INACTIVE);
        }
    }

    public void unregisterAdView(T t) {
        if (doesManageView(t)) {
            m47();
            m48();
            this.f53.set(null);
            mo51();
            m53();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m48() {
        if (isActive()) {
            this.f51.publishNativeViewState(AvidJSONUtil.getEmptyTreeJSONObject().toString());
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected void m49(boolean z) {
        this.f57 = z;
        if (this.f55 != null) {
            if (z) {
                this.f55.sessionHasBecomeActive(this);
            } else {
                this.f55.sessionHasResignedActive(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void mo50() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void mo51() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m52() {
        this.f52.setWebView(getWebView());
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    protected void m53() {
        boolean z = this.f51.isActive() && this.f56 && !isEmpty();
        if (this.f57 != z) {
            m49(z);
        }
    }
}
