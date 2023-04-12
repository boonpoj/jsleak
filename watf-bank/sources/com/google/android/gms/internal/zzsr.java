package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
final class zzsr extends zzkf {
    private /* synthetic */ zzse zzbzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsr(zzse zzseVar) {
        this.zzbzd = zzseVar;
    }

    @Override // com.google.android.gms.internal.zzke
    public final void onAdClicked() throws RemoteException {
        zzse.zza(this.zzbzd).add(new zzss(this));
    }
}
