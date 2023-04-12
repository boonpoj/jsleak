package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzjj;
/* loaded from: classes.dex */
final class zzai implements Runnable {
    private /* synthetic */ zzjj zzapt;
    private /* synthetic */ zzag zzapu;
    private /* synthetic */ int zzapv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzag zzagVar, zzjj zzjjVar, int i) {
        this.zzapu = zzagVar;
        this.zzapt = zzjjVar;
        this.zzapv = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzapu.mLock;
        synchronized (obj) {
            this.zzapu.zzb(this.zzapt, this.zzapv);
        }
    }
}
