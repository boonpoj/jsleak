package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
/* loaded from: classes.dex */
final class zzwc implements Runnable {
    private /* synthetic */ zzvx zzcfx;
    private /* synthetic */ AdRequest.ErrorCode zzcfy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwc(zzvx zzvxVar, AdRequest.ErrorCode errorCode) {
        this.zzcfx = zzvxVar;
        this.zzcfy = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvd zzvdVar;
        try {
            zzvdVar = this.zzcfx.zzcfp;
            zzvdVar.onAdFailedToLoad(zzwj.zza(this.zzcfy));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }
}
