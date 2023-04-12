package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzxb;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzzv;
import java.util.Collections;
@zzzv
/* loaded from: classes.dex */
public final class zzd extends zzxf implements zzt {
    private static int zzchx = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    private zzanh zzbyk;
    AdOverlayInfoParcel zzchy;
    private zzi zzchz;
    private zzo zzcia;
    private FrameLayout zzcic;
    private WebChromeClient.CustomViewCallback zzcid;
    private zzh zzcig;
    private Runnable zzcik;
    private boolean zzcil;
    private boolean zzcim;
    private boolean zzcib = false;
    private boolean zzcie = false;
    private boolean zzcif = false;
    private boolean zzcih = false;
    private int zzcii = 0;
    private final Object zzcij = new Object();
    private boolean zzcin = false;
    private boolean zzcio = false;
    private boolean zzcip = true;

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    private final void zzmw() {
        if (!this.mActivity.isFinishing() || this.zzcin) {
            return;
        }
        this.zzcin = true;
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar != null) {
            zzanhVar.zzag(this.zzcii);
            synchronized (this.zzcij) {
                if (!this.zzcil && this.zzbyk.zztg()) {
                    this.zzcik = new zzf(this);
                    zzahn.zzdaw.postDelayed(this.zzcik, ((Long) zzkb.zzif().zzd(zznh.zzbln)).longValue());
                    return;
                }
            }
        }
        zzmx();
    }

    private final void zzmz() {
        this.zzbyk.zzmz();
    }

    private final void zzr(boolean z) {
        int intValue = ((Integer) zzkb.zzif().zzd(zznh.zzbre)).intValue();
        zzp zzpVar = new zzp();
        zzpVar.size = 50;
        zzpVar.paddingLeft = z ? intValue : 0;
        zzpVar.paddingRight = z ? 0 : intValue;
        zzpVar.paddingTop = 0;
        zzpVar.paddingBottom = intValue;
        this.zzcia = new zzo(this.mActivity, zzpVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzchy.zzcjb);
        this.zzcig.addView(this.zzcia, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
        if (r18.mActivity.getResources().getConfiguration().orientation == 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c6, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c7, code lost:
        r18.zzcih = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
        if (r18.mActivity.getResources().getConfiguration().orientation == 2) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0229  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzs(boolean r19) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.zzs(boolean):void");
    }

    public final void close() {
        this.zzcii = 2;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onBackPressed() {
        this.zzcii = 0;
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onCreate(Bundle bundle) {
        this.mActivity.requestWindowFeature(1);
        this.zzcie = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzchy = AdOverlayInfoParcel.zzc(this.mActivity.getIntent());
            if (this.zzchy == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (this.zzchy.zzaty.zzdek > 7500000) {
                this.zzcii = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzcip = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzchy.zzcjg != null) {
                this.zzcif = this.zzchy.zzcjg.zzaqo;
            } else {
                this.zzcif = false;
            }
            if (((Boolean) zzkb.zzif().zzd(zznh.zzboc)).booleanValue() && this.zzcif && this.zzchy.zzcjg.zzaqt != -1) {
                new zzj(this, null).zzpy();
            }
            if (bundle == null) {
                if (this.zzchy.zzcix != null && this.zzcip) {
                    this.zzchy.zzcix.zzch();
                }
                if (this.zzchy.zzcje != 1 && this.zzchy.zzciw != null) {
                    this.zzchy.zzciw.onAdClicked();
                }
            }
            this.zzcig = new zzh(this.mActivity, this.zzchy.zzcjf, this.zzchy.zzaty.zzcv);
            this.zzcig.setId(1000);
            int i = this.zzchy.zzcje;
            if (i == 1) {
                zzs(false);
            } else if (i == 2) {
                this.zzchz = new zzi(this.zzchy.zzciy);
                zzs(false);
            } else if (i == 3) {
                zzs(true);
            } else if (i != 4) {
                throw new zzg("Could not determine ad overlay type.");
            } else {
                if (this.zzcie) {
                    this.zzcii = 3;
                    this.mActivity.finish();
                    return;
                }
                zzbs.zzef();
                if (zza.zza(this.mActivity, this.zzchy.zzciv, this.zzchy.zzcjd)) {
                    return;
                }
                this.zzcii = 3;
                this.mActivity.finish();
            }
        } catch (zzg e) {
            zzagf.zzcu(e.getMessage());
            this.zzcii = 3;
            this.mActivity.finish();
        }
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onDestroy() {
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar != null) {
            zzh zzhVar = this.zzcig;
            if (zzanhVar == null) {
                throw null;
            }
            zzhVar.removeView((View) zzanhVar);
        }
        zzmw();
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onPause() {
        zzms();
        if (this.zzchy.zzcix != null) {
            this.zzchy.zzcix.onPause();
        }
        if (!((Boolean) zzkb.zzif().zzd(zznh.zzbrd)).booleanValue() && this.zzbyk != null && (!this.mActivity.isFinishing() || this.zzchz == null)) {
            zzbs.zzek();
            zzaht.zzi(this.zzbyk);
        }
        zzmw();
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onResume() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzchy;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzcje == 4) {
            if (this.zzcie) {
                this.zzcii = 3;
                this.mActivity.finish();
            } else {
                this.zzcie = true;
            }
        }
        if (this.zzchy.zzcix != null) {
            this.zzchy.zzcix.onResume();
        }
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbrd)).booleanValue()) {
            return;
        }
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar == null || zzanhVar.isDestroyed()) {
            zzagf.zzcu("The webview does not exist. Ignoring action.");
            return;
        }
        zzbs.zzek();
        zzaht.zzj(this.zzbyk);
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzcie);
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onStart() {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbrd)).booleanValue()) {
            zzanh zzanhVar = this.zzbyk;
            if (zzanhVar == null || zzanhVar.isDestroyed()) {
                zzagf.zzcu("The webview does not exist. Ignoring action.");
                return;
            }
            zzbs.zzek();
            zzaht.zzj(this.zzbyk);
        }
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onStop() {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbrd)).booleanValue() && this.zzbyk != null && (!this.mActivity.isFinishing() || this.zzchz == null)) {
            zzbs.zzek();
            zzaht.zzi(this.zzbyk);
        }
        zzmw();
    }

    public final void setRequestedOrientation(int i) {
        this.mActivity.setRequestedOrientation(i);
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzcic = new FrameLayout(this.mActivity);
        this.zzcic.setBackgroundColor(-16777216);
        this.zzcic.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzcic);
        this.zzcim = true;
        this.zzcid = customViewCallback;
        this.zzcib = true;
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzkb.zzif().zzd(zznh.zzblp)).booleanValue() && (adOverlayInfoParcel = this.zzchy) != null && adOverlayInfoParcel.zzcjg != null && this.zzchy.zzcjg.zzaqv;
        if (z && z2 && z4) {
            new zzxb(this.zzbyk, "useCustomClose").zzbm("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzo zzoVar = this.zzcia;
        if (zzoVar != null) {
            zzoVar.zza(z, (!z2 || z4) ? false : false);
        }
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void zzbf() {
        this.zzcim = true;
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbrc)).booleanValue() && com.google.android.gms.common.util.zzq.isAtLeastN()) {
            zzbs.zzei();
            if (zzahn.zza(this.mActivity, (Configuration) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper))) {
                this.mActivity.getWindow().addFlags(1024);
                this.mActivity.getWindow().clearFlags(2048);
                return;
            }
            this.mActivity.getWindow().addFlags(2048);
            this.mActivity.getWindow().clearFlags(1024);
        }
    }

    public final void zzms() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzchy;
        if (adOverlayInfoParcel != null && this.zzcib) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzcic != null) {
            this.mActivity.setContentView(this.zzcig);
            this.zzcim = true;
            this.zzcic.removeAllViews();
            this.zzcic = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzcid;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzcid = null;
        }
        this.zzcib = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final void zzmt() {
        this.zzcii = 1;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.zzxe
    public final boolean zzmu() {
        this.zzcii = 0;
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar == null) {
            return true;
        }
        boolean zzte = zzanhVar.zzte();
        if (!zzte) {
            this.zzbyk.zza("onbackblocked", Collections.emptyMap());
        }
        return zzte;
    }

    public final void zzmv() {
        this.zzcig.removeView(this.zzcia);
        zzr(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzmx() {
        if (this.zzcio) {
            return;
        }
        this.zzcio = true;
        zzanh zzanhVar = this.zzbyk;
        if (zzanhVar != null) {
            zzh zzhVar = this.zzcig;
            if (zzanhVar == null) {
                throw null;
            }
            zzhVar.removeView((View) zzanhVar);
            zzi zziVar = this.zzchz;
            if (zziVar != null) {
                this.zzbyk.setContext(zziVar.zzair);
                this.zzbyk.zzad(false);
                ViewGroup viewGroup = this.zzchz.parent;
                zzanh zzanhVar2 = this.zzbyk;
                if (zzanhVar2 == null) {
                    throw null;
                }
                viewGroup.addView((View) zzanhVar2, this.zzchz.index, this.zzchz.zzcis);
                this.zzchz = null;
            } else if (this.mActivity.getApplicationContext() != null) {
                this.zzbyk.setContext(this.mActivity.getApplicationContext());
            }
            this.zzbyk = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzchy;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzcix == null) {
            return;
        }
        this.zzchy.zzcix.zzcg();
    }

    public final void zzmy() {
        if (this.zzcih) {
            this.zzcih = false;
            zzmz();
        }
    }

    public final void zzna() {
        this.zzcig.zzcir = true;
    }

    public final void zznb() {
        synchronized (this.zzcij) {
            this.zzcil = true;
            if (this.zzcik != null) {
                zzahn.zzdaw.removeCallbacks(this.zzcik);
                zzahn.zzdaw.post(this.zzcik);
            }
        }
    }
}
