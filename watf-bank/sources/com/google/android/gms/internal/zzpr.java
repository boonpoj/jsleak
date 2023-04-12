package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzpr extends zzev implements zzpq {
    public zzpr() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzpq zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(iBinder);
    }

    @Override // com.google.android.gms.internal.zzpr
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IObjectWrapper zzjr = zzjr();
            parcel2.writeNoException();
            zzew.zza(parcel2, zzjr);
        } else if (i == 2) {
            Uri uri = getUri();
            parcel2.writeNoException();
            zzew.zzb(parcel2, uri);
        } else if (i != 3) {
            return false;
        } else {
            double scale = getScale();
            parcel2.writeNoException();
            parcel2.writeDouble(scale);
        }
        return true;
    }
}
