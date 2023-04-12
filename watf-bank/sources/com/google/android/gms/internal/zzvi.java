package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzvi extends zzeu implements zzvg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    @Override // com.google.android.gms.internal.zzvg
    public final int zzmc() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
