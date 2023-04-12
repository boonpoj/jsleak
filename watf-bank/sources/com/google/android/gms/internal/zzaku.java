package com.google.android.gms.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
@zzzv
/* loaded from: classes.dex */
public final class zzaku<T> implements zzakv<T> {
    private final T value;
    private final zzakw zzdey = new zzakw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaku(T t) {
        this.value = t;
        this.zzdey.zzre();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final T get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzakv
    public final void zza(Runnable runnable, Executor executor) {
        this.zzdey.zza(runnable, executor);
    }
}
