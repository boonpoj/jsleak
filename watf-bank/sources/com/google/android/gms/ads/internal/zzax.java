package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzahn;
/* loaded from: classes.dex */
final class zzax implements Runnable {
    final /* synthetic */ Runnable zzarg;
    final /* synthetic */ zzaw zzarh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzaw zzawVar, Runnable runnable) {
        this.zzarh = zzawVar;
        this.zzarg = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbs.zzei();
        zzahn.runOnUiThread(new zzay(this));
    }
}
