package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzqi;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzqj extends zzev implements zzqi {

    /* loaded from: assets/classes2.dex */
    class zza {
        public final zzqi.zzc<T> zzYv;
        public final zzqi.zza zzYw;

        public zza(zzqj zzqjVar, zzqi.zzc<T> zzcVar, zzqi.zza zzaVar) {
            this.zzYv = zzcVar;
            this.zzYw = zzaVar;
        }
    }

    public zzqj() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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
                zzjt = zzjz();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 7:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 8:
                headline = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzew.zzb(parcel2, extras);
                break;
            case 10:
                destroy();
                parcel2.writeNoException();
                break;
            case 11:
                zzjt = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 12:
                performClick((Bundle) zzew.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                boolean recordImpression = recordImpression((Bundle) zzew.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzew.zza(parcel2, recordImpression);
                break;
            case 14:
                reportTouchEvent((Bundle) zzew.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                zzjt = zzjy();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 16:
                zzjt = zzjx();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzjt);
                break;
            case 17:
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
