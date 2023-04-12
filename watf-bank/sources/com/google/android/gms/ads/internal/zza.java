package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzadc;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzafq;
import com.google.android.gms.internal.zzafy;
import com.google.android.gms.internal.zzafz;
import com.google.android.gms.internal.zzagd;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzxr;
import com.google.android.gms.internal.zzyb;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
@zzzv
/* loaded from: classes.dex */
public abstract class zza extends zzkt implements com.google.android.gms.ads.internal.gmsg.zzb, com.google.android.gms.ads.internal.overlay.zzq, zzafy, zzje, zzyb, zzzx {
    protected zznu zzanj;
    protected zzns zzank;
    private zzns zzanl;
    protected boolean zzanm = false;
    protected final zzbi zzann = new zzbi(this);
    protected final zzbt zzano;
    protected transient zzjj zzanp;
    protected final zzfs zzanq;
    protected final zzv zzanr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzbt zzbtVar, zzbi zzbiVar, zzv zzvVar) {
        this.zzano = zzbtVar;
        this.zzanr = zzvVar;
        zzbs.zzei().zzah(this.zzano.zzair);
        zzbs.zzei().zzai(this.zzano.zzair);
        zzagd.zzae(this.zzano.zzair);
        zzbs.zzfe().initialize(this.zzano.zzair);
        zzbs.zzem().zzc(this.zzano.zzair, this.zzano.zzaty);
        zzbs.zzen().initialize(this.zzano.zzair);
        this.zzanq = zzbs.zzem().zzps();
        zzbs.zzel().initialize(this.zzano.zzair);
        zzbs.zzfg().initialize(this.zzano.zzair);
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbpb)).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(new zzb(this, new CountDownLatch(((Integer) zzkb.zzif().zzd(zznh.zzbpd)).intValue()), timer), 0L, ((Long) zzkb.zzif().zzd(zznh.zzbpc)).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean zza(zzjj zzjjVar) {
        Bundle bundle = zzjjVar.zzbdp.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle == null || !bundle.containsKey("gw");
    }

    private static long zzr(String str) {
        String str2;
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            str2 = "Invalid index for Url fetch time in CSI latency info.";
            zzagf.zzcu(str2);
            return -1L;
        } catch (NumberFormatException e2) {
            str2 = "Cannot find valid format of Url fetch time in CSI latency info.";
            zzagf.zzcu(str2);
            return -1L;
        }
    }

    @Override // com.google.android.gms.internal.zzks
    public void destroy() {
        com.google.android.gms.common.internal.zzbq.zzge("destroy must be called on the main UI thread.");
        this.zzann.cancel();
        this.zzanq.zzi(this.zzano.zzaud);
        zzbt zzbtVar = this.zzano;
        if (zzbtVar.zzatz != null) {
            zzbtVar.zzatz.zzfo();
        }
        zzbtVar.zzauh = null;
        zzbtVar.zzaui = null;
        zzbtVar.zzaut = null;
        zzbtVar.zzauj = null;
        zzbtVar.zzf(false);
        if (zzbtVar.zzatz != null) {
            zzbtVar.zzatz.removeAllViews();
        }
        zzbtVar.zzfi();
        zzbtVar.zzfj();
        zzbtVar.zzaud = null;
    }

    @Override // com.google.android.gms.internal.zzks
    public String getAdUnitId() {
        return this.zzano.zzatw;
    }

    @Override // com.google.android.gms.internal.zzks
    public zzll getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean isLoading() {
        return this.zzanm;
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean isReady() {
        com.google.android.gms.common.internal.zzbq.zzge("isLoaded must be called on the main UI thread.");
        return this.zzano.zzaua == null && this.zzano.zzaub == null && this.zzano.zzaud != null;
    }

    @Override // com.google.android.gms.internal.zzje
    public void onAdClicked() {
        if (this.zzano.zzaud == null) {
            zzagf.zzcu("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzagf.zzbx("Pinging click URLs.");
        if (this.zzano.zzauf != null) {
            this.zzano.zzauf.zzop();
        }
        if (this.zzano.zzaud.zzcdk != null) {
            zzbs.zzei();
            zzahn.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, zzc(this.zzano.zzaud.zzcdk));
        }
        if (this.zzano.zzaug != null) {
            try {
                this.zzano.zzaug.onAdClicked();
            } catch (RemoteException e) {
                zzagf.zzc("Could not notify onAdClicked event.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzb
    public final void onAppEvent(String str, String str2) {
        if (this.zzano.zzaui != null) {
            try {
                this.zzano.zzaui.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzagf.zzc("Could not call the AppEventListener.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzks
    public void pause() {
        com.google.android.gms.common.internal.zzbq.zzge("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzks
    public void resume() {
        com.google.android.gms.common.internal.zzbq.zzge("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.zzks
    public void setImmersiveMode(boolean z) {
        throw new IllegalStateException("onImmersiveModeUpdated is not supported for current ad type");
    }

    @Override // com.google.android.gms.internal.zzks
    public void setManualImpressionsEnabled(boolean z) {
        zzagf.zzcu("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setUserId(String str) {
        com.google.android.gms.common.internal.zzbq.zzge("setUserId must be called on the main UI thread.");
        this.zzano.zzauv = str;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void stopLoading() {
        com.google.android.gms.common.internal.zzbq.zzge("stopLoading must be called on the main UI thread.");
        this.zzanm = false;
        this.zzano.zzf(true);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzadp zzadpVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzano.zzauu = zzadpVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzaeq zzaeqVar) {
        if (this.zzano.zzauu == null) {
            return;
        }
        String str = "";
        int i = 1;
        if (zzaeqVar != null) {
            try {
                str = zzaeqVar.type;
                i = zzaeqVar.zzcwd;
            } catch (RemoteException e) {
                zzagf.zzc("Could not call RewardedVideoAdListener.onRewarded().", e);
                return;
            }
        }
        this.zzano.zzauu.zza(new zzadc(str, i));
    }

    @Override // com.google.android.gms.internal.zzzx
    public final void zza(zzafp zzafpVar) {
        if (zzafpVar.zzcxy.zzcpa != -1 && !TextUtils.isEmpty(zzafpVar.zzcxy.zzcpj)) {
            long zzr = zzr(zzafpVar.zzcxy.zzcpj);
            if (zzr != -1) {
                this.zzanj.zza(this.zzanj.zzd(zzafpVar.zzcxy.zzcpa + zzr), "stc");
            }
        }
        this.zzanj.zzao(zzafpVar.zzcxy.zzcpj);
        this.zzanj.zza(this.zzank, "arf");
        this.zzanl = this.zzanj.zzjf();
        this.zzanj.zzf("gqi", zzafpVar.zzcxy.zzcpk);
        zzbt zzbtVar = this.zzano;
        zzbtVar.zzaua = null;
        zzbtVar.zzaue = zzafpVar;
        zzafpVar.zzcxw.zza(new zzc(this, zzafpVar));
        zzafpVar.zzcxw.zza(zziu.zza.zzb.AD_LOADED);
        zza(zzafpVar, this.zzanj);
    }

    protected abstract void zza(zzafp zzafpVar, zznu zznuVar);

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzjn zzjnVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setAdSize must be called on the main UI thread.");
        zzbt zzbtVar = this.zzano;
        zzbtVar.zzauc = zzjnVar;
        if (zzbtVar.zzaud != null && this.zzano.zzaud.zzciy != null && this.zzano.zzauz == 0) {
            this.zzano.zzaud.zzciy.zza(zzapa.zzc(zzjnVar));
        }
        if (this.zzano.zzatz == null) {
            return;
        }
        if (this.zzano.zzatz.getChildCount() > 1) {
            this.zzano.zzatz.removeView(this.zzano.zzatz.getNextView());
        }
        this.zzano.zzatz.setMinimumWidth(zzjnVar.widthPixels);
        this.zzano.zzatz.setMinimumHeight(zzjnVar.heightPixels);
        this.zzano.zzatz.requestLayout();
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzke zzkeVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setAdListener must be called on the main UI thread.");
        this.zzano.zzaug = zzkeVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzkh zzkhVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setAdListener must be called on the main UI thread.");
        this.zzano.zzauh = zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzkx zzkxVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setAppEventListener must be called on the main UI thread.");
        this.zzano.zzaui = zzkxVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzld zzldVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setCorrelationIdProvider must be called on the main UI thread");
        this.zzano.zzauj = zzldVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzlr zzlrVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setIconAdOptions must be called on the main UI thread.");
        this.zzano.zzauq = zzlrVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzmr zzmrVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setVideoOptions must be called on the main UI thread.");
        this.zzano.zzaup = zzmrVar;
    }

    public final void zza(zzns zznsVar) {
        this.zzanj = new zznu(((Boolean) zzkb.zzif().zzd(zznh.zzbjl)).booleanValue(), "load_ad", this.zzano.zzauc.zzbek);
        this.zzanl = new zzns(-1L, null, null);
        if (zznsVar == null) {
            this.zzank = new zzns(-1L, null, null);
        } else {
            this.zzank = new zzns(zznsVar.getTime(), zznsVar.zzjc(), zznsVar.zzjd());
        }
    }

    @Override // com.google.android.gms.internal.zzks
    public void zza(zzoa zzoaVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    @Override // com.google.android.gms.internal.zzks
    public void zza(zzxl zzxlVar) {
        zzagf.zzcu("setInAppPurchaseListener is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzxr zzxrVar, String str) {
        zzagf.zzcu("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    @Override // com.google.android.gms.internal.zzafy
    public final void zza(HashSet<zzafq> hashSet) {
        this.zzano.zza(hashSet);
    }

    boolean zza(zzafo zzafoVar) {
        return false;
    }

    protected abstract boolean zza(zzafo zzafoVar, zzafo zzafoVar2);

    protected abstract boolean zza(zzjj zzjjVar, zznu zznuVar);

    @Override // com.google.android.gms.internal.zzyb
    public void zzb(zzafo zzafoVar) {
        zzis zzisVar;
        zziu.zza.zzb zzbVar;
        this.zzanj.zza(this.zzanl, "awr");
        this.zzano.zzaub = null;
        if (zzafoVar.errorCode != -2 && zzafoVar.errorCode != 3 && this.zzano.zzfh() != null) {
            zzbs.zzem().zzb(this.zzano.zzfh());
        }
        if (zzafoVar.errorCode == -1) {
            this.zzanm = false;
            return;
        }
        if (zza(zzafoVar)) {
            zzagf.zzbx("Ad refresh scheduled.");
        }
        if (zzafoVar.errorCode != -2) {
            if (zzafoVar.errorCode == 3) {
                zzisVar = zzafoVar.zzcxw;
                zzbVar = zziu.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL;
            } else {
                zzisVar = zzafoVar.zzcxw;
                zzbVar = zziu.zza.zzb.AD_FAILED_TO_LOAD;
            }
            zzisVar.zza(zzbVar);
            zzi(zzafoVar.errorCode);
            return;
        }
        if (this.zzano.zzaux == null) {
            zzbt zzbtVar = this.zzano;
            zzbtVar.zzaux = new zzafz(zzbtVar.zzatw);
        }
        if (this.zzano.zzatz != null) {
            this.zzano.zzatz.zzfn().zzcn(zzafoVar.zzcps);
        }
        this.zzanq.zzh(this.zzano.zzaud);
        if (zza(this.zzano.zzaud, zzafoVar)) {
            zzbt zzbtVar2 = this.zzano;
            zzbtVar2.zzaud = zzafoVar;
            if (zzbtVar2.zzauf != null) {
                if (zzbtVar2.zzaud != null) {
                    zzbtVar2.zzauf.zzh(zzbtVar2.zzaud.zzcxp);
                    zzbtVar2.zzauf.zzi(zzbtVar2.zzaud.zzcxq);
                    zzbtVar2.zzauf.zzw(zzbtVar2.zzaud.zzcow);
                }
                zzbtVar2.zzauf.zzv(zzbtVar2.zzauc.zzbel);
            }
            this.zzanj.zzf("is_mraid", this.zzano.zzaud.zzfv() ? "1" : "0");
            this.zzanj.zzf("is_mediation", this.zzano.zzaud.zzcow ? "1" : "0");
            if (this.zzano.zzaud.zzciy != null && this.zzano.zzaud.zzciy.zzsz() != null) {
                this.zzanj.zzf("is_delay_pl", this.zzano.zzaud.zzciy.zzsz().zztq() ? "1" : "0");
            }
            this.zzanj.zza(this.zzank, "ttc");
            if (zzbs.zzem().zzpc() != null) {
                zzbs.zzem().zzpc().zza(this.zzanj);
            }
            zzcc();
            if (this.zzano.zzfk()) {
                zzby();
            }
        }
        if (zzafoVar.zzcdn != null) {
            zzbs.zzei().zza(this.zzano.zzair, zzafoVar.zzcdn);
        }
    }

    @Override // com.google.android.gms.internal.zzks
    public boolean zzb(zzjj zzjjVar) {
        String sb;
        com.google.android.gms.common.internal.zzbq.zzge("loadAd must be called on the main UI thread.");
        zzbs.zzen().zzhe();
        if (((Boolean) zzkb.zzif().zzd(zznh.zzblm)).booleanValue()) {
            zzjj.zzh(zzjjVar);
        }
        if (com.google.android.gms.common.util.zzi.zzcu(this.zzano.zzair) && zzjjVar.zzbdn != null) {
            zzjjVar = new zzjk(zzjjVar).zza(null).zzhr();
        }
        if (this.zzano.zzaua != null || this.zzano.zzaub != null) {
            zzagf.zzcu(this.zzanp != null ? "Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes." : "Loading already in progress, saving this object for future refreshes.");
            this.zzanp = zzjjVar;
            return false;
        }
        zzagf.zzct("Starting ad request.");
        zza((zzns) null);
        this.zzank = this.zzanj.zzjf();
        if (zzjjVar.zzbdi) {
            sb = "This request is sent from a test device.";
        } else {
            zzkb.zzia();
            String zzbc = zzajr.zzbc(this.zzano.zzair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzbc).length() + 71);
            sb2.append("Use AdRequest.Builder.addTestDevice(\"");
            sb2.append(zzbc);
            sb2.append("\") to get test ads on this device.");
            sb = sb2.toString();
        }
        zzagf.zzct(sb);
        this.zzann.zzf(zzjjVar);
        this.zzanm = zza(zzjjVar, this.zzanj);
        return this.zzanm;
    }

    public final zzv zzbq() {
        return this.zzanr;
    }

    @Override // com.google.android.gms.internal.zzks
    public final IObjectWrapper zzbr() {
        com.google.android.gms.common.internal.zzbq.zzge("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zzn.zzz(this.zzano.zzatz);
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzjn zzbs() {
        com.google.android.gms.common.internal.zzbq.zzge("getAdSize must be called on the main UI thread.");
        if (this.zzano.zzauc == null) {
            return null;
        }
        return new zzmp(this.zzano.zzauc);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzbt() {
        zzbw();
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zzbu() {
        com.google.android.gms.common.internal.zzbq.zzge("recordManualImpression must be called on the main UI thread.");
        if (this.zzano.zzaud == null) {
            zzagf.zzcu("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzagf.zzbx("Pinging manual tracking URLs.");
        if (this.zzano.zzaud.zzcxu) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.zzano.zzaud.zzcoy != null) {
            arrayList.addAll(this.zzano.zzaud.zzcoy);
        }
        if (this.zzano.zzaud.zzces != null && this.zzano.zzaud.zzces.zzccx != null) {
            arrayList.addAll(this.zzano.zzaud.zzces.zzccx);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        zzbs.zzei();
        zzahn.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, arrayList);
        this.zzano.zzaud.zzcxu = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzbv() {
        zzagf.zzct("Ad closing.");
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdClosed();
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzano.zzauu != null) {
            try {
                this.zzano.zzauu.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzagf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbw() {
        zzagf.zzct("Ad leaving application.");
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdLeftApplication();
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzano.zzauu != null) {
            try {
                this.zzano.zzauu.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzagf.zzc("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbx() {
        zzagf.zzct("Ad opening.");
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdOpened();
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzano.zzauu != null) {
            try {
                this.zzano.zzauu.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzagf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzby() {
        zzc(false);
    }

    public final void zzbz() {
        zzagf.zzct("Ad impression.");
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdImpression();
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdImpression().", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> zzc(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(zzafi.zzb(str, this.zzano.zzair));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzc(int i, boolean z) {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Failed to load ad: ");
        sb.append(i);
        zzagf.zzcu(sb.toString());
        this.zzanm = z;
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzano.zzauu != null) {
            try {
                this.zzano.zzauu.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzagf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzc(boolean z) {
        zzagf.zzct("Ad finished loading.");
        this.zzanm = z;
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdLoaded();
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzano.zzauu != null) {
            try {
                this.zzano.zzauu.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzagf.zzc("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zzc(zzjj zzjjVar) {
        if (this.zzano.zzatz == null) {
            return false;
        }
        ViewParent parent = this.zzano.zzatz.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            return zzbs.zzei().zza(view, view.getContext());
        }
        return false;
    }

    public final void zzca() {
        zzagf.zzct("Ad clicked.");
        if (this.zzano.zzauh != null) {
            try {
                this.zzano.zzauh.onAdClicked();
            } catch (RemoteException e) {
                zzagf.zzc("Could not call AdListener.onAdClicked().", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzcb() {
        if (this.zzano.zzauu == null) {
            return;
        }
        try {
            this.zzano.zzauu.onRewardedVideoStarted();
        } catch (RemoteException e) {
            zzagf.zzc("Could not call RewardedVideoAdListener.onVideoStarted().", e);
        }
    }

    public final void zzcc() {
        zzafo zzafoVar = this.zzano.zzaud;
        if (zzafoVar == null || TextUtils.isEmpty(zzafoVar.zzcps) || zzafoVar.zzcxv || !zzbs.zzer().zzqq()) {
            return;
        }
        zzagf.zzbx("Sending troubleshooting signals to the server.");
        zzbs.zzer().zzb(this.zzano.zzair, this.zzano.zzaty.zzcv, zzafoVar.zzcps, this.zzano.zzatw);
        zzafoVar.zzcxv = true;
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzkx zzcd() {
        return this.zzano.zzaui;
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzkh zzce() {
        return this.zzano.zzauh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzg(View view) {
        zzbu zzbuVar = this.zzano.zzatz;
        if (zzbuVar != null) {
            zzbuVar.addView(view, zzbs.zzek().zzqi());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzi(int i) {
        zzc(i, false);
    }
}
