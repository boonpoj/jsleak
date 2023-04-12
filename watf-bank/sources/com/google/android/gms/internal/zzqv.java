package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzqv extends zzeu implements zzqt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzqt
    public final void zza(zzqi zzqiVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqiVar);
        zzb(1, zzbe);
    }
}
