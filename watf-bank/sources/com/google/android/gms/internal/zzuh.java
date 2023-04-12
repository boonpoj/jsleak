package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzuh {
    public final String zzccq;
    public final String zzccr;
    public final List<String> zzccs;
    public final String zzcct;
    public final String zzccu;
    public final List<String> zzccv;
    public final List<String> zzccw;
    public final List<String> zzccx;
    public final List<String> zzccy;
    public final String zzccz;
    public final List<String> zzcda;
    public final List<String> zzcdb;
    public final String zzcdc;
    public final String zzcdd;
    public final String zzcde;
    public final List<String> zzcdf;
    public final String zzcdg;
    private String zzcdh;
    public final long zzcdi;

    public zzuh(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, List<String> list4, String str5, String str6, List<String> list5, List<String> list6, String str7, String str8, String str9, List<String> list7, String str10, List<String> list8, String str11, long j) {
        this.zzccq = str;
        this.zzccr = null;
        this.zzccs = list;
        this.zzcct = null;
        this.zzccu = null;
        this.zzccv = list2;
        this.zzccw = list3;
        this.zzccx = list4;
        this.zzccz = str5;
        this.zzcda = list5;
        this.zzcdb = list6;
        this.zzcdc = null;
        this.zzcdd = null;
        this.zzcde = null;
        this.zzcdf = null;
        this.zzcdg = null;
        this.zzccy = list8;
        this.zzcdh = null;
        this.zzcdi = -1L;
    }

    public zzuh(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzccr = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzccs = Collections.unmodifiableList(arrayList);
        this.zzcct = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzccv = zzuq.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzccw = zzuq.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzccy = zzuq.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcda = zzuq.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcdb = zzuq.zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            com.google.android.gms.ads.internal.zzbs.zzez();
            list = zzuq.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzccx = list;
        this.zzccq = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzccz = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzccu = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzcdc = jSONObject.optString("html_template", null);
        this.zzcdd = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzcde = optJSONObject3 != null ? optJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcdf = zzuq.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzcdg = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzcdh = jSONObject.optString("response_type", null);
        this.zzcdi = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }

    public final boolean zzlv() {
        return "banner".equalsIgnoreCase(this.zzcdh);
    }

    public final boolean zzlw() {
        return "native".equalsIgnoreCase(this.zzcdh);
    }
}
