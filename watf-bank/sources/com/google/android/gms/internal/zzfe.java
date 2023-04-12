package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
/* loaded from: assets/classes2.dex */
public class zzfe extends zzen.zza {
    private zzel zzti;

    /* loaded from: assets/classes2.dex */
    private class zza extends zzem.zza {
        private zza() {
        }

        public String getMediationAdapterClassName() throws RemoteException {
            return null;
        }

        public boolean isLoading() throws RemoteException {
            return false;
        }

        public void zzf(zzdy zzdyVar) throws RemoteException {
            zzpy.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            zzpx.zzXU.post(new Runnable() { // from class: com.google.android.gms.internal.zzfe.zza.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzfe.this.zzti != null) {
                        try {
                            zzfe.this.zzti.onAdFailedToLoad(1);
                        } catch (RemoteException e) {
                            zzpy.zzc("Could not notify onAdFailedToLoad event.", e);
                        }
                    }
                }
            });
        }
    }

    public void zza(zzgw zzgwVar) throws RemoteException {
    }

    public void zza(zzhj zzhjVar) throws RemoteException {
    }

    public void zza(zzhk zzhkVar) throws RemoteException {
    }

    public void zza(String str, zzhm zzhmVar, zzhl zzhlVar) throws RemoteException {
    }

    public void zzb(zzel zzelVar) throws RemoteException {
        this.zzti = zzelVar;
    }

    public void zzb(zzet zzetVar) throws RemoteException {
    }

    public zzem zzci() throws RemoteException {
        return new zza();
    }
}
