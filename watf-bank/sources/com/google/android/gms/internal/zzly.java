package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzjr;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzly {
    private static final Object sLock = new Object();
    private static zzly zzbgn;
    private zzlg zzbgo;
    private RewardedVideoAd zzbgp;

    private zzly() {
    }

    public static zzly zziq() {
        zzly zzlyVar;
        synchronized (sLock) {
            if (zzbgn == null) {
                zzbgn = new zzly();
            }
            zzlyVar = zzbgn;
        }
        return zzlyVar;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (sLock) {
            if (this.zzbgp != null) {
                return this.zzbgp;
            }
            this.zzbgp = new zzadx(context, (zzadk) zzjr.zza(context, false, (zzjr.zza<Object>) new zzjz(zzkb.zzib(), context, new zzuw())));
            return this.zzbgp;
        }
    }

    public final void openDebugMenu(Context context, String str) {
        com.google.android.gms.common.internal.zzbq.zza(this.zzbgo != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzbgo.zzb(com.google.android.gms.dynamic.zzn.zzz(context), str);
        } catch (RemoteException e) {
            zzakb.zzb("Unable to open debug menu.", e);
        }
    }

    public final void setAppMuted(boolean z) {
        com.google.android.gms.common.internal.zzbq.zza(this.zzbgo != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.zzbgo.setAppMuted(z);
        } catch (RemoteException e) {
            zzakb.zzb("Unable to set app mute state.", e);
        }
    }

    public final void setAppVolume(float f) {
        com.google.android.gms.common.internal.zzbq.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        com.google.android.gms.common.internal.zzbq.zza(this.zzbgo != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzbgo.setAppVolume(f);
        } catch (RemoteException e) {
            zzakb.zzb("Unable to set app volume.", e);
        }
    }

    public final void zza(Context context, String str, zzma zzmaVar) {
        synchronized (sLock) {
            if (this.zzbgo != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                this.zzbgo = (zzlg) zzjr.zza(context, false, (zzjr.zza<Object>) new zzjw(zzkb.zzib(), context));
                this.zzbgo.initialize();
                if (str != null) {
                    this.zzbgo.zza(str, com.google.android.gms.dynamic.zzn.zzz(new zzlz(this, context)));
                }
            } catch (RemoteException e) {
                zzakb.zzc("MobileAdsSettingManager initialization failed", e);
            }
        }
    }

    public final float zzdn() {
        zzlg zzlgVar = this.zzbgo;
        if (zzlgVar == null) {
            return 1.0f;
        }
        try {
            return zzlgVar.zzdn();
        } catch (RemoteException e) {
            zzakb.zzb("Unable to get app volume.", e);
            return 1.0f;
        }
    }

    public final boolean zzdo() {
        zzlg zzlgVar = this.zzbgo;
        if (zzlgVar == null) {
            return false;
        }
        try {
            return zzlgVar.zzdo();
        } catch (RemoteException e) {
            zzakb.zzb("Unable to get app mute state.", e);
            return false;
        }
    }
}
