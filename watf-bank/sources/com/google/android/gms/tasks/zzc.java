package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
class zzc<TResult> implements zzf<TResult> {
    private final Executor zzbDK;
    private OnCompleteListener<TResult> zzbLx;
    private final Object zzrN = new Object();

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzbDK = executor;
        this.zzbLx = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzrN) {
            this.zzbLx = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.zzrN) {
            if (this.zzbLx == null) {
                return;
            }
            this.zzbDK.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzc.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzc.this.zzrN) {
                        if (zzc.this.zzbLx != null) {
                            zzc.this.zzbLx.onComplete(task);
                        }
                    }
                }
            });
        }
    }
}
