package com.google.android.gms.internal;

import android.os.Handler;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzaah implements Runnable {
    private /* synthetic */ zzzy zzcmu;
    private /* synthetic */ zzalh zzcmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaah(zzzy zzzyVar, zzalh zzalhVar) {
        this.zzcmu = zzzyVar;
        this.zzcmv = zzalhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzaau zzaauVar;
        Runnable runnable;
        obj = this.zzcmu.zzcjn;
        synchronized (obj) {
            zzzy zzzyVar = this.zzcmu;
            zzzy zzzyVar2 = this.zzcmu;
            zzaauVar = this.zzcmu.zzcmn;
            zzzyVar.zzcmq = zzzyVar2.zza(zzaauVar.zzaty, this.zzcmv);
            if (this.zzcmu.zzcmq == null) {
                this.zzcmu.zzc(0, "Could not start the ad request service.");
                Handler handler = zzahn.zzdaw;
                runnable = this.zzcmu.zzcjm;
                handler.removeCallbacks(runnable);
            }
        }
    }
}
