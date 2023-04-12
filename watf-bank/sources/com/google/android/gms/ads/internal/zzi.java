package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzxc;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzv;
@zzzv
/* loaded from: classes.dex */
public class zzi extends zzd implements zzae, zzxc {
    private boolean zzanz;

    public zzi(Context context, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar, zzv zzvVar) {
        super(context, zzjnVar, str, zzuxVar, zzakdVar, zzvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzanh zza(zzafp zzafpVar, zzw zzwVar, zzafb zzafbVar) throws zzanv {
        View nextView = this.zzano.zzatz.getNextView();
        if (nextView instanceof zzanh) {
            ((zzanh) nextView).destroy();
        }
        if (nextView != null) {
            this.zzano.zzatz.removeView(nextView);
        }
        zzanh zza = zzbs.zzej().zza(this.zzano.zzair, zzapa.zzc(this.zzano.zzauc), this.zzano.zzauc.zzbek, false, false, this.zzano.zzatx, this.zzano.zzaty, this.zzanj, this, this.zzanr, zzafpVar.zzcxw);
        if (this.zzano.zzauc.zzbem == null) {
            if (zza == null) {
                throw null;
            }
            zzg((View) zza);
        }
        zza.zzsz().zza(this, this, this, this, false, null, zzwVar, this, zzafbVar);
        zza(zza);
        zza.zzda(zzafpVar.zzcqv.zzcnq);
        return zza;
    }

    @Override // com.google.android.gms.internal.zzxc
    public final void zza(int i, int i2, int i3, int i4) {
        zzbx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public void zza(zzafp zzafpVar, zznu zznuVar) {
        if (zzafpVar.errorCode != -2) {
            zzahn.zzdaw.post(new zzk(this, zzafpVar));
            return;
        }
        if (zzafpVar.zzauc != null) {
            this.zzano.zzauc = zzafpVar.zzauc;
        }
        if (!zzafpVar.zzcxy.zzcow || zzafpVar.zzcxy.zzbep) {
            zzahn.zzdaw.post(new zzl(this, zzafpVar, this.zzanr.zzaon.zza(this.zzano.zzair, this.zzano.zzaty, zzafpVar.zzcxy), zznuVar));
            return;
        }
        this.zzano.zzauz = 0;
        zzbt zzbtVar = this.zzano;
        zzbs.zzeh();
        zzbtVar.zzaub = zzya.zza(this.zzano.zzair, this, zzafpVar, this.zzano.zzatx, null, this.zzanw, this, zznuVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzanh zzanhVar) {
        zzanhVar.zza("/trackActiveViewUnit", new zzj(this));
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void zza(zzoa zzoaVar) {
        com.google.android.gms.common.internal.zzbq.zzge("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzano.zzaut = zzoaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    public boolean zza(zzafo zzafoVar, zzafo zzafoVar2) {
        boolean z;
        if (this.zzano.zzfk() && this.zzano.zzatz != null) {
            this.zzano.zzatz.zzfn().zzcm(zzafoVar2.zzcpb);
        }
        try {
            if (zzafoVar2.zzciy != null && !zzafoVar2.zzcow && zzafoVar2.zzcxx) {
                if (((Boolean) zzkb.zzif().zzd(zznh.zzbrw)).booleanValue()) {
                    String str = zzafoVar2.zzcnd.zzbdt;
                    if (str != null && !"com.google.ads.mediation.AbstractAdViewAdapter".equals(str)) {
                        z = false;
                        if (z && !zzafoVar2.zzcnd.extras.containsKey("sdk_less_server_data")) {
                            zzafoVar2.zzciy.zztl();
                        }
                    }
                    z = true;
                    if (z) {
                        zzafoVar2.zzciy.zztl();
                    }
                }
            }
        } catch (RuntimeException e) {
            zzagf.v("Could not render test AdLabel.");
        }
        return super.zza(zzafoVar, zzafoVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzanh zzanhVar) {
        if (this.zzano.zzaud == null) {
            this.zzanz = true;
            zzagf.zzcu("Request to enable ActiveView before adState is available.");
            return;
        }
        zzfs zzfsVar = this.zzanq;
        zzjn zzjnVar = this.zzano.zzauc;
        zzafo zzafoVar = this.zzano.zzaud;
        if (zzanhVar == null) {
            throw null;
        }
        zzfsVar.zza(zzjnVar, zzafoVar, (View) zzanhVar, zzanhVar);
        this.zzanz = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public void zzby() {
        super.zzby();
        if (this.zzanz) {
            if (((Boolean) zzkb.zzif().zzd(zznh.zzbow)).booleanValue()) {
                zzb(this.zzano.zzaud.zzciy);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzae
    public final void zzcs() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzae
    public final void zzct() {
        recordImpression();
        zzbu();
    }

    @Override // com.google.android.gms.internal.zzxc
    public final void zzcu() {
        zzbv();
    }

    @Override // com.google.android.gms.ads.internal.zzae
    public final void zzh(View view) {
        this.zzano.zzauy = view;
        zzb(new zzafo(this.zzano.zzaue, null, null, null, null, null, null, null));
    }
}
