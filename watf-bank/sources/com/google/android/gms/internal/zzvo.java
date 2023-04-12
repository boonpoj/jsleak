package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class zzvo extends zzeu implements zzvm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getBody() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(13, zzbe());
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final List getImages() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        ArrayList zzb = zzew.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(12, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(11, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzll getVideoController() throws RemoteException {
        Parcel zza = zza(16, zzbe());
        zzll zzh = zzlm.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void recordImpression() throws RemoteException {
        zzb(8, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(9, zzbe);
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(10, zzbe);
    }

    @Override // com.google.android.gms.internal.zzvm
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(14, zzbe);
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzjx() throws RemoteException {
        Parcel zza = zza(21, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzpm zzjy() throws RemoteException {
        Parcel zza = zza(19, zzbe());
        zzpm zzj = zzpn.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final zzpq zzjz() throws RemoteException {
        Parcel zza = zza(5, zzbe());
        zzpq zzk = zzpr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzmk() throws RemoteException {
        Parcel zza = zza(15, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzvm
    public final IObjectWrapper zzml() throws RemoteException {
        Parcel zza = zza(20, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }
}
