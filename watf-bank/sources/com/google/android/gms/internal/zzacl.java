package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzacl {
    private zzaaz zzaor;
    private String zzbtu;
    private final zzaat zzcey;
    private List<String> zzckj;
    private String zzcsa;
    private String zzcsb;
    private List<String> zzcsc;
    private String zzcsd;
    private String zzcse;
    private String zzcsf;
    private List<String> zzcsg;
    private zzaeq zzcss;
    private List<String> zzcst;
    private List<String> zzcsu;
    private String zzcsx;
    private List<String> zzcsy;
    private boolean zzcsz;
    private String zzcta;
    private zzaey zzctb;
    private boolean zzctc;
    private boolean zzctd;
    private long zzcsh = -1;
    private boolean zzcsi = false;
    private final long zzcsj = -1;
    private long zzcsk = -1;
    private int mOrientation = -1;
    private boolean zzcsl = false;
    private boolean zzcsm = false;
    private boolean zzcsn = false;
    private boolean zzcso = true;
    private boolean zzcsp = true;
    private String zzcsq = "";
    private boolean zzcsr = false;
    private boolean zzcej = false;
    private boolean zzcsv = false;
    private boolean zzcsw = false;

    public zzacl(zzaat zzaatVar, String str) {
        this.zzcsb = str;
        this.zzcey = zzaatVar;
    }

    private static String zza(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static long zzb(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        String str2 = list.get(0);
        try {
            return Float.parseFloat(str2) * 1000.0f;
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length());
            sb.append("Could not parse float from ");
            sb.append(str);
            sb.append(" header: ");
            sb.append(str2);
            zzagf.zzcu(sb.toString());
            return -1L;
        }
    }

    private static List<String> zzc(Map<String, List<String>> map, String str) {
        String str2;
        List<String> list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private static boolean zzd(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return false;
        }
        return Boolean.valueOf(list.get(0)).booleanValue();
    }

    public final zzaax zza(long j, boolean z) {
        return new zzaax(this.zzcey, this.zzcsb, this.zzbtu, this.zzcsc, this.zzcsg, this.zzcsh, this.zzcsi, -1L, this.zzckj, this.zzcsk, this.mOrientation, this.zzcsa, j, this.zzcse, this.zzcsf, this.zzcsl, this.zzcsm, this.zzcsn, this.zzcso, false, this.zzcsq, this.zzcsr, this.zzcej, this.zzcss, this.zzcst, this.zzcsu, this.zzcsv, this.zzaor, this.zzcsw, this.zzcsx, this.zzcsy, this.zzcsz, this.zzcta, this.zzctb, this.zzcsd, this.zzcsp, this.zzctc, this.zzctd, z ? 2 : 1);
    }

    public final void zza(String str, Map<String, List<String>> map, String str2) {
        this.zzbtu = str2;
        zzo(map);
    }

    public final void zzo(Map<String, List<String>> map) {
        int zzqf;
        this.zzcsa = zza(map, "X-Afma-Ad-Size");
        this.zzcta = zza(map, "X-Afma-Ad-Slot-Size");
        List<String> zzc = zzc(map, "X-Afma-Click-Tracking-Urls");
        if (zzc != null) {
            this.zzcsc = zzc;
        }
        this.zzcsd = zza(map, "X-Afma-Debug-Signals");
        List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzcse = list.get(0);
        }
        List<String> zzc2 = zzc(map, "X-Afma-Tracking-Urls");
        if (zzc2 != null) {
            this.zzcsg = zzc2;
        }
        long zzb = zzb(map, "X-Afma-Interstitial-Timeout");
        if (zzb != -1) {
            this.zzcsh = zzb;
        }
        this.zzcsi |= zzd(map, "X-Afma-Mediation");
        List<String> zzc3 = zzc(map, "X-Afma-Manual-Tracking-Urls");
        if (zzc3 != null) {
            this.zzckj = zzc3;
        }
        long zzb2 = zzb(map, "X-Afma-Refresh-Rate");
        if (zzb2 != -1) {
            this.zzcsk = zzb2;
        }
        List<String> list2 = map.get("X-Afma-Orientation");
        if (list2 != null && !list2.isEmpty()) {
            String str = list2.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                zzqf = com.google.android.gms.ads.internal.zzbs.zzek().zzqg();
            } else if ("landscape".equalsIgnoreCase(str)) {
                zzqf = com.google.android.gms.ads.internal.zzbs.zzek().zzqf();
            }
            this.mOrientation = zzqf;
        }
        this.zzcsf = zza(map, "X-Afma-ActiveView");
        List<String> list3 = map.get("X-Afma-Use-HTTPS");
        if (list3 != null && !list3.isEmpty()) {
            this.zzcsn = Boolean.valueOf(list3.get(0)).booleanValue();
        }
        this.zzcsl |= zzd(map, "X-Afma-Custom-Rendering-Allowed");
        this.zzcsm = "native".equals(zza(map, "X-Afma-Ad-Format"));
        List<String> list4 = map.get("X-Afma-Content-Url-Opted-Out");
        if (list4 != null && !list4.isEmpty()) {
            this.zzcso = Boolean.valueOf(list4.get(0)).booleanValue();
        }
        List<String> list5 = map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list5 != null && !list5.isEmpty()) {
            this.zzcsp = Boolean.valueOf(list5.get(0)).booleanValue();
        }
        List<String> list6 = map.get("X-Afma-Gws-Query-Id");
        if (list6 != null && !list6.isEmpty()) {
            this.zzcsq = list6.get(0);
        }
        String zza = zza(map, "X-Afma-Fluid");
        if (zza != null && zza.equals("height")) {
            this.zzcsr = true;
        }
        this.zzcej = "native_express".equals(zza(map, "X-Afma-Ad-Format"));
        this.zzcss = zzaeq.zzbu(zza(map, "X-Afma-Rewards"));
        if (this.zzcst == null) {
            this.zzcst = zzc(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.zzcsu == null) {
            this.zzcsu = zzc(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.zzcsv |= zzd(map, "X-Afma-Use-Displayed-Impression");
        this.zzcsw |= zzd(map, "X-Afma-Auto-Collect-Location");
        this.zzcsx = zza(map, "Set-Cookie");
        String zza2 = zza(map, "X-Afma-Auto-Protection-Configuration");
        if (zza2 == null || TextUtils.isEmpty(zza2)) {
            Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.zzcse)) {
                buildUpon.appendQueryParameter("debugDialog", this.zzcse);
            }
            boolean booleanValue = ((Boolean) zzkb.zzif().zzd(zznh.zzbhv)).booleanValue();
            String builder = buildUpon.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(builder).length() + 18 + String.valueOf("navigationURL").length());
            sb.append(builder);
            sb.append("&");
            sb.append("navigationURL");
            sb.append("={NAVIGATION_URL}");
            this.zzaor = new zzaaz(booleanValue, Arrays.asList(sb.toString()));
        } else {
            try {
                this.zzaor = zzaaz.zzl(new JSONObject(zza2));
            } catch (JSONException e) {
                zzagf.zzc("Error parsing configuration JSON", e);
                this.zzaor = new zzaaz();
            }
        }
        List<String> zzc4 = zzc(map, "X-Afma-Remote-Ping-Urls");
        if (zzc4 != null) {
            this.zzcsy = zzc4;
        }
        String zza3 = zza(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(zza3)) {
            try {
                this.zzctb = zzaey.zzo(new JSONObject(zza3));
            } catch (JSONException e2) {
                zzagf.zzc("Error parsing safe browsing header", e2);
            }
        }
        this.zzcsz |= zzd(map, "X-Afma-Render-In-Browser");
        String zza4 = zza(map, "X-Afma-Pool");
        if (!TextUtils.isEmpty(zza4)) {
            try {
                this.zzctc = new JSONObject(zza4).getBoolean("never_pool");
            } catch (JSONException e3) {
                zzagf.zzc("Error parsing interstitial pool header", e3);
            }
        }
        this.zzctd = zzd(map, "X-Afma-Custom-Close-Blocked");
    }
}
