package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzyo implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private /* synthetic */ zzym zzcko;
    private /* synthetic */ zzon zzckp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyo(zzym zzymVar, zzon zzonVar) {
        this.zzcko = zzymVar;
        this.zzckp = zzonVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        this.zzcko.zzc(this.zzckp, map.get("asset"));
    }
}
