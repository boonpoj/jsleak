package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzalf;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzy implements zzt<Object> {
    private HashMap<String, zzalf<JSONObject>> zzbyd = new HashMap<>();

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("request_id");
        String str2 = map.get("fetched_ad");
        zzagf.zzbx("Received ad from the cache.");
        zzalf<JSONObject> zzalfVar = this.zzbyd.get(str);
        try {
            if (zzalfVar == null) {
                zzagf.e("Could not find the ad request for the corresponding ad response.");
            } else {
                zzalfVar.set(new JSONObject(str2));
            }
        } catch (JSONException e) {
            zzagf.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzalfVar.set(null);
        } finally {
            this.zzbyd.remove(str);
        }
    }

    public final Future<JSONObject> zzas(String str) {
        zzalf<JSONObject> zzalfVar = new zzalf<>();
        this.zzbyd.put(str, zzalfVar);
        return zzalfVar;
    }

    public final void zzat(String str) {
        zzalf<JSONObject> zzalfVar = this.zzbyd.get(str);
        if (zzalfVar == null) {
            zzagf.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzalfVar.isDone()) {
            zzalfVar.cancel(true);
        }
        this.zzbyd.remove(str);
    }
}
