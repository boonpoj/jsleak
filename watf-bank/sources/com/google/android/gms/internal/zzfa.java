package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
@zzmb
/* loaded from: assets/classes2.dex */
public class zzfa {
    private final Context mContext;
    private InAppPurchaseListener zzAa;
    private OnCustomRenderedAdLoadedListener zzAb;
    private PlayStorePurchaseListener zzAc;
    private String zzAd;
    private PublisherInterstitialAd zzAh;
    private boolean zzAi;
    private RewardedVideoAdListener zzcI;
    private final zzeb zzrB;
    private String zztq;
    private zzdt zzyD;
    private AdListener zzyE;
    private final zzjr zzzU;
    private Correlator zzzY;
    private zzep zzzZ;
    private AppEventListener zzzq;

    public zzfa(Context context) {
        this(context, zzeb.zzey(), null);
    }

    public zzfa(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzeb.zzey(), publisherInterstitialAd);
    }

    public zzfa(Context context, zzeb zzebVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzzU = new zzjr();
        this.mContext = context;
        this.zzrB = zzebVar;
        this.zzAh = publisherInterstitialAd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.google.android.gms.internal.zzdv, com.google.android.gms.internal.zzel] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.zznt, com.google.android.gms.internal.zznw] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.gms.internal.zzgk, com.google.android.gms.internal.zzgj] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.internal.zzld, com.google.android.gms.internal.zzli] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.zzkz, com.google.android.gms.internal.zzle] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.internal.zzee, com.google.android.gms.internal.zzer] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.android.gms.internal.zzdu, com.google.android.gms.internal.zzek] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.internal.zzjr, com.google.android.gms.internal.zzjs] */
    private void zzS(String str) throws RemoteException {
        if (this.zztq == null) {
            zzT(str);
        }
        this.zzzZ = zzeh.zzeP().zzb(this.mContext, this.zzAi ? zzec.zzez() : new zzec(), this.zztq, this.zzzU);
        if (this.zzyE != null) {
            this.zzzZ.zza(new zzdv(this.zzyE));
        }
        if (this.zzyD != null) {
            this.zzzZ.zza(new zzdu(this.zzyD));
        }
        if (this.zzzq != null) {
            this.zzzZ.zza(new zzee(this.zzzq));
        }
        if (this.zzAa != null) {
            this.zzzZ.zza(new zzle(this.zzAa));
        }
        if (this.zzAc != null) {
            this.zzzZ.zza(new zzli(this.zzAc), this.zzAd);
        }
        if (this.zzAb != null) {
            this.zzzZ.zza(new zzgk(this.zzAb));
        }
        if (this.zzzY != null) {
            this.zzzZ.zza(this.zzzY.zzbr());
        }
        if (this.zzcI != null) {
            this.zzzZ.zza(new zznw(this.zzcI));
        }
    }

    private void zzT(String str) {
        if (this.zzzZ != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public AdListener getAdListener() {
        return this.zzyE;
    }

    public String getAdUnitId() {
        return this.zztq;
    }

    public AppEventListener getAppEventListener() {
        return this.zzzq;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzAa;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzzZ != null) {
                return this.zzzZ.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzpy.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzAb;
    }

    public boolean isLoaded() {
        try {
            if (this.zzzZ == null) {
                return false;
            }
            return this.zzzZ.isReady();
        } catch (RemoteException e) {
            zzpy.zzc("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public boolean isLoading() {
        try {
            if (this.zzzZ == null) {
                return false;
            }
            return this.zzzZ.isLoading();
        } catch (RemoteException e) {
            zzpy.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzdv] */
    public void setAdListener(AdListener adListener) {
        try {
            this.zzyE = adListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(adListener != null ? new zzdv(adListener) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        if (this.zztq != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zztq = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzee] */
    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzzq = appEventListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(appEventListener != null ? new zzee(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.zzzY = correlator;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(this.zzzY == null ? null : this.zzzY.zzbr());
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set correlator.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzle] */
    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzAc != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzAa = inAppPurchaseListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(inAppPurchaseListener != null ? new zzle(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the InAppPurchaseListener.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzgk] */
    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzAb = onCustomRenderedAdLoadedListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(onCustomRenderedAdLoadedListener != null ? new zzgk(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzli] */
    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzAa != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzAc = playStorePurchaseListener;
            this.zzAd = str;
            if (this.zzzZ != null) {
                this.zzzZ.zza(playStorePurchaseListener != null ? new zzli(playStorePurchaseListener) : null, str);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the play store purchase parameter.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zznw] */
    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzcI = rewardedVideoAdListener;
            if (this.zzzZ != null) {
                this.zzzZ.zza(rewardedVideoAdListener != null ? new zznw(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the AdListener.", e);
        }
    }

    public void show() {
        try {
            zzT("show");
            this.zzzZ.showInterstitial();
        } catch (RemoteException e) {
            zzpy.zzc("Failed to show interstitial.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzdu] */
    public void zza(zzdt zzdtVar) {
        try {
            this.zzyD = zzdtVar;
            if (this.zzzZ != null) {
                this.zzzZ.zza(zzdtVar != null ? new zzdu(zzdtVar) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzey zzeyVar) {
        try {
            if (this.zzzZ == null) {
                zzS("loadAd");
            }
            if (this.zzzZ.zzb(this.zzrB.zza(this.mContext, zzeyVar))) {
                this.zzzU.zzi(zzeyVar.zzeY());
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to load ad.", e);
        }
    }

    public void zzd(boolean z) {
        this.zzAi = z;
    }
}
