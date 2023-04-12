package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzaiq;
/* loaded from: classes.dex */
final class zzai implements Runnable {
    private /* synthetic */ zzc zzcbw;
    private /* synthetic */ zzah zzcbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzah zzahVar, zzc zzcVar) {
        this.zzcbx = zzahVar;
        this.zzcbw = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaiq zzaiqVar;
        zzaiqVar = this.zzcbx.zzcbv.zzcba;
        zzaiqVar.zzf(this.zzcbw);
        this.zzcbw.destroy();
    }
}
