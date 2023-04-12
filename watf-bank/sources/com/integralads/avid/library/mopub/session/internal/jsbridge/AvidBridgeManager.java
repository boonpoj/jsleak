package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.text.TextUtils;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.AvidBridge;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.utils.AvidCommand;
import com.integralads.avid.library.mopub.weakreference.AvidWebView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: assets/classes2.dex */
public class AvidBridgeManager {
    public static final int VIDEO_EVENT_TAG = 1;

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final InternalAvidAdSessionContext f74;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private boolean f75;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f77;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private AvidBridgeManagerListener f78;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private final ArrayList<AvidEvent> f79 = new ArrayList<>();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AvidWebView f76 = new AvidWebView(null);

    /* loaded from: assets/classes2.dex */
    public interface AvidBridgeManagerListener {
        void avidBridgeManagerDidInjectAvidJs();
    }

    public AvidBridgeManager(InternalAvidAdSessionContext internalAvidAdSessionContext) {
        this.f74 = internalAvidAdSessionContext;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m54() {
        if (this.f76.isEmpty()) {
            return;
        }
        this.f75 = true;
        this.f76.injectJavaScript(AvidBridge.getAvidJs());
        m57();
        m56();
        m59();
        m58();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m55(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        callAvidbridge(!TextUtils.isEmpty(jSONObject2) ? AvidCommand.publishVideoEvent(str, jSONObject2) : AvidCommand.publishVideoEvent(str));
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m56() {
        if (isActive() && this.f77) {
            callAvidbridge(AvidCommand.publishReadyEventForDeferredAdSession());
        }
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m57() {
        callAvidbridge(AvidCommand.setAvidAdSessionContext(this.f74.getFullContext().toString()));
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    private void m58() {
        if (this.f78 != null) {
            this.f78.avidBridgeManagerDidInjectAvidJs();
        }
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m59() {
        Iterator<AvidEvent> it = this.f79.iterator();
        while (it.hasNext()) {
            AvidEvent next = it.next();
            m55(next.getType(), next.getData());
        }
        this.f79.clear();
    }

    public void callAvidbridge(String str) {
        this.f76.injectFormattedJavaScript(str);
    }

    public void destroy() {
        setWebView(null);
    }

    public boolean isActive() {
        return this.f75;
    }

    public void onAvidJsReady() {
        m54();
    }

    public void publishAppState(String str) {
        callAvidbridge(AvidCommand.setAppState(str));
    }

    public void publishNativeViewState(String str) {
        callAvidbridge(AvidCommand.setNativeViewState(str));
    }

    public void publishReadyEventForDeferredAdSession() {
        this.f77 = true;
        m56();
    }

    public void publishVideoEvent(String str, JSONObject jSONObject) {
        if (isActive()) {
            m55(str, jSONObject);
        } else {
            this.f79.add(new AvidEvent(1, str, jSONObject));
        }
    }

    public void setListener(AvidBridgeManagerListener avidBridgeManagerListener) {
        this.f78 = avidBridgeManagerListener;
    }

    public void setWebView(WebView webView) {
        if (this.f76.get() == webView) {
            return;
        }
        this.f76.set(webView);
        this.f75 = false;
        if (AvidBridge.isAvidJsReady()) {
            m54();
        }
    }
}
