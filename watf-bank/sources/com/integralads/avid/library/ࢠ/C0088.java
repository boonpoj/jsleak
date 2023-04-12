package com.integralads.avid.library.ࢠ;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.integralads.avid.library.ࢠ.AsyncTaskC0137;
import com.integralads.avid.library.ࢠ.ࢧ.C0144;
/* renamed from: com.integralads.avid.library.ࢠ.ࢣ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public class C0088 implements AsyncTaskC0137.InterfaceC0139 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static C0088 f128 = new C0088();

    /* renamed from: ࢢ  reason: contains not printable characters */
    private InterfaceC0090 f129;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private AsyncTaskC0137 f130;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private Context f131;

    /* renamed from: ࢦ  reason: contains not printable characters */
    private C0093 f133;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private C0092 f132 = new C0092();

    /* renamed from: ࢧ  reason: contains not printable characters */
    private final Runnable f134 = new Runnable() { // from class: com.integralads.avid.library.ࢠ.ࢣ.1
        @Override // java.lang.Runnable
        public void run() {
            if (C0088.this.f131 == null || !C0144.m280(C0088.this.f131)) {
                C0088.this.m106();
            } else {
                C0088.this.m104();
            }
        }
    };

    /* renamed from: com.integralads.avid.library.ࢠ.ࢣ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public interface InterfaceC0090 {
        /* renamed from: ࢠ  reason: contains not printable characters */
        void mo113();
    }

    /* renamed from: com.integralads.avid.library.ࢠ.ࢣ$ࢢ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0092 {
        public C0092() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m114(AsyncTaskC0137 asyncTaskC0137) {
            if (Build.VERSION.SDK_INT >= 11) {
                C0088.this.f130.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://mobile-static.adsafeprotected.com/avid-v2.js");
            } else {
                C0088.this.f130.execute("https://mobile-static.adsafeprotected.com/avid-v2.js");
            }
        }
    }

    /* renamed from: com.integralads.avid.library.ࢠ.ࢣ$ࢣ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public class C0093 {

        /* renamed from: ࢢ  reason: contains not printable characters */
        private Handler f138 = new Handler();

        public C0093() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        public void m115() {
            this.f138.postDelayed(C0088.this.f134, 2000L);
        }

        /* renamed from: ࢢ  reason: contains not printable characters */
        public void m116() {
            this.f138.removeCallbacks(C0088.this.f134);
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public static C0088 m100() {
        return f128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public void m104() {
        if (C0084.m82() || this.f130 != null) {
            return;
        }
        this.f130 = new AsyncTaskC0137();
        this.f130.m251(this);
        this.f132.m114(this.f130);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ࢥ  reason: contains not printable characters */
    public void m106() {
        if (this.f133 != null) {
            this.f133.m115();
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m108(Context context) {
        this.f131 = context;
        this.f133 = new C0093();
        m104();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m109(InterfaceC0090 interfaceC0090) {
        this.f129 = interfaceC0090;
    }

    @Override // com.integralads.avid.library.ࢠ.AsyncTaskC0137.InterfaceC0139
    /* renamed from: ࢠ  reason: contains not printable characters */
    public void mo110(String str) {
        this.f130 = null;
        C0084.m81(str);
        if (this.f129 != null) {
            this.f129.mo113();
        }
    }

    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m111() {
        if (this.f133 != null) {
            this.f133.m116();
            this.f133 = null;
        }
        this.f129 = null;
        this.f131 = null;
    }

    @Override // com.integralads.avid.library.ࢠ.AsyncTaskC0137.InterfaceC0139
    /* renamed from: ࢣ  reason: contains not printable characters */
    public void mo112() {
        this.f130 = null;
        m106();
    }
}
