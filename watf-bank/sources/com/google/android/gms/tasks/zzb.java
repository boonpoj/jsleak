package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: assets/classes2.dex */
class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    private final Executor zzbDK;
    private final Continuation<TResult, Task<TContinuationResult>> zzbLs;
    private final zzh<TContinuationResult> zzbLt;

    public zzb(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzh<TContinuationResult> zzhVar) {
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
        this.zzbDK.execute(new Runnable() { // from class: com.google.android.gms.tasks.zzb.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
            @Override // java.lang.Runnable
            public void run() {
                zzh zzhVar;
                RuntimeExecutionException runtimeExecutionException;
                try {
                    Task task2 = (Task) zzb.this.zzbLs.then(task);
                    if (task2 == null) {
                        zzb.this.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    task2.addOnSuccessListener(TaskExecutors.zzbLG, zzb.this);
                    task2.addOnFailureListener(TaskExecutors.zzbLG, zzb.this);
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzh zzhVar2 = zzb.this.zzbLt;
                        runtimeExecutionException = (Exception) e.getCause();
                        zzhVar = zzhVar2;
                    } else {
                        runtimeExecutionException = e;
                        zzhVar = zzb.this.zzbLt;
                    }
                    zzhVar.setException(runtimeExecutionException);
                } catch (Exception e2) {
                    zzb.this.zzbLt.setException(e2);
                }
            }
        });
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(@NonNull Exception exc) {
        this.zzbLt.setException(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzbLt.setResult(tcontinuationresult);
    }
}
