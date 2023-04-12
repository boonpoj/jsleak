package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public final class zzd extends Thread {
    private static final boolean DEBUG = zzae.DEBUG;
    private final BlockingQueue<zzr<?>> zzh;
    private final BlockingQueue<zzr<?>> zzi;
    private final zzb zzj;
    private final zzz zzk;
    private volatile boolean zzl = false;
    private final zzf zzm = new zzf(this);

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzbVar, zzz zzzVar) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = zzbVar;
        this.zzk = zzzVar;
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        zzr<?> take;
        zzc zza;
        boolean zzb;
        BlockingQueue<zzr<?>> blockingQueue;
        boolean zzb2;
        zzz zzzVar;
        boolean zzb3;
        if (DEBUG) {
            zzae.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.initialize();
        while (true) {
            try {
                take = this.zzh.take();
                take.zzb("cache-queue-take");
                zza = this.zzj.zza(take.getUrl());
            } catch (InterruptedException e) {
                if (this.zzl) {
                    return;
                }
            }
            if (zza == null) {
                take.zzb("cache-miss");
                zzb = this.zzm.zzb(take);
                if (!zzb) {
                    blockingQueue = this.zzi;
                }
            } else if (zza.zza()) {
                take.zzb("cache-hit-expired");
                take.zza(zza);
                zzb2 = this.zzm.zzb(take);
                if (!zzb2) {
                    blockingQueue = this.zzi;
                }
            } else {
                take.zzb("cache-hit");
                zzw<?> zza2 = take.zza(new zzp(zza.data, zza.zzf));
                take.zzb("cache-hit-parsed");
                if (zza.zze < System.currentTimeMillis()) {
                    take.zzb("cache-hit-refresh-needed");
                    take.zza(zza);
                    zza2.zzbj = true;
                    zzb3 = this.zzm.zzb(take);
                    if (zzb3) {
                        zzzVar = this.zzk;
                    } else {
                        this.zzk.zza(take, zza2, new zze(this, take));
                    }
                } else {
                    zzzVar = this.zzk;
                }
                zzzVar.zzb(take, zza2);
            }
            blockingQueue.put(take);
        }
    }
}
