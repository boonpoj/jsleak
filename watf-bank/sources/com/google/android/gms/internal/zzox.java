package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzox implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private final WeakReference<zzot> zzaps;
    private final String zzaro;

    /* loaded from: assets/classes2.dex */
    class zza {
        private final List<String> zzVT;
        private final Bundle zzVU;

        public zza(zzox zzoxVar, List<String> list, Bundle bundle) {
            this.zzVT = list;
            this.zzVU = bundle;
        }
    }

    /* loaded from: assets/classes2.dex */
    class zzb {
        final List<zza> zzVV = new ArrayList();

        zzb(zzox zzoxVar) {
        }

        public void zza(zza zzaVar) {
            this.zzVV.add(zzaVar);
        }
    }

    public zzox(zzot zzotVar, String str) {
        this.zzaps = new WeakReference<>(zzotVar);
        this.zzaro = str;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        zzot zzotVar;
        String str = map.get("ads_id");
        String str2 = map.get("eventName");
        if (TextUtils.isEmpty(str) || !this.zzaro.equals(str)) {
            return;
        }
        try {
            Integer.parseInt(map.get("eventType"));
        } catch (Exception e) {
            zzagf.zzb("Parse Scion log event type error", e);
        }
        if ("_ai".equals(str2)) {
            zzot zzotVar2 = this.zzaps.get();
            if (zzotVar2 != null) {
                zzotVar2.zzbz();
            }
        } else if (!"_ac".equals(str2) || (zzotVar = this.zzaps.get()) == null) {
        } else {
            zzotVar.zzca();
        }
    }
}
