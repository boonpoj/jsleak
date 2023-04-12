package com.google.android.gms.internal;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzoz implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    final /* synthetic */ zzzb zzbva;
    final /* synthetic */ zzoy zzbvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoz(zzoy zzoyVar, zzzb zzzbVar) {
        this.zzbvb = zzoyVar;
        this.zzbva = zzzbVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        WeakReference weakReference;
        weakReference = this.zzbvb.zzbuy;
        zzanh zzanhVar = (zzanh) weakReference.get();
        if (zzanhVar == null) {
            this.zzbva.zzb("/loadHtml", this);
            return;
        }
        zzanhVar.zzsz().zza(new zzpa(this, map));
        String str = map.get("overlayHtml");
        String str2 = map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzanhVar.loadData(str, "text/html", "UTF-8");
        } else {
            zzanhVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        }
    }
}
