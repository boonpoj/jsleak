package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahp implements Runnable {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzahn zzdbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahp(zzahn zzahnVar, Context context) {
        this.zzdbe = zzahnVar;
        this.val$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.zzdbe.mLock;
        synchronized (obj) {
            this.zzdbe.zzczb = zzahn.zzaj(this.val$context);
            obj2 = this.zzdbe.mLock;
            obj2.notifyAll();
        }
    }
}
