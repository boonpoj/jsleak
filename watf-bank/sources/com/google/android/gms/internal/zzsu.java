package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsu implements zztc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsu(zzst zzstVar) {
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzn != null) {
            zztdVar.zzbzn.onRewardedVideoAdLoaded();
        }
    }
}
