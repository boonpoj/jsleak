package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
@zzzv
/* loaded from: classes.dex */
public final class zzvs implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzvd zzcfp;
    private NativeAdMapper zzcfq;
    private NativeCustomTemplateAd zzcfr;

    public zzvs(zzvd zzvdVar) {
        this.zzcfp = zzvdVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClicked must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClicked.");
        try {
            this.zzcfp.onAdClicked();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClicked must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClicked.");
        try {
            this.zzcfp.onAdClicked();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClicked must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzcfq;
        if (this.zzcfr == null) {
            if (nativeAdMapper == null) {
                zzakb.zzcu("Could not call onAdClicked since NativeAdMapper is null.");
                return;
            } else if (!nativeAdMapper.getOverrideClickHandling()) {
                zzakb.zzbx("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzakb.zzbx("Adapter called onAdClicked.");
        try {
            this.zzcfp.onAdClicked();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClosed must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClosed.");
        try {
            this.zzcfp.onAdClosed();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClosed must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClosed.");
        try {
            this.zzcfp.onAdClosed();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdClosed must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdClosed.");
        try {
            this.zzcfp.onAdClosed();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdFailedToLoad must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        zzakb.zzbx(sb.toString());
        try {
            this.zzcfp.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdFailedToLoad must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzakb.zzbx(sb.toString());
        try {
            this.zzcfp.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdFailedToLoad must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzakb.zzbx(sb.toString());
        try {
            this.zzcfp.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdImpression must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzcfq;
        if (this.zzcfr == null) {
            if (nativeAdMapper == null) {
                zzakb.zzcu("Could not call onAdImpression since NativeAdMapper is null. ");
                return;
            } else if (!nativeAdMapper.getOverrideImpressionRecording()) {
                zzakb.zzbx("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzakb.zzbx("Adapter called onAdImpression.");
        try {
            this.zzcfp.onAdImpression();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdImpression.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLeftApplication must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLeftApplication.");
        try {
            this.zzcfp.onAdLeftApplication();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLeftApplication must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLeftApplication.");
        try {
            this.zzcfp.onAdLeftApplication();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLeftApplication must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLeftApplication.");
        try {
            this.zzcfp.onAdLeftApplication();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLoaded must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLoaded.");
        try {
            this.zzcfp.onAdLoaded();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLoaded must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLoaded.");
        try {
            this.zzcfp.onAdLoaded();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLoaded must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdLoaded.");
        this.zzcfq = nativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter) && nativeAdMapper.hasVideoContent()) {
            VideoController videoController = new VideoController();
            videoController.zza(new zzvp());
            this.zzcfq.zza(videoController);
        }
        try {
            this.zzcfp.onAdLoaded();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdOpened must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdOpened.");
        try {
            this.zzcfp.onAdOpened();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdOpened must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdOpened.");
        try {
            this.zzcfp.onAdOpened();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdOpened must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAdOpened.");
        try {
            this.zzcfp.onAdOpened();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        com.google.android.gms.common.internal.zzbq.zzge("onVideoEnd must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onVideoEnd.");
        try {
            this.zzcfp.onVideoEnd();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onVideoEnd.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        com.google.android.gms.common.internal.zzbq.zzge("onAppEvent must be called on the main UI thread.");
        zzakb.zzbx("Adapter called onAppEvent.");
        try {
            this.zzcfp.onAppEvent(str, str2);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAppEvent.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        com.google.android.gms.common.internal.zzbq.zzge("onAdLoaded must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        zzakb.zzbx(valueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(valueOf) : new String("Adapter called onAdLoaded with template id "));
        this.zzcfr = nativeCustomTemplateAd;
        try {
            this.zzcfp.onAdLoaded();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (!(nativeCustomTemplateAd instanceof zzqp)) {
            zzakb.zzcu("Unexpected native custom template ad type.");
            return;
        }
        try {
            this.zzcfp.zzb(((zzqp) nativeCustomTemplateAd).zzkm(), str);
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onCustomClick.", e);
        }
    }

    public final NativeAdMapper zzmm() {
        return this.zzcfq;
    }

    public final NativeCustomTemplateAd zzmn() {
        return this.zzcfr;
    }
}
