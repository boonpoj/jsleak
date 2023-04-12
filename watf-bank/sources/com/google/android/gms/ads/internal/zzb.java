package com.google.android.gms.ads.internal;

import android.os.Debug;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb extends TimerTask {
    private /* synthetic */ CountDownLatch zzans;
    private /* synthetic */ Timer zzant;
    private /* synthetic */ zza zzanu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zza zzaVar, CountDownLatch countDownLatch, Timer timer) {
        this.zzanu = zzaVar;
        this.zzans = countDownLatch;
        this.zzant = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (((Integer) zzkb.zzif().zzd(zznh.zzbpd)).intValue() != this.zzans.getCount()) {
            zzagf.zzbx("Stopping method tracing");
            Debug.stopMethodTracing();
            if (this.zzans.getCount() == 0) {
                this.zzant.cancel();
                return;
            }
        }
        String concat = String.valueOf(this.zzanu.zzano.zzair.getPackageName()).concat("_adsTrace_");
        try {
            zzagf.zzbx("Starting method tracing");
            this.zzans.countDown();
            long currentTimeMillis = zzbs.zzeo().currentTimeMillis();
            StringBuilder sb = new StringBuilder(String.valueOf(concat).length() + 20);
            sb.append(concat);
            sb.append(currentTimeMillis);
            Debug.startMethodTracing(sb.toString(), ((Integer) zzkb.zzif().zzd(zznh.zzbpe)).intValue());
        } catch (Exception e) {
            zzagf.zzc("Exception occurred while starting method tracing.", e);
        }
    }
}
