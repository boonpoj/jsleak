package com.google.android.gms.internal;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzahj implements Callable<Void> {
    private /* synthetic */ Runnable zzdat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahj(Runnable runnable) {
        this.zzdat = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.zzdat.run();
        return null;
    }
}
