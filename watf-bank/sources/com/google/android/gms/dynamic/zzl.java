package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
/* loaded from: classes.dex */
public abstract class zzl extends zzev implements zzk {
    public zzl() {
        attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface zzapx;
        int id;
        boolean retainInstance;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        IObjectWrapper iObjectWrapper = null;
        switch (i) {
            case 2:
                zzapx = zzapx();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzapx);
                break;
            case 3:
                Bundle arguments = getArguments();
                parcel2.writeNoException();
                zzew.zzb(parcel2, arguments);
                break;
            case 4:
                id = getId();
                parcel2.writeNoException();
                parcel2.writeInt(id);
                break;
            case 5:
                zzapx = zzapy();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzapx);
                break;
            case 6:
                zzapx = zzapz();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzapx);
                break;
            case 7:
                retainInstance = getRetainInstance();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 8:
                String tag = getTag();
                parcel2.writeNoException();
                parcel2.writeString(tag);
                break;
            case 9:
                zzapx = zzaqa();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzapx);
                break;
            case 10:
                id = getTargetRequestCode();
                parcel2.writeNoException();
                parcel2.writeInt(id);
                break;
            case 11:
                retainInstance = getUserVisibleHint();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 12:
                zzapx = getView();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzapx);
                break;
            case 13:
                retainInstance = isAdded();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 14:
                retainInstance = isDetached();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 15:
                retainInstance = isHidden();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 16:
                retainInstance = isInLayout();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 17:
                retainInstance = isRemoving();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 18:
                retainInstance = isResumed();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 19:
                retainInstance = isVisible();
                parcel2.writeNoException();
                zzew.zza(parcel2, retainInstance);
                break;
            case 20:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
                    iObjectWrapper = queryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) queryLocalInterface : new zzm(readStrongBinder);
                }
                zzv(iObjectWrapper);
                parcel2.writeNoException();
                break;
            case 21:
                setHasOptionsMenu(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 22:
                setMenuVisibility(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 23:
                setRetainInstance(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 24:
                setUserVisibleHint(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 25:
                startActivity((Intent) zzew.zza(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                break;
            case 26:
                startActivityForResult((Intent) zzew.zza(parcel, Intent.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                break;
            case 27:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
                    iObjectWrapper = queryLocalInterface2 instanceof IObjectWrapper ? (IObjectWrapper) queryLocalInterface2 : new zzm(readStrongBinder2);
                }
                zzw(iObjectWrapper);
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
