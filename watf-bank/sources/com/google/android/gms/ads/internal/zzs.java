package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzoj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzs implements Runnable {
    private /* synthetic */ zzq zzaoh;
    private /* synthetic */ zzoj zzaoi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzq zzqVar, zzoj zzojVar) {
        this.zzaoh = zzqVar;
        this.zzaoi = zzojVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzaoh.zzano.zzauk != null) {
                this.zzaoh.zzano.zzauk.zza(this.zzaoi);
            }
        } catch (RemoteException e) {
            zzagf.zzc("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
