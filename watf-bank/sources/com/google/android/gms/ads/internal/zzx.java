package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafe;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanq;
import com.google.android.gms.internal.zzanv;
import com.google.android.gms.internal.zzapa;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzvj;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.internal.zzzv;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import java.lang.ref.WeakReference;
import java.util.List;
@zzzv
/* loaded from: classes.dex */
public final class zzx extends zzi implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzamr;
    private WeakReference<Object> zzaos;

    public zzx(Context context, zzjn zzjnVar, String str, zzux zzuxVar, zzakd zzakdVar, zzv zzvVar) {
        super(context, zzjnVar, str, zzuxVar, zzakdVar, zzvVar);
        this.zzaos = new WeakReference<>(null);
    }

    private final boolean zzd(zzafo zzafoVar, zzafo zzafoVar2) {
        if (zzafoVar2.zzcow) {
            View zze = zzaq.zze(zzafoVar2);
            if (zze == null) {
                zzagf.zzcu("Could not get mediation view");
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
                    if (zzbs.zzfd().zzr(this.zzano.zzair)) {
                        new zzgp(this.zzano.zzair, zze).zza(new zzafe(this.zzano.zzair, this.zzano.zzatw));
                    }
                    if (zzafoVar2.zzcxn != null) {
                        this.zzano.zzatz.setMinimumWidth(zzafoVar2.zzcxn.widthPixels);
                        this.zzano.zzatz.setMinimumHeight(zzafoVar2.zzcxn.heightPixels);
                    }
                    zzg(zze);
                } catch (Exception e) {
                    zzbs.zzem().zza(e, "BannerAdManager.swapViews");
                    zzagf.zzc("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (zzafoVar2.zzcxn != null && zzafoVar2.zzciy != null) {
            zzafoVar2.zzciy.zza(zzapa.zzc(zzafoVar2.zzcxn));
            this.zzano.zzatz.removeAllViews();
            this.zzano.zzatz.setMinimumWidth(zzafoVar2.zzcxn.widthPixels);
            this.zzano.zzatz.setMinimumHeight(zzafoVar2.zzcxn.heightPixels);
            zzanh zzanhVar = zzafoVar2.zzciy;
            if (zzanhVar == null) {
                throw null;
            }
            zzg((View) zzanhVar);
        }
        if (this.zzano.zzatz.getChildCount() > 1) {
            this.zzano.zzatz.showNext();
        }
        if (zzafoVar != null) {
            View nextView2 = this.zzano.zzatz.getNextView();
            if (nextView2 instanceof zzanh) {
                ((zzanh) nextView2).destroy();
            } else if (nextView2 != null) {
                this.zzano.zzatz.removeView(nextView2);
            }
            this.zzano.zzfj();
        }
        this.zzano.zzatz.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final zzll getVideoController() {
        com.google.android.gms.common.internal.zzbq.zzge("getVideoController must be called from the main thread.");
        if (this.zzano.zzaud == null || this.zzano.zzaud.zzciy == null) {
            return null;
        }
        return this.zzano.zzaud.zzciy.zzsg();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzd(this.zzano.zzaud);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzd(this.zzano.zzaud);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final void setManualImpressionsEnabled(boolean z) {
        com.google.android.gms.common.internal.zzbq.zzge("setManualImpressionsEnabled must be called from the main thread.");
        this.zzamr = z;
    }

    @Override // com.google.android.gms.ads.internal.zzd, com.google.android.gms.internal.zzks
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzi
    public final zzanh zza(zzafp zzafpVar, zzw zzwVar, zzafb zzafbVar) throws zzanv {
        AdSize zzht;
        zzjn zzjnVar;
        if (this.zzano.zzauc.zzbem == null && this.zzano.zzauc.zzbeo) {
            zzbt zzbtVar = this.zzano;
            if (zzafpVar.zzcxy.zzbeo) {
                zzjnVar = this.zzano.zzauc;
            } else {
                String str = zzafpVar.zzcxy.zzcoz;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    zzht = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    zzht = this.zzano.zzauc.zzht();
                }
                zzjnVar = new zzjn(this.zzano.zzair, zzht);
            }
            zzbtVar.zzauc = zzjnVar;
        }
        return super.zza(zzafpVar, zzwVar, zzafbVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzd
    public final void zza(zzafo zzafoVar, boolean z) {
        View view;
        super.zza(zzafoVar, z);
        if (zzaq.zzf(zzafoVar)) {
            zzab zzabVar = new zzab(this);
            if (zzafoVar == null || !zzaq.zzf(zzafoVar)) {
                return;
            }
            zzanh zzanhVar = zzafoVar.zzciy;
            if (zzanhVar == null) {
                view = null;
            } else if (zzanhVar == null) {
                throw null;
            } else {
                view = (View) zzanhVar;
            }
            if (view == null) {
                zzagf.zzcu("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzafoVar.zzces != null ? zzafoVar.zzces.zzcdf : null;
                if (list != null && !list.isEmpty()) {
                    zzvj zzme = zzafoVar.zzcet != null ? zzafoVar.zzcet.zzme() : null;
                    zzvm zzmf = zzafoVar.zzcet != null ? zzafoVar.zzcet.zzmf() : null;
                    if (list.contains(InternalAvidAdSessionContext.AVID_API_LEVEL) && zzme != null) {
                        zzme.zzi(com.google.android.gms.dynamic.zzn.zzz(view));
                        if (!zzme.getOverrideImpressionRecording()) {
                            zzme.recordImpression();
                        }
                        zzanhVar.zzsz().zza("/nativeExpressViewClicked", zzaq.zza(zzme, (zzvm) null, zzabVar));
                        return;
                    } else if (!list.contains("1") || zzmf == null) {
                        zzagf.zzcu("No matching template id and mapper");
                        return;
                    } else {
                        zzmf.zzi(com.google.android.gms.dynamic.zzn.zzz(view));
                        if (!zzmf.getOverrideImpressionRecording()) {
                            zzmf.recordImpression();
                        }
                        zzanhVar.zzsz().zza("/nativeExpressViewClicked", zzaq.zza((zzvj) null, zzmf, zzabVar));
                        return;
                    }
                }
                zzagf.zzcu("No template ids present in mediation response");
            } catch (RemoteException e) {
                zzagf.zzc("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.zzkb.zzif().zzd(com.google.android.gms.internal.zznh.zzbok)).booleanValue() != false) goto L68;
     */
    @Override // com.google.android.gms.ads.internal.zzi, com.google.android.gms.ads.internal.zzd, com.google.android.gms.ads.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(com.google.android.gms.internal.zzafo r5, com.google.android.gms.internal.zzafo r6) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzx.zza(com.google.android.gms.internal.zzafo, com.google.android.gms.internal.zzafo):boolean");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzks
    public final boolean zzb(zzjj zzjjVar) {
        zzjj zzjjVar2 = zzjjVar;
        if (zzjjVar2.zzbdk != this.zzamr) {
            zzjjVar2 = new zzjj(zzjjVar2.versionCode, zzjjVar2.zzbdf, zzjjVar2.extras, zzjjVar2.zzbdg, zzjjVar2.zzbdh, zzjjVar2.zzbdi, zzjjVar2.zzbdj, zzjjVar2.zzbdk || this.zzamr, zzjjVar2.zzbdl, zzjjVar2.zzbdm, zzjjVar2.zzbdn, zzjjVar2.zzbdo, zzjjVar2.zzbdp, zzjjVar2.zzbdq, zzjjVar2.zzbdr, zzjjVar2.zzbds, zzjjVar2.zzbdt, zzjjVar2.zzbdu);
        }
        return super.zzb(zzjjVar2);
    }

    @Override // com.google.android.gms.ads.internal.zzd
    protected final boolean zzcf() {
        boolean z;
        zzbs.zzei();
        if (zzahn.zzd(this.zzano.zzair, this.zzano.zzair.getPackageName(), "android.permission.INTERNET")) {
            z = true;
        } else {
            zzkb.zzia().zza(this.zzano.zzatz, this.zzano.zzauc, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        zzbs.zzei();
        if (!zzahn.zzag(this.zzano.zzair)) {
            zzkb.zzia().zza(this.zzano.zzatz, this.zzano.zzauc, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzano.zzatz != null) {
            this.zzano.zzatz.setVisibility(0);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(zzafo zzafoVar) {
        if (zzafoVar == null || zzafoVar.zzcxk || this.zzano.zzatz == null || !zzbs.zzei().zza(this.zzano.zzatz, this.zzano.zzair) || !this.zzano.zzatz.getGlobalVisibleRect(new Rect(), null)) {
            return;
        }
        if (zzafoVar != null && zzafoVar.zzciy != null && zzafoVar.zzciy.zzsz() != null) {
            zzafoVar.zzciy.zzsz().zza((zzanq) null);
        }
        zza(zzafoVar, false);
        zzafoVar.zzcxk = true;
    }
}
