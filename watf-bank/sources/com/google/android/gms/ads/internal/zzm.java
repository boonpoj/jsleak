package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
/* loaded from: classes.dex */
final class zzm implements Runnable {
    private /* synthetic */ zzl zzaod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzl zzlVar) {
        this.zzaod = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaod.zzaoa.zzb(new zzafo(this.zzaod.zzanv, null, null, null, null, null, null, null));
    }
}
