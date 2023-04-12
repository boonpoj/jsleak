package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzadr extends zzeu implements zzadp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdClosed() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(7, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zzb(6, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zzb(1, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdOpened() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoStarted() throws RemoteException {
        zzb(3, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void zza(zzadh zzadhVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzadhVar);
        zzb(5, zzbe);
    }
}
