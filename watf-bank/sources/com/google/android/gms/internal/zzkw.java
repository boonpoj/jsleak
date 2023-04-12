package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzkw extends zzeu implements zzkv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.zzkv
    public final IBinder zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, zzux zzuxVar, int i, int i2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjnVar);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzuxVar);
        zzbe.writeInt(11910000);
        zzbe.writeInt(i2);
        Parcel zza = zza(2, zzbe);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}
