package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzip extends zzeu implements zzio {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzip(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.zzio
    public final zzii zza(zzil zzilVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzilVar);
        Parcel zza = zza(1, zzbe);
        zzii zziiVar = (zzii) zzew.zza(zza, zzii.CREATOR);
        zza.recycle();
        return zziiVar;
    }
}
