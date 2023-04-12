package com.google.android.gms.internal;

import java.util.concurrent.Future;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzace implements Runnable {
    private /* synthetic */ Future zzcrr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzace(zzacb zzacbVar, Future future) {
        this.zzcrr = future;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzcrr.isDone()) {
            return;
        }
        this.zzcrr.cancel(true);
    }
}
