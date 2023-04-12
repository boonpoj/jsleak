package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzqm;
/* loaded from: classes.dex */
final class zzbh implements Runnable {
    private /* synthetic */ zzqm zzaok;
    private /* synthetic */ zzba zzarp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(zzba zzbaVar, zzqm zzqmVar) {
        this.zzarp = zzbaVar;
        this.zzaok = zzqmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzarp.zzano.zzaun.get(this.zzaok.getCustomTemplateId()).zzb(this.zzaok);
        } catch (RemoteException e) {
            zzagf.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
