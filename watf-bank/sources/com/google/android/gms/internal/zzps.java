package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzps extends zzeu implements zzpq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.zzpq
    public final double getScale() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.zzpq
    public final Uri getUri() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        Uri uri = (Uri) zzew.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.zzpq
    public final IObjectWrapper zzjr() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }
}
