package com.google.android.gms.internal;

import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzabw implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        com.google.android.gms.ads.internal.gmsg.zzy zzyVar;
        String str = map.get("request_id");
        String valueOf = String.valueOf(map.get("errors"));
        zzagf.zzcu(valueOf.length() != 0 ? "Invalid request: ".concat(valueOf) : new String("Invalid request: "));
        zzyVar = zzabo.zzcqk;
        zzyVar.zzat(str);
    }
}
