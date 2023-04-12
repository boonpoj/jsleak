package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzacj implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private /* synthetic */ zzach zzcrz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacj(zzach zzachVar) {
        this.zzcrz = zzachVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        Object obj2;
        zzalf zzalfVar;
        String str;
        zzalf zzalfVar2;
        Context context;
        String str2;
        obj2 = this.zzcrz.mLock;
        synchronized (obj2) {
            zzalfVar = this.zzcrz.zzcrv;
            if (zzalfVar.isDone()) {
                return;
            }
            zzacn zzacnVar = new zzacn(-2, map);
            str = this.zzcrz.zzcrt;
            if (str.equals(zzacnVar.getRequestId())) {
                String url = zzacnVar.getUrl();
                if (url == null) {
                    zzagf.zzcu("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    context = this.zzcrz.mContext;
                    str2 = this.zzcrz.zzcru;
                    String replaceAll = url.replaceAll("%40mediation_adapters%40", zzaga.zzc(context, map.get("check_adapters"), str2));
                    zzacnVar.setUrl(replaceAll);
                    String valueOf = String.valueOf(replaceAll);
                    zzagf.v(valueOf.length() != 0 ? "Ad request URL modified to ".concat(valueOf) : new String("Ad request URL modified to "));
                }
                zzalfVar2 = this.zzcrz.zzcrv;
                zzalfVar2.set(zzacnVar);
            }
        }
    }
}
