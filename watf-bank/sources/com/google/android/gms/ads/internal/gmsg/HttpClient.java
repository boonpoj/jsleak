package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzzv;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public class HttpClient implements zzt<com.google.android.gms.ads.internal.js.zza> {
    private final Context mContext;
    private final zzakd zzapr;

    /* JADX INFO: Access modifiers changed from: package-private */
    @zzzv
    /* loaded from: classes.dex */
    public static class zza {
        private final String mValue;
        private final String zzbhb;

        public zza(String str, String str2) {
            this.zzbhb = str;
            this.mValue = str2;
        }

        public final String getKey() {
            return this.zzbhb;
        }

        public final String getValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @zzzv
    /* loaded from: classes.dex */
    public static class zzb {
        private final String zzbxu;
        private final URL zzbxv;
        private final ArrayList<zza> zzbxw;
        private final String zzbxx;

        zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzbxu = str;
            this.zzbxv = url;
            this.zzbxw = arrayList;
            this.zzbxx = str2;
        }

        public final String zzkn() {
            return this.zzbxu;
        }

        public final URL zzko() {
            return this.zzbxv;
        }

        public final ArrayList<zza> zzkp() {
            return this.zzbxw;
        }

        public final String zzkq() {
            return this.zzbxx;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @zzzv
    /* loaded from: classes.dex */
    public class zzc {
        private final zzd zzbxy;
        private final boolean zzbxz;
        private final String zzbya;

        public zzc(HttpClient httpClient, boolean z, zzd zzdVar, String str) {
            this.zzbxz = z;
            this.zzbxy = zzdVar;
            this.zzbya = str;
        }

        public final String getReason() {
            return this.zzbya;
        }

        public final boolean isSuccess() {
            return this.zzbxz;
        }

        public final zzd zzkr() {
            return this.zzbxy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @zzzv
    /* loaded from: classes.dex */
    public static class zzd {
        private final String zzbtu;
        private final String zzbxu;
        private final int zzbyb;
        private final List<zza> zzce;

        zzd(String str, int i, List<zza> list, String str2) {
            this.zzbxu = str;
            this.zzbyb = i;
            this.zzce = list;
            this.zzbtu = str2;
        }

        public final String getBody() {
            return this.zzbtu;
        }

        public final int getResponseCode() {
            return this.zzbyb;
        }

        public final String zzkn() {
            return this.zzbxu;
        }

        public final Iterable<zza> zzks() {
            return this.zzce;
        }
    }

    public HttpClient(Context context, zzakd zzakdVar) {
        this.mContext = context;
        this.zzapr = zzakdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.ads.internal.gmsg.HttpClient.zzc zza(com.google.android.gms.ads.internal.gmsg.HttpClient.zzb r13) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.HttpClient.zza(com.google.android.gms.ads.internal.gmsg.HttpClient$zzb):com.google.android.gms.ads.internal.gmsg.HttpClient$zzc");
    }

    private static JSONObject zza(zzd zzdVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzdVar.zzkn());
            if (zzdVar.getBody() != null) {
                jSONObject.put("body", zzdVar.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza zzaVar : zzdVar.zzks()) {
                jSONArray.put(new JSONObject().put("key", zzaVar.getKey()).put("value", zzaVar.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzdVar.getResponseCode());
        } catch (JSONException e) {
            zzagf.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    private static zzb zzd(JSONObject jSONObject) {
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        URL url = null;
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzagf.zzb("Error constructing http request.", e);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }

    public JSONObject send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String str = "";
        try {
            str = jSONObject.optString("http_request_id");
            zzc zza2 = zza(zzd(jSONObject));
            if (zza2.isSuccess()) {
                jSONObject2.put("response", zza(zza2.zzkr()));
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("response", new JSONObject().put("http_request_id", str));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza2.getReason());
            }
        } catch (Exception e) {
            zzagf.zzb("Error executing http request.", e);
            try {
                jSONObject2.put("response", new JSONObject().put("http_request_id", str));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", e.toString());
            } catch (JSONException e2) {
                zzagf.zzb("Error executing http request.", e2);
            }
        }
        return jSONObject2;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(com.google.android.gms.ads.internal.js.zza zzaVar, Map map) {
        zzahh.zza(new zzu(this, map, zzaVar));
    }
}
