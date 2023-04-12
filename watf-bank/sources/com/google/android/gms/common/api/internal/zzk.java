package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class zzk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzk zzfog = new zzk();
    private final AtomicBoolean zzfoh = new AtomicBoolean();
    private final AtomicBoolean zzfoi = new AtomicBoolean();
    private final ArrayList<zzl> zzfoj = new ArrayList<>();
    private boolean zzdtb = false;

    private zzk() {
    }

    public static void zza(Application application) {
        synchronized (zzfog) {
            if (!zzfog.zzdtb) {
                application.registerActivityLifecycleCallbacks(zzfog);
                application.registerComponentCallbacks(zzfog);
                zzfog.zzdtb = true;
            }
        }
    }

    public static zzk zzahb() {
        return zzfog;
    }

    private final void zzbf(boolean z) {
        synchronized (zzfog) {
            ArrayList<zzl> arrayList = this.zzfoj;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                zzl zzlVar = arrayList.get(i);
                i++;
                zzlVar.zzbf(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzfoh.compareAndSet(true, false);
        this.zzfoi.set(true);
        if (compareAndSet) {
            zzbf(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.zzfoh.compareAndSet(true, false);
        this.zzfoi.set(true);
        if (compareAndSet) {
            zzbf(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.zzfoh.compareAndSet(false, true)) {
            this.zzfoi.set(true);
            zzbf(true);
        }
    }

    public final void zza(zzl zzlVar) {
        synchronized (zzfog) {
            this.zzfoj.add(zzlVar);
        }
    }

    public final boolean zzahc() {
        return this.zzfoh.get();
    }

    public final boolean zzbe(boolean z) {
        if (!this.zzfoi.get()) {
            if (!zzq.zzami()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzfoi.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzfoh.set(true);
            }
        }
        return this.zzfoh.get();
    }
}
