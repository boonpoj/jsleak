package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzjj;
/* loaded from: classes.dex */
final class zzah implements Runnable {
    private /* synthetic */ zzjj zzapt;
    private /* synthetic */ zzag zzapu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(zzag zzagVar, zzjj zzjjVar) {
        this.zzapu = zzagVar;
        this.zzapt = zzjjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean zzdf;
        obj = this.zzapu.mLock;
        synchronized (obj) {
            zzdf = this.zzapu.zzdf();
            if (zzdf) {
                this.zzapu.zze(this.zzapt);
            } else {
                this.zzapu.zzb(this.zzapt, 1);
            }
        }
    }
}
