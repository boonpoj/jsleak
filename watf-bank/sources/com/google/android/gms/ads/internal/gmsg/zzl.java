package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import java.util.Map;
/* loaded from: classes.dex */
final class zzl implements zzt<zzanh> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        zzanh zzanhVar2 = zzanhVar;
        com.google.android.gms.ads.internal.overlay.zzd zzsv = zzanhVar2.zzsv();
        if (zzsv != null) {
            zzsv.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzsw = zzanhVar2.zzsw();
        if (zzsw != null) {
            zzsw.close();
        } else {
            zzagf.zzcu("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
