package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzev;
@zzmb
/* loaded from: assets/classes2.dex */
public class zzfd extends com.google.android.gms.dynamic.zzg<zzev> {
    public zzfd() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public zzeu zzl(Context context) {
        try {
            return zzeu.zza.zzu(((zzev) zzaT(context)).zza(com.google.android.gms.dynamic.zze.zzA(context), 10084000));
        } catch (RemoteException | zzg.zza e) {
            zzpy.zzc("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: zzy */
    public zzev zzc(IBinder iBinder) {
        return zzev.zza.zzv(iBinder);
    }
}
