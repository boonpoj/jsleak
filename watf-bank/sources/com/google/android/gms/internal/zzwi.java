package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzwi implements Runnable {
    private /* synthetic */ zzvx zzcfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwi(zzvx zzvxVar) {
        this.zzcfx = zzvxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzvd zzvdVar;
        try {
            zzvdVar = this.zzcfx.zzcfp;
            zzvdVar.onAdLeftApplication();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }
}
