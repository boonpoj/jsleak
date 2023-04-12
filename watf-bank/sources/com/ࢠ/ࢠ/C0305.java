package com.ࢠ.ࢠ;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
/* renamed from: com.ࢠ.ࢠ.ހ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0305 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static volatile C0305 f2257;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private HandlerThread f2259;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Handler f2260;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private BroadcastReceiver f2258 = new BroadcastReceiver() { // from class: com.ࢠ.ࢠ.ހ.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler;
            Runnable runnable;
            String action = intent.getAction();
            long j = 3000;
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                C0305.this.m1744();
                if (!C0338.m1885().m1888()) {
                    return;
                }
                handler = C0305.this.f2260;
                runnable = C0305.this.f2262;
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C0305.this.m1744();
                handler = C0305.this.f2260;
                runnable = C0305.this.f2261;
            } else if ("Ne0hGmDkkivy0aYpZYm".equals(action)) {
                C0305.this.m1744();
                handler = C0305.this.f2260;
                runnable = C0305.this.f2263;
                j = 90000;
            } else if (!"PzLLQeMlZSxOpi".equals(action)) {
                if ("QUBU0tfNU5f0xFQQQ".equals(action)) {
                    C0305.this.m1744();
                    return;
                }
                return;
            } else {
                C0305.this.m1744();
                handler = C0305.this.f2260;
                runnable = C0305.this.f2263;
                j = 300000;
            }
            handler.postDelayed(runnable, j);
        }
    };

    /* renamed from: ࢥ  reason: contains not printable characters */
    private Runnable f2261 = new Runnable() { // from class: com.ࢠ.ࢠ.ހ.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };

    /* renamed from: ࢦ  reason: contains not printable characters */
    private Runnable f2262 = new Runnable() { // from class: com.ࢠ.ࢠ.ހ.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                C0303.m1719(C0337.m1878(), 1);
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: ࢧ  reason: contains not printable characters */
    private Runnable f2263 = new Runnable() { // from class: com.ࢠ.ࢠ.ހ.4
        @Override // java.lang.Runnable
        public void run() {
            C0303.m1719(C0337.m1878(), 2);
        }
    };

    private C0305(Context context) {
        this.f2259 = null;
        this.f2260 = null;
        this.f2259 = new HandlerThread("sch-thread");
        this.f2259.start();
        this.f2260 = new Handler(this.f2259.getLooper());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("Ne0hGmDkkivy0aYpZYm");
        intentFilter.addAction("PzLLQeMlZSxOpi");
        intentFilter.addAction("QUBU0tfNU5f0xFQQQ");
        context.getApplicationContext().registerReceiver(this.f2258, intentFilter);
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0305 m1741() {
        if (f2257 == null) {
            synchronized (C0305.class) {
                if (f2257 == null) {
                    f2257 = new C0305(C0337.m1878());
                }
            }
        }
        return f2257;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m1744() {
        this.f2260.removeCallbacks(this.f2262);
        this.f2260.removeCallbacks(this.f2263);
        this.f2260.removeCallbacks(this.f2261);
    }
}
