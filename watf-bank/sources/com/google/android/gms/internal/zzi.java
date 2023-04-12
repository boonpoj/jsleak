package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzi implements zzz {
    private final Executor zzv;

    public zzi(Handler handler) {
        this.zzv = new zzj(this, handler);
    }

    @Override // com.google.android.gms.internal.zzz
    public final void zza(zzr<?> zzrVar, zzad zzadVar) {
        zzrVar.zzb("post-error");
        this.zzv.execute(new zzk(this, zzrVar, zzw.zzc(zzadVar), null));
    }

    @Override // com.google.android.gms.internal.zzz
    public final void zza(zzr<?> zzrVar, zzw<?> zzwVar, Runnable runnable) {
        zzrVar.zzj();
        zzrVar.zzb("post-response");
        this.zzv.execute(new zzk(this, zzrVar, zzwVar, runnable));
    }

    @Override // com.google.android.gms.internal.zzz
    public final void zzb(zzr<?> zzrVar, zzw<?> zzwVar) {
        zza(zzrVar, zzwVar, null);
    }
}
