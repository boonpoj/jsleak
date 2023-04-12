package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public abstract class zzadl extends zzev implements zzadk {
    public zzadl() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzadk zzz(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzadk ? (zzadk) queryLocalInterface : new zzadm(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzadp zzadrVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            zza((zzadv) zzew.zza(parcel, zzadv.CREATOR));
        } else if (i == 2) {
            show();
        } else if (i == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzadrVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                zzadrVar = queryLocalInterface instanceof zzadp ? (zzadp) queryLocalInterface : new zzadr(readStrongBinder);
            }
            zza(zzadrVar);
        } else if (i != 34) {
            switch (i) {
                case 5:
                    boolean isLoaded = isLoaded();
                    parcel2.writeNoException();
                    zzew.zza(parcel2, isLoaded);
                    break;
                case 6:
                    pause();
                    break;
                case 7:
                    resume();
                    break;
                case 8:
                    destroy();
                    break;
                case 9:
                    zzb(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                    break;
                case 10:
                    zzc(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                    break;
                case 11:
                    zzd(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                    break;
                case 12:
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    parcel2.writeNoException();
                    parcel2.writeString(mediationAdapterClassName);
                    break;
                case 13:
                    setUserId(parcel.readString());
                    break;
                default:
                    return false;
            }
            return true;
        } else {
            setImmersiveMode(zzew.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
