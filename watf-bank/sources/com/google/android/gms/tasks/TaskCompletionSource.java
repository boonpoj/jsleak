package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
/* loaded from: assets/classes2.dex */
public class TaskCompletionSource<TResult> {
    private final zzh<TResult> zzbLF = new zzh<>();

    @NonNull
    public Task<TResult> getTask() {
        return this.zzbLF;
    }

    public void setException(@NonNull Exception exc) {
        this.zzbLF.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.zzbLF.setResult(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.zzbLF.trySetException(exc);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zzbLF.trySetResult(tresult);
    }
}
