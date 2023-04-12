package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzk implements Runnable {
    private final zzr zzx;
    private final zzw zzy;
    private final Runnable zzz;

    /* renamed from: com.google.android.gms.internal.zzk$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String zzO;
        final /* synthetic */ long zzP;

        AnonymousClass1(String str, long j) {
            this.zzO = str;
            this.zzP = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzk.zzd(zzk.this).zza(this.zzO, this.zzP);
            zzk.zzd(zzk.this).zzd(toString());
        }
    }

    /* loaded from: assets/classes2.dex */
    public enum zza {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public zzk(zzi zziVar, zzr zzrVar, zzw zzwVar, Runnable runnable) {
        this.zzx = zzrVar;
        this.zzy = zzwVar;
        this.zzz = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzy.zzbi == null) {
            this.zzx.zza((zzr) this.zzy.result);
        } else {
            this.zzx.zzb(this.zzy.zzbi);
        }
        if (this.zzy.zzbj) {
            this.zzx.zzb("intermediate-response");
        } else {
            this.zzx.zzc("done");
        }
        Runnable runnable = this.zzz;
        if (runnable != null) {
            runnable.run();
        }
    }
}
