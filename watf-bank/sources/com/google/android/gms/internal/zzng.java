package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzng implements Callable<T> {
    private /* synthetic */ zzmx zzbhj;
    private /* synthetic */ zznf zzbhk;

    /* loaded from: assets/classes2.dex */
    private class zza {
        public final long zzUy = com.google.android.gms.ads.internal.zzv.zzcP().currentTimeMillis();
        public final zznf zzUz;

        public zza(zzng zzngVar, zznf zznfVar) {
            this.zzUz = zznfVar;
        }

        public boolean hasExpired() {
            return this.zzUy + ((Long) zzfx.zzCQ.get()).longValue() < com.google.android.gms.ads.internal.zzv.zzcP().currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzng(zznf zznfVar, zzmx zzmxVar) {
        this.zzbhk = zznfVar;
        this.zzbhj = zzmxVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @Override // java.util.concurrent.Callable
    public final T call() {
        SharedPreferences sharedPreferences;
        zzmx zzmxVar = this.zzbhj;
        sharedPreferences = this.zzbhk.zzbhh;
        return zzmxVar.zza(sharedPreferences);
    }
}
