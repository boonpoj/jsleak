package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzlf extends zzeu implements zzld {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    @Override // com.google.android.gms.internal.zzld
    public final long getValue() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }
}
