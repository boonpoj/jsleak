package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@zzzv
/* loaded from: classes.dex */
public class zzalf<T> implements zzakv<T> {
    private T mValue;
    private boolean zzcfb;
    private Throwable zzdfl;
    private boolean zzdfm;
    private final Object mLock = new Object();
    private final zzakw zzdfn = new zzakw();

    private final boolean zzrg() {
        return this.zzdfl != null || this.zzdfm;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (z) {
            synchronized (this.mLock) {
                if (zzrg()) {
                    return false;
                }
                this.zzcfb = true;
                this.zzdfm = true;
                this.mLock.notifyAll();
                this.zzdfn.zzre();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.mLock) {
            if (!zzrg()) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzdfl != null) {
                throw new ExecutionException(this.zzdfl);
            }
            if (this.zzcfb) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.mValue;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.mLock) {
            if (!zzrg()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.mLock.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzdfl != null) {
                throw new ExecutionException(this.zzdfl);
            }
            if (!this.zzdfm) {
                throw new TimeoutException("SettableFuture timed out.");
            }
            if (this.zzcfb) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.mValue;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcfb;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean zzrg;
        synchronized (this.mLock) {
            zzrg = zzrg();
        }
        return zzrg;
    }

    public final void set(T t) {
        synchronized (this.mLock) {
            if (this.zzcfb) {
                return;
            }
            if (zzrg()) {
                com.google.android.gms.ads.internal.zzbs.zzem().zza(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.zzdfm = true;
            this.mValue = t;
            this.mLock.notifyAll();
            this.zzdfn.zzre();
        }
    }

    public final void setException(Throwable th) {
        synchronized (this.mLock) {
            if (this.zzcfb) {
                return;
            }
            if (zzrg()) {
                com.google.android.gms.ads.internal.zzbs.zzem().zza(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.zzdfl = th;
            this.mLock.notifyAll();
            this.zzdfn.zzre();
        }
    }

    @Override // com.google.android.gms.internal.zzakv
    public final void zza(Runnable runnable, Executor executor) {
        this.zzdfn.zza(runnable, executor);
    }
}
