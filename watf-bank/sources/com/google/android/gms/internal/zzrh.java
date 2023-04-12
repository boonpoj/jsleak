package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzrh extends zzeu implements zzrf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzrf
    public final void zza(zzks zzksVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzksVar);
        zzew.zza(zzbe, iObjectWrapper);
        zzb(1, zzbe);
    }
}
