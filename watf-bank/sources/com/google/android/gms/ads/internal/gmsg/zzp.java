package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.Map;
/* loaded from: classes.dex */
final class zzp implements zzt<zzanh> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        if (((Boolean) zzkb.zzif().zzd(zznh.zzbmz)).booleanValue()) {
            zzanhVar2.zzaf(!Boolean.parseBoolean((String) map.get("disabled")));
        }
    }
}
