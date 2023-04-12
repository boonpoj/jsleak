package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0343;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢩ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public abstract class AbstractC0383 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    C0348 f2551 = null;

    /* renamed from: ࢢ  reason: contains not printable characters */
    WeakReference<WebView> f2552;

    /* renamed from: ࢣ  reason: contains not printable characters */
    C0343 f2553;

    /* renamed from: ࢤ  reason: contains not printable characters */
    InterfaceC0377 f2554;

    /* renamed from: ࢥ  reason: contains not printable characters */
    final String f2555;

    /* renamed from: ࢦ  reason: contains not printable characters */
    final boolean f2556;

    /* renamed from: ࢧ  reason: contains not printable characters */
    private WeakReference<View> f2557;

    /* renamed from: ࢨ  reason: contains not printable characters */
    private final C0362 f2558;

    /* renamed from: ࢩ  reason: contains not printable characters */
    private final boolean f2559;

    /* renamed from: ࢪ  reason: contains not printable characters */
    private boolean f2560;

    /* renamed from: ࢫ  reason: contains not printable characters */
    private boolean f2561;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0383(@Nullable View view, boolean z, boolean z2) {
        String str;
        C0379.m2046(3, "BaseTracker", this, "Initializing.");
        if (z) {
            str = "m" + hashCode();
        } else {
            str = "";
        }
        this.f2555 = str;
        this.f2557 = new WeakReference<>(view);
        this.f2559 = z;
        this.f2556 = z2;
        this.f2560 = false;
        this.f2561 = false;
        this.f2558 = new C0362();
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    public void m2061() {
        try {
            C0379.m2046(3, "BaseTracker", this, "In startTracking method.");
            m2066();
            if (this.f2554 != null) {
                this.f2554.m2042("Tracking started on " + C0379.m2045(this.f2557.get()));
            }
            String str = "startTracking succeeded for " + C0379.m2045(this.f2557.get());
            C0379.m2046(3, "BaseTracker", this, str);
            C0379.m2049("[SUCCESS] ", mo2027() + " " + str);
        } catch (Exception e) {
            m2063("startTracking", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public final void m2062(WebView webView) throws C0348 {
        String str;
        String str2;
        if (webView != null) {
            this.f2552 = new WeakReference<>(webView);
            if (this.f2553 == null) {
                if (!(this.f2559 || this.f2556)) {
                    C0379.m2046(3, "BaseTracker", this, "Attempting bridge installation.");
                    if (this.f2552.get() != null) {
                        this.f2553 = new C0343(this.f2552.get(), C0343.EnumC0344.f2435);
                        str = "BaseTracker";
                        str2 = "Bridge installed.";
                    } else {
                        this.f2553 = null;
                        str = "BaseTracker";
                        str2 = "Bridge not installed, WebView is null.";
                    }
                    C0379.m2046(3, str, this, str2);
                }
            }
            if (this.f2553 != null) {
                this.f2553.m1945(this);
            }
        }
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    final void m2063(String str, Exception exc) {
        try {
            C0348.m1974(exc);
            String m1972 = C0348.m1972(str, exc);
            if (this.f2554 != null) {
                this.f2554.m2043(m1972);
            }
            C0379.m2046(3, "BaseTracker", this, m1972);
            C0379.m2049("[ERROR] ", mo2027() + " " + m1972);
        } catch (Exception unused) {
        }
    }

    @CallSuper
    /* renamed from: ࢠ  reason: contains not printable characters */
    void m2064(List<String> list) throws C0348 {
        if (this.f2557.get() == null && !this.f2556) {
            list.add("Tracker's target view is null");
        }
        if (!list.isEmpty()) {
            throw new C0348(TextUtils.join(" and ", list));
        }
    }

    @CallSuper
    /* renamed from: ࢢ  reason: contains not printable characters */
    public void m2065() {
        boolean z = false;
        try {
            C0379.m2046(3, "BaseTracker", this, "In stopTracking method.");
            this.f2561 = true;
            if (this.f2553 != null) {
                this.f2553.m1948(this);
                z = true;
            }
        } catch (Exception e) {
            C0348.m1974(e);
        }
        StringBuilder sb = new StringBuilder("Attempt to stop tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C0379.m2046(3, "BaseTracker", this, sb.toString());
        String str = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo2027());
        sb2.append(" stopTracking ");
        sb2.append(z ? "succeeded" : "failed");
        sb2.append(" for ");
        sb2.append(C0379.m2045(this.f2557.get()));
        C0379.m2049(str, sb2.toString());
        if (this.f2554 != null) {
            this.f2554.m2044("");
            this.f2554 = null;
        }
    }

    /* renamed from: ࢣ */
    abstract String mo2027();

    @CallSuper
    /* renamed from: ࢤ  reason: contains not printable characters */
    void m2066() throws C0348 {
        C0379.m2046(3, "BaseTracker", this, "Attempting to start impression.");
        m2067();
        if (this.f2560) {
            throw new C0348("Tracker already started");
        }
        if (this.f2561) {
            throw new C0348("Tracker already stopped");
        }
        m2064(new ArrayList());
        if (this.f2553 == null) {
            C0379.m2046(3, "BaseTracker", this, "Bridge is null, won't start tracking");
            throw new C0348("Bridge is null");
        }
        this.f2553.m1947(this);
        this.f2560 = true;
        C0379.m2046(3, "BaseTracker", this, "Impression started.");
    }

    /* renamed from: ࢥ  reason: contains not printable characters */
    final void m2067() throws C0348 {
        if (this.f2551 == null) {
            return;
        }
        throw new C0348("Tracker initialization failed: " + this.f2551.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢦ  reason: contains not printable characters */
    public final boolean m2068() {
        return this.f2560 && !this.f2561;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢧ  reason: contains not printable characters */
    public final View m2069() {
        return this.f2557.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢨ  reason: contains not printable characters */
    public final String m2070() {
        return C0379.m2045(this.f2557.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢩ  reason: contains not printable characters */
    public final String m2071() {
        this.f2558.m2026(this.f2555, this.f2557.get());
        return this.f2558.f2513;
    }
}
