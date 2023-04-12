package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
@zzzv
/* loaded from: classes.dex */
final class zzaky<V> extends FutureTask<V> implements zzakv<V> {
    private final zzakw zzdey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaky(Runnable runnable, V v) {
        super(runnable, v);
        this.zzdey = new zzakw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaky(Callable<V> callable) {
        super(callable);
        this.zzdey = new zzakw();
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        this.zzdey.zzre();
    }

    @Override // com.google.android.gms.internal.zzakv
    public final void zza(Runnable runnable, Executor executor) {
        this.zzdey.zza(runnable, executor);
    }
}
