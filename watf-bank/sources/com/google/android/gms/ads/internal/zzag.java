package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzag extends zzkl {
    private final Context mContext;
    private final zzv zzanr;
    private final zzux zzanw;
    private final zzkh zzape;
    private final zzqq zzapf;
    private final zzrc zzapg;
    private final zzqt zzaph;
    private final zzrf zzapi;
    private final zzjn zzapj;
    private final PublisherAdViewOptions zzapk;
    private final SimpleArrayMap<String, zzqz> zzapl;
    private final SimpleArrayMap<String, zzqw> zzapm;
    private final zzpe zzapn;
    private final zzld zzapp;
    private final String zzapq;
    private final zzakd zzapr;
    private WeakReference<zzd> zzaps;
    private final Object mLock = new Object();
    private final List<String> zzapo = zzdh();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(Context context, String str, zzux zzuxVar, zzakd zzakdVar, zzkh zzkhVar, zzqq zzqqVar, zzrc zzrcVar, zzqt zzqtVar, SimpleArrayMap<String, zzqz> simpleArrayMap, SimpleArrayMap<String, zzqw> simpleArrayMap2, zzpe zzpeVar, zzld zzldVar, zzv zzvVar, zzrf zzrfVar, zzjn zzjnVar, PublisherAdViewOptions publisherAdViewOptions) {
        this.mContext = context;
        this.zzapq = str;
        this.zzanw = zzuxVar;
        this.zzapr = zzakdVar;
        this.zzape = zzkhVar;
        this.zzaph = zzqtVar;
        this.zzapf = zzqqVar;
        this.zzapg = zzrcVar;
        this.zzapl = simpleArrayMap;
        this.zzapm = simpleArrayMap2;
        this.zzapn = zzpeVar;
        this.zzapp = zzldVar;
        this.zzanr = zzvVar;
        this.zzapi = zzrfVar;
        this.zzapj = zzjnVar;
        this.zzapk = publisherAdViewOptions;
        zznh.initialize(this.mContext);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzahn.zzdaw.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzjj zzjjVar, int i) {
        Context context = this.mContext;
        zzba zzbaVar = new zzba(context, this.zzanr, zzjn.zzf(context), this.zzapq, this.zzanw, this.zzapr);
        this.zzaps = new WeakReference<>(zzbaVar);
        zzqq zzqqVar = this.zzapf;
        com.google.android.gms.common.internal.zzbq.zzge("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzbaVar.zzano.zzauk = zzqqVar;
        zzqt zzqtVar = this.zzaph;
        com.google.android.gms.common.internal.zzbq.zzge("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzbaVar.zzano.zzaul = zzqtVar;
        SimpleArrayMap<String, zzqz> simpleArrayMap = this.zzapl;
        com.google.android.gms.common.internal.zzbq.zzge("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzbaVar.zzano.zzaun = simpleArrayMap;
        zzbaVar.zza(this.zzape);
        SimpleArrayMap<String, zzqw> simpleArrayMap2 = this.zzapm;
        com.google.android.gms.common.internal.zzbq.zzge("setOnCustomClickListener must be called on the main UI thread.");
        zzbaVar.zzano.zzaum = simpleArrayMap2;
        zzbaVar.zzd(zzdh());
        zzpe zzpeVar = this.zzapn;
        com.google.android.gms.common.internal.zzbq.zzge("setNativeAdOptions must be called on the main UI thread.");
        zzbaVar.zzano.zzauo = zzpeVar;
        zzbaVar.zza(this.zzapp);
        zzbaVar.zzj(i);
        zzbaVar.zzb(zzjjVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzdf() {
        return ((Boolean) zzkb.zzif().zzd(zznh.zzblk)).booleanValue() && this.zzapi != null;
    }

    private final boolean zzdg() {
        if (this.zzapf == null && this.zzaph == null) {
            SimpleArrayMap<String, zzqz> simpleArrayMap = this.zzapl;
            return simpleArrayMap != null && simpleArrayMap.size() > 0;
        }
        return true;
    }

    private final List<String> zzdh() {
        ArrayList arrayList = new ArrayList();
        if (this.zzaph != null) {
            arrayList.add("1");
        }
        if (this.zzapf != null) {
            arrayList.add(InternalAvidAdSessionContext.AVID_API_LEVEL);
        }
        if (this.zzapl.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzjj zzjjVar) {
        zzq zzqVar = new zzq(this.mContext, this.zzanr, this.zzapj, this.zzapq, this.zzanw, this.zzapr);
        this.zzaps = new WeakReference<>(zzqVar);
        zzrf zzrfVar = this.zzapi;
        com.google.android.gms.common.internal.zzbq.zzge("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
        zzqVar.zzano.zzaur = zzrfVar;
        PublisherAdViewOptions publisherAdViewOptions = this.zzapk;
        if (publisherAdViewOptions != null) {
            if (publisherAdViewOptions.zzbn() != null) {
                zzqVar.zza(this.zzapk.zzbn());
            }
            zzqVar.setManualImpressionsEnabled(this.zzapk.getManualImpressionsEnabled());
        }
        zzqq zzqqVar = this.zzapf;
        com.google.android.gms.common.internal.zzbq.zzge("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzqVar.zzano.zzauk = zzqqVar;
        zzqt zzqtVar = this.zzaph;
        com.google.android.gms.common.internal.zzbq.zzge("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzqVar.zzano.zzaul = zzqtVar;
        SimpleArrayMap<String, zzqz> simpleArrayMap = this.zzapl;
        com.google.android.gms.common.internal.zzbq.zzge("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzqVar.zzano.zzaun = simpleArrayMap;
        SimpleArrayMap<String, zzqw> simpleArrayMap2 = this.zzapm;
        com.google.android.gms.common.internal.zzbq.zzge("setOnCustomClickListener must be called on the main UI thread.");
        zzqVar.zzano.zzaum = simpleArrayMap2;
        zzpe zzpeVar = this.zzapn;
        com.google.android.gms.common.internal.zzbq.zzge("setNativeAdOptions must be called on the main UI thread.");
        zzqVar.zzano.zzauo = zzpeVar;
        zzqVar.zzd(zzdh());
        zzqVar.zza(this.zzape);
        zzqVar.zza(this.zzapp);
        ArrayList arrayList = new ArrayList();
        if (zzdg()) {
            arrayList.add(1);
        }
        if (this.zzapi != null) {
            arrayList.add(2);
        }
        zzqVar.zze(arrayList);
        if (zzdg()) {
            zzjjVar.extras.putBoolean("ina", true);
        }
        if (this.zzapi != null) {
            zzjjVar.extras.putBoolean("iba", true);
        }
        zzqVar.zzb(zzjjVar);
    }

    @Override // com.google.android.gms.internal.zzkk
    public final String getMediationAdapterClassName() {
        synchronized (this.mLock) {
            if (this.zzaps != null) {
                zzd zzdVar = this.zzaps.get();
                return zzdVar != null ? zzdVar.getMediationAdapterClassName() : null;
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzkk
    public final boolean isLoading() {
        synchronized (this.mLock) {
            if (this.zzaps != null) {
                zzd zzdVar = this.zzaps.get();
                return zzdVar != null ? zzdVar.isLoading() : false;
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void zza(zzjj zzjjVar, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Number of ads has to be more than 0");
        }
        runOnUiThread(new zzai(this, zzjjVar, i));
    }

    @Override // com.google.android.gms.internal.zzkk
    public final String zzcp() {
        synchronized (this.mLock) {
            if (this.zzaps != null) {
                zzd zzdVar = this.zzaps.get();
                return zzdVar != null ? zzdVar.zzcp() : null;
            }
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzkk
    public final void zzd(zzjj zzjjVar) {
        runOnUiThread(new zzah(this, zzjjVar));
    }
}
