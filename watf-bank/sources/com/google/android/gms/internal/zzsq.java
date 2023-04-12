package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsq implements zztc {
    private /* synthetic */ zznx zzbzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsq(zzsp zzspVar, zznx zznxVar) {
        this.zzbzg = zznxVar;
    }

    @Override // com.google.android.gms.internal.zztc
    public final void zzb(zztd zztdVar) throws RemoteException {
        if (zztdVar.zzbzl != null) {
            zztdVar.zzbzl.zza(this.zzbzg);
        }
    }
}
