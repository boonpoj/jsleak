package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzabc extends zzev implements zzabb {
    public zzabc() {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            zzabe zzabeVar = null;
            zzabh zzabhVar = null;
            if (i == 2) {
                zzaat zzaatVar = (zzaat) zzew.zza(parcel, zzaat.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    zzabeVar = queryLocalInterface instanceof zzabe ? (zzabe) queryLocalInterface : new zzabg(readStrongBinder);
                }
                zza(zzaatVar, zzabeVar);
            } else if (i != 4) {
                return false;
            } else {
                zzabm zzabmVar = (zzabm) zzew.zza(parcel, zzabm.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzabhVar = queryLocalInterface2 instanceof zzabh ? (zzabh) queryLocalInterface2 : new zzabi(readStrongBinder2);
                }
                zza(zzabmVar, zzabhVar);
            }
            parcel2.writeNoException();
        } else {
            zzaax zzb = zzb((zzaat) zzew.zza(parcel, zzaat.CREATOR));
            parcel2.writeNoException();
            zzew.zzb(parcel2, zzb);
        }
        return true;
    }
}
