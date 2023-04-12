package com.google.android.gms.internal;
@zzzv
/* loaded from: classes.dex */
public final class zzaji {
    private long zzdda;
    private long zzddb = Long.MIN_VALUE;
    private Object mLock = new Object();

    public zzaji(long j) {
        this.zzdda = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.mLock) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime();
            if (this.zzddb + this.zzdda > elapsedRealtime) {
                return false;
            }
            this.zzddb = elapsedRealtime;
            return true;
        }
    }
}
