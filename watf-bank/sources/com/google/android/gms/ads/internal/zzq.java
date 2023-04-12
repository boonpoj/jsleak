package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzui;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzzv;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzq extends zzd implements zzot {
    private boolean zzamr;
    private zzafo zzaof;
    private boolean zzaog;

    public zzq(Context context, zzv zzvVar, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar) {
        super(context, zzjnVar, str, zzuxVar, zzakdVar, zzvVar);
        this.zzaog = false;
    }

    private static zzafo zza(zzafp zzafpVar, int i) {
        return new zzafo(zzafpVar.zzcqv.zzcnd, null, zzafpVar.zzcxy.zzcdk, i, zzafpVar.zzcxy.zzcdl, zzafpVar.zzcxy.zzcoy, zzafpVar.zzcxy.orientation, zzafpVar.zzcxy.zzcdq, zzafpVar.zzcqv.zzcng, zzafpVar.zzcxy.zzcow, null, null, null, zzafpVar.zzcxl, null, zzafpVar.zzcxy.zzcox, zzafpVar.zzauc, zzafpVar.zzcxy.zzcov, zzafpVar.zzcxp, zzafpVar.zzcxq, zzafpVar.zzcxy.zzcpb, zzafpVar.zzcxj, null, zzafpVar.zzcxy.zzcpl, zzafpVar.zzcxy.zzcpm, zzafpVar.zzcxy.zzcpm, zzafpVar.zzcxy.zzcpo, zzafpVar.zzcxy.zzcpp, null, zzafpVar.zzcxy.zzcdn, zzafpVar.zzcxy.zzcps, zzafpVar.zzcxw, zzafpVar.zzcxy.zzaqv, zzafpVar.zzcxx);
    }

    private final boolean zzb(zzafo zzafoVar, zzafo zzafoVar2) {
        Handler handler;
        Runnable zztVar;
        zzd(null);
        if (this.zzano.zzfk()) {
            try {
                zzvj zzme = zzafoVar2.zzcet != null ? zzafoVar2.zzcet.zzme() : null;
                zzvm zzmf = zzafoVar2.zzcet != null ? zzafoVar2.zzcet.zzmf() : null;
                zzqm zzmj = zzafoVar2.zzcet != null ? zzafoVar2.zzcet.zzmj() : null;
                String zzc = zzc(zzafoVar2);
                if (zzme != null && this.zzano.zzauk != null) {
                    zzoj zzojVar = new zzoj(zzme.getHeadline(), zzme.getImages(), zzme.getBody(), zzme.zzjs() != null ? zzme.zzjs() : null, zzme.getCallToAction(), zzme.getStarRating(), zzme.getStore(), zzme.getPrice(), null, zzme.getExtras(), zzme.getVideoController(), zzme.zzml() != null ? (View) com.google.android.gms.dynamic.zzn.zzx(zzme.zzml()) : null, zzme.zzjx(), zzc);
                    zzojVar.zzb(new zzor(this.zzano.zzair, this, this.zzano.zzatx, zzme, zzojVar));
                    handler = zzahn.zzdaw;
                    zztVar = new zzs(this, zzojVar);
                } else if (zzmf == null || this.zzano.zzaul == null) {
                    if (zzmj != null && this.zzano.zzaun != null && this.zzano.zzaun.get(zzmj.getCustomTemplateId()) != null) {
                        zzahn.zzdaw.post(new zzu(this, zzmj));
                        return super.zza(zzafoVar, zzafoVar2);
                    }
                    zzagf.zzcu("No matching mapper/listener for retrieved native ad template.");
                    zzi(0);
                    return false;
                } else {
                    zzol zzolVar = new zzol(zzmf.getHeadline(), zzmf.getImages(), zzmf.getBody(), zzmf.zzjz() != null ? zzmf.zzjz() : null, zzmf.getCallToAction(), zzmf.getAdvertiser(), null, zzmf.getExtras(), zzmf.getVideoController(), zzmf.zzml() != null ? (View) com.google.android.gms.dynamic.zzn.zzx(zzmf.zzml()) : null, zzmf.zzjx(), zzc);
                    zzolVar.zzb(new zzor(this.zzano.zzair, this, this.zzano.zzatx, zzmf, zzolVar));
                    handler = zzahn.zzdaw;
                    zztVar = new zzt(this, zzolVar);
                }
                handler.post(zztVar);
                return super.zza(zzafoVar, zzafoVar2);
            } catch (RemoteException e) {
                zzagf.zzc("Failed to get native ad mapper", e);
            }
        } else {
            zzagf.zzcu("Native ad does not have custom rendering mode.");
        }
        zzi(0);
        return false;
    }

    private final boolean zzc(zzafo zzafoVar, zzafo zzafoVar2) {
        View zze = zzaq.zze(zzafoVar2);
        if (zze == null) {
            return false;
        }
        View nextView = this.zzano.zzatz.getNextView();
        if (nextView != null) {
            if (nextView instanceof zzanh) {
                ((zzanh) nextView).destroy();
            }
            this.zzano.zzatz.removeView(nextView);
        }
        if (!zzaq.zzf(zzafoVar2)) {
            try {
                zzg(zze);
            } catch (Throwable th) {
                zzbs.zzem().zza(th, "AdLoaderManager.swapBannerViews");
                zzagf.zzc("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.zzano.zzatz.getChildCount() > 1) {
            this.zzano.zzatz.showNext();
        }
        if (zzafoVar != null) {
            View nextView2 = this.zzano.zzatz.getNextView();
            if (nextView2 != null) {
                this.zzano.zzatz.removeView(nextView2);
            }
            this.zzano.zzfj();
        }
        this.zzano.zzatz.setMinimumWidth(zzbs().widthPixels);
        this.zzano.zzatz.setMinimumHeight(zzbs().heightPixels);
        this.zzano.zzatz.requestLayout();
        this.zzano.zzatz.setVisibility(0);
        return true;
    }

    private final zzui zzcy() {
        if (this.zzano.zzaud == null || !this.zzano.zzaud.zzcow) {
            return null;
        }
        return this.zzano.zzaud.zzcxl;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final zzll getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void pause() {
        if (!this.zzaog) {
            throw new IllegalStateException("Native Ad does not support pause().");
        }
        super.pause();
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void resume() {
        if (!this.zzaog) {
            throw new IllegalStateException("Native Ad does not support resume().");
        }
        super.resume();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void setManualImpressionsEnabled(boolean z) {
        com.google.android.gms.common.internal.zzbq.zzge("setManualImpressionsEnabled must be called from the main thread.");
        this.zzamr = z;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzks
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // com.google.android.gms.ads.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.zzafp r11, com.google.android.gms.internal.zznu r12) {
        /*
            r10 = this;
            r0 = 0
            r10.zzaof = r0
            int r0 = r11.errorCode
            r1 = 0
            r2 = -2
            if (r0 == r2) goto L12
            int r0 = r11.errorCode
            com.google.android.gms.internal.zzafo r0 = zza(r11, r0)
        Lf:
            r10.zzaof = r0
            goto L22
        L12:
            com.google.android.gms.internal.zzaax r0 = r11.zzcxy
            boolean r0 = r0.zzcow
            if (r0 != 0) goto L22
            java.lang.String r0 = "partialAdState is not mediation"
            com.google.android.gms.internal.zzagf.zzcu(r0)
            com.google.android.gms.internal.zzafo r0 = zza(r11, r1)
            goto Lf
        L22:
            com.google.android.gms.internal.zzafo r0 = r10.zzaof
            if (r0 == 0) goto L31
            android.os.Handler r11 = com.google.android.gms.internal.zzahn.zzdaw
            com.google.android.gms.ads.internal.zzr r12 = new com.google.android.gms.ads.internal.zzr
            r12.<init>(r10)
            r11.post(r12)
            return
        L31:
            com.google.android.gms.internal.zzjn r0 = r11.zzauc
            if (r0 == 0) goto L3b
            com.google.android.gms.ads.internal.zzbt r0 = r10.zzano
            com.google.android.gms.internal.zzjn r2 = r11.zzauc
            r0.zzauc = r2
        L3b:
            com.google.android.gms.ads.internal.zzbt r0 = r10.zzano
            r0.zzauz = r1
            com.google.android.gms.ads.internal.zzbt r0 = r10.zzano
            com.google.android.gms.ads.internal.zzbs.zzeh()
            com.google.android.gms.ads.internal.zzbt r1 = r10.zzano
            android.content.Context r2 = r1.zzair
            com.google.android.gms.ads.internal.zzbt r1 = r10.zzano
            com.google.android.gms.internal.zzcv r5 = r1.zzatx
            r6 = 0
            com.google.android.gms.internal.zzux r7 = r10.zzanw
            r3 = r10
            r4 = r11
            r8 = r10
            r9 = r12
            com.google.android.gms.internal.zzaif r11 = com.google.android.gms.internal.zzya.zza(r2, r3, r4, r5, r6, r7, r8, r9)
            r0.zzaub = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzq.zza(com.google.android.gms.internal.zzafp, com.google.android.gms.internal.zznu):void");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void zza(zzoa zzoaVar) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    @Override // com.google.android.gms.internal.zzot
    public final void zza(zzoq zzoqVar) {
        zzagf.zzcu("Unexpected call to AdLoaderManager method");
    }

    @Override // com.google.android.gms.internal.zzot
    public final void zza(zzos zzosVar) {
        zzagf.zzcu("Unexpected call to AdLoaderManager method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(com.google.android.gms.internal.zzafo r5, com.google.android.gms.internal.zzafo r6) {
        /*
            r4 = this;
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzano
            boolean r0 = r0.zzfk()
            if (r0 == 0) goto L9a
            boolean r0 = r6.zzcow
            r1 = 0
            if (r0 != 0) goto L16
            r4.zzi(r1)
            java.lang.String r5 = "newState is not mediation."
        L12:
            com.google.android.gms.internal.zzagf.zzcu(r5)
            return r1
        L16:
            com.google.android.gms.internal.zzuh r0 = r6.zzces
            r2 = 1
            if (r0 == 0) goto L6a
            com.google.android.gms.internal.zzuh r0 = r6.zzces
            boolean r0 = r0.zzlv()
            if (r0 == 0) goto L6a
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzano
            boolean r0 = r0.zzfk()
            if (r0 == 0) goto L3e
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzano
            com.google.android.gms.ads.internal.zzbu r0 = r0.zzatz
            if (r0 == 0) goto L3e
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzano
            com.google.android.gms.ads.internal.zzbu r0 = r0.zzatz
            com.google.android.gms.internal.zzaig r0 = r0.zzfn()
            java.lang.String r3 = r6.zzcpb
            r0.zzcm(r3)
        L3e:
            boolean r0 = super.zza(r5, r6)
            if (r0 != 0) goto L46
        L44:
            r5 = 0
            goto L64
        L46:
            com.google.android.gms.ads.internal.zzbt r0 = r4.zzano
            boolean r0 = r0.zzfk()
            if (r0 == 0) goto L58
            boolean r5 = r4.zzc(r5, r6)
            if (r5 != 0) goto L58
            r4.zzi(r1)
            goto L44
        L58:
            com.google.android.gms.ads.internal.zzbt r5 = r4.zzano
            boolean r5 = r5.zzfl()
            if (r5 != 0) goto L63
            super.zza(r6, r1)
        L63:
            r5 = 1
        L64:
            if (r5 != 0) goto L67
            return r1
        L67:
            r4.zzaog = r2
            goto L7d
        L6a:
            com.google.android.gms.internal.zzuh r0 = r6.zzces
            if (r0 == 0) goto L93
            com.google.android.gms.internal.zzuh r0 = r6.zzces
            boolean r0 = r0.zzlw()
            if (r0 == 0) goto L93
            boolean r5 = r4.zzb(r5, r6)
            if (r5 != 0) goto L7d
            return r1
        L7d:
            java.util.ArrayList r5 = new java.util.ArrayList
            java.lang.Integer[] r6 = new java.lang.Integer[r2]
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r1] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            r5.<init>(r6)
            r4.zze(r5)
            return r2
        L93:
            r4.zzi(r1)
            java.lang.String r5 = "Response is neither banner nor native."
            goto L12
        L9a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "AdLoader API does not support custom rendering."
            r5.<init>(r6)
            goto La3
        La2:
            throw r5
        La3:
            goto La2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzq.zza(com.google.android.gms.internal.zzafo, com.google.android.gms.internal.zzafo):boolean");
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zza(zzjj zzjjVar, zzafo zzafoVar, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final boolean zzb(zzjj zzjjVar) {
        zzjj zzjjVar2 = zzjjVar;
        if (this.zzano.zzaus != null && this.zzano.zzaus.size() == 1 && this.zzano.zzaus.get(0).intValue() == 2) {
            zzagf.e("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            zzi(0);
            return false;
        } else if (this.zzano.zzaur != null) {
            if (zzjjVar2.zzbdk != this.zzamr) {
                zzjjVar2 = new zzjj(zzjjVar2.versionCode, zzjjVar2.zzbdf, zzjjVar2.extras, zzjjVar2.zzbdg, zzjjVar2.zzbdh, zzjjVar2.zzbdi, zzjjVar2.zzbdj, zzjjVar2.zzbdk || this.zzamr, zzjjVar2.zzbdl, zzjjVar2.zzbdm, zzjjVar2.zzbdn, zzjjVar2.zzbdo, zzjjVar2.zzbdp, zzjjVar2.zzbdq, zzjjVar2.zzbdr, zzjjVar2.zzbds, zzjjVar2.zzbdt, zzjjVar2.zzbdu);
            }
            return super.zzb(zzjjVar2);
        } else {
            return super.zzb(zzjjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzby() {
        super.zzby();
        zzafo zzafoVar = this.zzano.zzaud;
        if (zzafoVar == null || zzafoVar.zzces == null || !zzafoVar.zzces.zzlv() || this.zzano.zzaur == null) {
            return;
        }
        try {
            this.zzano.zzaur.zza(this, com.google.android.gms.dynamic.zzn.zzz(this.zzano.zzair));
        } catch (RemoteException e) {
            zzagf.zzc("Could not call PublisherAdViewLoadedListener.onPublisherAdViewLoaded().", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzuj
    public final void zzcj() {
        if (this.zzano.zzaud == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzano.zzaud.zzceu) || this.zzano.zzaud.zzces == null || !this.zzano.zzaud.zzces.zzlw()) {
            super.zzcj();
        } else {
            zzca();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzuj
    public final void zzco() {
        if (this.zzano.zzaud == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzano.zzaud.zzceu) || this.zzano.zzaud.zzces == null || !this.zzano.zzaud.zzces.zzlw()) {
            super.zzco();
        } else {
            zzbz();
        }
    }

    @Override // com.google.android.gms.internal.zzot
    public final void zzcv() {
        zzagf.zzcu("Unexpected call to AdLoaderManager method");
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

    public final void zze(List<Integer> list) {
        com.google.android.gms.common.internal.zzbq.zzge("setAllowedAdTypes must be called on the main UI thread.");
        this.zzano.zzaus = list;
    }

    @Override // com.google.android.gms.internal.zzot
    public final zzqw zzs(String str) {
        com.google.android.gms.common.internal.zzbq.zzge("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzano.zzaum.get(str);
    }
}
