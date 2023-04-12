package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
@zzzv
/* loaded from: classes.dex */
public final class zzvx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzvd zzcfp;

    public zzvx(zzvd zzvdVar) {
        this.zzcfp = zzvdVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzakb.zzbx("Adapter called onClick.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onClick must be called on the main UI thread.");
            zzajr.zzajw.post(new zzvy(this));
            return;
        }
        try {
            this.zzcfp.onAdClicked();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClicked.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzakb.zzbx("Adapter called onDismissScreen.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onDismissScreen must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwb(this));
            return;
        }
        try {
            this.zzcfp.onAdClosed();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzakb.zzbx("Adapter called onDismissScreen.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onDismissScreen must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwg(this));
            return;
        }
        try {
            this.zzcfp.onAdClosed();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdClosed.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzakb.zzbx(sb.toString());
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onFailedToReceiveAd must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwc(this, errorCode));
            return;
        }
        try {
            this.zzcfp.onAdFailedToLoad(zzwj.zza(errorCode));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzakb.zzbx(sb.toString());
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onFailedToReceiveAd must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwh(this, errorCode));
            return;
        }
        try {
            this.zzcfp.onAdFailedToLoad(zzwj.zza(errorCode));
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdFailedToLoad.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzakb.zzbx("Adapter called onLeaveApplication.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onLeaveApplication must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwd(this));
            return;
        }
        try {
            this.zzcfp.onAdLeftApplication();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzakb.zzbx("Adapter called onLeaveApplication.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onLeaveApplication must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwi(this));
            return;
        }
        try {
            this.zzcfp.onAdLeftApplication();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLeftApplication.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzakb.zzbx("Adapter called onPresentScreen.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onPresentScreen must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwe(this));
            return;
        }
        try {
            this.zzcfp.onAdOpened();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzakb.zzbx("Adapter called onPresentScreen.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onPresentScreen must be called on the main UI thread.");
            zzajr.zzajw.post(new zzvz(this));
            return;
        }
        try {
            this.zzcfp.onAdOpened();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdOpened.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzakb.zzbx("Adapter called onReceivedAd.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onReceivedAd must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwf(this));
            return;
        }
        try {
            this.zzcfp.onAdLoaded();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzakb.zzbx("Adapter called onReceivedAd.");
        zzkb.zzia();
        if (!zzajr.zzqz()) {
            zzakb.zzcu("onReceivedAd must be called on the main UI thread.");
            zzajr.zzajw.post(new zzwa(this));
            return;
        }
        try {
            this.zzcfp.onAdLoaded();
        } catch (RemoteException e) {
            zzakb.zzc("Could not call onAdLoaded.", e);
        }
    }
}
