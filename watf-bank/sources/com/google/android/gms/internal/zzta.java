package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzta implements zztc {
    private /* synthetic */ int zzbze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzta(zzst zzstVar, int i) {
        this.zzbze = i;
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzn != null) {
            zztdVar.zzbzn.onRewardedVideoAdFailedToLoad(this.zzbze);
        }
    }
}
