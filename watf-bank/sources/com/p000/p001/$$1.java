package com.p000.p001;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.ࢠ.ࢠ.C0307;
/* renamed from: com.ࢠ.ࢠ.ނ$ࢠ$1  reason: invalid class name and invalid package */
/* loaded from: assets/classes2.dex */
class $$1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: ࢠ  reason: contains not printable characters */
    final /* synthetic */ C0307.ࢠ f2272;

    $$1(C0307.ࢠ r1) {
        this.f2272 = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            C0319.m1819(activity, C0307.ࢠ.ࢠ(this.f2272));
            C0304.m1730(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            C0304.m1730(activity);
            C0304.m1724(activity);
            C0304.m1728(activity);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        FlurryAgent.onPageView();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
