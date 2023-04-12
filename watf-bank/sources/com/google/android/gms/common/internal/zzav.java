package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
/* loaded from: classes.dex */
public final class zzav extends zzeu implements zzat {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzat
    public final IObjectWrapper zzaga() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.common.internal.zzat
    public final int zzagb() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
