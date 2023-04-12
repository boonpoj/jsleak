package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzqm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzu implements Runnable {
    private /* synthetic */ zzq zzaoh;
    private /* synthetic */ zzqm zzaok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzq zzqVar, zzqm zzqmVar) {
        this.zzaoh = zzqVar;
        this.zzaok = zzqmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzaoh.zzano.zzaun.get(this.zzaok.getCustomTemplateId()).zzb(this.zzaok);
        } catch (RemoteException e) {
            zzagf.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
