package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzcbu extends zzeu implements zzcbt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.zzcbt
    public final zzcbr zza(zzcbp zzcbpVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzcbpVar);
        Parcel zza = zza(1, zzbe);
        zzcbr zzcbrVar = (zzcbr) zzew.zza(zza, zzcbr.CREATOR);
        zza.recycle();
        return zzcbrVar;
    }
}
