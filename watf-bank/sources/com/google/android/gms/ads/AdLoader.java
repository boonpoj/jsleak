package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.internal.zzuw;
/* loaded from: classes.dex */
public class AdLoader {
    private final Context mContext;
    private final zzjm zzalp;
    private final zzkk zzalq;

    /* loaded from: classes.dex */
    public static class Builder {
        private final Context mContext;
        private final zzkn zzalr;

        private Builder(Context context, zzkn zzknVar) {
            this.mContext = context;
            this.zzalr = zzknVar;
        }

        public Builder(Context context, String str) {
            this((Context) zzbq.checkNotNull(context, "context cannot be null"), zzkb.zzib().zzb(context, str, new zzuw()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzalr.zzdi());
            } catch (RemoteException e) {
                zzakb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzalr.zza(new zzrk(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzakb.zzc("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzalr.zza(new zzrl(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzakb.zzc("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzalr.zza(str, new zzrn(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzrm(onCustomClickListener));
            } catch (RemoteException e) {
                zzakb.zzc("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzalr.zza(new zzro(onPublisherAdViewLoadedListener), new zzjn(this.mContext, adSizeArr));
            } catch (RemoteException e) {
                zzakb.zzc("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzalr.zzb(new zzjg(adListener));
            } catch (RemoteException e) {
                zzakb.zzc("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(Correlator correlator) {
            zzbq.checkNotNull(correlator);
            try {
                this.zzalr.zzb(correlator.zzbh());
            } catch (RemoteException e) {
                zzakb.zzc("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzalr.zza(new zzpe(nativeAdOptions));
            } catch (RemoteException e) {
                zzakb.zzc("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzalr.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzakb.zzc("Failed to specify DFP banner ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzkk zzkkVar) {
        this(context, zzkkVar, zzjm.zzbej);
    }

    private AdLoader(Context context, zzkk zzkkVar, zzjm zzjmVar) {
        this.mContext = context;
        this.zzalq = zzkkVar;
        this.zzalp = zzjmVar;
    }

    private final void zza(zzlt zzltVar) {
        try {
            this.zzalq.zzd(zzjm.zza(this.mContext, zzltVar));
        } catch (RemoteException e) {
            zzakb.zzb("Failed to load ad.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzalq.zzcp();
        } catch (RemoteException e) {
            zzakb.zzc("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzalq.isLoading();
        } catch (RemoteException e) {
            zzakb.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzbg());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzbg());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzalq.zza(zzjm.zza(this.mContext, adRequest.zzbg()), i);
        } catch (RemoteException e) {
            zzakb.zzb("Failed to load ads.", e);
        }
    }
}
