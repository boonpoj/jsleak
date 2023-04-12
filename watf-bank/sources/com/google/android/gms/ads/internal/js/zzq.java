package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
/* loaded from: classes.dex */
final class zzq implements Runnable {
    final /* synthetic */ zzp zzcbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzp zzpVar) {
        this.zzcbi = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzcbi.zzcbh.zzcbf.mLock;
        synchronized (obj) {
            if (this.zzcbi.zzcbh.zzcbe.getStatus() != -1 && this.zzcbi.zzcbh.zzcbe.getStatus() != 1) {
                this.zzcbi.zzcbh.zzcbe.reject();
                zzbs.zzei();
                zzahn.runOnUiThread(new zzr(this));
                zzagf.v("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
