package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzad implements zzt<Object> {
    private final Object mLock = new Object();
    private final Map<String, zzae> zzbym = new HashMap();

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("result");
        synchronized (this.mLock) {
            zzae remove = this.zzbym.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                zzagf.zzcu(valueOf.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str2)) {
                remove.zzau(str3);
            } else if (str4 == null) {
                remove.zze(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    if (zzagf.zzpz()) {
                        String valueOf2 = String.valueOf(jSONObject.toString(2));
                        zzagf.v(valueOf2.length() != 0 ? "Result GMSG: ".concat(valueOf2) : new String("Result GMSG: "));
                    }
                    remove.zze(jSONObject);
                } catch (JSONException e) {
                    remove.zzau(e.getMessage());
                }
            }
        }
    }

    public final void zza(String str, zzae zzaeVar) {
        synchronized (this.mLock) {
            this.zzbym.put(str, zzaeVar);
        }
    }
}
