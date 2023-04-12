package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsz implements zztc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsz(zzst zzstVar) {
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzn != null) {
            zztdVar.zzbzn.onRewardedVideoAdLeftApplication();
        }
    }
}
