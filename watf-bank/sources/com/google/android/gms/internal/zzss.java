package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzss implements zztc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzss(zzsr zzsrVar) {
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzm != null) {
            zztdVar.zzbzm.onAdClicked();
        }
    }
}
