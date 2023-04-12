package com.google.android.gms.internal;

import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzmm implements Runnable {
    private /* synthetic */ zzml zzbgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmm(zzml zzmlVar) {
        this.zzbgv = zzmlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzadp zzadpVar;
        zzadp zzadpVar2;
        zzadpVar = this.zzbgv.zzbgu;
        if (zzadpVar != null) {
            try {
                zzadpVar2 = this.zzbgv.zzbgu;
                zzadpVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzakb.zzc("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
