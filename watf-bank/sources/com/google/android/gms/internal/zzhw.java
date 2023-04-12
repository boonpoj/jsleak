package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.mopub.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzhw {

    /* renamed from: com.google.android.gms.internal.zzhw$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass1 implements zzhx {
        AnonymousClass1() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$10  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass10 implements zzhx {
        AnonymousClass10() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str;
            PackageManager packageManager = zzqpVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject(map.get("data")).getJSONArray("intents");
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
                            Intent intent = new Intent();
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
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (JSONException e) {
                                e = e;
                                str = "Error constructing openable urls response.";
                                zzpe.zzb(str, e);
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            str = "Error parsing the intent data.";
                        }
                    }
                    zzqpVar.zzb("openableIntents", jSONObject);
                } catch (JSONException unused) {
                    zzqpVar.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException unused2) {
                zzqpVar.zzb("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$11  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass11 implements zzhx {
        AnonymousClass11() {
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.zzpd, com.google.android.gms.internal.zzps] */
        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                zzpe.zzbe("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                zzav zzkX = zzqpVar.zzkX();
                if (zzkX != null && zzkX.zzc(parse)) {
                    parse = zzkX.zza(parse, zzqpVar.getContext(), zzqpVar.getView());
                }
            } catch (zzaw unused) {
                String valueOf = String.valueOf(str);
                zzpe.zzbe(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
            }
            new zzps(zzqpVar.getContext(), zzqpVar.zzkY().zzaZ, parse.toString()).zziw();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$12  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass12 implements zzhx {
        AnonymousClass12() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            com.google.android.gms.ads.internal.overlay.zze zzkT = zzqpVar.zzkT();
            if (zzkT != null) {
                zzkT.close();
                return;
            }
            com.google.android.gms.ads.internal.overlay.zze zzkU = zzqpVar.zzkU();
            if (zzkU != null) {
                zzkU.close();
            } else {
                zzpe.zzbe("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$13  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass13 implements zzhx {
        AnonymousClass13() {
        }

        private void zzd(zzqp zzqpVar) {
            zzpe.zzbd("Received support message, responding.");
            com.google.android.gms.ads.internal.zzd zzbz = zzqpVar.zzbz();
            if (zzbz != null && zzbz.zzsO != null) {
                zzqpVar.getContext();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, "checkSupport");
                jSONObject.put("supports", false);
                zzqpVar.zzb("appStreaming", jSONObject);
            } catch (Throwable unused) {
            }
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                zzd(zzqpVar);
                return;
            }
            com.google.android.gms.ads.internal.overlay.zze zzkT = zzqpVar.zzkT();
            if (zzkT != null) {
                zzkT.zzg(zzqpVar, map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$14  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass14 implements zzhx {
        AnonymousClass14() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            zzqpVar.zzK("1".equals(map.get("custom_close")));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$15  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass15 implements zzhx {
        AnonymousClass15() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.zzpd, com.google.android.gms.internal.zzps] */
        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                zzpe.zzbe("URL missing from httpTrack GMSG.");
            } else {
                new zzps(zzqpVar.getContext(), zzqpVar.zzkY().zzaZ, str).zziw();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$16  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass16 implements zzhx {
        AnonymousClass16() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String valueOf = String.valueOf(map.get("string"));
            zzpe.zzbd(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass2 implements zzhx {
        AnonymousClass2() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            zzgs zzll = zzqpVar.zzll();
            if (zzll != null) {
                zzll.zzfR();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass3 implements zzhx {
        AnonymousClass3() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                zzav zzkX = zzqpVar.zzkX();
                if (zzkX != null) {
                    zzkX.zzW().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException unused) {
                zzpe.zzbe("Could not parse touch parameters from gmsg.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass4 implements zzhx {
        AnonymousClass4() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (((Boolean) zzfx.zzCX.get()).booleanValue()) {
                zzqpVar.zzL(!Boolean.parseBoolean(map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass5 implements zzhx {
        AnonymousClass5() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str = map.get("action");
            if ("pause".equals(str)) {
                zzqpVar.zzbV();
            } else if ("resume".equals(str)) {
                zzqpVar.zzbW();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass6 implements zzhx {
        AnonymousClass6() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzqpVar.zzkV().zzlu();
            } else if (map.keySet().contains("stop")) {
                zzqpVar.zzkV().zzlv();
            } else if (map.keySet().contains("cancel")) {
                zzqpVar.zzkV().zzlw();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass7 implements zzhx {
        AnonymousClass7() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzqpVar.zzM(true);
            }
            if (map.keySet().contains("stop")) {
                zzqpVar.zzM(false);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$8  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass8 implements zzhx {
        AnonymousClass8() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            zzqpVar.zza("locationReady", com.google.android.gms.ads.internal.zzv.zzcJ().zza((View) zzqpVar, (WindowManager) zzqpVar.getContext().getSystemService("window")));
            zzpe.zzbe("GET LOCATION COMPILED");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw$9  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    final class AnonymousClass9 implements zzhx {
        AnonymousClass9() {
        }

        public void zza(zzqp zzqpVar, Map<String, String> map) {
            String str = map.get(Constants.VIDEO_TRACKING_URLS_KEY);
            if (TextUtils.isEmpty(str)) {
                zzpe.zzbe("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = zzqpVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                boolean z = true;
                if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                    z = false;
                }
                hashMap.put(str2, Boolean.valueOf(z));
            }
            zzqpVar.zza("openableURLs", hashMap);
        }
    }

    boolean zza(Activity activity);
}
