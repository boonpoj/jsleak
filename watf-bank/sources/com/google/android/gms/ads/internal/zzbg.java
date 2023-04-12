package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzon;
/* loaded from: classes.dex */
final class zzbg implements Runnable {
    private /* synthetic */ zzafo zzaox;
    private /* synthetic */ zzba zzarp;
    private /* synthetic */ String zzarv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(zzba zzbaVar, String str, zzafo zzafoVar) {
        this.zzarp = zzbaVar;
        this.zzarv = str;
        this.zzaox = zzafoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzarp.zzano.zzaun.get(this.zzarv).zzb((zzon) this.zzaox.zzcxr);
        } catch (RemoteException e) {
            zzagf.zzc("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
