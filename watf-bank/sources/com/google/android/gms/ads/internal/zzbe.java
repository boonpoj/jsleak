package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzoj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbe implements Runnable {
    private /* synthetic */ zzoj zzaoi;
    private /* synthetic */ zzba zzarp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(zzba zzbaVar, zzoj zzojVar) {
        this.zzarp = zzbaVar;
        this.zzaoi = zzojVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzarp.zzano.zzauk != null) {
                this.zzarp.zzano.zzauk.zza(this.zzaoi);
            }
        } catch (RemoteException e) {
            zzagf.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
