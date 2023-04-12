package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzgn implements com.google.android.gms.ads.internal.gmsg.zzt<com.google.android.gms.ads.internal.js.zzaj> {
    private /* synthetic */ zzgf zzaxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgn(zzgf zzgfVar) {
        this.zzaxd = zzgfVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(com.google.android.gms.ads.internal.js.zzaj zzajVar, Map map) {
        zzft zzftVar;
        com.google.android.gms.ads.internal.gmsg.zzz zzzVar;
        com.google.android.gms.ads.internal.js.zzaj zzajVar2 = zzajVar;
        zzftVar = this.zzaxd.zzawt;
        if (zzftVar.zze(map)) {
            zzzVar = this.zzaxd.zzawz;
            zzzVar.zza(zzajVar2, map);
        }
    }
}
