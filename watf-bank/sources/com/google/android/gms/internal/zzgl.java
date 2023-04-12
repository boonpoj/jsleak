package com.google.android.gms.internal;

import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzgl implements com.google.android.gms.ads.internal.gmsg.zzt<com.google.android.gms.ads.internal.js.zzaj> {
    private /* synthetic */ zzgf zzaxd;

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzfE();

        void zzfF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgl(zzgf zzgfVar) {
        this.zzaxd = zzgfVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(com.google.android.gms.ads.internal.js.zzaj zzajVar, Map map) {
        if (zzgf.zza(this.zzaxd).zze(map)) {
            zzgf.zza(this.zzaxd).zza(this.zzaxd, map);
        }
    }
}
