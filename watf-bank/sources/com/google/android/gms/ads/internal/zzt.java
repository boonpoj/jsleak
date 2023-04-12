package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzol;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzt implements Runnable {
    private /* synthetic */ zzq zzaoh;
    private /* synthetic */ zzol zzaoj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzq zzqVar, zzol zzolVar) {
        this.zzaoh = zzqVar;
        this.zzaoj = zzolVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzaoh.zzano.zzaul != null) {
                this.zzaoh.zzano.zzaul.zza(this.zzaoj);
            }
        } catch (RemoteException e) {
            zzagf.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
