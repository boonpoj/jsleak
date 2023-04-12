package com.ࢢ.ࢠ.ࢠ.ࢠ;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ࢢ.ࢠ.ࢠ.ࢠ.C0355;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢨ  reason: contains not printable characters */
/* loaded from: assets/classes2.dex */
public final class C0381 {

    /* renamed from: ࢠ  reason: contains not printable characters */
    static WeakReference<Activity> f2546 = null;

    /* renamed from: ࢢ  reason: contains not printable characters */
    private static boolean f2547 = false;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private static Application f2548 = null;

    /* renamed from: ࢤ  reason: contains not printable characters */
    private static int f2549 = 0;

    /* renamed from: ࢥ  reason: contains not printable characters */
    private static boolean f2550 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ࢢ.ࢠ.ࢠ.ࢠ.ࢨ$ࢠ  reason: contains not printable characters */
    /* loaded from: assets/classes2.dex */
    public static class C0382 implements Application.ActivityLifecycleCallbacks {
        C0382() {
        }

        /* renamed from: ࢠ  reason: contains not printable characters */
        private static void m2060(boolean z) {
            if (z) {
                C0379.m2046(3, "ActivityState", (Object) null, "App became visible");
                if (C0355.m2002().f2486 != C0355.EnumC0357.f2501 || ((C0385) AbstractC0368.m2030()).f2566) {
                    return;
                }
                C0347.m1954().m1970();
                return;
            }
            C0379.m2046(3, "ActivityState", (Object) null, "App became invisible");
            if (C0355.m2002().f2486 != C0355.EnumC0357.f2501 || ((C0385) AbstractC0368.m2030()).f2566) {
                return;
            }
            C0347.m1954().m1971();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            int unused = C0381.f2549 = 1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            try {
                if (C0381.f2549 != 3 && C0381.f2549 != 5) {
                    if (C0381.f2550) {
                        m2060(false);
                    }
                    boolean unused = C0381.f2550 = false;
                }
                int unused2 = C0381.f2549 = 6;
                C0379.m2046(3, "ActivityState", this, "Activity destroyed: " + activity.getClass() + "@" + activity.hashCode());
                if (C0381.m2056(activity)) {
                    C0381.f2546 = new WeakReference<>(null);
                }
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                int unused = C0381.f2549 = 4;
                if (C0381.m2056(activity)) {
                    C0381.f2546 = new WeakReference<>(null);
                }
                C0379.m2046(3, "ActivityState", this, "Activity paused: " + activity.getClass() + "@" + activity.hashCode());
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                C0381.f2546 = new WeakReference<>(activity);
                int unused = C0381.f2549 = 3;
                C0355.m2002().m2013();
                C0379.m2046(3, "ActivityState", this, "Activity resumed: " + activity.getClass() + "@" + activity.hashCode());
                if (((C0385) AbstractC0368.m2030()).f2565) {
                    C0384.m2072(activity);
                }
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            try {
                C0381.f2546 = new WeakReference<>(activity);
                int unused = C0381.f2549 = 2;
                if (!C0381.f2550) {
                    m2060(true);
                }
                boolean unused2 = C0381.f2550 = true;
                C0379.m2046(3, "ActivityState", this, "Activity started: " + activity.getClass() + "@" + activity.hashCode());
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            try {
                if (C0381.f2549 != 3) {
                    boolean unused = C0381.f2550 = false;
                    m2060(false);
                }
                int unused2 = C0381.f2549 = 5;
                if (C0381.m2056(activity)) {
                    C0381.f2546 = new WeakReference<>(null);
                }
                C0379.m2046(3, "ActivityState", this, "Activity stopped: " + activity.getClass() + "@" + activity.hashCode());
            } catch (Exception e) {
                C0348.m1974(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static Application m2054() {
        return f2548;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢠ  reason: contains not printable characters */
    public static void m2055(Application application) {
        f2548 = application;
        if (f2547) {
            return;
        }
        f2547 = true;
        f2548.registerActivityLifecycleCallbacks(new C0382());
    }

    /* renamed from: ࢠ  reason: contains not printable characters */
    static /* synthetic */ boolean m2056(Activity activity) {
        return f2546 != null && f2546.get() == activity;
    }
}
