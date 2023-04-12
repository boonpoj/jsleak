package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsh implements zztc {
    private /* synthetic */ int zzbze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsh(zzsf zzsfVar, int i) {
        this.zzbze = i;
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzape != null) {
            zztdVar.zzape.onAdFailedToLoad(this.zzbze);
        }
    }
}
