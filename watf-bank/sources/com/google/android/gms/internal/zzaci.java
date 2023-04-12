package com.google.android.gms.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzaci implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private /* synthetic */ zzach zzcrz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaci(zzach zzachVar) {
        this.zzcrz = zzachVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        Object obj2;
        zzalf zzalfVar;
        String str;
        zzalf zzalfVar2;
        obj2 = this.zzcrz.mLock;
        synchronized (obj2) {
            zzalfVar = this.zzcrz.zzcrv;
            if (zzalfVar.isDone()) {
                return;
            }
            str = this.zzcrz.zzcrt;
            if (str.equals(map.get("request_id"))) {
                zzacn zzacnVar = new zzacn(1, map);
                String type = zzacnVar.getType();
                String valueOf = String.valueOf(zzacnVar.zzns());
                StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 24 + String.valueOf(valueOf).length());
                sb.append("Invalid ");
                sb.append(type);
                sb.append(" request error: ");
                sb.append(valueOf);
                zzagf.zzcu(sb.toString());
                zzalfVar2 = this.zzcrz.zzcrv;
                zzalfVar2.set(zzacnVar);
            }
        }
    }
}
