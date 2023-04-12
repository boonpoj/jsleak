package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import java.util.Map;
/* loaded from: classes.dex */
final class zzs implements zzt<zzanh> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        if (map.keySet().contains("start")) {
            zzanhVar2.zzag(true);
        }
        if (map.keySet().contains("stop")) {
            zzanhVar2.zzag(false);
        }
    }
}
