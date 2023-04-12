package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzali;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzx implements zzali {
    private /* synthetic */ zzn zzcbf;
    private /* synthetic */ zzae zzcbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzn zznVar, zzae zzaeVar) {
        this.zzcbf = zznVar;
        this.zzcbm = zzaeVar;
    }

    @Override // com.google.android.gms.internal.zzali
    public final void run() {
        Object obj;
        obj = this.zzcbf.mLock;
        synchronized (obj) {
            this.zzcbf.zzcbc = 1;
            zzagf.v("Failed loading new engine. Marking new engine destroyable.");
            this.zzcbm.zzlr();
        }
    }
}
