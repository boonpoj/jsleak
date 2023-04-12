package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzali;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzag implements zzali {
    private /* synthetic */ zzaa zzcbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzae zzaeVar, zzaa zzaaVar) {
        this.zzcbu = zzaaVar;
    }

    @Override // com.google.android.gms.internal.zzali
    public final void run() {
        zzagf.v("Rejecting reference for JS Engine.");
        this.zzcbu.reject();
    }
}
