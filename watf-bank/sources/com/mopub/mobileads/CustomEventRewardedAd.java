package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubLifecycleManager;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import java.util.Map;
/* loaded from: assets/classes2.dex */
public abstract class CustomEventRewardedAd {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean checkAndInitializeSdk(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract String getAdNetworkId();

    @Nullable
    @VisibleForTesting
    protected abstract LifecycleListener getLifecycleListener();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢠ */
    public abstract void mo654();

    /* renamed from: ࢠ */
    protected abstract void mo655(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ࢢ  reason: contains not printable characters */
    public final void m755(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        try {
            if (checkAndInitializeSdk(activity, map, map2)) {
                MoPubLifecycleManager.getInstance(activity).addLifecycleListener(getLifecycleListener());
            }
            mo655(activity, map, map2);
        } catch (Exception e) {
            MoPubLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢣ  reason: contains not printable characters */
    public abstract boolean mo756();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ࢤ  reason: contains not printable characters */
    public abstract void mo757();
}
