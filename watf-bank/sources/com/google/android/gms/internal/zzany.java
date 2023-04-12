package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes.dex */
final class zzany implements com.google.android.gms.ads.internal.gmsg.zzt<zzanh> {
    private /* synthetic */ zzanx zzdmx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzany(zzanx zzanxVar) {
        this.zzdmx = zzanxVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzanh zzanhVar, Map map) {
        Object obj;
        int i;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                obj = this.zzdmx.mLock;
                synchronized (obj) {
                    i = this.zzdmx.zzdmp;
                    if (i != parseInt) {
                        this.zzdmx.zzdmp = parseInt;
                        this.zzdmx.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzagf.zzc("Exception occurred while getting webview content height", e);
            }
        }
    }
}
