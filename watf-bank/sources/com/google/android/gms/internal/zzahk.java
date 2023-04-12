package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahk implements Runnable {
    private /* synthetic */ Callable val$callable;
    private /* synthetic */ zzalf zzbyv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahk(zzalf zzalfVar, Callable callable) {
        this.zzbyv = zzalfVar;
        this.val$callable = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(10);
            this.zzbyv.set(this.val$callable.call());
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AdThreadPool.submit");
            this.zzbyv.setException(e);
        }
    }
}
