package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzqa extends zzev implements zzpz {
    public zzqa() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzpz zzm(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        return queryLocalInterface instanceof zzpz ? (zzpz) queryLocalInterface : new zzqb(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            zza(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
        } else if (i != 2) {
            return false;
        } else {
            unregisterNativeAd();
        }
        parcel2.writeNoException();
        return true;
    }
}
