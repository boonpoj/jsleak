package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzaag implements Runnable {
    private /* synthetic */ zzzy zzcmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaag(zzzy zzzyVar) {
        this.zzcmu = zzzyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzcmu.zzcjn;
        synchronized (obj) {
            if (this.zzcmu.zzcmq == null) {
                return;
            }
            this.zzcmu.onStop();
            this.zzcmu.zzc(2, "Timed out waiting for ad response.");
        }
    }
}
