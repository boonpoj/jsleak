package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zznz extends zzeu implements zznx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zznz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.zznx
    public final String getContent() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zznx
    public final void recordClick() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zznx
    public final void recordImpression() throws RemoteException {
        zzb(5, zzbe());
    }

    @Override // com.google.android.gms.internal.zznx
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zznx
    public final String zzjj() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
