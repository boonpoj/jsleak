package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdt implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzajw = new Handler(Looper.getMainLooper());
    private final zzdm zzagr;
    private Application zzaii;
    private final Context zzajx;
    private final PowerManager zzajy;
    private final KeyguardManager zzajz;
    private BroadcastReceiver zzaka;
    private WeakReference<ViewTreeObserver> zzakb;
    private WeakReference<View> zzakc;
    private zzda zzakd;
    private boolean zzake = false;
    private int zzakf = -1;
    private long zzakg = -3;

    public zzdt(zzdm zzdmVar, View view) {
        this.zzagr = zzdmVar;
        this.zzajx = zzdmVar.zzair;
        this.zzajy = (PowerManager) this.zzajx.getSystemService("power");
        this.zzajz = (KeyguardManager) this.zzajx.getSystemService("keyguard");
        Context context = this.zzajx;
        if (context instanceof Application) {
            this.zzaii = (Application) context;
            this.zzakd = new zzda((Application) context, this);
        }
        zzd(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzakc == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzakc.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzakf = i;
    }

    private final void zzav() {
        zzajw.post(new zzdu(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r4 == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzax() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzakc
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            if (r0 != 0) goto L15
            r2 = -3
            r9.zzakg = r2
            r9.zzake = r1
            return
        L15:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            boolean r2 = r0.getGlobalVisibleRect(r2)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            boolean r3 = r0.getLocalVisibleRect(r3)
            com.google.android.gms.internal.zzdm r4 = r9.zzagr
            boolean r4 = r4.zzan()
            r5 = 1
            if (r4 != 0) goto L5b
            android.app.KeyguardManager r4 = r9.zzajz
            boolean r4 = r4.inKeyguardRestrictedInputMode()
            if (r4 == 0) goto L59
            android.app.Activity r4 = com.google.android.gms.internal.zzdr.zzc(r0)
            if (r4 == 0) goto L55
            android.view.Window r4 = r4.getWindow()
            if (r4 != 0) goto L46
            r4 = 0
            goto L4a
        L46:
            android.view.WindowManager$LayoutParams r4 = r4.getAttributes()
        L4a:
            if (r4 == 0) goto L55
            int r4 = r4.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r4 = r4 & r6
            if (r4 == 0) goto L55
            r4 = 1
            goto L56
        L55:
            r4 = 0
        L56:
            if (r4 == 0) goto L59
            goto L5b
        L59:
            r4 = 0
            goto L5c
        L5b:
            r4 = 1
        L5c:
            int r6 = r0.getWindowVisibility()
            int r7 = r9.zzakf
            r8 = -1
            if (r7 == r8) goto L66
            r6 = r7
        L66:
            int r7 = r0.getVisibility()
            if (r7 != 0) goto L83
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L83
            android.os.PowerManager r0 = r9.zzajy
            boolean r0 = r0.isScreenOn()
            if (r0 == 0) goto L83
            if (r4 == 0) goto L83
            if (r3 == 0) goto L83
            if (r2 == 0) goto L83
            if (r6 != 0) goto L83
            r1 = 1
        L83:
            boolean r0 = r9.zzake
            if (r0 == r1) goto L94
            if (r1 == 0) goto L8e
            long r2 = android.os.SystemClock.elapsedRealtime()
            goto L90
        L8e:
            r2 = -2
        L90:
            r9.zzakg = r2
            r9.zzake = r1
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdt.zzax():void");
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzakb = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzaka == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzaka = new zzdv(this);
            this.zzajx.registerReceiver(this.zzaka, intentFilter);
        }
        Application application = this.zzaii;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzakd);
            } catch (Exception e) {
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zzakb != null) {
                ViewTreeObserver viewTreeObserver = this.zzakb.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzakb = null;
            }
        } catch (Exception e) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzaka;
        if (broadcastReceiver != null) {
            try {
                this.zzajx.unregisterReceiver(broadcastReceiver);
            } catch (Exception e3) {
            }
            this.zzaka = null;
        }
        Application application = this.zzaii;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzakd);
            } catch (Exception e4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzax();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzax();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzax();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzax();
        zzav();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzax();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzax();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzax();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzax();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzax();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzakf = -1;
        zze(view);
        zzax();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzakf = -1;
        zzax();
        zzav();
        zzf(view);
    }

    public final long zzaw() {
        if (this.zzakg == -2 && this.zzakc.get() == null) {
            this.zzakg = -3L;
        }
        return this.zzakg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(View view) {
        long j;
        WeakReference<View> weakReference = this.zzakc;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzakc = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.zzakg = j;
    }
}
