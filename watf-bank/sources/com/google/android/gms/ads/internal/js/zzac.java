package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzac implements zzalk<zzaj> {
    private /* synthetic */ zzaa zzcbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzaa zzaaVar) {
        this.zzcbr = zzaaVar;
    }

    @Override // com.google.android.gms.internal.zzalk
    public final /* synthetic */ void zzf(zzaj zzajVar) {
        zzae zzaeVar;
        zzagf.v("Releasing engine reference.");
        zzaeVar = this.zzcbr.zzcbp;
        zzaeVar.zzlq();
    }
}
