package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
@zzzv
/* loaded from: classes.dex */
public final class zzaep implements MediationRewardedVideoAdListener {
    private final zzaem zzcwc;

    public zzaep(zzaem zzaemVar) {
        this.zzcwc = zzaemVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClicked must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClicked.");
        try {
            this.zzcwc.zzr(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClosed must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClosed.");
        try {
            this.zzcwc.zzq(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdFailedToLoad must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdFailedToLoad.");
        try {
            this.zzcwc.zzd(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLeftApplication must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLeftApplication.");
        try {
            this.zzcwc.zzs(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLoaded must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLoaded.");
        try {
            this.zzcwc.zzn(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdOpened must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdOpened.");
        try {
            this.zzcwc.zzo(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        com.google.android.gms.common.internal.zzbq.zzge("onInitializationFailed must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onInitializationFailed.");
        try {
            this.zzcwc.zzc(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onInitializationFailed.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onInitializationSucceeded must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onInitializationSucceeded.");
        try {
            this.zzcwc.zzm(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onInitializationSucceeded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        com.google.android.gms.common.internal.zzbq.zzge("onRewarded must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.zzcwc.zza(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter), new zzaeq(rewardItem));
            } else {
                this.zzcwc.zza(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter), new zzaeq("", 1));
            }
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onRewarded.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onVideoStarted must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onVideoStarted.");
        try {
            this.zzcwc.zzp(com.google.android.gms.dynamic.zzn.zzz(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onVideoStarted.", e);
        }
    }
}
