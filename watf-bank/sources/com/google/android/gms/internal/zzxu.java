package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
@zzzv
/* loaded from: classes.dex */
public abstract class zzxu implements zzaif<Void>, zzanm {
    protected final Context mContext;
    protected final zzanh zzbyk;
    private zzyb zzcjj;
    private zzafp zzcjk;
    protected zzaax zzcjl;
    private Runnable zzcjm;
    private Object zzcjn = new Object();
    private AtomicBoolean zzcjo = new AtomicBoolean(true);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzxu(Context context, zzafp zzafpVar, zzanh zzanhVar, zzyb zzybVar) {
        this.mContext = context;
        this.zzcjk = zzafpVar;
        this.zzcjl = this.zzcjk.zzcxy;
        this.zzbyk = zzanhVar;
        this.zzcjj = zzybVar;
    }

    @Override // com.google.android.gms.internal.zzaif
    public void cancel() {
        if (this.zzcjo.getAndSet(false)) {
            this.zzbyk.stopLoading();
            com.google.android.gms.ads.internal.zzbs.zzek();
            zzaht.zzi(this.zzbyk);
            zzx(-1);
            zzahn.zzdaw.removeCallbacks(this.zzcjm);
        }
    }

    @Override // com.google.android.gms.internal.zzanm
    public final void zza(zzanh zzanhVar, boolean z) {
        zzagf.zzbx("WebView finished loading.");
        if (this.zzcjo.getAndSet(false)) {
            zzx(z ? -2 : 0);
            zzahn.zzdaw.removeCallbacks(this.zzcjm);
        }
    }

    protected abstract void zznc();

    @Override // com.google.android.gms.internal.zzaif
    public final /* synthetic */ Void zznd() {
        com.google.android.gms.common.internal.zzbq.zzge("Webview render task needs to be called on UI thread.");
        this.zzcjm = new zzxv(this);
        zzahn.zzdaw.postDelayed(this.zzcjm, ((Long) zzkb.zzif().zzd(zznh.zzbnj)).longValue());
        zznc();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzx(int i) {
        if (i != -2) {
            this.zzcjl = new zzaax(i, this.zzcjl.zzcdq);
        }
        this.zzbyk.zzst();
        zzyb zzybVar = this.zzcjj;
        zzaat zzaatVar = this.zzcjk.zzcqv;
        zzybVar.zzb(new zzafo(zzaatVar.zzcnd, this.zzbyk, this.zzcjl.zzcdk, i, this.zzcjl.zzcdl, this.zzcjl.zzcoy, this.zzcjl.orientation, this.zzcjl.zzcdq, zzaatVar.zzcng, this.zzcjl.zzcow, null, null, null, null, null, this.zzcjl.zzcox, this.zzcjk.zzauc, this.zzcjl.zzcov, this.zzcjk.zzcxp, this.zzcjl.zzcpa, this.zzcjl.zzcpb, this.zzcjk.zzcxj, null, this.zzcjl.zzcpl, this.zzcjl.zzcpm, this.zzcjl.zzcpn, this.zzcjl.zzcpo, this.zzcjl.zzcpp, null, this.zzcjl.zzcdn, this.zzcjl.zzcps, this.zzcjk.zzcxw, this.zzcjk.zzcxy.zzaqv, this.zzcjk.zzcxx));
    }
}
