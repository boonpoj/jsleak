package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class zzfts extends CustomTabsServiceConnection {
    private WeakReference<zzftt> zzrac;

    public zzfts(zzftt zzfttVar) {
        this.zzrac = new WeakReference<>(zzfttVar);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzftt zzfttVar = this.zzrac.get();
        if (zzfttVar != null) {
            zzfttVar.zza(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzftt zzfttVar = this.zzrac.get();
        if (zzfttVar != null) {
            zzfttVar.zzjk();
        }
    }
}
