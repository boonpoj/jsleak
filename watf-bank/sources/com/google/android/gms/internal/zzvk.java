package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes.dex */
public abstract class zzvk extends zzev implements zzvj {
    public zzvk() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String headline;
        IInterface zzjs;
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
                zzjs = zzjs();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjs);
                break;
            case 6:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 7:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                break;
            case 8:
                headline = getStore();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 9:
                headline = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 11:
                zzh(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                zzi(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 13:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzew.zza(parcel2, overrideImpressionRecording);
                break;
            case 14:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                zzew.zza(parcel2, overrideImpressionRecording);
                break;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzew.zzb(parcel2, extras);
                break;
            case 16:
                zzj(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 17:
                zzjs = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjs);
                break;
            case 18:
                zzjs = zzmk();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjs);
                break;
            case 19:
                zzjs = zzjy();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjs);
                break;
            case 20:
                zzjs = zzml();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjs);
                break;
            case 21:
                zzjs = zzjx();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjs);
                break;
            default:
                return false;
        }
        return true;
    }
}
