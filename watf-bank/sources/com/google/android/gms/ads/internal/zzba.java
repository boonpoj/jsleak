package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzakv;
import com.google.android.gms.internal.zzalf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzva;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzb;
import com.google.android.gms.internal.zzzf;
import com.google.android.gms.internal.zzzv;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzba extends zzd implements zzot {
    private final Object mLock;
    private boolean zzanz;
    private boolean zzarj;
    private zzalf<zzou> zzark;
    private zzanh zzarl;
    private int zzarm;
    private zzzb zzarn;
    private final String zzaro;

    public zzba(Context context, zzv zzvVar, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar) {
        this(context, zzvVar, zzjnVar, str, zzuxVar, zzakdVar, false);
    }

    public zzba(Context context, zzv zzvVar, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar, boolean z) {
        super(context, zzjnVar, str, zzuxVar, zzakdVar, zzvVar);
        this.mLock = new Object();
        this.zzark = new zzalf<>();
        this.zzarm = 1;
        this.zzaro = UUID.randomUUID().toString();
        this.zzarj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzbt zzbtVar, zzbt zzbtVar2) {
        if (zzbtVar2.zzauk == null) {
            zzbtVar2.zzauk = zzbtVar.zzauk;
        }
        if (zzbtVar2.zzaul == null) {
            zzbtVar2.zzaul = zzbtVar.zzaul;
        }
        if (zzbtVar2.zzaum == null) {
            zzbtVar2.zzaum = zzbtVar.zzaum;
        }
        if (zzbtVar2.zzaun == null) {
            zzbtVar2.zzaun = zzbtVar.zzaun;
        }
        if (zzbtVar2.zzaup == null) {
            zzbtVar2.zzaup = zzbtVar.zzaup;
        }
        if (zzbtVar2.zzauo == null) {
            zzbtVar2.zzauo = zzbtVar.zzauo;
        }
        if (zzbtVar2.zzauw == null) {
            zzbtVar2.zzauw = zzbtVar.zzauw;
        }
        if (zzbtVar2.zzauf == null) {
            zzbtVar2.zzauf = zzbtVar.zzauf;
        }
        if (zzbtVar2.zzaux == null) {
            zzbtVar2.zzaux = zzbtVar.zzaux;
        }
        if (zzbtVar2.zzaug == null) {
            zzbtVar2.zzaug = zzbtVar.zzaug;
        }
        if (zzbtVar2.zzauh == null) {
            zzbtVar2.zzauh = zzbtVar.zzauh;
        }
        if (zzbtVar2.zzauc == null) {
            zzbtVar2.zzauc = zzbtVar.zzauc;
        }
        if (zzbtVar2.zzaud == null) {
            zzbtVar2.zzaud = zzbtVar.zzaud;
        }
        if (zzbtVar2.zzaue == null) {
            zzbtVar2.zzaue = zzbtVar.zzaue;
        }
    }

    private final void zza(zzoj zzojVar) {
        zzahn.zzdaw.post(new zzbe(this, zzojVar));
    }

    private final void zza(zzol zzolVar) {
        zzahn.zzdaw.post(new zzbf(this, zzolVar));
    }

    private final zzui zzcy() {
        if (this.zzano.zzaud == null || !this.zzano.zzaud.zzcow) {
            return null;
        }
        return this.zzano.zzaud.zzcxl;
    }

    private final void zzdw() {
        zzzb zzdq = zzdq();
        if (zzdq != null) {
            zzdq.zzls();
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final String getAdUnitId() {
        return this.zzano.zzatw;
    }

    public final String getUuid() {
        return this.zzaro;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzks
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzafp zzafpVar, zznu zznuVar) {
        if (zzafpVar.zzauc != null) {
            this.zzano.zzauc = zzafpVar.zzauc;
        }
        if (zzafpVar.errorCode != -2) {
            zzahn.zzdaw.post(new zzbb(this, zzafpVar));
            return;
        }
        int i = zzafpVar.zzcqv.zzcoo;
        if (i == 1) {
            this.zzano.zzauz = 0;
            zzbt zzbtVar = this.zzano;
            zzbs.zzeh();
            zzbtVar.zzaub = zzya.zza(this.zzano.zzair, this, zzafpVar, this.zzano.zzatx, null, this.zzanw, this, zznuVar);
            String valueOf = String.valueOf(this.zzano.zzaub.getClass().getName());
            zzagf.zzbx(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(zzafpVar.zzcxy.body).getJSONArray("slots");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i2).getJSONArray("ads");
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    jSONArray.put(jSONArray3.get(i3));
                }
            }
            zzdw();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i; i4++) {
                arrayList.add(zzahh.zza(newFixedThreadPool, new zzbc(this, i4, jSONArray, i, zzafpVar)));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                try {
                    zzahn.zzdaw.post(new zzbd(this, (zzou) ((zzakv) arrayList.get(i5)).get(((Long) zzkb.zzif().zzd(zznh.zzbnj)).longValue(), TimeUnit.MILLISECONDS), i5, arrayList));
                } catch (InterruptedException e) {
                    zzagf.zzc("Exception occurred while getting an ad response", e);
                    Thread.currentThread().interrupt();
                } catch (CancellationException e2) {
                    e = e2;
                    zzagf.zzc("Exception occurred while getting an ad response", e);
                } catch (ExecutionException e3) {
                    e = e3;
                    zzagf.zzc("Exception occurred while getting an ad response", e);
                } catch (TimeoutException e4) {
                    e = e4;
                    zzagf.zzc("Exception occurred while getting an ad response", e);
                }
            }
        } catch (JSONException e5) {
            zzagf.zzc("Malformed native ad response", e5);
            zzi(0);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void zza(zzoa zzoaVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.internal.zzot
    public final void zza(zzoq zzoqVar) {
        zzanh zzanhVar = this.zzarl;
        if (zzanhVar != null) {
            zzanhVar.zzb(zzoqVar);
        }
    }

    @Override // com.google.android.gms.internal.zzot
    public final void zza(zzos zzosVar) {
        if (this.zzano.zzaud.zzcxj != null) {
            zzbs.zzem().zzps().zza(this.zzano.zzauc, this.zzano.zzaud, new zzfv(zzosVar), (zzanh) null);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void zza(zzxl zzxlVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    protected final boolean zza(zzafo zzafoVar, zzafo zzafoVar2) {
        zzd(null);
        if (this.zzano.zzfk()) {
            if (zzafoVar2.zzcow) {
                zzdw();
                try {
                    zzvj zzme = zzafoVar2.zzcet != null ? zzafoVar2.zzcet.zzme() : null;
                    zzvm zzmf = zzafoVar2.zzcet != null ? zzafoVar2.zzcet.zzmf() : null;
                    zzqm zzmj = zzafoVar2.zzcet != null ? zzafoVar2.zzcet.zzmj() : null;
                    String zzc = zzc(zzafoVar2);
                    if (zzme != null && this.zzano.zzauk != null) {
                        zzoj zzojVar = new zzoj(zzme.getHeadline(), zzme.getImages(), zzme.getBody(), zzme.zzjs() != null ? zzme.zzjs() : null, zzme.getCallToAction(), zzme.getStarRating(), zzme.getStore(), zzme.getPrice(), null, zzme.getExtras(), zzme.getVideoController(), zzme.zzml() != null ? (View) com.google.android.gms.dynamic.zzn.zzx(zzme.zzml()) : null, zzme.zzjx(), zzc);
                        zzojVar.zzb(new zzor(this.zzano.zzair, this, this.zzano.zzatx, zzme, zzojVar));
                        zza(zzojVar);
                    } else if (zzmf != null && this.zzano.zzaul != null) {
                        zzol zzolVar = new zzol(zzmf.getHeadline(), zzmf.getImages(), zzmf.getBody(), zzmf.zzjz() != null ? zzmf.zzjz() : null, zzmf.getCallToAction(), zzmf.getAdvertiser(), null, zzmf.getExtras(), zzmf.getVideoController(), zzmf.zzml() != null ? (View) com.google.android.gms.dynamic.zzn.zzx(zzmf.zzml()) : null, zzmf.zzjx(), zzc);
                        zzolVar.zzb(new zzor(this.zzano.zzair, this, this.zzano.zzatx, zzmf, zzolVar));
                        zza(zzolVar);
                    } else if (zzmj == null || this.zzano.zzaun == null || this.zzano.zzaun.get(zzmj.getCustomTemplateId()) == null) {
                        zzagf.zzcu("No matching mapper/listener for retrieved native ad template.");
                        zzi(0);
                        return false;
                    } else {
                        zzahn.zzdaw.post(new zzbh(this, zzmj));
                    }
                } catch (RemoteException e) {
                    zzagf.zzc("Failed to get native ad mapper", e);
                }
            } else {
                zzou zzouVar = zzafoVar2.zzcxr;
                if (this.zzarj) {
                    this.zzark.set(zzouVar);
                } else if ((zzouVar instanceof zzol) && this.zzano.zzaul != null) {
                    zza((zzol) zzafoVar2.zzcxr);
                } else if (!(zzouVar instanceof zzoj) || this.zzano.zzauk == null) {
                    if ((zzouVar instanceof zzon) && this.zzano.zzaun != null) {
                        zzon zzonVar = (zzon) zzouVar;
                        if (this.zzano.zzaun.get(zzonVar.getCustomTemplateId()) != null) {
                            zzahn.zzdaw.post(new zzbg(this, zzonVar.getCustomTemplateId(), zzafoVar2));
                        }
                    }
                    zzagf.zzcu("No matching listener for retrieved native ad template.");
                    zzi(0);
                    return false;
                } else {
                    zza((zzoj) zzafoVar2.zzcxr);
                }
            }
            return super.zza(zzafoVar, zzafoVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzjj zzjjVar, zzafo zzafoVar, boolean z) {
        return this.zzann.zzdx();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzjj zzjjVar, zznu zznuVar) {
        try {
            zzdp();
            return super.zza(zzjjVar, zznuVar, this.zzarm);
        } catch (Exception e) {
            if (zzakb.zzae(4)) {
                Log.i(AdRequest.LOGTAG, "Error initializing webview.", e);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzby() {
        zzc(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzc(int i, boolean z) {
        zzdw();
        super.zzc(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzc(boolean z) {
        super.zzc(z);
        if (this.zzanz) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbow)).booleanValue()) {
                zzds();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzuj
    public final void zzci() {
        zzlo zzij;
        zzafo zzafoVar = this.zzano.zzaud;
        if (zzafoVar.zzcet == null) {
            super.zzci();
            return;
        }
        try {
            zzva zzvaVar = zzafoVar.zzcet;
            zzll zzllVar = null;
            zzvj zzme = zzvaVar.zzme();
            if (zzme != null) {
                zzllVar = zzme.getVideoController();
            } else {
                zzvm zzmf = zzvaVar.zzmf();
                if (zzmf != null) {
                    zzllVar = zzmf.getVideoController();
                } else {
                    zzqm zzmj = zzvaVar.zzmj();
                    if (zzmj != null) {
                        zzllVar = zzmj.getVideoController();
                    }
                }
            }
            if (zzllVar == null || (zzij = zzllVar.zzij()) == null) {
                return;
            }
            zzij.onVideoEnd();
        } catch (RemoteException e) {
            zzagf.zzc("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzuj
    public final void zzcj() {
        if (this.zzano.zzaud == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzano.zzaud.zzceu)) {
            super.zzcj();
        } else {
            zzca();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzuj
    public final void zzco() {
        if (this.zzano.zzaud == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzano.zzaud.zzceu)) {
            super.zzco();
        } else {
            zzbz();
        }
    }

    @Override // com.google.android.gms.internal.zzot
    public final void zzcv() {
        zzanh zzanhVar = this.zzarl;
        if (zzanhVar != null) {
            zzanhVar.destroy();
            this.zzarl = null;
        }
    }

    @Override // com.google.android.gms.internal.zzot
    public final boolean zzcw() {
        if (zzcy() != null) {
            return zzcy().zzcdw;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzot
    public final boolean zzcx() {
        if (zzcy() != null) {
            return zzcy().zzcdx;
        }
        return false;
    }

    public final void zzd(List<String> list) {
        com.google.android.gms.common.internal.zzbq.zzge("setNativeTemplates must be called on the main UI thread.");
        this.zzano.zzauw = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzdp() throws zzanv {
        synchronized (this.mLock) {
            zzagf.v("Initializing webview native ads utills");
            this.zzarn = new zzzf(this.zzano.zzair, this, this.zzaro, this.zzano.zzatx, this.zzano.zzaty);
        }
    }

    public final zzzb zzdq() {
        zzzb zzzbVar;
        synchronized (this.mLock) {
            zzzbVar = this.zzarn;
        }
        return zzzbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Future<zzou> zzdr() {
        return this.zzark;
    }

    public final void zzds() {
        if (this.zzano.zzaud == null || this.zzarl == null) {
            this.zzanz = true;
            zzagf.zzcu("Request to enable ActiveView before adState is available.");
            return;
        }
        zzfs zzps = zzbs.zzem().zzps();
        zzjn zzjnVar = this.zzano.zzauc;
        zzafo zzafoVar = this.zzano.zzaud;
        zzanh zzanhVar = this.zzarl;
        if (zzanhVar == null) {
            throw null;
        }
        zzps.zza(zzjnVar, zzafoVar, (View) zzanhVar, zzanhVar);
        this.zzanz = false;
    }

    public final void zzdt() {
        this.zzanz = false;
        if (this.zzano.zzaud == null || this.zzarl == null) {
            zzagf.zzcu("Request to enable ActiveView before adState is available.");
        } else {
            zzbs.zzem().zzps().zzh(this.zzano.zzaud);
        }
    }

    public final SimpleArrayMap<String, zzqz> zzdu() {
        com.google.android.gms.common.internal.zzbq.zzge("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzano.zzaun;
    }

    public final void zzdv() {
        zzanh zzanhVar = this.zzarl;
        if (zzanhVar == null || zzanhVar.zzsg() == null || this.zzano.zzauo == null || this.zzano.zzauo.zzbvi == null) {
            return;
        }
        this.zzarl.zzsg().zzb(this.zzano.zzauo.zzbvi);
    }

    public final void zze(zzanh zzanhVar) {
        this.zzarl = zzanhVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzi(int i) {
        zzc(i, false);
    }

    public final void zzj(int i) {
        com.google.android.gms.common.internal.zzbq.zzge("setMaxNumberOfAds must be called on the main UI thread.");
        this.zzarm = i;
    }

    @Override // com.google.android.gms.internal.zzot
    public final zzqw zzs(String str) {
        com.google.android.gms.common.internal.zzbq.zzge("getOnCustomClickListener must be called on the main UI thread.");
        if (this.zzano.zzaum == null) {
            return null;
        }
        return this.zzano.zzaum.get(str);
    }
}
