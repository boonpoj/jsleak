package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzade extends com.google.android.gms.ads.internal.zzd implements zzaef {
    private static zzade zzcuy;
    private static final zzuw zzcuz = new zzuw();
    private boolean zzaqg;
    private zzafe zzaqh;
    private final Map<String, zzael> zzcva;
    private boolean zzcvb;

    public zzade(Context context, com.google.android.gms.ads.internal.zzv zzvVar, zzjn zzjnVar, zzux zzuxVar, zzakd zzakdVar) {
        super(context, zzjnVar, null, zzuxVar, zzakdVar, zzvVar);
        this.zzcva = new HashMap();
        zzcuy = this;
        this.zzaqh = new zzafe(context, null);
    }

    private static zzafp zzc(zzafp zzafpVar) {
        zzagf.v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzacg.zzb(zzafpVar.zzcxy).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzafpVar.zzcqv.zzatw);
            return new zzafp(zzafpVar.zzcqv, zzafpVar.zzcxy, new zzui(Arrays.asList(new zzuh(jSONObject, null, Arrays.asList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1L)), ((Long) zzkb.zzif().zzd(zznh.zzbnj)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1L, 0, 1, null, 0, -1, -1L, false), zzafpVar.zzauc, zzafpVar.errorCode, zzafpVar.zzcxp, zzafpVar.zzcxq, zzafpVar.zzcxj, zzafpVar.zzcxw, null);
        } catch (JSONException e) {
            zzagf.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return new zzafp(zzafpVar.zzcqv, zzafpVar.zzcxy, null, zzafpVar.zzauc, 0, zzafpVar.zzcxp, zzafpVar.zzcxq, zzafpVar.zzcxj, zzafpVar.zzcxw, null);
        }
    }

    public static zzade zzoa() {
        return zzcuy;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void destroy() {
        com.google.android.gms.common.internal.zzbq.zzge("destroy must be called on the main UI thread.");
        for (String str : this.zzcva.keySet()) {
            try {
                zzael zzaelVar = this.zzcva.get(str);
                if (zzaelVar != null && zzaelVar.zzoi() != null) {
                    zzaelVar.zzoi().destroy();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzagf.zzcu(valueOf.length() != 0 ? "Fail to destroy adapter: ".concat(valueOf) : new String("Fail to destroy adapter: "));
            }
        }
    }

    public final boolean isLoaded() {
        com.google.android.gms.common.internal.zzbq.zzge("isLoaded must be called on the main UI thread.");
        return this.zzano.zzaua == null && this.zzano.zzaub == null && this.zzano.zzaud != null && !this.zzcvb;
    }

    public final void onContextChanged(Context context) {
        for (zzael zzaelVar : this.zzcva.values()) {
            try {
                zzaelVar.zzoi().zzg(com.google.android.gms.dynamic.zzn.zzz(context));
            } catch (RemoteException e) {
                zzagf.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzaef
    public final void onRewardedVideoAdClosed() {
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzu(this.zzano.zzair)) {
            this.zzaqh.zzu(false);
        }
        zzbv();
    }

    @Override // com.google.android.gms.internal.zzaef
    public final void onRewardedVideoAdLeftApplication() {
        zzbw();
    }

    @Override // com.google.android.gms.internal.zzaef
    public final void onRewardedVideoAdOpened() {
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzu(this.zzano.zzair)) {
            this.zzaqh.zzu(true);
        }
        zza(this.zzano.zzaud, false);
        zzbx();
    }

    @Override // com.google.android.gms.internal.zzaef
    public final void onRewardedVideoStarted() {
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzces != null) {
            com.google.android.gms.ads.internal.zzbs.zzez();
            zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, this.zzano.zzaud, this.zzano.zzatw, false, this.zzano.zzaud.zzces.zzcda);
        }
        zzcb();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void pause() {
        com.google.android.gms.common.internal.zzbq.zzge("pause must be called on the main UI thread.");
        for (String str : this.zzcva.keySet()) {
            try {
                zzael zzaelVar = this.zzcva.get(str);
                if (zzaelVar != null && zzaelVar.zzoi() != null) {
                    zzaelVar.zzoi().pause();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzagf.zzcu(valueOf.length() != 0 ? "Fail to pause adapter: ".concat(valueOf) : new String("Fail to pause adapter: "));
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void resume() {
        com.google.android.gms.common.internal.zzbq.zzge("resume must be called on the main UI thread.");
        for (String str : this.zzcva.keySet()) {
            try {
                zzael zzaelVar = this.zzcva.get(str);
                if (zzaelVar != null && zzaelVar.zzoi() != null) {
                    zzaelVar.zzoi().resume();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzagf.zzcu(valueOf.length() != 0 ? "Fail to resume adapter: ".concat(valueOf) : new String("Fail to resume adapter: "));
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void setImmersiveMode(boolean z) {
        com.google.android.gms.common.internal.zzbq.zzge("setImmersiveMode must be called on the main UI thread.");
        this.zzaqg = z;
    }

    public final void zza(zzadv zzadvVar) {
        com.google.android.gms.common.internal.zzbq.zzge("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(zzadvVar.zzatw)) {
            zzagf.zzcu("Invalid ad unit id. Aborting.");
            zzahn.zzdaw.post(new zzadf(this));
            return;
        }
        this.zzcvb = false;
        this.zzano.zzatw = zzadvVar.zzatw;
        this.zzaqh.setAdUnitId(zzadvVar.zzatw);
        super.zzb(zzadvVar.zzcnd);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzafp zzafpVar, zznu zznuVar) {
        if (zzafpVar.errorCode != -2) {
            zzahn.zzdaw.post(new zzadg(this, zzafpVar));
            return;
        }
        this.zzano.zzaue = zzafpVar;
        if (zzafpVar.zzcxl == null) {
            this.zzano.zzaue = zzc(zzafpVar);
        }
        this.zzano.zzauz = 0;
        com.google.android.gms.ads.internal.zzbt zzbtVar = this.zzano;
        com.google.android.gms.ads.internal.zzbs.zzeh();
        zzaei zzaeiVar = new zzaei(this.zzano.zzair, this.zzano.zzaue, this);
        String valueOf = String.valueOf(zzaeiVar.getClass().getName());
        zzagf.zzbx(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzaeiVar.zznd();
        zzbtVar.zzaub = zzaeiVar;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzafo zzafoVar, zzafo zzafoVar2) {
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzjj zzjjVar, zzafo zzafoVar, boolean z) {
        return false;
    }

    public final zzael zzbq(String str) {
        zzael zzaelVar;
        zzael zzaelVar2 = this.zzcva.get(str);
        if (zzaelVar2 == null) {
            try {
                zzux zzuxVar = this.zzanw;
                if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                    zzuxVar = zzcuz;
                }
                zzaelVar = new zzael(zzuxVar.zzbg(str), this);
            } catch (Exception e) {
                e = e;
            }
            try {
                this.zzcva.put(str, zzaelVar);
                return zzaelVar;
            } catch (Exception e2) {
                e = e2;
                zzaelVar2 = zzaelVar;
                String valueOf = String.valueOf(str);
                zzagf.zzc(valueOf.length() != 0 ? "Fail to instantiate adapter ".concat(valueOf) : new String("Fail to instantiate adapter "), e);
                return zzaelVar2;
            }
        }
        return zzaelVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbv() {
        this.zzano.zzaud = null;
        super.zzbv();
    }

    @Override // com.google.android.gms.internal.zzaef
    public final void zzc(zzaeq zzaeqVar) {
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzcxl != null && !TextUtils.isEmpty(this.zzano.zzaud.zzcxl.zzcdr)) {
            zzaeqVar = new zzaeq(this.zzano.zzaud.zzcxl.zzcdr, this.zzano.zzaud.zzcxl.zzcds);
        }
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzces != null) {
            com.google.android.gms.ads.internal.zzbs.zzez();
            zzuq.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, this.zzano.zzaud.zzces.zzcdb, this.zzano.zzauv, zzaeqVar);
        }
        if (com.google.android.gms.ads.internal.zzbs.zzfd().zzu(this.zzano.zzair) && zzaeqVar != null) {
            com.google.android.gms.ads.internal.zzbs.zzfd().zza(this.zzano.zzair, com.google.android.gms.ads.internal.zzbs.zzfd().zzy(this.zzano.zzair), this.zzano.zzatw, zzaeqVar.type, zzaeqVar.zzcwd);
        }
        zza(zzaeqVar);
    }

    public final void zzob() {
        com.google.android.gms.common.internal.zzbq.zzge("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzagf.zzcu("The reward video has not loaded.");
            return;
        }
        this.zzcvb = true;
        zzael zzbq = zzbq(this.zzano.zzaud.zzceu);
        if (zzbq == null || zzbq.zzoi() == null) {
            return;
        }
        try {
            zzbq.zzoi().setImmersiveMode(this.zzaqg);
            zzbq.zzoi().showVideo();
        } catch (RemoteException e) {
            zzagf.zzc("Could not call showVideo.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzaef
    public final void zzoc() {
        onAdClicked();
    }
}
