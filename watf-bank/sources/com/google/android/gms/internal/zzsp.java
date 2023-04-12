package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
final class zzsp extends zzob {
    private /* synthetic */ zzse zzbzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsp(zzse zzseVar) {
        this.zzbzd = zzseVar;
    }

    @Override // com.google.android.gms.internal.zzoa
    public final void zza(zznx zznxVar) throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsq(this, zznxVar));
    }
}
