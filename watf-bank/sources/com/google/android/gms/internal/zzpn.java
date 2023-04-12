package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzpn extends zzev implements zzpm {
    public zzpn() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzpm zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        return queryLocalInterface instanceof zzpm ? (zzpm) queryLocalInterface : new zzpo(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 2) {
            String text = getText();
            parcel2.writeNoException();
            parcel2.writeString(text);
        } else if (i != 3) {
            return false;
        } else {
            List<zzpq> zzjm = zzjm();
            parcel2.writeNoException();
            parcel2.writeList(zzjm);
        }
        return true;
    }
}
