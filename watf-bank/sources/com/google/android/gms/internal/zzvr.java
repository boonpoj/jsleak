package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzvr extends zzvb {
    private final MediationAdapter zzcfn;
    private zzvs zzcfo;

    public zzvr(MediationAdapter mediationAdapter) {
        this.zzcfn = mediationAdapter;
    }

    private final Bundle zza(String str, zzjj zzjjVar, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzakb.zzcu(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzcfn instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzjjVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzjjVar.zzbdj);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzakb.zzc("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    private static boolean zzn(zzjj zzjjVar) {
        if (zzjjVar.zzbdi) {
            return true;
        }
        zzkb.zzia();
        return zzajr.zzqy();
    }

    @Override // com.google.android.gms.internal.zzva
    public final void destroy() throws RemoteException {
        try {
            this.zzcfn.onDestroy();
        } catch (Throwable th) {
            zzakb.zzc("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle getInterstitialAdapterInfo() {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (mediationAdapter instanceof zzapc) {
            return ((zzapc) mediationAdapter).getInterstitialAdapterInfo();
        }
        String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
        zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationInterstitialAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzll getVideoController() {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (mediationAdapter instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) mediationAdapter).getVideoController();
            } catch (Throwable th) {
                zzakb.zzc("Could not get video controller.", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzva
    public final IObjectWrapper getView() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zzn.zzz(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzakb.zzc("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean isInitialized() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzcfn).isInitialized();
        } catch (Throwable th) {
            zzakb.zzc("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void pause() throws RemoteException {
        try {
            this.zzcfn.onPause();
        } catch (Throwable th) {
            zzakb.zzc("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void resume() throws RemoteException {
        try {
            this.zzcfn.onResume();
        } catch (Throwable th) {
            zzakb.zzc("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void setImmersiveMode(boolean z) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof OnImmersiveModeUpdatedListener)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzct(valueOf.length() != 0 ? "MediationAdapter is not an OnImmersiveModeUpdatedListener: ".concat(valueOf) : new String("MediationAdapter is not an OnImmersiveModeUpdatedListener: "));
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) mediationAdapter).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzakb.zzc("Could not set immersive mode.", th);
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void showInterstitial() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzcfn).showInterstitial();
        } catch (Throwable th) {
            zzakb.zzc("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void showVideo() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzcfn).showVideo();
        } catch (Throwable th) {
            zzakb.zzc("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzaem zzaemVar, List<String> list) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzcfn;
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                arrayList.add(zza(str, (zzjj) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), new zzaep(zzaemVar), arrayList);
        } catch (Throwable th) {
            zzakb.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzaem zzaemVar, String str2) throws RemoteException {
        zzvq zzvqVar;
        Bundle bundle;
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzcfn;
            Bundle zza = zza(str2, zzjjVar, (String) null);
            if (zzjjVar != null) {
                zzvq zzvqVar2 = new zzvq(zzjjVar.zzbdf == -1 ? null : new Date(zzjjVar.zzbdf), zzjjVar.zzbdg, zzjjVar.zzbdh != null ? new HashSet(zzjjVar.zzbdh) : null, zzjjVar.zzbdn, zzn(zzjjVar), zzjjVar.zzbdj, zzjjVar.zzbdu);
                bundle = zzjjVar.zzbdp != null ? zzjjVar.zzbdp.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                zzvqVar = zzvqVar2;
            } else {
                zzvqVar = null;
                bundle = null;
            }
            mediationRewardedVideoAdAdapter.initialize((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), zzvqVar, str, new zzaep(zzaemVar), zza, bundle);
        } catch (Throwable th) {
            zzakb.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException {
        zza(iObjectWrapper, zzjjVar, str, (String) null, zzvdVar);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzcfn;
            mediationInterstitialAdapter.requestInterstitialAd((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), new zzvs(zzvdVar), zza(str, zzjjVar, str2), new zzvq(zzjjVar.zzbdf == -1 ? null : new Date(zzjjVar.zzbdf), zzjjVar.zzbdg, zzjjVar.zzbdh != null ? new HashSet(zzjjVar.zzbdh) : null, zzjjVar.zzbdn, zzn(zzjjVar), zzjjVar.zzbdj, zzjjVar.zzbdu), zzjjVar.zzbdp != null ? zzjjVar.zzbdp.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzakb.zzc("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar, zzpe zzpeVar, List<String> list) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationNativeAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationNativeAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) mediationAdapter;
            zzvv zzvvVar = new zzvv(zzjjVar.zzbdf == -1 ? null : new Date(zzjjVar.zzbdf), zzjjVar.zzbdg, zzjjVar.zzbdh != null ? new HashSet(zzjjVar.zzbdh) : null, zzjjVar.zzbdn, zzn(zzjjVar), zzjjVar.zzbdj, zzpeVar, list, zzjjVar.zzbdu);
            Bundle bundle = zzjjVar.zzbdp != null ? zzjjVar.zzbdp.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzcfo = new zzvs(zzvdVar);
            mediationNativeAdapter.requestNativeAd((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), this.zzcfo, zza(str, zzjjVar, str2), zzvvVar, bundle);
        } catch (Throwable th) {
            zzakb.zzc("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException {
        zza(iObjectWrapper, zzjnVar, zzjjVar, str, null, zzvdVar);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzcfn;
            mediationBannerAdapter.requestBannerAd((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), new zzvs(zzvdVar), zza(str, zzjjVar, str2), com.google.android.gms.ads.zzb.zza(zzjnVar.width, zzjnVar.height, zzjnVar.zzbek), new zzvq(zzjjVar.zzbdf == -1 ? null : new Date(zzjjVar.zzbdf), zzjjVar.zzbdg, zzjjVar.zzbdh != null ? new HashSet(zzjjVar.zzbdh) : null, zzjjVar.zzbdn, zzn(zzjjVar), zzjjVar.zzbdj, zzjjVar.zzbdu), zzjjVar.zzbdp != null ? zzjjVar.zzbdp.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzakb.zzc("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(zzjj zzjjVar, String str, String str2) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzcfn;
            mediationRewardedVideoAdAdapter.loadAd(new zzvq(zzjjVar.zzbdf == -1 ? null : new Date(zzjjVar.zzbdf), zzjjVar.zzbdg, zzjjVar.zzbdh != null ? new HashSet(zzjjVar.zzbdh) : null, zzjjVar.zzbdn, zzn(zzjjVar), zzjjVar.zzbdj, zzjjVar.zzbdu), zza(str, zzjjVar, str2), zzjjVar.zzbdp != null ? zzjjVar.zzbdp.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzakb.zzc("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zzc(zzjj zzjjVar, String str) throws RemoteException {
        zza(zzjjVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        try {
            ((OnContextChangedListener) this.zzcfn).onContextChanged((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
        } catch (Throwable th) {
            zzakb.zza("Could not inform adapter of changed context", th);
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvj zzme() {
        NativeAdMapper zzmm = this.zzcfo.zzmm();
        if (zzmm instanceof NativeAppInstallAdMapper) {
            return new zzvt((NativeAppInstallAdMapper) zzmm);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvm zzmf() {
        NativeAdMapper zzmm = this.zzcfo.zzmm();
        if (zzmm instanceof NativeContentAdMapper) {
            return new zzvu((NativeContentAdMapper) zzmm);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle zzmg() {
        MediationAdapter mediationAdapter = this.zzcfn;
        if (mediationAdapter instanceof zzapb) {
            return ((zzapb) mediationAdapter).zzmg();
        }
        String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
        zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a v2 MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a v2 MediationBannerAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle zzmh() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean zzmi() {
        return this.zzcfn instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzqm zzmj() {
        NativeCustomTemplateAd zzmn = this.zzcfo.zzmn();
        if (zzmn instanceof zzqp) {
            return ((zzqp) zzmn).zzkm();
        }
        return null;
    }
}
