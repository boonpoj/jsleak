package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzadm extends zzeu implements zzadk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void destroy() throws RemoteException {
        zzb(8, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadk
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(12, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(5, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void pause() throws RemoteException {
        zzb(6, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void resume() throws RemoteException {
        zzb(7, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(34, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void setUserId(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(13, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void show() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zza(zzadp zzadpVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzadpVar);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zza(zzadv zzadvVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzadvVar);
        zzb(1, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(9, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(10, zzbe);
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(11, zzbe);
    }
}
