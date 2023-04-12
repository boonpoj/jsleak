package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzqq;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzlv {
    private final zzjm zzalp;
    private VideoOptions zzaml;
    private boolean zzamr;
    private AppEventListener zzamt;
    private String zzapq;
    private zzje zzbdd;
    private AdListener zzbde;
    private AdSize[] zzbeq;
    private final zzuw zzbgb;
    private final AtomicBoolean zzbgc;
    private final VideoController zzbgd;
    private zzkd zzbge;
    private Correlator zzbgf;
    private zzks zzbgg;
    private OnCustomRenderedAdLoadedListener zzbgh;
    private ViewGroup zzbgi;
    private int zzbgj;

    /* renamed from: com.google.android.gms.internal.zzlv$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ JSONObject zzQC;
        final /* synthetic */ zzqc zzQD;

        AnonymousClass1(JSONObject jSONObject, zzqc zzqcVar) {
            this.zzQC = jSONObject;
            this.zzQD = zzqcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final zzqp zziU = zzlv.this.zziU();
                zzlv.this.zzbgd.zzc(zziU);
                WeakReference weakReference = new WeakReference(zziU);
                zziU.zzkV().zza(zzlv.zza(zzlv.this, weakReference), zzlv.zzb(zzlv.this, weakReference));
                zzlv.zza(zzlv.this, zziU);
                zziU.zzkV().zza(new zzqq.zzb() { // from class: com.google.android.gms.internal.zzlv.1.1
                    @Override // com.google.android.gms.internal.zzqq.zzb
                    public void zzk(zzqp zzqpVar) {
                        zziU.zza("google.afma.nativeAds.renderVideo", AnonymousClass1.this.zzQC);
                    }
                });
                zziU.zzkV().zza(new zzqq.zza() { // from class: com.google.android.gms.internal.zzlv.1.2
                    @Override // com.google.android.gms.internal.zzqq.zza
                    public void zza(zzqp zzqpVar, boolean z) {
                        zzlv.this.zzbgd.zzcu();
                        AnonymousClass1.this.zzQD.zzh(zzqpVar);
                    }
                });
                zziU.loadUrl(zzlt.zza(zzlv.zzb(zzlv.this), (String) zzfx.zzDS.get()));
            } catch (Exception e) {
                zzpe.zzc("Exception occurred while getting video view", e);
                this.zzQD.zzh(null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements zzhx {
        AnonymousClass2() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            zzlv.this.zzbgd.zzcr();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ WeakReference zzQG;

        AnonymousClass3(WeakReference weakReference) {
            this.zzQG = weakReference;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            zzlv.zza(zzlv.this, this.zzQG, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements ViewTreeObserver.OnScrollChangedListener {
        final /* synthetic */ WeakReference zzQG;

        AnonymousClass4(WeakReference weakReference) {
            this.zzQG = weakReference;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            zzlv.zza(zzlv.this, this.zzQG, true);
        }
    }

    public zzlv(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzjm.zzbej, 0);
    }

    public zzlv(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzjm.zzbej, i);
    }

    public zzlv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzjm.zzbej, 0);
    }

    public zzlv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzjm.zzbej, i);
    }

    private zzlv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzjm zzjmVar, int i) {
        this(viewGroup, attributeSet, z, zzjmVar, null, i);
    }

    private zzlv(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzjm zzjmVar, zzks zzksVar, int i) {
        this.zzbgb = new zzuw();
        this.zzbgd = new VideoController();
        this.zzbge = new zzlw(this);
        this.zzbgi = viewGroup;
        this.zzalp = zzjmVar;
        this.zzbgg = null;
        this.zzbgc = new AtomicBoolean(false);
        this.zzbgj = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzjq zzjqVar = new zzjq(context, attributeSet);
                this.zzbeq = zzjqVar.zzh(z);
                this.zzapq = zzjqVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzajr zzia = zzkb.zzia();
                    AdSize adSize = this.zzbeq[0];
                    int i2 = this.zzbgj;
                    zzjn zzjnVar = new zzjn(context, adSize);
                    zzjnVar.zzbep = zzs(i2);
                    zzia.zza(viewGroup, zzjnVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzkb.zzia().zza(viewGroup, new zzjn(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzjn zza(Context context, AdSize[] adSizeArr, int i) {
        zzjn zzjnVar = new zzjn(context, adSizeArr);
        zzjnVar.zzbep = zzs(i);
        return zzjnVar;
    }

    private static boolean zzs(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzbgg != null) {
                this.zzbgg.destroy();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to destroy AdView.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzbde;
    }

    public final AdSize getAdSize() {
        zzjn zzbs;
        try {
            if (this.zzbgg != null && (zzbs = this.zzbgg.zzbs()) != null) {
                return zzbs.zzht();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to get the current AdSize.", e);
        }
        AdSize[] adSizeArr = this.zzbeq;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzbeq;
    }

    public final String getAdUnitId() {
        zzks zzksVar;
        if (this.zzapq == null && (zzksVar = this.zzbgg) != null) {
            try {
                this.zzapq = zzksVar.getAdUnitId();
            } catch (RemoteException e) {
                zzakb.zzc("Failed to get ad unit id.", e);
            }
        }
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

    public final VideoController getVideoController() {
        return this.zzbgd;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzaml;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbgg != null) {
                return this.zzbgg.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzakb.zzc("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public final void pause() {
        try {
            if (this.zzbgg != null) {
                this.zzbgg.pause();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to call pause.", e);
        }
    }

    public final void recordManualImpression() {
        if (this.zzbgc.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzbgg != null) {
                this.zzbgg.zzbu();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to record impression.", e);
        }
    }

    public final void resume() {
        try {
            if (this.zzbgg != null) {
                this.zzbgg.resume();
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to call resume.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzbde = adListener;
        this.zzbge.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzbeq != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        if (this.zzapq != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzamr = z;
        try {
            if (this.zzbgg != null) {
                this.zzbgg.setManualImpressionsEnabled(this.zzamr);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set manual impressions.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzbgh = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbgg != null) {
                this.zzbgg.zza(onCustomRenderedAdLoadedListener != null ? new zzod(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzaml = videoOptions;
        try {
            if (this.zzbgg != null) {
                this.zzbgg.zza(videoOptions == null ? null : new zzmr(videoOptions));
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set video options.", e);
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
                if ((this.zzbeq == null || this.zzapq == null) && this.zzbgg == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzbgi.getContext();
                zzjn zza = zza(context, this.zzbeq, this.zzbgj);
                this.zzbgg = (zzks) ("search_v2".equals(zza.zzbek) ? zzjr.zza(context, false, (zzjr.zza<Object>) new zzjt(zzkb.zzib(), context, zza, this.zzapq)) : zzjr.zza(context, false, (zzjr.zza<Object>) new zzjs(zzkb.zzib(), context, zza, this.zzapq, this.zzbgb)));
                this.zzbgg.zza(new zzjg(this.zzbge));
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
                if (this.zzaml != null) {
                    this.zzbgg.zza(new zzmr(this.zzaml));
                }
                this.zzbgg.setManualImpressionsEnabled(this.zzamr);
                try {
                    IObjectWrapper zzbr = this.zzbgg.zzbr();
                    if (zzbr != null) {
                        this.zzbgi.addView((View) com.google.android.gms.dynamic.zzn.zzx(zzbr));
                    }
                } catch (RemoteException e) {
                    zzakb.zzc("Failed to get an ad frame.", e);
                }
            }
            if (this.zzbgg.zzb(zzjm.zza(this.zzbgi.getContext(), zzltVar))) {
                this.zzbgb.zzn(zzltVar.zzim());
            }
        } catch (RemoteException e2) {
            zzakb.zzc("Failed to load ad.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzbeq = adSizeArr;
        try {
            if (this.zzbgg != null) {
                this.zzbgg.zza(zza(this.zzbgi.getContext(), this.zzbeq, this.zzbgj));
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to set the ad size.", e);
        }
        this.zzbgi.requestLayout();
    }

    public final boolean zza(zzks zzksVar) {
        if (zzksVar == null) {
            return false;
        }
        try {
            IObjectWrapper zzbr = zzksVar.zzbr();
            if (zzbr != null && ((View) com.google.android.gms.dynamic.zzn.zzx(zzbr)).getParent() == null) {
                this.zzbgi.addView((View) com.google.android.gms.dynamic.zzn.zzx(zzbr));
                this.zzbgg = zzksVar;
                return true;
            }
            return false;
        } catch (RemoteException e) {
            zzakb.zzc("Failed to get an ad frame.", e);
            return false;
        }
    }

    public final zzll zzbj() {
        zzks zzksVar = this.zzbgg;
        if (zzksVar == null) {
            return null;
        }
        try {
            return zzksVar.getVideoController();
        } catch (RemoteException e) {
            zzakb.zzc("Failed to retrieve VideoController.", e);
            return null;
        }
    }
}
