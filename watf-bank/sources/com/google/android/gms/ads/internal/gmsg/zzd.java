package com.google.android.gms.ads.internal.gmsg;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajh;
import com.google.android.gms.internal.zzamp;
import com.google.android.gms.internal.zzamv;
import com.google.android.gms.internal.zzamw;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzaog;
import com.google.android.gms.internal.zzaow;
import com.google.android.gms.internal.zzaox;
import com.google.android.gms.internal.zzaoy;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzv;
import com.mopub.common.Constants;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzd {
    private static zzt<Object> zzbww = new zzj();
    public static final zzt<zzanh> zzbwx = zze.zzbxp;
    public static final zzt<zzanh> zzbwy = zzf.zzbxp;
    public static final zzt<zzanh> zzbwz = zzg.zzbxp;
    public static final zzt<zzanh> zzbxa = new zzl();
    public static final zzt<zzanh> zzbxb = new zzm();
    public static final zzt<zzanh> zzbxc = zzh.zzbxp;
    public static final zzt<Object> zzbxd = new zzn();
    public static final zzt<zzanh> zzbxe = new zzo();
    public static final zzt<zzanh> zzbxf = zzi.zzbxp;
    public static final zzt<zzanh> zzbxg = new zzp();
    public static final zzt<zzanh> zzbxh = new zzq();
    public static final zzt<zzamp> zzbxi = new zzamv();
    public static final zzt<zzamp> zzbxj = new zzamw();
    public static final zzt<zzanh> zzbxk = new zzc();
    public static final zzad zzbxl = new zzad();
    public static final zzt<zzanh> zzbxm = new zzr();
    public static final zzt<zzanh> zzbxn = new zzs();
    public static final zzt<zzanh> zzbxo = new zzk();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(com.google.android.gms.ads.internal.js.zza zzaVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzagf.zzcu("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzcv zztb = ((zzaow) zzaVar).zztb();
            if (zztb != null && zztb.zzb(parse)) {
                Context context = ((zzaog) zzaVar).getContext();
                zzaoy zzaoyVar = (zzaoy) zzaVar;
                if (zzaoyVar == null) {
                    throw null;
                }
                parse = zztb.zza(parse, context, (View) zzaoyVar, ((zzaog) zzaVar).zzsi());
            }
        } catch (zzcw e) {
            String valueOf = String.valueOf(str);
            zzagf.zzcu(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        zzaog zzaogVar = (zzaog) zzaVar;
        if ((((Boolean) zzkb.zzif().zzd(zznh.zzbku)).booleanValue() && zzbs.zzfd().zzq(zzaogVar.getContext())) && TextUtils.isEmpty(parse.getQueryParameter("fbs_aeid"))) {
            String zzy = zzbs.zzfd().zzy(zzaogVar.getContext());
            zzbs.zzei();
            parse = zzahn.zzb(parse.toString(), "fbs_aeid", zzy);
            zzbs.zzfd().zze(zzaogVar.getContext(), zzy);
        }
        new zzajh(zzaogVar.getContext(), ((zzaox) zzaVar).zzsk().zzcv, parse.toString()).zzpy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(zzaog zzaogVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzagf.zzcu("URL missing from httpTrack GMSG.");
        } else {
            new zzajh(zzaogVar.getContext(), ((zzaox) zzaogVar).zzsk().zzcv, str).zzpy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(zzaow zzaowVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzcv zztb = zzaowVar.zztb();
            if (zztb != null) {
                zztb.zzaf().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            zzagf.zzcu("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzb(zzaog zzaogVar, Map map) {
        JSONException jSONException;
        String str;
        PackageManager packageManager = zzaogVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                String valueOf = String.valueOf(optString7);
                                zzagf.zzb(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e2) {
                            jSONException = e2;
                            str = "Error constructing openable urls response.";
                            zzagf.zzb(str, jSONException);
                        }
                    } catch (JSONException e3) {
                        jSONException = e3;
                        str = "Error parsing the intent data.";
                    }
                }
                ((com.google.android.gms.ads.internal.js.zza) zzaogVar).zza("openableIntents", jSONObject);
            } catch (JSONException e4) {
                ((com.google.android.gms.ads.internal.js.zza) zzaogVar).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException e5) {
            ((com.google.android.gms.ads.internal.js.zza) zzaogVar).zza("openableIntents", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzc(zzaog zzaogVar, Map map) {
        String str = (String) map.get(Constants.VIDEO_TRACKING_URLS_KEY);
        if (TextUtils.isEmpty(str)) {
            zzagf.zzcu("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzaogVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((com.google.android.gms.ads.internal.js.zza) zzaogVar).zza("openableURLs", hashMap);
    }
}
