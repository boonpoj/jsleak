package com.integralads.avid.library.mopub;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.integralads.avid.library.mopub.registration.AvidAdSessionRegistry;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
/* loaded from: assets/classes2.dex */
public class AvidStateWatcher {
    public static final String CONTEXT_AVID_AD_SESSION_ID = "avidAdSessionId";
    public static final String CONTEXT_AVID_LIBRARY_VERSION = "avidLibraryVersion";
    public static final String CONTEXT_BUNDLE_IDENTIFIER = "bundleIdentifier";
    public static final String CONTEXT_PARTNER = "partner";
    public static final String CONTEXT_PARTNER_VERSION = "partnerVersion";

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static AvidStateWatcher f16 = new AvidStateWatcher();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Context f17;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private BroadcastReceiver f18;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f19;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f20;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private AvidStateWatcherListener f21;

    /* loaded from: assets/classes2.dex */
    public interface AvidStateWatcherListener {
        void onAppStateChanged(boolean z);
    }

    public static AvidStateWatcher getInstance() {
        return f16;
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    private void m18() {
        this.f18 = new BroadcastReceiver() { // from class: com.integralads.avid.library.mopub.AvidStateWatcher.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    AvidStateWatcher.this.m20(true);
                } else if (!"android.intent.action.USER_PRESENT".equals(intent.getAction()) && (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode())) {
                } else {
                    AvidStateWatcher.this.m20(false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f17.registerReceiver(this.f18, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m20(boolean z) {
        if (this.f20 != z) {
            this.f20 = z;
            if (this.f19) {
                m22();
                if (this.f21 != null) {
                    this.f21.onAppStateChanged(isActive());
                }
            }
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    private void m21() {
        if (this.f17 == null || this.f18 == null) {
            return;
        }
        this.f17.unregisterReceiver(this.f18);
        this.f18 = null;
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    private void m22() {
        boolean z = !this.f20;
        for (InternalAvidAdSession internalAvidAdSession : AvidAdSessionRegistry.getInstance().getInternalAvidAdSessions()) {
            internalAvidAdSession.setScreenMode(z);
        }
    }

    public AvidStateWatcherListener getStateWatcherListener() {
        return this.f21;
    }

    public void init(Context context) {
        m21();
        this.f17 = context;
        m18();
    }

    public boolean isActive() {
        return !this.f20;
    }

    public void setStateWatcherListener(AvidStateWatcherListener avidStateWatcherListener) {
        this.f21 = avidStateWatcherListener;
    }

    public void start() {
        this.f19 = true;
        m22();
    }

    public void stop() {
        m21();
        this.f17 = null;
        this.f19 = false;
        this.f20 = false;
        this.f21 = null;
    }
}
