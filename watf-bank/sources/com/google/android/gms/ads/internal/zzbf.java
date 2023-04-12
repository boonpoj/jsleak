package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzol;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbf implements Runnable {
    private /* synthetic */ zzol zzaoj;
    private /* synthetic */ zzba zzarp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbf(zzba zzbaVar, zzol zzolVar) {
        this.zzarp = zzbaVar;
        this.zzaoj = zzolVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzarp.zzano.zzaul != null) {
                this.zzarp.zzano.zzaul.zza(this.zzaoj);
            }
        } catch (RemoteException e) {
            zzagf.zzc("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
