package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzanu implements Callable<zzanh> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzcv zzcbd;
    private /* synthetic */ zzapa zzdln;
    private /* synthetic */ String zzdlo;
    private /* synthetic */ boolean zzdlp;
    private /* synthetic */ boolean zzdlq;
    private /* synthetic */ zzakd zzdlr;
    private /* synthetic */ zznu zzdls;
    private /* synthetic */ com.google.android.gms.ads.internal.zzbl zzdlt;
    private /* synthetic */ com.google.android.gms.ads.internal.zzv zzdlu;
    private /* synthetic */ zzis zzdlv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanu(zzanr zzanrVar, Context context, zzapa zzapaVar, String str, boolean z, boolean z2, zzcv zzcvVar, zzakd zzakdVar, zznu zznuVar, com.google.android.gms.ads.internal.zzbl zzblVar, com.google.android.gms.ads.internal.zzv zzvVar, zzis zzisVar) {
        this.val$context = context;
        this.zzdln = zzapaVar;
        this.zzdlo = str;
        this.zzdlp = z;
        this.zzdlq = z2;
        this.zzcbd = zzcvVar;
        this.zzdlr = zzakdVar;
        this.zzdls = zznuVar;
        this.zzdlt = zzblVar;
        this.zzdlu = zzvVar;
        this.zzdlv = zzisVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzanh call() throws Exception {
        zzanw zzanwVar = new zzanw(zzanx.zzb(this.val$context, this.zzdln, this.zzdlo, this.zzdlp, this.zzdlq, this.zzcbd, this.zzdlr, this.zzdls, this.zzdlt, this.zzdlu, this.zzdlv));
        zzanwVar.setWebViewClient(com.google.android.gms.ads.internal.zzbs.zzek().zzb(zzanwVar, this.zzdlq));
        zzanwVar.setWebChromeClient(com.google.android.gms.ads.internal.zzbs.zzek().zzk(zzanwVar));
        return zzanwVar;
    }
}
