package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzrw extends zzeu implements zzrv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.zzrv
    public final ParcelFileDescriptor zza(zzrr zzrrVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzrrVar);
        Parcel zza = zza(1, zzbe);
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzew.zza(zza, ParcelFileDescriptor.CREATOR);
        zza.recycle();
        return parcelFileDescriptor;
    }
}
