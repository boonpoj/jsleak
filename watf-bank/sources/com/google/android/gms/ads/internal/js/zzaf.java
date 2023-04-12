package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaf implements zzalk<zzc> {
    private /* synthetic */ zzaa zzcbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzae zzaeVar, zzaa zzaaVar) {
        this.zzcbu = zzaaVar;
    }

    @Override // com.google.android.gms.internal.zzalk
    public final /* synthetic */ void zzf(zzc zzcVar) {
        zzagf.v("Getting a new session for JS Engine.");
        this.zzcbu.zzk(zzcVar.zzln());
    }
}
