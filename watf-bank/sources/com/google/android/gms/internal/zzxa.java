package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzxa extends zzxb implements com.google.android.gms.ads.internal.gmsg.zzt<zzanh> {
    private final Context mContext;
    private final WindowManager zzavx;
    private DisplayMetrics zzaxm;
    private final zzanh zzbyk;
    private final zzmt zzchj;
    private float zzchk;
    private int zzchl;
    private int zzchm;
    private int zzchn;
    private int zzcho;
    private int zzchp;
    private int zzchq;
    private int zzchr;

    public zzxa(zzanh zzanhVar, Context context, zzmt zzmtVar) {
        super(zzanhVar);
        this.zzchl = -1;
        this.zzchm = -1;
        this.zzcho = -1;
        this.zzchp = -1;
        this.zzchq = -1;
        this.zzchr = -1;
        this.zzbyk = zzanhVar;
        this.mContext = context;
        this.zzchj = zzmtVar;
        this.zzavx = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        int i;
        this.zzaxm = new DisplayMetrics();
        Display defaultDisplay = this.zzavx.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzaxm);
        this.zzchk = this.zzaxm.density;
        this.zzchn = defaultDisplay.getRotation();
        zzkb.zzia();
        DisplayMetrics displayMetrics = this.zzaxm;
        this.zzchl = zzajr.zzb(displayMetrics, displayMetrics.widthPixels);
        zzkb.zzia();
        DisplayMetrics displayMetrics2 = this.zzaxm;
        this.zzchm = zzajr.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzsi = this.zzbyk.zzsi();
        if (zzsi == null || zzsi.getWindow() == null) {
            this.zzcho = this.zzchl;
            i = this.zzchm;
        } else {
            com.google.android.gms.ads.internal.zzbs.zzei();
            int[] zzf = zzahn.zzf(zzsi);
            zzkb.zzia();
            this.zzcho = zzajr.zzb(this.zzaxm, zzf[0]);
            zzkb.zzia();
            i = zzajr.zzb(this.zzaxm, zzf[1]);
        }
        this.zzchp = i;
        if (this.zzbyk.zzsx().zzuh()) {
            this.zzchq = this.zzchl;
            this.zzchr = this.zzchm;
        } else {
            this.zzbyk.measure(0, 0);
        }
        zza(this.zzchl, this.zzchm, this.zzcho, this.zzchp, this.zzchk, this.zzchn);
        this.zzbyk.zza("onDeviceFeaturesReceived", new zzwx(new zzwz().zzn(this.zzchj.zzir()).zzm(this.zzchj.zzis()).zzo(this.zzchj.zziu()).zzp(this.zzchj.zzit()).zzq(true)).toJson());
        int[] iArr = new int[2];
        this.zzbyk.getLocationOnScreen(iArr);
        zzkb.zzia();
        int zzd = zzajr.zzd(this.mContext, iArr[0]);
        zzkb.zzia();
        zzc(zzd, zzajr.zzd(this.mContext, iArr[1]));
        if (zzagf.zzae(2)) {
            zzagf.zzct("Dispatching Ready Event.");
        }
        zzbn(this.zzbyk.zzsk().zzcv);
    }

    public final void zzc(int i, int i2) {
        int i3 = this.mContext instanceof Activity ? com.google.android.gms.ads.internal.zzbs.zzei().zzh((Activity) this.mContext)[0] : 0;
        if (this.zzbyk.zzsx() == null || !this.zzbyk.zzsx().zzuh()) {
            zzkb.zzia();
            this.zzchq = zzajr.zzd(this.mContext, this.zzbyk.getWidth());
            zzkb.zzia();
            this.zzchr = zzajr.zzd(this.mContext, this.zzbyk.getHeight());
        }
        zzc(i, i2 - i3, this.zzchq, this.zzchr);
        this.zzbyk.zzsz().zzb(i, i2);
    }
}
