package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.integralads.avid.library.mopub.utils.AvidJSONUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzuq {
    private static String zza(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public static List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            return Collections.unmodifiableList(arrayList);
        }
        return null;
    }

    public static void zza(Context context, String str, zzafo zzafoVar, String str2, boolean z, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str3 = z ? "1" : "0";
        for (String str4 : list) {
            String zza = zza(zza(zza(zza(zza(zza(zza(str4, "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", zzafoVar.zzcxl.zzcdp), "@gw_sdkver@", str), "@gw_sessid@", zzkb.zzic()), "@gw_seqnum@", zzafoVar.zzcng), "@gw_adnetstatus@", zzafoVar.zzcxm);
            if (zzafoVar.zzces != null) {
                zza = zza(zza(zza, "@gw_adnetid@", zzafoVar.zzces.zzccr), "@gw_allocid@", zzafoVar.zzces.zzcct);
            }
            String zzb = zzafi.zzb(zza, context);
            com.google.android.gms.ads.internal.zzbs.zzei();
            zzahn.zze(context, str, zzb);
        }
    }

    public static void zza(Context context, String str, List<String> list, String str2, zzaeq zzaeqVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        long currentTimeMillis = com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis();
        for (String str3 : list) {
            String zza = zza(zza(str3, "@gw_rwd_userid@", str2), "@gw_tmstmp@", Long.toString(currentTimeMillis));
            if (zzaeqVar != null) {
                zza = zza(zza(zza, "@gw_rwd_itm@", zzaeqVar.type), "@gw_rwd_amt@", Integer.toString(zzaeqVar.zzcwd));
            }
            com.google.android.gms.ads.internal.zzbs.zzei();
            zzahn.zze(context, str, zza);
        }
    }

    public static boolean zza(String str, int[] iArr) {
        if (!TextUtils.isEmpty(str) && iArr.length == 2) {
            String[] split = str.split(AvidJSONUtil.KEY_X);
            if (split.length != 2) {
                return false;
            }
            try {
                iArr[0] = Integer.parseInt(split[0]);
                iArr[1] = Integer.parseInt(split[1]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
