package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzaax;
import com.google.android.gms.internal.zzacg;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafe;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzani;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzak extends zzi implements com.google.android.gms.ads.internal.gmsg.zzag, com.google.android.gms.ads.internal.gmsg.zzx {
    private transient boolean zzaqc;
    private int zzaqd;
    private boolean zzaqe;
    private float zzaqf;
    private boolean zzaqg;
    private zzafe zzaqh;
    private String zzaqi;
    private final String zzaqj;

    public zzak(Context context, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar, zzv zzvVar) {
        super(context, zzjnVar, str, zzuxVar, zzakdVar, zzvVar);
        this.zzaqd = -1;
        this.zzaqc = false;
        this.zzaqj = (zzjnVar == null || !"reward_mb".equals(zzjnVar.zzbek)) ? "/Interstitial" : "/Rewarded";
    }

    private final void zza(Bundle bundle) {
        zzbs.zzei().zzb(this.zzano.zzair, this.zzano.zzaty.zzcv, "gmob-apps", bundle, false);
    }

    private static zzafp zzb(zzafp zzafpVar) {
        try {
            String jSONObject = zzacg.zzb(zzafpVar.zzcxy).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zzafpVar.zzcqv.zzatw);
            zzuh zzuhVar = new zzuh(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1L);
            zzaax zzaaxVar = zzafpVar.zzcxy;
            zzui zzuiVar = new zzui(Collections.singletonList(zzuhVar), ((Long) zzkb.zzif().zzd(zznh.zzbnj)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzaaxVar.zzcdn, zzaaxVar.zzcdo, "", -1L, 0, 1, null, 0, -1, -1L, false);
            return new zzafp(zzafpVar.zzcqv, new zzaax(zzafpVar.zzcqv, zzaaxVar.zzcja, zzaaxVar.body, Collections.emptyList(), Collections.emptyList(), zzaaxVar.zzcov, true, zzaaxVar.zzcox, Collections.emptyList(), zzaaxVar.zzcdq, zzaaxVar.orientation, zzaaxVar.zzcoz, zzaaxVar.zzcpa, zzaaxVar.zzcpb, zzaaxVar.zzcpc, zzaaxVar.zzcpd, null, zzaaxVar.zzcpf, zzaaxVar.zzben, zzaaxVar.zzcnl, zzaaxVar.zzcpg, zzaaxVar.zzcph, zzaaxVar.zzcpk, zzaaxVar.zzbeo, zzaaxVar.zzbep, null, Collections.emptyList(), Collections.emptyList(), zzaaxVar.zzcpo, zzaaxVar.zzcpp, zzaaxVar.zzcnz, zzaaxVar.zzcoa, zzaaxVar.zzcdn, zzaaxVar.zzcdo, zzaaxVar.zzcpq, null, zzaaxVar.zzcps, zzaaxVar.zzcpt, zzaaxVar.zzcol, zzaaxVar.zzaqv, 0), zzuiVar, zzafpVar.zzauc, zzafpVar.errorCode, zzafpVar.zzcxp, zzafpVar.zzcxq, null, zzafpVar.zzcxw, null);
        } catch (JSONException e) {
            zzagf.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zzafpVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void setImmersiveMode(boolean z) {
        com.google.android.gms.common.internal.zzbq.zzge("setImmersiveMode must be called on the main UI thread.");
        this.zzaqg = z;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzks
    public final void showInterstitial() {
        com.google.android.gms.common.internal.zzbq.zzge("showInterstitial must be called on the main UI thread.");
        if (zzbs.zzfd().zzt(this.zzano.zzair)) {
            this.zzaqi = zzbs.zzfd().zzv(this.zzano.zzair);
            String valueOf = String.valueOf(this.zzaqi);
            String valueOf2 = String.valueOf(this.zzaqj);
            this.zzaqi = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        if (this.zzano.zzaud == null) {
            zzagf.zzcu("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbmt)).booleanValue()) {
            String packageName = (this.zzano.zzair.getApplicationContext() != null ? this.zzano.zzair.getApplicationContext() : this.zzano.zzair).getPackageName();
            if (!this.zzaqc) {
                zzagf.zzcu("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zza(bundle);
            }
            zzbs.zzei();
            if (!zzahn.zzan(this.zzano.zzair)) {
                zzagf.zzcu("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString("action", "show_interstitial_app_not_in_foreground");
                zza(bundle2);
            }
        }
        if (this.zzano.zzfl()) {
            return;
        }
        if (this.zzano.zzaud.zzcow && this.zzano.zzaud.zzcet != null) {
            try {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzblo)).booleanValue()) {
                    this.zzano.zzaud.zzcet.setImmersiveMode(this.zzaqg);
                }
                this.zzano.zzaud.zzcet.showInterstitial();
            } catch (RemoteException e) {
                zzagf.zzc("Could not show interstitial.", e);
                zzdk();
            }
        } else if (this.zzano.zzaud.zzciy == null) {
            zzagf.zzcu("The interstitial failed to load.");
        } else if (this.zzano.zzaud.zzciy.zztc()) {
            zzagf.zzcu("The interstitial is already showing.");
        } else {
            this.zzano.zzaud.zzciy.zzad(true);
            zzbt zzbtVar = this.zzano;
            zzanh zzanhVar = this.zzano.zzaud.zzciy;
            Bitmap bitmap = null;
            if (zzanhVar == null) {
                throw null;
            }
            zzbtVar.zzi((View) zzanhVar);
            if (this.zzano.zzaud.zzcxj != null) {
                this.zzanq.zza(this.zzano.zzauc, this.zzano.zzaud);
            }
            zzafo zzafoVar = this.zzano.zzaud;
            if (zzafoVar.zzfv()) {
                Context context = this.zzano.zzair;
                zzanh zzanhVar2 = zzafoVar.zzciy;
                if (zzanhVar2 == null) {
                    throw null;
                }
                new zzgp(context, (View) zzanhVar2).zza(zzafoVar.zzciy);
            } else {
                zzafoVar.zzciy.zzsz().zza(new zzal(this, zzafoVar));
            }
            if (this.zzano.zzaqo) {
                zzbs.zzei();
                bitmap = zzahn.zzao(this.zzano.zzair);
            }
            this.zzaqd = zzbs.zzfa().zzb(bitmap);
            if (((Boolean) zzkb.zzif().zzd(zznh.zzboc)).booleanValue() && bitmap != null) {
                new zzam(this, this.zzaqd).zzpy();
                return;
            }
            zzao zzaoVar = new zzao(this.zzano.zzaqo, zzdj(), false, 0.0f, -1, this.zzaqg, this.zzano.zzaud.zzaqv);
            int requestedOrientation = this.zzano.zzaud.zzciy.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzano.zzaud.orientation;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.zzano.zzaud.zzciy, requestedOrientation, this.zzano.zzaty, this.zzano.zzaud.zzcpb, zzaoVar);
            zzbs.zzeg();
            com.google.android.gms.ads.internal.overlay.zzl.zza(this.zzano.zzair, adOverlayInfoParcel, true);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzi
    protected final zzanh zza(zzafp zzafpVar, zzw zzwVar, zzafb zzafbVar) throws zzanv {
        zzanh zza = zzbs.zzej().zza(this.zzano.zzair, zzapa.zzc(this.zzano.zzauc), this.zzano.zzauc.zzbek, false, false, this.zzano.zzatx, this.zzano.zzaty, this.zzanj, this, this.zzanr, zzafpVar.zzcxw);
        zza.zzsz().zza(this, null, this, this, ((Boolean) zzkb.zzif().zzd(zznh.zzbki)).booleanValue(), this, zzwVar, null, zzafbVar);
        zza(zza);
        zza.zzda(zzafpVar.zzcqv.zzcnq);
        zza.zzsz().zza("/reward", new com.google.android.gms.ads.internal.gmsg.zzaf(this));
        return zza;
    }

    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zza
    public final void zza(zzafp zzafpVar, zznu zznuVar) {
        if (!((Boolean) zzkb.zzif().zzd(zznh.zzblu)).booleanValue()) {
            super.zza(zzafpVar, zznuVar);
        } else if (zzafpVar.errorCode != -2) {
            super.zza(zzafpVar, zznuVar);
        } else {
            boolean z = !zzafpVar.zzcxy.zzcow;
            if (zza(zzafpVar.zzcqv.zzcnd) && z) {
                this.zzano.zzaue = zzb(zzafpVar);
            }
            super.zza(this.zzano.zzaue, zznuVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzx
    public final void zza(boolean z, float f) {
        this.zzaqe = z;
        this.zzaqf = f;
    }

    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzafo zzafoVar, zzafo zzafoVar2) {
        if (super.zza(zzafoVar, zzafoVar2)) {
            if (this.zzano.zzfk() || this.zzano.zzauy == null || zzafoVar2.zzcxj == null) {
                return true;
            }
            this.zzanq.zza(this.zzano.zzauc, zzafoVar2, this.zzano.zzauy);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzjj zzjjVar, zzafo zzafoVar, boolean z) {
        if (this.zzano.zzfk() && zzafoVar.zzciy != null) {
            zzbs.zzek();
            zzaht.zzi(zzafoVar.zzciy);
        }
        return this.zzann.zzdx();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzjj zzjjVar, zznu zznuVar) {
        if (this.zzano.zzaud != null) {
            zzagf.zzcu("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.zzaqh == null && zza(zzjjVar) && zzbs.zzfd().zzt(this.zzano.zzair) && !TextUtils.isEmpty(this.zzano.zzatw)) {
            this.zzaqh = new zzafe(this.zzano.zzair, this.zzano.zzatw);
        }
        return super.zza(zzjjVar, zznuVar);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzag
    public final void zzb(zzaeq zzaeqVar) {
        if (this.zzano.zzaud != null) {
            if (this.zzano.zzaud.zzcpn != null) {
                zzbs.zzei();
                zzahn.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, this.zzano.zzaud.zzcpn);
            }
            if (this.zzano.zzaud.zzcpl != null) {
                zzaeqVar = this.zzano.zzaud.zzcpl;
            }
        }
        zza(zzaeqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbv() {
        zzdk();
        super.zzbv();
    }

    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zza
    protected final void zzby() {
        super.zzby();
        this.zzaqc = true;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.overlay.zzn
    public final void zzcg() {
        super.zzcg();
        this.zzanq.zzh(this.zzano.zzaud);
        zzafe zzafeVar = this.zzaqh;
        if (zzafeVar != null) {
            zzafeVar.zzu(false);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.overlay.zzn
    public final void zzch() {
        zzani zzsz;
        recordImpression();
        super.zzch();
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzciy != null && (zzsz = this.zzano.zzaud.zzciy.zzsz()) != null) {
            zzsz.zztt();
        }
        if (zzbs.zzfd().zzt(this.zzano.zzair) && this.zzano.zzaud != null && this.zzano.zzaud.zzciy != null) {
            zzbs.zzfd().zzd(this.zzano.zzaud.zzciy.getContext(), this.zzaqi);
        }
        zzafe zzafeVar = this.zzaqh;
        if (zzafeVar != null) {
            zzafeVar.zzu(true);
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzx
    public final void zzd(boolean z) {
        this.zzano.zzaqo = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzdj() {
        Window window;
        if ((this.zzano.zzair instanceof Activity) && (window = ((Activity) this.zzano.zzair).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public final void zzdk() {
        zzbs.zzfa().zzb(Integer.valueOf(this.zzaqd));
        if (this.zzano.zzfk()) {
            this.zzano.zzfi();
            this.zzano.zzaud = null;
            this.zzano.zzaqo = false;
            this.zzaqc = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzag
    public final void zzdl() {
        if (this.zzano.zzaud != null && this.zzano.zzaud.zzcxo != null) {
            zzbs.zzei();
            zzahn.zza(this.zzano.zzair, this.zzano.zzaty.zzcv, this.zzano.zzaud.zzcxo);
        }
        zzcb();
    }
}
