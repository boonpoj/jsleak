package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzk implements Runnable {
    private /* synthetic */ zzafp zzanv;
    private /* synthetic */ zzi zzaoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzi zziVar, zzafp zzafpVar) {
        this.zzaoa = zziVar;
        this.zzanv = zzafpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaoa.zzb(new zzafo(this.zzanv, null, null, null, null, null, null, null));
    }
}
