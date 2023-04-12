package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzanq;
/* loaded from: classes.dex */
final class zzz implements zzanq {
    private /* synthetic */ zzafo zzaou;
    private /* synthetic */ Runnable zzaov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzx zzxVar, zzafo zzafoVar, Runnable runnable) {
        this.zzaou = zzafoVar;
        this.zzaov = runnable;
    }

    @Override // com.google.android.gms.internal.zzanq
    public final void zzdb() {
        if (this.zzaou.zzcxk) {
            return;
        }
        zzbs.zzei();
        zzahn.zzb(this.zzaov);
    }
}
