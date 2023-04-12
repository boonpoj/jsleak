package com.integralads.avid.library.ࢠ;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.integralads.avid.library.ࢠ.ࢥ.C0101;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.AbstractC0107;
/* renamed from: com.integralads.avid.library.ࢠ.ࢥ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0100 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0100 f145 = new C0100();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private Context f146;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private BroadcastReceiver f147;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private boolean f148;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private boolean f149;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private InterfaceC0102 f150;

    /* renamed from: com.integralads.avid.library.ࢠ.ࢥ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0102 {
        /* renamed from: ࢠ */
        void mo127(boolean z);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0100 m135() {
        return f145;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m137(boolean z) {
        if (this.f149 != z) {
            this.f149 = z;
            if (this.f148) {
                m140();
                if (this.f150 != null) {
                    this.f150.mo127(m145());
                }
            }
        }
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    private void m138() {
        this.f147 = new BroadcastReceiver() { // from class: com.integralads.avid.library.ࢠ.ࢥ.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    C0100.this.m137(true);
                } else if (!"android.intent.action.USER_PRESENT".equals(intent.getAction()) && (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode())) {
                } else {
                    C0100.this.m137(false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f146.registerReceiver(this.f147, intentFilter);
    }

    /* renamed from: ࢦ  reason: contains not printable characters */
    private void m139() {
        if (this.f146 == null || this.f147 == null) {
            return;
        }
        this.f146.unregisterReceiver(this.f147);
        this.f147 = null;
    }

    /* renamed from: ࢧ  reason: contains not printable characters */
    private void m140() {
        boolean z = !this.f149;
        for (AbstractC0107 abstractC0107 : C0101.m146().m151()) {
            abstractC0107.m191(z);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m141(Context context) {
        m139();
        this.f146 = context;
        m138();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m142(InterfaceC0102 interfaceC0102) {
        this.f150 = interfaceC0102;
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m143() {
        this.f148 = true;
        m140();
    }

    /* renamed from: ࢣ  reason: contains not printable characters */
    public void m144() {
        m139();
        this.f146 = null;
        this.f148 = false;
        this.f149 = false;
        this.f150 = null;
    }

    /* renamed from: ࢤ  reason: contains not printable characters */
    public boolean m145() {
        return !this.f149;
    }
}
