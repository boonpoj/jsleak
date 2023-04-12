package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.internal.zzakb;
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    private CustomEventBanner zzdny;
    private CustomEventInterstitial zzdnz;
    private CustomEventNative zzdoa;
    private View zzhm;

    /* loaded from: classes.dex */
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzdob;
        private final MediationBannerListener zzhe;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzdob = customEventAdapter;
            this.zzhe = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzakb.zzbx("Custom event adapter called onAdClicked.");
            this.zzhe.onAdClicked(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzakb.zzbx("Custom event adapter called onAdClosed.");
            this.zzhe.onAdClosed(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzakb.zzbx("Custom event adapter called onAdFailedToLoad.");
            this.zzhe.onAdFailedToLoad(this.zzdob, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzakb.zzbx("Custom event adapter called onAdLeftApplication.");
            this.zzhe.onAdLeftApplication(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzakb.zzbx("Custom event adapter called onAdLoaded.");
            this.zzdob.zza(view);
            this.zzhe.onAdLoaded(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzakb.zzbx("Custom event adapter called onAdOpened.");
            this.zzhe.onAdOpened(this.zzdob);
        }
    }

    /* loaded from: classes.dex */
    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzdob;
        private final MediationInterstitialListener zzhf;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzdob = customEventAdapter;
            this.zzhf = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzakb.zzbx("Custom event adapter called onAdClicked.");
            this.zzhf.onAdClicked(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzakb.zzbx("Custom event adapter called onAdClosed.");
            this.zzhf.onAdClosed(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzakb.zzbx("Custom event adapter called onFailedToReceiveAd.");
            this.zzhf.onAdFailedToLoad(this.zzdob, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzakb.zzbx("Custom event adapter called onAdLeftApplication.");
            this.zzhf.onAdLeftApplication(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onAdLoaded() {
            zzakb.zzbx("Custom event adapter called onReceivedAd.");
            this.zzhf.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzakb.zzbx("Custom event adapter called onAdOpened.");
            this.zzhf.onAdOpened(this.zzdob);
        }
    }

    /* loaded from: classes.dex */
    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzdob;
        private final MediationNativeListener zzhg;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzdob = customEventAdapter;
            this.zzhg = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzakb.zzbx("Custom event adapter called onAdClicked.");
            this.zzhg.onAdClicked(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzakb.zzbx("Custom event adapter called onAdClosed.");
            this.zzhg.onAdClosed(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzakb.zzbx("Custom event adapter called onAdFailedToLoad.");
            this.zzhg.onAdFailedToLoad(this.zzdob, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdImpression() {
            zzakb.zzbx("Custom event adapter called onAdImpression.");
            this.zzhg.onAdImpression(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzakb.zzbx("Custom event adapter called onAdLeftApplication.");
            this.zzhg.onAdLeftApplication(this.zzdob);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzakb.zzbx("Custom event adapter called onAdLoaded.");
            this.zzhg.onAdLoaded(this.zzdob, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzakb.zzbx("Custom event adapter called onAdOpened.");
            this.zzhg.onAdOpened(this.zzdob);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view) {
        this.zzhm = view;
    }

    private static <T> T zzi(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzakb.zzcu(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.zzhm;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzdny;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzdnz;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzdoa;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzdny;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzdnz;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzdoa;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzdny;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzdnz;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzdoa;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdny = (CustomEventBanner) zzi(bundle.getString("class_name"));
        if (this.zzdny == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzdny.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdnz = (CustomEventInterstitial) zzi(bundle.getString("class_name"));
        if (this.zzdnz == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzdnz.requestInterstitialAd(context, new zzb(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzdoa = (CustomEventNative) zzi(bundle.getString("class_name"));
        if (this.zzdoa == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzdoa.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.zzdnz.showInterstitial();
    }
}
