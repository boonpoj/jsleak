package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzqf extends zzev implements zzqe {
    public zzqf() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface zzjt;
        String headline;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                zzjt = zzjt();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 3:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 5:
                headline = getBody();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 6:
                zzjt = zzjs();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 7:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                break;
            case 9:
                headline = getStore();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 10:
                headline = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 11:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzew.zzb(parcel2, extras);
                break;
            case 12:
                destroy();
                parcel2.writeNoException();
                break;
            case 13:
                zzjt = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 14:
                performClick((Bundle) zzew.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                boolean recordImpression = recordImpression((Bundle) zzew.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzew.zza(parcel2, recordImpression);
                break;
            case 16:
                reportTouchEvent((Bundle) zzew.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 17:
                zzjt = zzjy();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 18:
                zzjt = zzjx();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 19:
                headline = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            default:
                return false;
        }
        return true;
    }
}
