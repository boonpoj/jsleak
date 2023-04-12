package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzfq extends zzeu implements zzfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.zzfo
    public final String getId() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzfo
    public final boolean zzb(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, true);
        Parcel zza = zza(2, zzbe);
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzfo
    public final boolean zzbp() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }
}
