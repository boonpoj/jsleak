package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzj implements Executor {
    private /* synthetic */ Handler zzw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zzi zziVar, Handler handler) {
        this.zzw = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzw.post(runnable);
    }
}
