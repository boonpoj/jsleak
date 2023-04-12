package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzvw<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzvb {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzcfv;
    private final NETWORK_EXTRAS zzcfw;

    public zzvw(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzcfv = mediationAdapter;
        this.zzcfw = network_extras;
    }

    private final SERVER_PARAMETERS zza(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzcfv.getServerParametersType();
            if (serverParametersType != null) {
                SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
                newInstance.load(hashMap);
                return newInstance;
            }
            return null;
        } catch (Throwable th) {
            zzakb.zzc("Could not get MediationServerParameters.", th);
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
            this.zzcfv.destroy();
        } catch (Throwable th) {
            zzakb.zzc("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzll getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzva
    public final IObjectWrapper getView() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzcfv;
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
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzva
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzva
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzva
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzcfv;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzcfv).showInterstitial();
        } catch (Throwable th) {
            zzakb.zzc("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzaem zzaemVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzaem zzaemVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException {
        zza(iObjectWrapper, zzjjVar, str, (String) null, zzvdVar);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzcfv;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzcfv).requestInterstitialAd(new zzvx(zzvdVar), (Activity) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), zza(str, zzjjVar.zzbdj, str2), zzwj.zza(zzjjVar, zzn(zzjjVar)), this.zzcfw);
        } catch (Throwable th) {
            zzakb.zzc("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar, zzpe zzpeVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException {
        zza(iObjectWrapper, zzjnVar, zzjjVar, str, null, zzvdVar);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzcfv;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzakb.zzcu(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzakb.zzbx("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzcfv).requestBannerAd(new zzvx(zzvdVar), (Activity) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper), zza(str, zzjjVar.zzbdj, str2), zzwj.zzb(zzjnVar), zzwj.zza(zzjjVar, zzn(zzjjVar)), this.zzcfw);
        } catch (Throwable th) {
            zzakb.zzc("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(zzjj zzjjVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zzc(zzjj zzjjVar, String str) {
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvj zzme() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvm zzmf() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle zzmg() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle zzmh() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean zzmi() {
        return false;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzqm zzmj() {
        return null;
    }
}
