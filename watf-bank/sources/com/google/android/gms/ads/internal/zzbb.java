package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
/* loaded from: classes.dex */
final class zzbb implements Runnable {
    private /* synthetic */ zzafp zzanv;
    private /* synthetic */ zzba zzarp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(zzba zzbaVar, zzafp zzafpVar) {
        this.zzarp = zzbaVar;
        this.zzanv = zzafpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzarp.zzb(new zzafo(this.zzanv, null, null, null, null, null, null, null));
    }
}
