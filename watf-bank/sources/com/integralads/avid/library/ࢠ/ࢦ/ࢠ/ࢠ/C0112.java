package com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.integralads.avid.library.ࢠ.ࢦ.ࢠ.C0116;
/* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0112 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private final C0116 f192;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Handler f193 = new Handler();

    /* renamed from: ࢣ  reason: contains not printable characters */
    private InterfaceC0113 f194;

    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.ࢣ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0113 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void mo227();
    }

    /* renamed from: com.integralads.avid.library.ࢠ.ࢦ.ࢠ.ࢠ.ࢣ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    class RunnableC0114 implements Runnable {
        RunnableC0114() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0112.this.f194 != null) {
                C0112.this.f194.mo227();
                C0112.this.f194 = null;
            }
        }
    }

    public C0112(C0116 c0116) {
        this.f192 = c0116;
    }

    @JavascriptInterface
    public String getAvidAdSessionContext() {
        this.f193.post(new RunnableC0114());
        return this.f192.m233().toString();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m226(InterfaceC0113 interfaceC0113) {
        this.f194 = interfaceC0113;
    }
}
