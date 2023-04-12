package com.google.android.gms.internal;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzn extends Thread {
    private final BlockingQueue<zzr<?>> zzaa;
    private final zzm zzab;
    private final zzb zzj;
    private final zzz zzk;
    private volatile boolean zzl = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzmVar, zzb zzbVar, zzz zzzVar) {
        this.zzaa = blockingQueue;
        this.zzab = zzmVar;
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
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                take = this.zzaa.take();
            } catch (InterruptedException e) {
                if (this.zzl) {
                    return;
                }
            }
            try {
                take.zzb("network-queue-take");
                TrafficStats.setThreadStatsTag(take.zzd());
                zzp zzc = this.zzab.zzc(take);
                take.zzb("network-http-complete");
                if (zzc.zzad && take.zzk()) {
                    take.zzc("not-modified");
                    take.zzl();
                } else {
                    zzw<?> zza = take.zza(zzc);
                    take.zzb("network-parse-complete");
                    if (take.zzg() && zza.zzbh != null) {
                        this.zzj.zza(take.getUrl(), zza.zzbh);
                        take.zzb("network-cache-written");
                    }
                    take.zzj();
                    this.zzk.zzb(take, zza);
                    take.zza(zza);
                }
            } catch (zzad e2) {
                e2.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.zzk.zza(take, e2);
                take.zzl();
            } catch (Exception e3) {
                zzae.zza(e3, "Unhandled exception %s", e3.toString());
                zzad zzadVar = new zzad(e3);
                zzadVar.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.zzk.zza(take, zzadVar);
                take.zzl();
            }
        }
    }
}
