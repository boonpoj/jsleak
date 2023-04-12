package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
/* loaded from: assets/classes2.dex */
public abstract class RepeatingHandlerRunnable implements Runnable {
    @NonNull

    /* renamed from: ࢠ  reason: contains not printable characters */
    protected final Handler f957;

    /* renamed from: ࢢ  reason: contains not printable characters */
    protected volatile long f958;

    /* renamed from: ࢣ  reason: contains not printable characters */
    private volatile boolean f959;

    public RepeatingHandlerRunnable(@NonNull Handler handler) {
        Preconditions.checkNotNull(handler);
        this.f957 = handler;
    }

    public abstract void doWork();

    @VisibleForTesting
    @Deprecated
    public boolean isRunning() {
        return this.f959;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f959) {
            doWork();
            this.f957.postDelayed(this, this.f958);
        }
    }

    public void startRepeating(long j) {
        Preconditions.checkArgument(j > 0, "intervalMillis must be greater than 0. Saw: %d", Long.valueOf(j));
        this.f958 = j;
        if (this.f959) {
            return;
        }
        this.f959 = true;
        this.f957.post(this);
    }

    public void stop() {
        this.f959 = false;
    }
}
