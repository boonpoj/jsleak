package com.google.android.gms.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zztb implements Runnable {
    private /* synthetic */ zztc zzbzi;
    private /* synthetic */ zztd zzbzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztb(zzse zzseVar, zztc zztcVar, zztd zztdVar) {
        this.zzbzi = zztcVar;
        this.zzbzj = zztdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbzi.zzb(this.zzbzj);
        } catch (RemoteException e) {
            zzagf.zzc("Could not propagate interstitial ad event.", e);
        }
    }
}
