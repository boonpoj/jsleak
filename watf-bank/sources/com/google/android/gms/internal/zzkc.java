package com.google.android.gms.internal;

import java.util.Random;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzkc extends zzle {
    private Object mLock = new Object();
    private final Random zzbfo = new Random();
    private long zzbfp;

    public zzkc() {
        zzig();
    }

    @Override // com.google.android.gms.internal.zzld
    public final long getValue() {
        return this.zzbfp;
    }

    public final void zzig() {
        synchronized (this.mLock) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = this.zzbfo.nextInt() + 2147483648L;
                if (j != this.zzbfp && j != 0) {
                    break;
                }
            }
            this.zzbfp = j;
        }
    }
}
