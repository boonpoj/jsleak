package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzu implements Runnable {
    final /* synthetic */ zzc zzcbg;
    private /* synthetic */ zzo zzcbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzo zzoVar, zzc zzcVar) {
        this.zzcbh = zzoVar;
        this.zzcbg = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzcbh.zzcbf.mLock;
        synchronized (obj) {
            if (this.zzcbh.zzcbe.getStatus() != -1 && this.zzcbh.zzcbe.getStatus() != 1) {
                this.zzcbh.zzcbe.reject();
                zzbs.zzei();
                zzahn.runOnUiThread(new zzv(this));
                zzagf.v("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
