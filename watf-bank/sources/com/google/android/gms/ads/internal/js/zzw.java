package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzw implements zzalk<zzc> {
    private /* synthetic */ zzn zzcbf;
    private /* synthetic */ zzae zzcbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(zzn zznVar, zzae zzaeVar) {
        this.zzcbf = zznVar;
        this.zzcbm = zzaeVar;
    }

    @Override // com.google.android.gms.internal.zzalk
    public final /* synthetic */ void zzf(zzc zzcVar) {
        Object obj;
        zzae zzaeVar;
        zzae zzaeVar2;
        zzae zzaeVar3;
        obj = this.zzcbf.mLock;
        synchronized (obj) {
            this.zzcbf.zzcbc = 0;
            zzaeVar = this.zzcbf.zzcbb;
            if (zzaeVar != null) {
                zzae zzaeVar4 = this.zzcbm;
                zzaeVar2 = this.zzcbf.zzcbb;
                if (zzaeVar4 != zzaeVar2) {
                    zzagf.v("New JS engine is loaded, marking previous one as destroyable.");
                    zzaeVar3 = this.zzcbf.zzcbb;
                    zzaeVar3.zzlr();
                }
            }
            this.zzcbf.zzcbb = this.zzcbm;
        }
    }
}
