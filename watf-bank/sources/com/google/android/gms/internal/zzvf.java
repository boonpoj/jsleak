package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzvf extends zzeu implements zzvd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdClicked() throws RemoteException {
        zzb(1, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdClosed() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdImpression() throws RemoteException {
        zzb(8, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdLeftApplication() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdLoaded() throws RemoteException {
        zzb(6, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAdOpened() throws RemoteException {
        zzb(5, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzb(9, zzbe);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void onVideoEnd() throws RemoteException {
        zzb(11, zzbe());
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zza(zzvg zzvgVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzvgVar);
        zzb(7, zzbe);
    }

    @Override // com.google.android.gms.internal.zzvd
    public final void zzb(zzqm zzqmVar, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqmVar);
        zzbe.writeString(str);
        zzb(10, zzbe);
    }
}
