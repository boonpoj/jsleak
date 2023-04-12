package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes.dex */
public abstract class zzvn extends zzev implements zzvm {
    public zzvn() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String headline;
        IInterface zzjz;
        boolean overrideImpressionRecording;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 4:
                headline = getBody();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 5:
                zzjz = zzjz();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjz);
                break;
            case 6:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 7:
                headline = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 8:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 9:
                zzh(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                zzi(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzew.zza(parcel2, overrideImpressionRecording);
                break;
            case 12:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                zzew.zza(parcel2, overrideImpressionRecording);
                break;
            case 13:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzew.zzb(parcel2, extras);
                break;
            case 14:
                zzj(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                zzjz = zzmk();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjz);
                break;
            case 16:
                zzjz = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjz);
                break;
            case 17:
            case 18:
            default:
                return false;
            case 19:
                zzjz = zzjy();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjz);
                break;
            case 20:
                zzjz = zzml();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjz);
                break;
            case 21:
                zzjz = zzjx();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjz);
                break;
        }
        return true;
    }
}
