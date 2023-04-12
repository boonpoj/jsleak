package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzpa implements zzanm {
    private /* synthetic */ Map zzbvc;
    private /* synthetic */ zzoz zzbvd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpa(zzoz zzozVar, Map map) {
        this.zzbvd = zzozVar;
        this.zzbvc = map;
    }

    @Override // com.google.android.gms.internal.zzanm
    public final void zza(zzanh zzanhVar, boolean z) {
        String str;
        this.zzbvd.zzbvb.zzbuz = (String) this.zzbvc.get("id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            str = this.zzbvd.zzbvb.zzbuz;
            jSONObject.put("id", str);
            this.zzbvd.zzbva.zza("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzagf.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
