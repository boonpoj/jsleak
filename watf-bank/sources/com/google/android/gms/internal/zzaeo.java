package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzaeo extends zzeu implements zzaem {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zza(IObjectWrapper iObjectWrapper, zzaeq zzaeqVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzaeqVar);
        zzb(7, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzc(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeInt(i);
        zzb(2, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeInt(i);
        zzb(9, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(1, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(4, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(6, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(8, zzbe);
    }

    @Override // com.google.android.gms.internal.zzaem
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(10, zzbe);
    }
}
