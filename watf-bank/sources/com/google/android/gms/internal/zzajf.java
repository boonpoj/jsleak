package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
@zzzv
/* loaded from: classes.dex */
public final class zzajf {
    private HandlerThread zzdcv = null;
    private Handler mHandler = null;
    private int zzdcw = 0;
    private final Object mLock = new Object();

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final Looper zzqs() {
        Looper looper;
        synchronized (this.mLock) {
            if (this.zzdcw != 0) {
                com.google.android.gms.common.internal.zzbq.checkNotNull(this.zzdcv, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzdcv == null) {
                zzagf.v("Starting the looper thread.");
                this.zzdcv = new HandlerThread("LooperProvider");
                this.zzdcv.start();
                this.mHandler = new Handler(this.zzdcv.getLooper());
                zzagf.v("Looper thread started.");
            } else {
                zzagf.v("Resuming the looper thread");
                this.mLock.notifyAll();
            }
            this.zzdcw++;
            looper = this.zzdcv.getLooper();
        }
        return looper;
    }
}
