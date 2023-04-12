package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;
/* loaded from: assets/classes2.dex */
public class zzbva extends CustomTabsServiceConnection {
    private WeakReference<zzbvb> zzcsV;

    public zzbva(zzbvb zzbvbVar) {
        this.zzcsV = new WeakReference<>(zzbvbVar);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbvb zzbvbVar = this.zzcsV.get();
        if (zzbvbVar != null) {
            zzbvbVar.zza(customTabsClient);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzbvb zzbvbVar = this.zzcsV.get();
        if (zzbvbVar != null) {
            zzbvbVar.zzfD();
        }
    }
}
