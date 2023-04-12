package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzf implements Callable<String> {
    private /* synthetic */ zzd zzany;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzd zzdVar) {
        this.zzany = zzdVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.zzany.zzano.zzatx.zzaf().zza(this.zzany.zzano.zzair);
    }
}
