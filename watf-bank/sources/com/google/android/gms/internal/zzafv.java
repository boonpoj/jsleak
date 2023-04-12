package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzafv {
    private final Object mLock;
    private volatile int zzczn;
    private volatile long zzczo;

    private zzafv() {
        this.mLock = new Object();
        this.zzczn = zzafw.zzczp;
        this.zzczo = 0L;
    }

    private final void zzd(int i, int i2) {
        zzpw();
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzczn != i) {
                return;
            }
            this.zzczn = i2;
            if (this.zzczn == zzafw.zzczr) {
                this.zzczo = currentTimeMillis;
            }
        }
    }

    private final void zzpw() {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzczn == zzafw.zzczr) {
                if (this.zzczo + ((Long) zzkb.zzif().zzd(zznh.zzbrt)).longValue() <= currentTimeMillis) {
                    this.zzczn = zzafw.zzczp;
                }
            }
        }
    }

    public final boolean zzpm() {
        zzpw();
        return this.zzczn == zzafw.zzczq;
    }

    public final boolean zzpn() {
        zzpw();
        return this.zzczn == zzafw.zzczr;
    }

    public final void zzpo() {
        zzd(zzafw.zzczq, zzafw.zzczr);
    }

    public final void zzz(boolean z) {
        int i;
        int i2;
        if (z) {
            i = zzafw.zzczp;
            i2 = zzafw.zzczq;
        } else {
            i = zzafw.zzczq;
            i2 = zzafw.zzczp;
        }
        zzd(i, i2);
    }
}
