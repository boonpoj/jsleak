package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import java.util.Map;
/* loaded from: classes.dex */
final class zzn implements zzt<Object> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf(map.get("string"));
        zzagf.zzct(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
