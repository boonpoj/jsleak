package com.google.android.gms.internal;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzafs {
    private String mAppId;
    private final long zzcyk;
    private String zzcyo;
    private final List<String> zzcyl = new ArrayList();
    private final List<String> zzcym = new ArrayList();
    private final Map<String, zzui> zzcyn = new HashMap();
    private boolean zzcyp = false;

    public zzafs(String str, long j) {
        this.zzcyo = str;
        this.zzcyk = j;
        zzbz(str);
    }

    private final void zzbz(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1) != 1) {
                this.zzcyp = false;
                zzagf.zzcu("App settings could not be fetched successfully.");
                return;
            }
            this.zzcyp = true;
            this.mAppId = jSONObject.optString("app_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("format");
                    String optString2 = jSONObject2.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if (AdType.INTERSTITIAL.equalsIgnoreCase(optString)) {
                            this.zzcym.add(optString2);
                        } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                            this.zzcyn.put(optString2, new zzui(optJSONObject));
                        }
                    }
                }
            }
            zzp(jSONObject);
        } catch (JSONException e) {
            zzagf.zzc("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "AppSettings.parseAppSettingsJson");
        }
    }

    private final void zzp(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("persistable_banner_ad_unit_ids");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.zzcyl.add(optJSONArray.optString(i));
            }
        }
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final long zzou() {
        return this.zzcyk;
    }

    public final boolean zzov() {
        return this.zzcyp;
    }

    public final String zzow() {
        return this.zzcyo;
    }

    public final Map<String, zzui> zzox() {
        return this.zzcyn;
    }
}
