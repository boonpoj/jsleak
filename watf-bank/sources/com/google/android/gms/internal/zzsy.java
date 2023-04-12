package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsy implements zztc {
    private /* synthetic */ zzadh zzbzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsy(zzst zzstVar, zzadh zzadhVar) {
        this.zzbzh = zzadhVar;
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzn != null) {
            zztdVar.zzbzn.zza(this.zzbzh);
        }
    }
}
