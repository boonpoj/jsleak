package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzanh;
/* loaded from: classes.dex */
final class zzj implements Runnable {
    private /* synthetic */ zze zzcat;
    private /* synthetic */ String zzcav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zze zzeVar, String str) {
        this.zzcat = zzeVar;
        this.zzcav = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzanh zzanhVar;
        zzanhVar = this.zzcat.zzbyk;
        zzanhVar.loadUrl(this.zzcav);
    }
}
