package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zzw implements zzt<Object> {
    private final zzx zzbyc;

    public zzw(zzx zzxVar) {
        this.zzbyc = zzxVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat(map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzagf.zzb("Fail to parse float", e);
        }
        this.zzbyc.zzd(equals);
        this.zzbyc.zza(equals2, f);
    }
}
