package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzkt extends zzev implements zzks {
    public zzkt() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzks zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface zzbr;
        boolean isReady;
        String mediationAdapterClassName;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        zzkh zzkhVar = null;
        zzld zzldVar = null;
        zzke zzkeVar = null;
        zzkx zzkxVar = null;
        switch (i) {
            case 1:
                zzbr = zzbr();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzbr);
                break;
            case 2:
                destroy();
                parcel2.writeNoException();
                break;
            case 3:
                isReady = isReady();
                parcel2.writeNoException();
                zzew.zza(parcel2, isReady);
                break;
            case 4:
                isReady = zzb((zzjj) zzew.zza(parcel, zzjj.CREATOR));
                parcel2.writeNoException();
                zzew.zza(parcel2, isReady);
                break;
            case 5:
                pause();
                parcel2.writeNoException();
                break;
            case 6:
                resume();
                parcel2.writeNoException();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzkhVar = queryLocalInterface instanceof zzkh ? (zzkh) queryLocalInterface : new zzkj(readStrongBinder);
                }
                zza(zzkhVar);
                parcel2.writeNoException();
                break;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzkxVar = queryLocalInterface2 instanceof zzkx ? (zzkx) queryLocalInterface2 : new zzkz(readStrongBinder2);
                }
                zza(zzkxVar);
                parcel2.writeNoException();
                break;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                break;
            case 11:
                zzbu();
                parcel2.writeNoException();
                break;
            case 12:
                zzjn zzbs = zzbs();
                parcel2.writeNoException();
                zzew.zzb(parcel2, zzbs);
                break;
            case 13:
                zza((zzjn) zzew.zza(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                zza(zzxm.zzw(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                zza(zzxs.zzy(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 19:
                zza(zzob.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzkeVar = queryLocalInterface3 instanceof zzke ? (zzke) queryLocalInterface3 : new zzkg(readStrongBinder3);
                }
                zza(zzkeVar);
                parcel2.writeNoException();
                break;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzldVar = queryLocalInterface4 instanceof zzld ? (zzld) queryLocalInterface4 : new zzlf(readStrongBinder4);
                }
                zza(zzldVar);
                parcel2.writeNoException();
                break;
            case 22:
                setManualImpressionsEnabled(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 23:
                isReady = isLoading();
                parcel2.writeNoException();
                zzew.zza(parcel2, isReady);
                break;
            case 24:
                zza(zzadq.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                break;
            case 26:
                zzbr = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzbr);
                break;
            case 29:
                zza((zzmr) zzew.zza(parcel, zzmr.CREATOR));
                parcel2.writeNoException();
                break;
            case 30:
                zza((zzlr) zzew.zza(parcel, zzlr.CREATOR));
                parcel2.writeNoException();
                break;
            case 31:
                mediationAdapterClassName = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 32:
                zzbr = zzcd();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzbr);
                break;
            case 33:
                zzbr = zzce();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzbr);
                break;
            case 34:
                setImmersiveMode(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 35:
                mediationAdapterClassName = zzcp();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
        }
        return true;
    }
}
