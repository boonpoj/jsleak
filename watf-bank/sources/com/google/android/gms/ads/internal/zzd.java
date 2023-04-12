package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.zzaau;
import com.google.android.gms.internal.zzabo;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafq;
import com.google.android.gms.internal.zzafs;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzakv;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzbhf;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.internal.zzuj;
import com.google.android.gms.internal.zzuq;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzy;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public abstract class zzd extends zza implements com.google.android.gms.ads.internal.overlay.zzn, zzbl, zzuj {
    protected final zzux zzanw;
    private transient boolean zzanx;

    public zzd(Context context, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar, zzv zzvVar) {
        this(new zzbt(context, zzjnVar, str, zzakdVar), zzuxVar, null, zzvVar);
    }

    private zzd(zzbt zzbtVar, zzux zzuxVar, zzbi zzbiVar, zzv zzvVar) {
        super(zzbtVar, null, zzvVar);
        this.zzanw = zzuxVar;
        this.zzanx = false;
    }

    private final zzaau zza(zzjj zzjjVar, Bundle bundle, zzafs zzafsVar, int i) {
        PackageInfo packageInfo;
        Bundle bundle2;
        JSONArray optJSONArray;
        ApplicationInfo applicationInfo = this.zzano.zzair.getApplicationInfo();
        String str = null;
        try {
            packageInfo = zzbhf.zzdb(this.zzano.zzair).getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzano.zzair.getResources().getDisplayMetrics();
        if (this.zzano.zzatz == null || this.zzano.zzatz.getParent() == null) {
            bundle2 = null;
        } else {
            int[] iArr = new int[2];
            this.zzano.zzatz.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = 1;
            int i4 = iArr[1];
            int width = this.zzano.zzatz.getWidth();
            int height = this.zzano.zzatz.getHeight();
            i3 = (!this.zzano.zzatz.isShown() || i2 + width <= 0 || i4 + height <= 0 || i2 > displayMetrics.widthPixels || i4 > displayMetrics.heightPixels) ? 0 : 0;
            Bundle bundle3 = new Bundle(5);
            bundle3.putInt(AvidJSONUtil.KEY_X, i2);
            bundle3.putInt(AvidJSONUtil.KEY_Y, i4);
            bundle3.putInt("width", width);
            bundle3.putInt("height", height);
            bundle3.putInt("visible", i3);
            bundle2 = bundle3;
        }
        String zzpa = zzbs.zzem().zzpa();
        this.zzano.zzauf = new zzafq(zzpa, this.zzano.zzatw);
        this.zzano.zzauf.zzo(zzjjVar);
        zzbs.zzei();
        String zza = zzahn.zza(this.zzano.zzair, this.zzano.zzatz, this.zzano.zzauc);
        long j = 0;
        if (this.zzano.zzauj != null) {
            try {
                j = this.zzano.zzauj.getValue();
            } catch (RemoteException e2) {
                zzagf.zzcu("Cannot get correlation id, default to 0.");
            }
        }
        long j2 = j;
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzbs.zzem().zza(this.zzano.zzair, this, zzpa);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < this.zzano.zzaun.size(); i5++) {
            String keyAt = this.zzano.zzaun.keyAt(i5);
            arrayList.add(keyAt);
            if (this.zzano.zzaum.containsKey(keyAt) && this.zzano.zzaum.get(keyAt) != null) {
                arrayList2.add(keyAt);
            }
        }
        zzakv zza3 = zzahh.zza(zzahh.zzdar, new zze(this));
        zzakv zza4 = zzahh.zza(zzahh.zzdar, new zzf(this));
        String zzow = zzafsVar != null ? zzafsVar.zzow() : null;
        if (this.zzano.zzauw != null && this.zzano.zzauw.size() > 0) {
            int i6 = packageInfo != null ? packageInfo.versionCode : 0;
            if (i6 > zzbs.zzem().zzpk()) {
                zzbs.zzem().zzpr();
                zzbs.zzem().zzac(i6);
            } else {
                JSONObject zzpq = zzbs.zzem().zzpq();
                if (zzpq != null && (optJSONArray = zzpq.optJSONArray(this.zzano.zzatw)) != null) {
                    str = optJSONArray.toString();
                }
            }
        }
        String str2 = str;
        zzjn zzjnVar = this.zzano.zzauc;
        String str3 = this.zzano.zzatw;
        String zzic = zzkb.zzic();
        zzakd zzakdVar = this.zzano.zzaty;
        List<String> list = this.zzano.zzauw;
        boolean zzpd = zzbs.zzem().zzpd();
        int i7 = displayMetrics.widthPixels;
        int i8 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        List<String> zziw = zznh.zziw();
        String str4 = this.zzano.zzatv;
        zzpe zzpeVar = this.zzano.zzauo;
        String zzfm = this.zzano.zzfm();
        zzbs.zzei();
        float zzdn = zzahn.zzdn();
        zzbs.zzei();
        boolean zzdo = zzahn.zzdo();
        zzbs.zzei();
        int zzar = zzahn.zzar(this.zzano.zzair);
        zzbs.zzei();
        int zzw = zzahn.zzw(this.zzano.zzatz);
        boolean z = this.zzano.zzair instanceof Activity;
        boolean zzph = zzbs.zzem().zzph();
        boolean zzpm = zzbs.zzem().zzpm();
        int zzsr = zzbs.zzfb().zzsr();
        zzbs.zzei();
        Bundle zzqe = zzahn.zzqe();
        String zzqp = zzbs.zzer().zzqp();
        zzlr zzlrVar = this.zzano.zzauq;
        boolean zzqq = zzbs.zzer().zzqq();
        Bundle asBundle = zztk.zzlc().asBundle();
        zzbs.zzem();
        boolean contains = this.zzano.zzair.getSharedPreferences("admob", 0).getStringSet("never_pool_slots", Collections.emptySet()).contains(this.zzano.zzatw);
        List<Integer> list2 = this.zzano.zzaus;
        boolean zzamu = zzbhf.zzdb(this.zzano.zzair).zzamu();
        boolean zzpn = zzbs.zzem().zzpn();
        zzbs.zzek();
        return new zzaau(bundle2, zzjjVar, zzjnVar, str3, applicationInfo, packageInfo, zzpa, zzic, zzakdVar, zza2, list, arrayList, bundle, zzpd, i7, i8, f, zza, j2, uuid, zziw, str4, zzpeVar, zzfm, zzdn, zzdo, zzar, zzw, z, zzph, zza3, zzow, zzpm, zzsr, zzqe, zzqp, zzlrVar, zzqq, asBundle, contains, zza4, list2, str2, arrayList2, i, zzamu, zzpn, zzaht.zzqj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzc(zzafo zzafoVar) {
        if (zzafoVar == null) {
            return null;
        }
        String str = zzafoVar.zzceu;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && zzafoVar.zzces != null) {
            try {
                return new JSONObject(zzafoVar.zzces.zzccz).getString("class_name");
            } catch (NullPointerException e) {
            } catch (JSONException e2) {
            }
        }
        return str;
    }

    @Override // com.google.android.gms.internal.zzks
    public final String getMediationAdapterClassName() {
        if (this.zzano.zzaud == null) {
            return null;
        }
        return this.zzano.zzaud.zzceu;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzje
    public void onAdClicked() {
        if (this.zzano.zzaud == null) {
            zzagf.zzcu("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.zzano.zzaud.zzcxl != null && this.zzano.zzaud.zzcxl.zzcdk != null) {
            zzbs.zzez();
            zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, this.zzano.zzaud, this.zzano.zzatw, false, zzc(this.zzano.zzaud.zzcxl.zzcdk));
        }
        if (this.zzano.zzaud.zzces != null && this.zzano.zzaud.zzces.zzccv != null) {
            zzbs.zzez();
            zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, this.zzano.zzaud, this.zzano.zzatw, false, this.zzano.zzaud.zzces.zzccv);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
        this.zzanq.zzj(this.zzano.zzaud);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
        this.zzanq.zzk(this.zzano.zzaud);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public void pause() {
        com.google.android.gms.common.internal.zzbq.zzge("pause must be called on the main UI thread.");
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzciy != null && this.zzano.zzfk()) {
            zzbs.zzek();
            zzaht.zzi(this.zzano.zzaud.zzciy);
        }
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzcet != null) {
            try {
                this.zzano.zzaud.zzcet.pause();
            } catch (RemoteException e) {
                zzagf.zzcu("Could not pause mediation adapter.");
            }
        }
        this.zzanq.zzj(this.zzano.zzaud);
        this.zzann.pause();
    }

    public final void recordImpression() {
        zza(this.zzano.zzaud, false);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public void resume() {
        com.google.android.gms.common.internal.zzbq.zzge("resume must be called on the main UI thread.");
        zzanh zzanhVar = (this.zzano.zzaud == null || this.zzano.zzaud.zzciy == null) ? null : this.zzano.zzaud.zzciy;
        if (zzanhVar != null && this.zzano.zzfk()) {
            zzbs.zzek();
            zzaht.zzj(this.zzano.zzaud.zzciy);
        }
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzcet != null) {
            try {
                this.zzano.zzaud.zzcet.resume();
            } catch (RemoteException e) {
                zzagf.zzcu("Could not resume mediation adapter.");
            }
        }
        if (zzanhVar == null || !zzanhVar.zztf()) {
            this.zzann.resume();
        }
        this.zzanq.zzk(this.zzano.zzaud);
    }

    public void showInterstitial() {
        zzagf.zzcu("showInterstitial is not supported for current ad type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(zzafo zzafoVar, boolean z) {
        if (zzafoVar == null) {
            zzagf.zzcu("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (zzafoVar == null) {
            zzagf.zzcu("Ad state was null when trying to ping impression URLs.");
        } else {
            zzagf.zzbx("Pinging Impression URLs.");
            if (this.zzano.zzauf != null) {
                this.zzano.zzauf.zzoo();
            }
            zzafoVar.zzcxw.zza(zziu.zza.zzb.AD_IMPRESSION);
            if (zzafoVar.zzcdl != null && !zzafoVar.zzcxs) {
                zzbs.zzei();
                zzahn.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, zzc(zzafoVar.zzcdl));
                zzafoVar.zzcxs = true;
            }
        }
        if (!zzafoVar.zzcxt || z) {
            if (zzafoVar.zzcxl != null && zzafoVar.zzcxl.zzcdl != null) {
                zzbs.zzez();
                zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, zzafoVar, this.zzano.zzatw, z, zzc(zzafoVar.zzcxl.zzcdl));
            }
            if (zzafoVar.zzces != null && zzafoVar.zzces.zzccw != null) {
                zzbs.zzez();
                zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, zzafoVar, this.zzano.zzatw, z, zzafoVar.zzces.zzccw);
            }
            zzafoVar.zzcxt = true;
        }
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void zza(zzqm zzqmVar, String str) {
        String customTemplateId;
        zzqw zzqwVar = null;
        if (zzqmVar != null) {
            try {
                customTemplateId = zzqmVar.getCustomTemplateId();
            } catch (RemoteException e) {
                zzagf.zzc("Unable to call onCustomClick.", e);
                return;
            }
        } else {
            customTemplateId = null;
        }
        if (this.zzano.zzaum != null && customTemplateId != null) {
            zzqwVar = this.zzano.zzaum.get(customTemplateId);
        }
        if (zzqwVar == null) {
            zzagf.zzcu("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzqwVar.zzb(zzqmVar, str);
        }
    }

    public final boolean zza(zzaau zzaauVar, zznu zznuVar) {
        this.zzanj = zznuVar;
        zznuVar.zzf("seq_num", zzaauVar.zzcng);
        zznuVar.zzf("request_id", zzaauVar.zzcnq);
        zznuVar.zzf("session_id", zzaauVar.zzcnh);
        if (zzaauVar.zzcne != null) {
            zznuVar.zzf("app_version", String.valueOf(zzaauVar.zzcne.versionCode));
        }
        zzbt zzbtVar = this.zzano;
        zzbs.zzee();
        Context context = this.zzano.zzair;
        zzix zzixVar = this.zzanr.zzaoo;
        zzagb zzaboVar = zzaauVar.zzcnd.extras.getBundle("sdk_less_server_data") != null ? new zzabo(context, zzaauVar, this, zzixVar) : new zzzy(context, zzaauVar, this, zzixVar);
        zzaboVar.zzpy();
        zzbtVar.zzaua = zzaboVar;
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza
    final boolean zza(zzafo zzafoVar) {
        zzjj zzjjVar;
        boolean z = false;
        if (this.zzanp != null) {
            zzjjVar = this.zzanp;
            this.zzanp = null;
        } else {
            zzjjVar = zzafoVar.zzcnd;
            if (zzjjVar.extras != null) {
                z = zzjjVar.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(zzjjVar, zzafoVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzafo zzafoVar, zzafo zzafoVar2) {
        int i;
        if (zzafoVar != null && zzafoVar.zzcev != null) {
            zzafoVar.zzcev.zza((zzuj) null);
        }
        if (zzafoVar2.zzcev != null) {
            zzafoVar2.zzcev.zza(this);
        }
        int i2 = 0;
        if (zzafoVar2.zzcxl != null) {
            i2 = zzafoVar2.zzcxl.zzcdy;
            i = zzafoVar2.zzcxl.zzcdz;
        } else {
            i = 0;
        }
        this.zzano.zzaux.zze(i2, i);
        return true;
    }

    protected boolean zza(zzjj zzjjVar, zzafo zzafoVar, boolean z) {
        zzbi zzbiVar;
        long j;
        if (!z && this.zzano.zzfk()) {
            if (zzafoVar.zzcdq > 0) {
                zzbiVar = this.zzann;
                j = zzafoVar.zzcdq;
            } else if (zzafoVar.zzcxl != null && zzafoVar.zzcxl.zzcdq > 0) {
                zzbiVar = this.zzann;
                j = zzafoVar.zzcxl.zzcdq;
            } else if (!zzafoVar.zzcow && zzafoVar.errorCode == 2) {
                this.zzann.zzg(zzjjVar);
            }
            zzbiVar.zza(zzjjVar, j);
        }
        return this.zzann.zzdx();
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzjj zzjjVar, zznu zznuVar) {
        return zza(zzjjVar, zznuVar, 1);
    }

    public final boolean zza(zzjj zzjjVar, zznu zznuVar, int i) {
        zzafs zzafsVar;
        if (zzcf()) {
            zzbs.zzei();
            zzhk zzac = zzbs.zzem().zzac(this.zzano.zzair);
            Bundle zza = zzac == null ? null : zzahn.zza(zzac);
            this.zzann.cancel();
            this.zzano.zzauz = 0;
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbpl)).booleanValue()) {
                zzafsVar = zzbs.zzem().zzpp();
                zzbs.zzep().zza(this.zzano.zzair, this.zzano.zzaty, false, zzafsVar, zzafsVar != null ? zzafsVar.getAppId() : null, this.zzano.zzatw, null);
            } else {
                zzafsVar = null;
            }
            return zza(zza(zzjjVar, zza, zzafsVar, i), zznuVar);
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzyb
    public final void zzb(zzafo zzafoVar) {
        super.zzb(zzafoVar);
        if (zzafoVar.zzces != null) {
            zzagf.zzbx("Disable the debug gesture detector on the mediation ad frame.");
            if (this.zzano.zzatz != null) {
                this.zzano.zzatz.zzfq();
            }
            zzagf.zzbx("Pinging network fill URLs.");
            zzbs.zzez();
            zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, zzafoVar, this.zzano.zzatw, false, zzafoVar.zzces.zzccy);
            if (zzafoVar.zzcxl != null && zzafoVar.zzcxl.zzcdn != null && zzafoVar.zzcxl.zzcdn.size() > 0) {
                zzagf.zzbx("Pinging urls remotely");
                zzbs.zzei().zza(this.zzano.zzair, zzafoVar.zzcxl.zzcdn);
            }
        } else {
            zzagf.zzbx("Enable the debug gesture detector on the admob ad frame.");
            if (this.zzano.zzatz != null) {
                this.zzano.zzatz.zzfp();
            }
        }
        if (zzafoVar.errorCode != 3 || zzafoVar.zzcxl == null || zzafoVar.zzcxl.zzcdm == null) {
            return;
        }
        zzagf.zzbx("Pinging no fill URLs.");
        zzbs.zzez();
        zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, zzafoVar, this.zzano.zzatw, false, zzafoVar.zzcxl.zzcdm);
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void zzc(String str, String str2) {
        onAppEvent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final boolean zzc(zzjj zzjjVar) {
        return super.zzc(zzjjVar) && !this.zzanx;
    }

    protected boolean zzcf() {
        zzbs.zzei();
        if (zzahn.zzd(this.zzano.zzair, this.zzano.zzair.getPackageName(), "android.permission.INTERNET")) {
            zzbs.zzei();
            if (zzahn.zzag(this.zzano.zzair)) {
                return true;
            }
        }
        return false;
    }

    public void zzcg() {
        this.zzanx = false;
        zzbv();
        this.zzano.zzauf.zzoq();
    }

    public void zzch() {
        this.zzanx = true;
        zzbx();
    }

    public void zzci() {
        zzagf.zzcu("Mediated ad does not support onVideoEnd callback");
    }

    public void zzcj() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void zzck() {
        zzcg();
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void zzcl() {
        zzbw();
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void zzcm() {
        zzch();
    }

    @Override // com.google.android.gms.internal.zzuj
    public final void zzcn() {
        if (this.zzano.zzaud != null) {
            String str = this.zzano.zzaud.zzceu;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Mediation adapter ");
            sb.append(str);
            sb.append(" refreshed, but mediation adapters should never refresh.");
            zzagf.zzcu(sb.toString());
        }
        zza(this.zzano.zzaud, true);
        zzby();
    }

    public void zzco() {
        recordImpression();
    }

    @Override // com.google.android.gms.internal.zzks
    public final String zzcp() {
        if (this.zzano.zzaud == null) {
            return null;
        }
        return zzc(this.zzano.zzaud);
    }

    @Override // com.google.android.gms.ads.internal.zzbl
    public final void zzcq() {
        zzbs.zzei();
        zzahn.runOnUiThread(new zzg(this));
    }

    @Override // com.google.android.gms.ads.internal.zzbl
    public final void zzcr() {
        zzbs.zzei();
        zzahn.runOnUiThread(new zzh(this));
    }
}
