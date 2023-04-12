package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public abstract class zzuy extends zzev implements zzux {
    public zzuy() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzux zzu(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzux ? (zzux) queryLocalInterface : new zzuz(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            zzva zzbg = zzbg(parcel.readString());
            parcel2.writeNoException();
            zzew.zza(parcel2, zzbg);
        } else if (i != 2) {
            return false;
        } else {
            boolean zzbh = zzbh(parcel.readString());
            parcel2.writeNoException();
            zzew.zza(parcel2, zzbh);
        }
        return true;
    }
}
