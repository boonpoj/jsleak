package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzpd implements com.google.android.gms.ads.internal.gmsg.zzt<Object> {
    private /* synthetic */ zzzb zzbva;
    private /* synthetic */ zzoy zzbvb;

    /* renamed from: com.google.android.gms.internal.zzpd$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            zzpd.zza(zzpd.this, Thread.currentThread());
            zzpd.this.zzcm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpd(zzoy zzoyVar, zzzb zzzbVar) {
        this.zzbvb = zzoyVar;
        this.zzbva = zzzbVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            str = this.zzbvb.zzbuz;
            jSONObject.put("id", str);
            this.zzbva.zza("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzagf.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
