package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
/* loaded from: classes.dex */
public abstract class zzax extends zzev implements zzaw {
    public zzax() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            zza(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzew.zza(parcel, Bundle.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zza(parcel.readInt(), (Bundle) zzew.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
