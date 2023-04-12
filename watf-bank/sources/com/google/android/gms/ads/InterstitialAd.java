package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzlx;
/* loaded from: classes.dex */
public final class InterstitialAd {
    private final zzlx zzama;

    public InterstitialAd(Context context) {
        this.zzama = new zzlx(context);
        zzbq.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzama.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzama.getAdUnitId();
    }

    public final String getMediationAdapterClassName() {
        return this.zzama.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        return this.zzama.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzama.isLoading();
    }

    public final void loadAd(AdRequest adRequest) {
        this.zzama.zza(adRequest.zzbg());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzama.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzje)) {
            this.zzama.zza((zzje) adListener);
        } else if (adListener == null) {
            this.zzama.zza((zzje) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzama.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzama.setImmersiveMode(z);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzama.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzama.show();
    }

    public final void zza(boolean z) {
        this.zzama.zza(true);
    }
}
