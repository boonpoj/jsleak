package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import java.util.Map;
/* loaded from: classes.dex */
final class zzq implements zzt<zzanh> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzanhVar2.zzcq();
        } else if ("resume".equals(str)) {
            zzanhVar2.zzcr();
        }
    }
}
