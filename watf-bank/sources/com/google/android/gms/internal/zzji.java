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
public final class zzji extends com.google.android.gms.dynamic.zzp<zzkv> {
    public zzji() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzks zza(Context context, zzjn zzjnVar, String str, zzux zzuxVar, int i) {
        try {
            IBinder zza = zzde(context).zza(com.google.android.gms.dynamic.zzn.zzz(context), zzjnVar, str, zzuxVar, 11910000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(zza);
        } catch (RemoteException | com.google.android.gms.dynamic.zzq e) {
            zzakb.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzkv zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzkv ? (zzkv) queryLocalInterface : new zzkw(iBinder);
    }
}
