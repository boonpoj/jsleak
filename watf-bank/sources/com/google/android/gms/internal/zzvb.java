package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public abstract class zzvb extends zzev implements zzva {
    public zzvb() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface view;
        boolean isInitialized;
        Bundle zzmg;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        zzvd zzvdVar = null;
        switch (i) {
            case 1:
                IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(parcel.readStrongBinder());
                zzjn zzjnVar = (zzjn) zzew.zza(parcel, zzjn.CREATOR);
                zzjj zzjjVar = (zzjj) zzew.zza(parcel, zzjj.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvdVar = queryLocalInterface instanceof zzvd ? (zzvd) queryLocalInterface : new zzvf(readStrongBinder);
                }
                zza(zzaq, zzjnVar, zzjjVar, readString, zzvdVar);
                parcel2.writeNoException();
                return true;
            case 2:
                view = getView();
                parcel2.writeNoException();
                zzew.zza(parcel2, view);
                return true;
            case 3:
                IObjectWrapper zzaq2 = IObjectWrapper.zza.zzaq(parcel.readStrongBinder());
                zzjj zzjjVar2 = (zzjj) zzew.zza(parcel, zzjj.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvdVar = queryLocalInterface2 instanceof zzvd ? (zzvd) queryLocalInterface2 : new zzvf(readStrongBinder2);
                }
                zza(zzaq2, zzjjVar2, readString2, zzvdVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper zzaq3 = IObjectWrapper.zza.zzaq(parcel.readStrongBinder());
                zzjn zzjnVar2 = (zzjn) zzew.zza(parcel, zzjn.CREATOR);
                zzjj zzjjVar3 = (zzjj) zzew.zza(parcel, zzjj.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvdVar = queryLocalInterface3 instanceof zzvd ? (zzvd) queryLocalInterface3 : new zzvf(readStrongBinder3);
                }
                zza(zzaq3, zzjnVar2, zzjjVar3, readString3, readString4, zzvdVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper zzaq4 = IObjectWrapper.zza.zzaq(parcel.readStrongBinder());
                zzjj zzjjVar4 = (zzjj) zzew.zza(parcel, zzjj.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvdVar = queryLocalInterface4 instanceof zzvd ? (zzvd) queryLocalInterface4 : new zzvf(readStrongBinder4);
                }
                zza(zzaq4, zzjjVar4, readString5, readString6, zzvdVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), (zzjj) zzew.zza(parcel, zzjj.CREATOR), parcel.readString(), zzaen.zzab(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zzc((zzjj) zzew.zza(parcel, zzjj.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                isInitialized = isInitialized();
                parcel2.writeNoException();
                zzew.zza(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper zzaq5 = IObjectWrapper.zza.zzaq(parcel.readStrongBinder());
                zzjj zzjjVar5 = (zzjj) zzew.zza(parcel, zzjj.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzvdVar = queryLocalInterface5 instanceof zzvd ? (zzvd) queryLocalInterface5 : new zzvf(readStrongBinder5);
                }
                zza(zzaq5, zzjjVar5, readString7, readString8, zzvdVar, (zzpe) zzew.zza(parcel, zzpe.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                view = zzme();
                parcel2.writeNoException();
                zzew.zza(parcel2, view);
                return true;
            case 16:
                view = zzmf();
                parcel2.writeNoException();
                zzew.zza(parcel2, view);
                return true;
            case 17:
                zzmg = zzmg();
                parcel2.writeNoException();
                zzew.zzb(parcel2, zzmg);
                return true;
            case 18:
                zzmg = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzew.zzb(parcel2, zzmg);
                return true;
            case 19:
                zzmg = zzmh();
                parcel2.writeNoException();
                zzew.zzb(parcel2, zzmg);
                return true;
            case 20:
                zza((zzjj) zzew.zza(parcel, zzjj.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzg(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                isInitialized = zzmi();
                parcel2.writeNoException();
                zzew.zza(parcel2, isInitialized);
                return true;
            case 23:
                zza(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), zzaen.zzab(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                view = zzmj();
                parcel2.writeNoException();
                zzew.zza(parcel2, view);
                return true;
            case 25:
                setImmersiveMode(zzew.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                view = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, view);
                return true;
            default:
                return false;
        }
    }
}
