package com.google.android.gms.internal;

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
public final class zzqo extends zzeu implements zzqm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.zzqm
    public final void destroy() throws RemoteException {
        zzb(8, zzbe());
    }

    @Override // com.google.android.gms.internal.zzqm
    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        ArrayList<String> createStringArrayList = zza.createStringArrayList();
        zza.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.zzqm, com.google.android.gms.internal.zzou
    public final String getCustomTemplateId() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final zzll getVideoController() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        zzll zzh = zzlm.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final void performClick(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzqm
    public final void recordImpression() throws RemoteException {
        zzb(6, zzbe());
    }

    @Override // com.google.android.gms.internal.zzqm
    public final String zzap(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        Parcel zza = zza(1, zzbe);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final zzpq zzaq(String str) throws RemoteException {
        zzpq zzpsVar;
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        Parcel zza = zza(2, zzbe);
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

    @Override // com.google.android.gms.internal.zzqm
    public final boolean zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        Parcel zza = zza(10, zzbe);
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final IObjectWrapper zzjt() throws RemoteException {
        Parcel zza = zza(11, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzqm
    public final IObjectWrapper zzka() throws RemoteException {
        Parcel zza = zza(9, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }
}
