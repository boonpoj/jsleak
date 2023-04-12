package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzv
/* loaded from: classes.dex */
public final class zzadt extends com.google.android.gms.dynamic.zzp<zzadn> {
    public zzadt() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzadk zza(Context context, zzux zzuxVar) {
        try {
            IBinder zza = zzde(context).zza(com.google.android.gms.dynamic.zzn.zzz(context), zzuxVar, 11910000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            return queryLocalInterface instanceof zzadk ? (zzadk) queryLocalInterface : new zzadm(zza);
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzakb.zzc("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzadn zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return queryLocalInterface instanceof zzadn ? (zzadn) queryLocalInterface : new zzado(iBinder);
    }
}
