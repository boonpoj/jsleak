package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: assets/classes2.dex */
class zzg<TResult> {
    private Queue<zzf<TResult>> zzbLD;
    private boolean zzbLE;
    private final Object zzrN = new Object();

    public void zza(@NonNull Task<TResult> task) {
        zzf<TResult> poll;
        synchronized (this.zzrN) {
            if (this.zzbLD != null && !this.zzbLE) {
                this.zzbLE = true;
                while (true) {
                    synchronized (this.zzrN) {
                        poll = this.zzbLD.poll();
                        if (poll == null) {
                            this.zzbLE = false;
                            return;
                        }
                    }
                    poll.onComplete(task);
                }
            }
        }
    }

    public void zza(@NonNull zzf<TResult> zzfVar) {
        synchronized (this.zzrN) {
            if (this.zzbLD == null) {
                this.zzbLD = new ArrayDeque();
            }
            this.zzbLD.add(zzfVar);
        }
    }
}
