package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
class zzd<TResult> implements zzf<TResult> {
    private final Executor zzbDK;
    private OnFailureListener zzbLz;
    private final Object zzrN = new Object();

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzbDK = executor;
        this.zzbLz = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzrN) {
            this.zzbLz = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            return;
        }
        synchronized (this.zzrN) {
            if (this.zzbLz == null) {
                return;
            }
            this.zzbDK.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzd.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzd.this.zzrN) {
                        if (zzd.this.zzbLz != null) {
                            zzd.this.zzbLz.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
