package com.google.android.gms.internal;

import android.os.Process;
/* loaded from: classes.dex */
final class zzbhc implements Runnable {
    private final int mPriority;
    private final Runnable zzz;

    public zzbhc(Runnable runnable, int i) {
        this.zzz = runnable;
        this.mPriority = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzz.run();
    }
}
