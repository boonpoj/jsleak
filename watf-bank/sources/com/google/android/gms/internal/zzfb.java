package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
@zzmb
/* loaded from: assets/classes2.dex */
public class zzfb {
    private static zzfb zzAj;
    private static final Object zztU = new Object();
    private zzeu zzAk;
    private RewardedVideoAd zzAl;

    private zzfb() {
    }

    public static zzfb zzff() {
        zzfb zzfbVar;
        synchronized (zztU) {
            if (zzAj == null) {
                zzAj = new zzfb();
            }
            zzfbVar = zzAj;
        }
        return zzfbVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.zzjr, com.google.android.gms.internal.zzjs] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.gms.internal.zznz, com.google.android.gms.ads.reward.RewardedVideoAd] */
    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (zztU) {
            if (this.zzAl != null) {
                return this.zzAl;
            }
            this.zzAl = new zznz(context, zzeh.zzeP().zza(context, new zzjr()));
            return this.zzAl;
        }
    }

    public void openDebugMenu(Context context, String str) {
        com.google.android.gms.common.internal.zzac.zza(this.zzAk != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzAk.zzb(com.google.android.gms.dynamic.zze.zzA(context), str);
        } catch (RemoteException e) {
            zzpy.zzb("Unable to open debug menu.", e);
        }
    }

    public void setAppMuted(boolean z) {
        com.google.android.gms.common.internal.zzac.zza(this.zzAk != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzAk.setAppMuted(z);
        } catch (RemoteException e) {
            zzpy.zzb("Unable to set app mute state.", e);
        }
    }

    public void setAppVolume(float f) {
        com.google.android.gms.common.internal.zzac.zzb(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        com.google.android.gms.common.internal.zzac.zza(this.zzAk != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzAk.setAppVolume(f);
        } catch (RemoteException e) {
            zzpy.zzb("Unable to set app volume.", e);
        }
    }

    public void zza(Context context, String str, zzfc zzfcVar) {
        synchronized (zztU) {
            if (this.zzAk != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                this.zzAk = zzeh.zzeP().zzk(context);
                this.zzAk.initialize();
                if (str != null) {
                    this.zzAk.zzy(str);
                }
            } catch (RemoteException e) {
                zzpy.zzc("Fail to initialize or set applicationCode on mobile ads setting manager", e);
            }
        }
    }
}
