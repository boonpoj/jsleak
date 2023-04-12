package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
@zzzv
/* loaded from: classes.dex */
public final class zzmb extends com.google.android.gms.dynamic.zzp<zzlj> {
    public zzmb() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.zzp
    protected final /* synthetic */ zzlj zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof zzlj ? (zzlj) queryLocalInterface : new zzlk(iBinder);
    }

    public final zzlg zzg(Context context) {
        try {
            IBinder zza = zzde(context).zza(com.google.android.gms.dynamic.zzn.zzz(context), 11910000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return queryLocalInterface instanceof zzlg ? (zzlg) queryLocalInterface : new zzli(zza);
        } catch (RemoteException e) {
            zzakb.zzc("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (com.google.android.gms.dynamic.zzq e2) {
            zzakb.zzc("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
