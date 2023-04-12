package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzui {
    public final long zzcdi;
    public final List<zzuh> zzcdj;
    public final List<String> zzcdk;
    public final List<String> zzcdl;
    public final List<String> zzcdm;
    public final List<String> zzcdn;
    public final boolean zzcdo;
    public final String zzcdp;
    public final long zzcdq;
    public final String zzcdr;
    public final int zzcds;
    public final int zzcdt;
    public final long zzcdu;
    public final boolean zzcdv;
    public final boolean zzcdw;
    public final boolean zzcdx;
    public int zzcdy;
    public int zzcdz;
    public boolean zzcea;

    public zzui(String str) throws JSONException {
        this(new JSONObject(str));
    }

    public zzui(List<zzuh> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.zzcdj = list;
        this.zzcdi = j;
        this.zzcdk = list2;
        this.zzcdl = list3;
        this.zzcdm = list4;
        this.zzcdn = list5;
        this.zzcdo = z;
        this.zzcdp = str;
        this.zzcdq = -1L;
        this.zzcdy = 0;
        this.zzcdz = 1;
        this.zzcdr = null;
        this.zzcds = 0;
        this.zzcdt = -1;
        this.zzcdu = -1L;
        this.zzcdv = false;
        this.zzcdw = false;
        this.zzcdx = false;
        this.zzcea = false;
    }

    public zzui(JSONObject jSONObject) throws JSONException {
        if (zzagf.zzae(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzagf.v(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzuh zzuhVar = new zzuh(jSONArray.getJSONObject(i2));
            if (zzuhVar.zzlv()) {
                this.zzcea = true;
            }
            arrayList.add(zzuhVar);
            if (i < 0 && zza(zzuhVar)) {
                i = i2;
            }
        }
        this.zzcdy = i;
        this.zzcdz = jSONArray.length();
        this.zzcdj = Collections.unmodifiableList(arrayList);
        this.zzcdp = jSONObject.optString("qdata");
        this.zzcdt = jSONObject.optInt("fs_model_type", -1);
        this.zzcdu = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject == null) {
            this.zzcdi = -1L;
            this.zzcdk = null;
            this.zzcdl = null;
            this.zzcdm = null;
            this.zzcdn = null;
            this.zzcdq = -1L;
            this.zzcdr = null;
            this.zzcds = 0;
            this.zzcdv = false;
            this.zzcdo = false;
            this.zzcdw = false;
            this.zzcdx = false;
            return;
        }
        this.zzcdi = optJSONObject.optLong("ad_network_timeout_millis", -1L);
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcdk = zzuq.zza(optJSONObject, "click_urls");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcdl = zzuq.zza(optJSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcdm = zzuq.zza(optJSONObject, "nofill_urls");
        com.google.android.gms.ads.internal.zzbs.zzez();
        this.zzcdn = zzuq.zza(optJSONObject, "remote_ping_urls");
        this.zzcdo = optJSONObject.optBoolean("render_in_browser", false);
        long optLong = optJSONObject.optLong("refresh", -1L);
        this.zzcdq = optLong > 0 ? 1000 * optLong : -1L;
        zzaeq zza = zzaeq.zza(optJSONObject.optJSONArray("rewards"));
        if (zza == null) {
            this.zzcdr = null;
            this.zzcds = 0;
        } else {
            this.zzcdr = zza.type;
            this.zzcds = zza.zzcwd;
        }
        this.zzcdv = optJSONObject.optBoolean("use_displayed_impression", false);
        this.zzcdw = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
        this.zzcdx = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
    }

    private static boolean zza(zzuh zzuhVar) {
        for (String str : zzuhVar.zzccs) {
            if (str.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
