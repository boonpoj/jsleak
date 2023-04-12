package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
@zzzv
/* loaded from: classes.dex */
public final class zzamg {
    private final Context zzdhi;
    private final zzamp zzdhj;
    private final ViewGroup zzdhk;
    private zzamd zzdhl;

    private zzamg(Context context, ViewGroup viewGroup, zzamp zzampVar, zzamd zzamdVar) {
        this.zzdhi = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdhk = viewGroup;
        this.zzdhj = zzampVar;
        this.zzdhl = null;
    }

    public zzamg(Context context, ViewGroup viewGroup, zzanh zzanhVar) {
        this(context, viewGroup, zzanhVar, null);
    }

    public final void onDestroy() {
        com.google.android.gms.common.internal.zzbq.zzge("onDestroy must be called from the UI thread.");
        zzamd zzamdVar = this.zzdhl;
        if (zzamdVar != null) {
            zzamdVar.destroy();
            this.zzdhk.removeView(this.zzdhl);
            this.zzdhl = null;
        }
    }

    public final void onPause() {
        com.google.android.gms.common.internal.zzbq.zzge("onPause must be called from the UI thread.");
        zzamd zzamdVar = this.zzdhl;
        if (zzamdVar != null) {
            zzamdVar.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzamo zzamoVar) {
        if (this.zzdhl != null) {
            return;
        }
        zznn.zza(this.zzdhj.zzsj().zzje(), this.zzdhj.zzsh(), "vpr2");
        Context context = this.zzdhi;
        zzamp zzampVar = this.zzdhj;
        this.zzdhl = new zzamd(context, zzampVar, i5, z, zzampVar.zzsj().zzje(), zzamoVar);
        this.zzdhk.addView(this.zzdhl, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzdhl.zzd(i, i2, i3, i4);
        this.zzdhj.zzac(false);
    }

    public final void zze(int i, int i2, int i3, int i4) {
        com.google.android.gms.common.internal.zzbq.zzge("The underlay may only be modified from the UI thread.");
        zzamd zzamdVar = this.zzdhl;
        if (zzamdVar != null) {
            zzamdVar.zzd(i, i2, i3, i4);
        }
    }

    public final zzamd zzsa() {
        com.google.android.gms.common.internal.zzbq.zzge("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzdhl;
    }
}
