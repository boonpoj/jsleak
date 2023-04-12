package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
class zze<TResult> implements zzf<TResult> {
    private final Executor zzbDK;
    private OnSuccessListener<? super TResult> zzbLB;
    private final Object zzrN = new Object();

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzbDK = executor;
        this.zzbLB = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        synchronized (this.zzrN) {
            this.zzbLB = null;
        }
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzrN) {
                if (this.zzbLB == null) {
                    return;
                }
                this.zzbDK.execute(new Runnable() { // from class: com.google.android.gms.tasks.zze.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zze.this.zzrN) {
                            if (zze.this.zzbLB != null) {
                                zze.this.zzbLB.onSuccess(task.getResult());
                            }
                        }
                    }
                });
            }
        }
    }
}
