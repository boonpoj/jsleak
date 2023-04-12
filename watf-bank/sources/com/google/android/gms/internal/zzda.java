package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzda implements Application.ActivityLifecycleCallbacks {
    private final Application zzaii;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzaij;
    private boolean zzaik = false;

    @TargetApi(14)
    /* loaded from: assets/classes2.dex */
    static class zza implements Application.ActivityLifecycleCallbacks {
        @Nullable
        private Activity mActivity;
        private Context mContext;
        private Runnable zzxA;
        private long zzxB;
        private final Object zzrN = new Object();
        private boolean zzxy = true;
        private boolean zzxz = false;
        private List<zzb> mListeners = new ArrayList();
        private boolean zztW = false;

        zza() {
        }

        private void setActivity(Activity activity) {
            synchronized (this.zzrN) {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.mActivity = activity;
                }
            }
        }

        @Nullable
        public Activity getActivity() {
            return this.mActivity;
        }

        @Nullable
        public Context getContext() {
            return this.mContext;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            synchronized (this.zzrN) {
                if (this.mActivity == null) {
                    return;
                }
                if (this.mActivity.equals(activity)) {
                    this.mActivity = null;
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            setActivity(activity);
            this.zzxz = true;
            if (this.zzxA != null) {
                zzpi.zzWR.removeCallbacks(this.zzxA);
            }
            Handler handler = zzpi.zzWR;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.zzda.zza.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zza.this.zzrN) {
                        if (zza.this.zzxy && zza.this.zzxz) {
                            zza.this.zzxy = false;
                            zzpe.zzbc("App went background");
                            for (zzb zzbVar : zza.this.mListeners) {
                                try {
                                    zzbVar.zzk(false);
                                } catch (Exception e) {
                                    zzpe.zzb("OnForegroundStateChangedListener threw exception.", e);
                                }
                            }
                        } else {
                            zzpe.zzbc("App is still foreground");
                        }
                    }
                }
            };
            this.zzxA = runnable;
            handler.postDelayed(runnable, this.zzxB);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            setActivity(activity);
            this.zzxz = false;
            boolean z = !this.zzxy;
            this.zzxy = true;
            if (this.zzxA != null) {
                zzpi.zzWR.removeCallbacks(this.zzxA);
            }
            synchronized (this.zzrN) {
                try {
                    if (z) {
                        for (zzb zzbVar : this.mListeners) {
                            try {
                                zzbVar.zzk(true);
                            } catch (Exception e) {
                                zzpe.zzb("OnForegroundStateChangedListener threw exception.", e);
                            }
                        }
                    } else {
                        zzpe.zzbc("App is still foreground.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            setActivity(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        public void zza(Application application, Context context) {
            if (this.zztW) {
                return;
            }
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.mContext = context;
            this.zzxB = ((Long) zzfx.zzCu.get()).longValue();
            this.zztW = true;
        }

        public void zza(zzb zzbVar) {
            this.mListeners.add(zzbVar);
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzb {
        void zzk(boolean z);
    }

    public zzda(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzaij = new WeakReference<>(activityLifecycleCallbacks);
        this.zzaii = application;
    }

    private final void zza(zzdi zzdiVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzaij.get();
            if (activityLifecycleCallbacks != null) {
                zzdiVar.zza(activityLifecycleCallbacks);
            } else if (this.zzaik) {
            } else {
                this.zzaii.unregisterActivityLifecycleCallbacks(this);
                this.zzaik = true;
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzdb(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzdh(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzde(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzdd(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzdg(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzdc(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzdf(this, activity));
    }
}
