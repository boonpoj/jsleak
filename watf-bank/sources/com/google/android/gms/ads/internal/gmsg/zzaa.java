package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzwo;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzwt;
import com.google.android.gms.internal.zzwu;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzaa implements zzt<zzanh> {
    private static Map<String, Integer> zzbyg = com.google.android.gms.common.util.zze.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);
    private final com.google.android.gms.ads.internal.zzw zzbye;
    private final zzwr zzbyf;

    public zzaa(com.google.android.gms.ads.internal.zzw zzwVar, zzwr zzwrVar) {
        this.zzbye = zzwVar;
        this.zzbyf = zzwrVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        com.google.android.gms.ads.internal.zzw zzwVar;
        zzanh zzanhVar2 = zzanhVar;
        int intValue = zzbyg.get((String) map.get("a")).intValue();
        if (intValue != 5 && (zzwVar = this.zzbye) != null && !zzwVar.zzda()) {
            this.zzbye.zzt(null);
        } else if (intValue == 1) {
            this.zzbyf.execute(map);
        } else if (intValue == 3) {
            new zzwu(zzanhVar2, map).execute();
        } else if (intValue == 4) {
            new zzwo(zzanhVar2, map).execute();
        } else if (intValue == 5) {
            new zzwt(zzanhVar2, map).execute();
        } else if (intValue != 6) {
            zzagf.zzct("Unknown MRAID command called.");
        } else {
            this.zzbyf.zzl(true);
        }
    }
}
