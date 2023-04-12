package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzadj extends zzeu implements zzadh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.zzadh
    public final int getAmount() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.zzadh
    public final String getType() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
