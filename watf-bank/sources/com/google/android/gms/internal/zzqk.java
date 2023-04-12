package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzqk extends zzeu implements zzqi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.zzqi
    public final void destroy() throws RemoteException {
        zzb(10, zzbe());
    }

    @Override // com.google.android.gms.internal.zzqi
    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final String getBody() throws RemoteException {
        Parcel zza = zza(5, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(9, zzbe());
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqi, com.google.android.gms.internal.zzov
    public final List getImages() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        ArrayList zzb = zzew.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(17, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final zzll getVideoController() throws RemoteException {
        Parcel zza = zza(11, zzbe());
        zzll zzh = zzlm.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, bundle);
        zzb(12, zzbe);
    }

    @Override // com.google.android.gms.internal.zzqi
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, bundle);
        Parcel zza = zza(13, zzbe);
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, bundle);
        zzb(14, zzbe);
    }

    @Override // com.google.android.gms.internal.zzqi
    public final IObjectWrapper zzjt() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final IObjectWrapper zzjx() throws RemoteException {
        Parcel zza = zza(16, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final zzpm zzjy() throws RemoteException {
        zzpm zzpoVar;
        Parcel zza = zza(15, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzpoVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzpoVar = queryLocalInterface instanceof zzpm ? (zzpm) queryLocalInterface : new zzpo(readStrongBinder);
        }
        zza.recycle();
        return zzpoVar;
    }

    @Override // com.google.android.gms.internal.zzqi
    public final zzpq zzjz() throws RemoteException {
        zzpq zzpsVar;
        Parcel zza = zza(6, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzpsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzpsVar = queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(readStrongBinder);
        }
        zza.recycle();
        return zzpsVar;
    }
}
