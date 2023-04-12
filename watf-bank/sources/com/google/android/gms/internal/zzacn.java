package com.google.android.gms.internal;

import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzacn {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzcnq;
    private final List<String> zzcte;
    private final String zzctf;
    private final String zzctg;
    private final boolean zzcth;
    private final String zzcti;
    private final boolean zzctj;
    private final JSONObject zzctk;

    public zzacn(int i, Map<String, String> map) {
        this.url = map.get("url");
        this.zzctf = map.get("base_uri");
        this.zzctg = map.get("post_parameters");
        this.zzcth = parseBoolean(map.get("drt_include"));
        this.zzcnq = map.get("request_id");
        this.type = map.get(VastExtensionXmlManager.TYPE);
        this.zzcte = zzbp(map.get("errors"));
        this.errorCode = i;
        this.zzcti = map.get("fetched_ad");
        this.zzctj = parseBoolean(map.get("render_test_ad_label"));
        this.zzctk = new JSONObject();
    }

    public zzacn(JSONObject jSONObject) {
        this.url = jSONObject.optString("url");
        this.zzctf = jSONObject.optString("base_uri");
        this.zzctg = jSONObject.optString("post_parameters");
        this.zzcth = parseBoolean(jSONObject.optString("drt_include"));
        this.zzcnq = jSONObject.optString("request_id");
        this.type = jSONObject.optString(VastExtensionXmlManager.TYPE);
        this.zzcte = zzbp(jSONObject.optString("errors"));
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzcti = jSONObject.optString("fetched_ad");
        this.zzctj = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzctk = optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    private static boolean parseBoolean(String str) {
        if (str != null) {
            return str.equals("1") || str.equals("true");
        }
        return false;
    }

    private static List<String> zzbp(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getRequestId() {
        return this.zzcnq;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final List<String> zzns() {
        return this.zzcte;
    }

    public final String zznt() {
        return this.zzctf;
    }

    public final String zznu() {
        return this.zzctg;
    }

    public final boolean zznv() {
        return this.zzcth;
    }

    public final String zznw() {
        return this.zzcti;
    }

    public final boolean zznx() {
        return this.zzctj;
    }
}
