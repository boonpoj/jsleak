package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
@zzzv
/* loaded from: classes.dex */
public final class zza implements zzt<Object> {
    private final zzb zzbwv;

    public zza(zzb zzbVar) {
        this.zzbwv = zzbVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzagf.zzcu("App event with no name parameter.");
        } else {
            this.zzbwv.onAppEvent(str, map.get("info"));
        }
    }
}
