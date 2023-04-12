package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzny extends zzev implements zznx {
    public zzny() {
        attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String zzjj;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            zzjj = zzjj();
        } else if (i != 2) {
            if (i == 3) {
                zze(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
            } else if (i == 4) {
                recordClick();
            } else if (i != 5) {
                return false;
            } else {
                recordImpression();
            }
            parcel2.writeNoException();
            return true;
        } else {
            zzjj = getContent();
        }
        parcel2.writeNoException();
        parcel2.writeString(zzjj);
        return true;
    }
}
