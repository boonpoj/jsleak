package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
/* loaded from: classes.dex */
public abstract class zzau extends zzev implements zzat {
    public zzau() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    public static zzat zzam(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzat ? (zzat) queryLocalInterface : new zzav(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IObjectWrapper zzaga = zzaga();
            parcel2.writeNoException();
            zzew.zza(parcel2, zzaga);
        } else if (i != 2) {
            return false;
        } else {
            int zzagb = zzagb();
            parcel2.writeNoException();
            parcel2.writeInt(zzagb);
        }
        return true;
    }
}
