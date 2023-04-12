package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Executor zzbDK;
    private final Continuation<TResult, TContinuationResult> zzbLs;
    private final zzh<TContinuationResult> zzbLt;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> zzhVar) {
        this.zzbDK = executor;
        this.zzbLs = continuation;
        this.zzbLt = zzhVar;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        this.zzbDK.execute(new Runnable() { // from class: com.google.android.gms.tasks.zza.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
            /* JADX WARN: Type inference failed for: r1v11, types: [com.google.android.gms.tasks.zzh] */
            @Override // java.lang.Runnable
            public void run() {
                zzh zzhVar;
                RuntimeExecutionException runtimeExecutionException;
                try {
                    zza.this.zzbLt.setResult(zza.this.zzbLs.then(task));
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzh zzhVar2 = zza.this.zzbLt;
                        runtimeExecutionException = (Exception) e.getCause();
                        zzhVar = zzhVar2;
                    } else {
                        runtimeExecutionException = e;
                        zzhVar = zza.this.zzbLt;
                    }
                    zzhVar.setException(runtimeExecutionException);
                } catch (Exception e2) {
                    zza.this.zzbLt.setException(e2);
                }
            }
        });
    }
}
