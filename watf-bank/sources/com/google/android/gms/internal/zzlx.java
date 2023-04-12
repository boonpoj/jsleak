package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzjr;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzlx {
    private final Context mContext;
    private final zzjm zzalp;
    private AppEventListener zzamt;
    private String zzapq;
    private boolean zzaqg;
    private zzje zzbdd;
    private AdListener zzbde;
    private final zzuw zzbgb;
    private Correlator zzbgf;
    private zzks zzbgg;
    private OnCustomRenderedAdLoadedListener zzbgh;
    private PublisherInterstitialAd zzbgl;
    private boolean zzbgm;
    private RewardedVideoAdListener zzgz;

    public zzlx(Context context) {
        this(context, zzjm.zzbej, null);
    }

    public zzlx(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzjm.zzbej, publisherInterstitialAd);
    }

    private zzlx(Context context, zzjm zzjmVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbgb = new zzuw();
        this.mContext = context;
        this.zzalp = zzjmVar;
        this.zzbgl = publisherInterstitialAd;
    }

    private final void zzak(String str) {
        if (this.zzbgg != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public final AdListener getAdListener() {
        return this.zzbde;
    }

    public final String getAdUnitId() {
        return this.zzapq;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzamt;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbgg != null) {
                return this.zzbgg.zzcp();
            }
            return null;
        } catch (RemoteException e) {
            zzakb.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzbgh;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbgg == null) {
                return false;
            }
            return this.zzbgg.isReady();
        } catch (RemoteException e) {
            zzakb.zzc("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbgg == null) {
                return false;
            }
            return this.zzbgg.isLoading();
        } catch (RemoteException e) {
            zzakb.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzbde = adListener;
            if (this.zzbgg != null) {
                this.zzbgg.zza(adListener != null ? new zzjg(adListener) : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the AdListener.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzapq != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzapq = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzamt = appEventListener;
            if (this.zzbgg != null) {
                this.zzbgg.zza(appEventListener != null ? new zzjp(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the AppEventListener.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.zzbgf = correlator;
        try {
            if (this.zzbgg != null) {
                this.zzbgg.zza(this.zzbgf == null ? null : this.zzbgf.zzbh());
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set correlator.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzaqg = z;
            if (this.zzbgg != null) {
                this.zzbgg.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set immersive mode", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzbgh = onCustomRenderedAdLoadedListener;
            if (this.zzbgg != null) {
                this.zzbgg.zza(onCustomRenderedAdLoadedListener != null ? new zzod(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzgz = rewardedVideoAdListener;
            if (this.zzbgg != null) {
                this.zzbgg.zza(rewardedVideoAdListener != null ? new zzadu(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the AdListener.", e);
        }
    }

    public final void show() {
        try {
            zzak("show");
            this.zzbgg.showInterstitial();
        } catch (RemoteException e) {
            zzakb.zzc("Failed to show interstitial.", e);
        }
    }

    public final void zza(zzje zzjeVar) {
        try {
            this.zzbdd = zzjeVar;
            if (this.zzbgg != null) {
                this.zzbgg.zza(zzjeVar != null ? new zzjf(zzjeVar) : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the AdClickListener.", e);
        }
    }

    public final void zza(zzlt zzltVar) {
        try {
            if (this.zzbgg == null) {
                if (this.zzapq == null) {
                    zzak("loadAd");
                }
                zzjn zzhs = this.zzbgm ? zzjn.zzhs() : new zzjn();
                zzjr zzib = zzkb.zzib();
                Context context = this.mContext;
                this.zzbgg = (zzks) zzjr.zza(context, false, (zzjr.zza<Object>) new zzju(zzib, context, zzhs, this.zzapq, this.zzbgb));
                if (this.zzbde != null) {
                    this.zzbgg.zza(new zzjg(this.zzbde));
                }
                if (this.zzbdd != null) {
                    this.zzbgg.zza(new zzjf(this.zzbdd));
                }
                if (this.zzamt != null) {
                    this.zzbgg.zza(new zzjp(this.zzamt));
                }
                if (this.zzbgh != null) {
                    this.zzbgg.zza(new zzod(this.zzbgh));
                }
                if (this.zzbgf != null) {
                    this.zzbgg.zza(this.zzbgf.zzbh());
                }
                if (this.zzgz != null) {
                    this.zzbgg.zza(new zzadu(this.zzgz));
                }
                this.zzbgg.setImmersiveMode(this.zzaqg);
            }
            if (this.zzbgg.zzb(zzjm.zza(this.mContext, zzltVar))) {
                this.zzbgb.zzn(zzltVar.zzim());
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to load ad.", e);
        }
    }

    public final void zza(boolean z) {
        this.zzbgm = true;
    }
}
