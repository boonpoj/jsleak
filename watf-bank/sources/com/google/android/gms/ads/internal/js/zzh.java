package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzanh;
/* loaded from: classes.dex */
final class zzh implements Runnable {
    private /* synthetic */ zze zzcat;
    private /* synthetic */ String zzcau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zze zzeVar, String str) {
        this.zzcat = zzeVar;
        this.zzcau = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzanh zzanhVar;
        zzanhVar = this.zzcat.zzbyk;
        zzanhVar.loadData(this.zzcau, "text/html", "UTF-8");
    }
}
