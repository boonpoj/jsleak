package com.mopub.common;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.privacy.PersonalInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
/* loaded from: assets/classes2.dex */
public class MoPubLifecycleManager implements LifecycleListener {

    /* renamed from: ࢠ  reason: contains not printable characters */
    private static MoPubLifecycleManager f404;
    @NonNull

    /* renamed from: ࢢ  reason: contains not printable characters */
    private final Set<LifecycleListener> f405 = new HashSet();
    @NonNull

    /* renamed from: ࢣ  reason: contains not printable characters */
    private final WeakReference<Activity> f406;

    private MoPubLifecycleManager(Activity activity) {
        this.f406 = new WeakReference<>(activity);
    }

    @NonNull
    public static synchronized MoPubLifecycleManager getInstance(Activity activity) {
        MoPubLifecycleManager moPubLifecycleManager;
        synchronized (MoPubLifecycleManager.class) {
            if (f404 == null) {
                f404 = new MoPubLifecycleManager(activity);
            }
            moPubLifecycleManager = f404;
        }
        return moPubLifecycleManager;
    }

    public void addLifecycleListener(@Nullable LifecycleListener lifecycleListener) {
        Activity activity;
        if (lifecycleListener == null || !this.f405.add(lifecycleListener) || (activity = this.f406.get()) == null) {
            return;
        }
        lifecycleListener.onCreate(activity);
        lifecycleListener.onStart(activity);
    }

    @Override // com.mopub.common.LifecycleListener
    public void onBackPressed(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onBackPressed(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onCreate(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onCreate(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onDestroy(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onDestroy(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onPause(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onPause(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onRestart(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onRestart(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onResume(@NonNull Activity activity) {
        PersonalInfoManager personalInformationManager = MoPub.getPersonalInformationManager();
        if (personalInformationManager != null) {
            personalInformationManager.requestSync(false);
        }
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onResume(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onStart(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onStart(activity);
        }
    }

    @Override // com.mopub.common.LifecycleListener
    public void onStop(@NonNull Activity activity) {
        for (LifecycleListener lifecycleListener : this.f405) {
            lifecycleListener.onStop(activity);
        }
    }
}
