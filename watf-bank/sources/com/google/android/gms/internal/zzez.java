package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import java.util.concurrent.atomic.AtomicBoolean;
@zzmb
/* loaded from: assets/classes2.dex */
public class zzez {
    private InAppPurchaseListener zzAa;
    private OnCustomRenderedAdLoadedListener zzAb;
    private PlayStorePurchaseListener zzAc;
    private String zzAd;
    private ViewGroup zzAe;
    private int zzAf;
    private final zzeb zzrB;
    private boolean zzsS;
    private VideoOptions zzsb;
    private String zztq;
    private zzdt zzyD;
    private AdListener zzyE;
    private final zzjr zzzU;
    private final AtomicBoolean zzzV;
    private final VideoController zzzW;
    final zzej zzzX;
    private Correlator zzzY;
    private zzep zzzZ;
    private AppEventListener zzzq;
    private AdSize[] zzzr;

    public zzez(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzeb.zzey(), 0);
    }

    public zzez(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzeb.zzey(), i);
    }

    public zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzeb.zzey(), 0);
    }

    public zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzeb.zzey(), i);
    }

    zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzeb zzebVar, int i) {
        this(viewGroup, attributeSet, z, zzebVar, null, i);
    }

    zzez(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzeb zzebVar, zzep zzepVar, int i) {
        this.zzzU = new zzjr();
        this.zzzW = new VideoController();
        this.zzzX = new zzej() { // from class: com.google.android.gms.internal.zzez.1
            public void onAdFailedToLoad(int i2) {
                zzez.this.zzzW.zza(zzez.this.zzbt());
                super.onAdFailedToLoad(i2);
            }

            public void onAdLoaded() {
                zzez.this.zzzW.zza(zzez.this.zzbt());
                super.onAdLoaded();
            }
        };
        this.zzAe = viewGroup;
        this.zzrB = zzebVar;
        this.zzzZ = zzepVar;
        this.zzzV = new AtomicBoolean(false);
        this.zzAf = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzef zzefVar = new zzef(context, attributeSet);
                this.zzzr = zzefVar.zzm(z);
                this.zztq = zzefVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzeh.zzeO().zza(viewGroup, zza(context, this.zzzr[0], this.zzAf), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzeh.zzeO().zza(viewGroup, new zzec(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzec zza(Context context, AdSize adSize, int i) {
        zzec zzecVar = new zzec(context, adSize);
        zzecVar.zzl(zzy(i));
        return zzecVar;
    }

    private static zzec zza(Context context, AdSize[] adSizeArr, int i) {
        zzec zzecVar = new zzec(context, adSizeArr);
        zzecVar.zzl(zzy(i));
        return zzecVar;
    }

    private void zzfc() {
        try {
            com.google.android.gms.dynamic.zzd zzbC = this.zzzZ.zzbC();
            if (zzbC == null) {
                return;
            }
            this.zzAe.addView((View) com.google.android.gms.dynamic.zze.zzE(zzbC));
        } catch (RemoteException e) {
            zzpy.zzc("Failed to get an ad frame.", e);
        }
    }

    private static boolean zzy(int i) {
        return i == 1;
    }

    public void destroy() {
        try {
            if (this.zzzZ != null) {
                this.zzzZ.destroy();
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzyE;
    }

    public AdSize getAdSize() {
        zzec zzbD;
        try {
            if (this.zzzZ != null && (zzbD = this.zzzZ.zzbD()) != null) {
                return zzbD.zzeA();
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to get the current AdSize.", e);
        }
        if (this.zzzr != null) {
            return this.zzzr[0];
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.zzzr;
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

    public VideoController getVideoController() {
        return this.zzzW;
    }

    public VideoOptions getVideoOptions() {
        return this.zzsb;
    }

    public boolean isLoading() {
        try {
            if (this.zzzZ != null) {
                return this.zzzZ.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzpy.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void pause() {
        try {
            if (this.zzzZ != null) {
                this.zzzZ.pause();
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (this.zzzV.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zzbF();
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.zzzZ != null) {
                this.zzzZ.resume();
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.zzyE = adListener;
        this.zzzX.zza(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (this.zzzr != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        if (this.zztq != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public void setManualImpressionsEnabled(boolean z) {
        this.zzsS = z;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.setManualImpressionsEnabled(this.zzsS);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set manual impressions.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzgk] */
    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzAb = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(onCustomRenderedAdLoadedListener != null ? new zzgk(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.zzli] */
    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzAa != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
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

    public void setVideoOptions(VideoOptions videoOptions) {
        this.zzsb = videoOptions;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(videoOptions == null ? null : new zzfn(videoOptions));
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set video options.", e);
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
                zzfd();
            }
            if (this.zzzZ.zzb(this.zzrB.zza(this.zzAe.getContext(), zzeyVar))) {
                this.zzzU.zzi(zzeyVar.zzeY());
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzzr = adSizeArr;
        try {
            if (this.zzzZ != null) {
                this.zzzZ.zza(zza(this.zzAe.getContext(), this.zzzr, this.zzAf));
            }
        } catch (RemoteException e) {
            zzpy.zzc("Failed to set the ad size.", e);
        }
        this.zzAe.requestLayout();
    }

    public boolean zzb(zzec zzecVar) {
        return "search_v2".equals(zzecVar.zzzk);
    }

    public zzew zzbt() {
        if (this.zzzZ == null) {
            return null;
        }
        try {
            return this.zzzZ.zzbG();
        } catch (RemoteException e) {
            zzpy.zzc("Failed to retrieve VideoController.", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.zzdv, com.google.android.gms.internal.zzel] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.google.android.gms.internal.zzdu, com.google.android.gms.internal.zzek] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.google.android.gms.internal.zzgk, com.google.android.gms.internal.zzgj] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.gms.internal.zzld, com.google.android.gms.internal.zzli] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.zzkz, com.google.android.gms.internal.zzle] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.google.android.gms.internal.zzee, com.google.android.gms.internal.zzer] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.zzej, com.google.android.gms.ads.AdListener] */
    void zzfd() throws RemoteException {
        if ((this.zzzr == null || this.zztq == null) && this.zzzZ == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.zzzZ = zzfe();
        this.zzzZ.zza(new zzdv((AdListener) this.zzzX));
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
        if (this.zzsb != null) {
            this.zzzZ.zza(new zzfn(this.zzsb));
        }
        this.zzzZ.setManualImpressionsEnabled(this.zzsS);
        zzfc();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.zzjr, com.google.android.gms.internal.zzjs] */
    protected zzep zzfe() throws RemoteException {
        Context context = this.zzAe.getContext();
        zzec zza = zza(context, this.zzzr, this.zzAf);
        return zzb(zza) ? zzeh.zzeP().zza(context, zza, this.zztq) : zzeh.zzeP().zza(context, zza, this.zztq, this.zzzU);
    }
}
