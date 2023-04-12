package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzko extends zzev implements zzkn {
    public zzko() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        zzkh zzkhVar = null;
        zzld zzldVar = null;
        switch (i) {
            case 1:
                zzkk zzdi = zzdi();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzdi);
                break;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzkhVar = queryLocalInterface instanceof zzkh ? (zzkh) queryLocalInterface : new zzkj(readStrongBinder);
                }
                zzb(zzkhVar);
                parcel2.writeNoException();
                break;
            case 3:
                zza(zzqr.zzo(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 4:
                zza(zzqu.zzp(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 5:
                zza(parcel.readString(), zzra.zzr(parcel.readStrongBinder()), zzqx.zzq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 6:
                zza((zzpe) zzew.zza(parcel, zzpe.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzldVar = queryLocalInterface2 instanceof zzld ? (zzld) queryLocalInterface2 : new zzlf(readStrongBinder2);
                }
                zzb(zzldVar);
                parcel2.writeNoException();
                break;
            case 8:
                zza(zzrg.zzt(parcel.readStrongBinder()), (zzjn) zzew.zza(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                break;
            case 9:
                zza((PublisherAdViewOptions) zzew.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                break;
            case 10:
                zza(zzrd.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
