package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzah implements zzalk<zzc> {
    final /* synthetic */ zzae zzcbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(zzae zzaeVar) {
        this.zzcbv = zzaeVar;
    }

    @Override // com.google.android.gms.internal.zzalk
    public final /* synthetic */ void zzf(zzc zzcVar) {
        zzbs.zzei();
        zzahn.runOnUiThread(new zzai(this, zzcVar));
    }
}
