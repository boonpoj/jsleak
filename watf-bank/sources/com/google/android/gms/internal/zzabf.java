package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzabf extends zzev implements zzabe {
    public zzabf() {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            zza((zzaax) zzew.zza(parcel, zzaax.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
