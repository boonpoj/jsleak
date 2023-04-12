package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zznr;
/* loaded from: assets/classes2.dex */
public class zzfi extends zznr.zza {
    private zznt zzAp;

    public void destroy() throws RemoteException {
    }

    public boolean isLoaded() throws RemoteException {
        return false;
    }

    public void pause() throws RemoteException {
    }

    public void resume() throws RemoteException {
    }

    public void setUserId(String str) throws RemoteException {
    }

    public void show() throws RemoteException {
    }

    public void zza(zznt zzntVar) throws RemoteException {
        this.zzAp = zzntVar;
    }

    public void zza(zznx zznxVar) throws RemoteException {
        zzpy.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzpx.zzXU.post(new Runnable() { // from class: com.google.android.gms.internal.zzfi.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzfi.this.zzAp != null) {
                    try {
                        zzfi.this.zzAp.onRewardedVideoAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        zzpy.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                    }
                }
            }
        });
    }

    public void zzf(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
    }

    public void zzg(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
    }

    public void zzh(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
    }
}
