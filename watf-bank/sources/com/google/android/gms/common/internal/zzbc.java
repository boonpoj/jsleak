package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
/* loaded from: classes.dex */
public final class zzbc extends zzeu implements zzba {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzba
    public final boolean zza(com.google.android.gms.common.zzn zznVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zznVar);
        zzew.zza(zzbe, iObjectWrapper);
        Parcel zza = zza(5, zzbe);
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }
}
