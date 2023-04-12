package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
/* loaded from: classes.dex */
final class zzr implements Runnable {
    private /* synthetic */ zzq zzaoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzq zzqVar) {
        this.zzaoh = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzafo zzafoVar;
        zzq zzqVar = this.zzaoh;
        zzafoVar = zzqVar.zzaof;
        zzqVar.zzb(zzafoVar);
    }
}
