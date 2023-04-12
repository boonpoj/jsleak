package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzuv implements Runnable {
    private /* synthetic */ zzuo zzcfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuv(zzuu zzuuVar, zzuo zzuoVar) {
        this.zzcfj = zzuoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzcfj.zzcet.destroy();
        } catch (RemoteException e) {
            zzagf.zzc("Could not destroy mediation adapter.", e);
        }
    }
}
