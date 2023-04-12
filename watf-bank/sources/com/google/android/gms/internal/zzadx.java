package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
@zzzv
/* loaded from: classes.dex */
public final class zzadx implements RewardedVideoAd {
    private final Context mContext;
    private final Object mLock = new Object();
    private String zzauv;
    private final zzadk zzcve;
    private RewardedVideoAdListener zzgz;

    public zzadx(Context context, zzadk zzadkVar) {
        this.zzcve = zzadkVar;
        this.mContext = context;
    }

    private final void zza(String str, zzlt zzltVar) {
        synchronized (this.mLock) {
            if (this.zzcve == null) {
                return;
            }
            try {
                this.zzcve.zza(new zzadv(zzjm.zza(this.mContext, zzltVar), str));
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.mLock) {
            if (this.zzcve == null) {
                return;
            }
            try {
                this.zzcve.zzd(com.google.android.gms.dynamic.zzn.zzz(context));
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.zzcve != null) {
                return this.zzcve.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzakb.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.mLock) {
            rewardedVideoAdListener = this.zzgz;
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzauv;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.mLock) {
            if (this.zzcve == null) {
                return false;
            }
            try {
                return this.zzcve.isLoaded();
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward isLoaded to RewardedVideoAd", e);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzbg());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzbg());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.mLock) {
            if (this.zzcve == null) {
                return;
            }
            try {
                this.zzcve.zzb(com.google.android.gms.dynamic.zzn.zzz(context));
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.mLock) {
            if (this.zzcve == null) {
                return;
            }
            try {
                this.zzcve.zzc(com.google.android.gms.dynamic.zzn.zzz(context));
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcve != null) {
                try {
                    this.zzcve.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzakb.zzc("Could not forward setImmersiveMode to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.mLock) {
            this.zzgz = rewardedVideoAdListener;
            if (this.zzcve != null) {
                try {
                    this.zzcve.zza(new zzadu(rewardedVideoAdListener));
                } catch (RemoteException e) {
                    zzakb.zzc("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzauv = str;
            if (this.zzcve != null) {
                try {
                    this.zzcve.setUserId(str);
                } catch (RemoteException e) {
                    zzakb.zzc("Could not forward setUserId to RewardedVideoAd", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.mLock) {
            if (this.zzcve == null) {
                return;
            }
            try {
                this.zzcve.show();
            } catch (RemoteException e) {
                zzakb.zzc("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
