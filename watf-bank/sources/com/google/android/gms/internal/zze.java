package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zze implements Runnable {
    private /* synthetic */ zzr zzn;
    private /* synthetic */ zzd zzo;

    /* renamed from: com.google.android.gms.internal.zze$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Executor {
        final /* synthetic */ Handler zzs;

        AnonymousClass1(zze zzeVar, Handler handler) {
            this.zzs = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.zzs.post(runnable);
        }
    }

    /* loaded from: assets/classes2.dex */
    private class zza implements Runnable {
        private final zzk zzt;
        private final zzm zzu;
        private final Runnable zzv;

        public zza(zze zzeVar, zzk zzkVar, zzm zzmVar, Runnable runnable) {
            this.zzt = zzkVar;
            this.zzu = zzmVar;
            this.zzv = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzu.isSuccess()) {
                this.zzt.zza(this.zzu.result);
            } else {
                this.zzt.zzc(this.zzu.zzaf);
            }
            if (this.zzu.zzag) {
                this.zzt.zzc("intermediate-response");
            } else {
                this.zzt.zzd("done");
            }
            if (this.zzv != null) {
                this.zzv.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzd zzdVar, zzr zzrVar) {
        this.zzo = zzdVar;
        this.zzn = zzrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.zzo.zzi;
            blockingQueue.put(this.zzn);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
