package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzqn extends zzev implements zzqm {
    public zzqn() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzqm zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return queryLocalInterface instanceof zzqm ? (zzqm) queryLocalInterface : new zzqo(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String zzap;
        IInterface zzaq;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzap = zzap(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzap);
                break;
            case 2:
                zzaq = zzaq(parcel.readString());
                parcel2.writeNoException();
                zzew.zza(parcel2, zzaq);
                break;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                break;
            case 4:
                zzap = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(zzap);
                break;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 7:
                zzaq = getVideoController();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzaq);
                break;
            case 8:
                destroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzaq = zzka();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzaq);
                break;
            case 10:
                boolean zzf = zzf(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzew.zza(parcel2, zzf);
                break;
            case 11:
                zzaq = zzjt();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzaq);
                break;
            default:
                return false;
        }
        return true;
    }
}
