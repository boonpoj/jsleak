package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public abstract class zzaen extends zzev implements zzaem {
    public zzaen() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzaem zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return queryLocalInterface instanceof zzaem ? (zzaem) queryLocalInterface : new zzaeo(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzm(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 2:
                zzc(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzn(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 4:
                zzo(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 5:
                zzp(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 6:
                zzq(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 7:
                zza(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), (zzaeq) zzew.zza(parcel, zzaeq.CREATOR));
                break;
            case 8:
                zzr(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 9:
                zzd(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzs(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
