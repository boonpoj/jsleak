package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzqd extends zzeu implements zzqc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
    }

    @Override // com.google.android.gms.internal.zzqc
    public final IBinder zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, iObjectWrapper2);
        zzew.zza(zzbe, iObjectWrapper3);
        Parcel zza = zza(1, zzbe);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}
