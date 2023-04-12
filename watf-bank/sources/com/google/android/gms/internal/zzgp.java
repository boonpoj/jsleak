package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzgp implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzaxf = ((Long) zzkb.zzif().zzd(zznh.zzbmp)).longValue();
    private final Context mApplicationContext;
    private final WindowManager zzavx;
    private final PowerManager zzavy;
    private final KeyguardManager zzavz;
    private BroadcastReceiver zzawh;
    private Application zzaxg;
    private WeakReference<ViewTreeObserver> zzaxh;
    private WeakReference<View> zzaxi;
    private zzgu zzaxj;
    private DisplayMetrics zzaxm;
    private zzaji zzavd = new zzaji(zzaxf);
    private boolean zzawg = false;
    private int zzaxk = -1;
    private HashSet<zzgt> zzaxl = new HashSet<>();

    public zzgp(Context context, View view) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzavx = (WindowManager) context.getSystemService("window");
        this.zzavy = (PowerManager) this.mApplicationContext.getSystemService("power");
        this.zzavz = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.mApplicationContext;
        if (context2 instanceof Application) {
            this.zzaxg = (Application) context2;
            this.zzaxj = new zzgu((Application) context2, this);
        }
        this.zzaxm = context.getResources().getDisplayMetrics();
        WeakReference<View> weakReference = this.zzaxi;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzaxi = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzbs.zzek().isAttachedToWindow(view)) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzn(rect.left), zzn(rect.top), zzn(rect.right), zzn(rect.bottom));
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzaxi == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzaxi.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzaxk = i;
    }

    private final void zzav() {
        com.google.android.gms.ads.internal.zzbs.zzei();
        zzahn.zzdaw.post(new zzgq(this));
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaxh = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzawh == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzawh = new zzgr(this);
            com.google.android.gms.ads.internal.zzbs.zzfg().zza(this.mApplicationContext, this.zzawh, intentFilter);
        }
        Application application = this.zzaxg;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzaxj);
            } catch (Exception e) {
                zzagf.zzb("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zzaxh != null) {
                ViewTreeObserver viewTreeObserver = this.zzaxh.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaxh = null;
            }
        } catch (Exception e) {
            zzagf.zzb("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzagf.zzb("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzawh != null) {
            try {
                com.google.android.gms.ads.internal.zzbs.zzfg().zza(this.mApplicationContext, this.zzawh);
            } catch (IllegalStateException e3) {
                zzagf.zzb("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                com.google.android.gms.ads.internal.zzbs.zzem().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzawh = null;
        }
        Application application = this.zzaxg;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzaxj);
            } catch (Exception e5) {
                zzagf.zzb("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        if (this.zzaxl.size() == 0 || (weakReference = this.zzaxi) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z3 = i == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        Rect rect5 = new Rect();
        rect5.right = this.zzavx.getDefaultDisplay().getWidth();
        rect5.bottom = this.zzavx.getDefaultDisplay().getHeight();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e) {
                zzagf.zzb("Failure getting view location.", e);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i2 = this.zzaxk;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        boolean z5 = !z4 && com.google.android.gms.ads.internal.zzbs.zzei().zza(view, this.zzavy, this.zzavz) && z && z2 && windowVisibility == 0;
        if (z3 && !this.zzavd.tryAcquire() && z5 == this.zzawg) {
            return;
        }
        if (z5 || this.zzawg || i != 1) {
            zzgs zzgsVar = new zzgs(com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime(), this.zzavy.isScreenOn(), view != null ? com.google.android.gms.ads.internal.zzbs.zzek().isAttachedToWindow(view) : false, view != null ? view.getWindowVisibility() : 8, zza(rect5), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzaxm.density, z5);
            Iterator<zzgt> it = this.zzaxl.iterator();
            while (it.hasNext()) {
                it.next().zza(zzgsVar);
            }
            this.zzawg = z5;
        }
    }

    private final int zzn(int i) {
        return (int) (i / this.zzaxm.density);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzm(3);
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzm(3);
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzm(3);
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzm(3);
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzm(3);
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzm(3);
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzm(3);
        zzav();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzm(2);
        zzav();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzm(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaxk = -1;
        zze(view);
        zzm(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaxk = -1;
        zzm(3);
        zzav();
        zzf(view);
    }

    public final void zza(zzgt zzgtVar) {
        this.zzaxl.add(zzgtVar);
        zzm(3);
    }

    public final void zzb(zzgt zzgtVar) {
        this.zzaxl.remove(zzgtVar);
    }

    public final void zzgi() {
        zzm(4);
    }
}
