package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsg implements zztc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsg(zzsf zzsfVar) {
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzape != null) {
            zztdVar.zzape.onAdClosed();
        }
    }
}
