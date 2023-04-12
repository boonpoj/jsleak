package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsv implements zztc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsv(zzst zzstVar) {
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzn != null) {
            zztdVar.zzbzn.onRewardedVideoAdOpened();
        }
    }
}
