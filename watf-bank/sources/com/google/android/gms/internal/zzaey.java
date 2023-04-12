package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzaey extends zzbfm {
    public static final Parcelable.Creator<zzaey> CREATOR = new zzaez();
    public final String zzcwp;
    public final String zzcwq;
    public final boolean zzcwr;
    public final boolean zzcws;
    public final List<String> zzcwt;
    public final boolean zzcwu;
    public final boolean zzcwv;

    public zzaey(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4) {
        this.zzcwp = str;
        this.zzcwq = str2;
        this.zzcwr = z;
        this.zzcws = z2;
        this.zzcwt = list;
        this.zzcwu = z3;
        this.zzcwv = z4;
    }

    public static zzaey zzo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", "");
        String optString2 = jSONObject.optString("report_url", "");
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
        }
        return new zzaey(optString, optString2, optBoolean, optBoolean2, arrayList, jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzcwp, false);
        zzbfp.zza(parcel, 3, this.zzcwq, false);
        zzbfp.zza(parcel, 4, this.zzcwr);
        zzbfp.zza(parcel, 5, this.zzcws);
        zzbfp.zzb(parcel, 6, this.zzcwt, false);
        zzbfp.zza(parcel, 7, this.zzcwu);
        zzbfp.zza(parcel, 8, this.zzcwv);
        zzbfp.zzai(parcel, zze);
    }
}
