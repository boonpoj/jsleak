package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzjh extends com.google.android.gms.dynamic.zzp<zzkq> {
    public zzjh() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzkn zza(Context context, String str, zzux zzuxVar) {
        try {
            IBinder zza = zzde(context).zza(com.google.android.gms.dynamic.zzn.zzz(context), str, zzuxVar, 11910000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new zzkp(zza);
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzakb.zzc("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzkq zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof zzkq ? (zzkq) queryLocalInterface : new zzkr(iBinder);
    }
}
