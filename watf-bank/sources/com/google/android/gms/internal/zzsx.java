package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsx implements zztc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsx(zzst zzstVar) {
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzn != null) {
            zztdVar.zzbzn.onRewardedVideoAdClosed();
        }
    }
}
