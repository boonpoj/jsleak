package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzahn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzp implements zzd {
    final /* synthetic */ zzc zzcbg;
    final /* synthetic */ zzo zzcbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzo zzoVar, zzc zzcVar) {
        this.zzcbh = zzoVar;
        this.zzcbg = zzcVar;
    }

    @Override // com.google.android.gms.ads.internal.js.zzd
    public final void zzlo() {
        zzahn.zzdaw.postDelayed(new zzq(this), zzy.zzcbo);
    }
}
