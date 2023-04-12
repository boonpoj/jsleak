package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
final class zzxv implements Runnable {
    private /* synthetic */ zzxu zzcjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxv(zzxu zzxuVar) {
        this.zzcjp = zzxuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.zzcjp.zzcjo;
        if (atomicBoolean.get()) {
            zzagf.e("Timed out waiting for WebView to finish loading.");
            this.zzcjp.cancel();
        }
    }
}
