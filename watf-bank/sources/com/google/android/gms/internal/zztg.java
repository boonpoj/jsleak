package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@zzzv
/* loaded from: classes.dex */
public final class zztg {
    private final Map<zzth, zzti> zzbzq = new HashMap();
    private final LinkedList<zzth> zzbzr = new LinkedList<>();
    private zzsd zzbzs;

    private static void zza(String str, zzth zzthVar) {
        if (zzagf.zzae(2)) {
            zzagf.v(String.format(str, zzthVar));
        }
    }

    private static String[] zzax(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private static boolean zzay(String str) {
        try {
            return Pattern.matches((String) zzkb.zzif().zzd(zznh.zzbmb), str);
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    private static String zzaz(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
        } catch (RuntimeException e) {
        }
        return str;
    }

    private static void zzc(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length == 0) {
                return;
            }
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            bundle = bundle.getBundle(str2);
            if (bundle == null) {
                return;
            }
            str = split[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<String> zzi(zzjj zzjjVar) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(zzjjVar.extras.keySet());
        Bundle bundle = zzjjVar.zzbdp.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjj zzj(zzjj zzjjVar) {
        zzjj zzl = zzl(zzjjVar);
        Bundle bundle = zzl.zzbdp.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean("_skipMediation", true);
        }
        zzl.extras.putBoolean("_skipMediation", true);
        return zzl;
    }

    private static zzjj zzk(zzjj zzjjVar) {
        String[] split;
        zzjj zzl = zzl(zzjjVar);
        for (String str : ((String) zzkb.zzif().zzd(zznh.zzblx)).split(",")) {
            zzc(zzl.zzbdp, str);
            if (str.startsWith("com.google.ads.mediation.admob.AdMobAdapter/")) {
                zzc(zzl.extras, str.replaceFirst("com.google.ads.mediation.admob.AdMobAdapter/", ""));
            }
        }
        return zzl;
    }

    private final String zzkw() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<zzth> it = this.zzbzr.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(it.next().toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static zzjj zzl(zzjj zzjjVar) {
        Parcel obtain = Parcel.obtain();
        zzjjVar.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzjj createFromParcel = zzjj.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (((Boolean) zzkb.zzif().zzd(zznh.zzblm)).booleanValue()) {
            zzjj.zzh(createFromParcel);
        }
        return createFromParcel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zztj zza(zzjj zzjjVar, String str) {
        if (zzay(str)) {
            return null;
        }
        int i = new zzacp(this.zzbzs.getApplicationContext()).zzny().zzcty;
        zzjj zzk = zzk(zzjjVar);
        String zzaz = zzaz(str);
        zzth zzthVar = new zzth(zzk, zzaz, i);
        zzti zztiVar = this.zzbzq.get(zzthVar);
        if (zztiVar == null) {
            zza("Interstitial pool created at %s.", zzthVar);
            zztiVar = new zzti(zzk, zzaz, i);
            this.zzbzq.put(zzthVar, zztiVar);
        }
        this.zzbzr.remove(zzthVar);
        this.zzbzr.add(zzthVar);
        zztiVar.zzla();
        while (this.zzbzr.size() > ((Integer) zzkb.zzif().zzd(zznh.zzbly)).intValue()) {
            zzth remove = this.zzbzr.remove();
            zzti zztiVar2 = this.zzbzq.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (zztiVar2.size() > 0) {
                zztj zzm = zztiVar2.zzm(null);
                if (zzm.zzcab) {
                    zztk.zzlc().zzle();
                }
                zzm.zzbzx.zzdk();
            }
            this.zzbzq.remove(remove);
        }
        while (zztiVar.size() > 0) {
            zztj zzm2 = zztiVar.zzm(zzk);
            if (zzm2.zzcab) {
                if (com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis() - zzm2.zzcaa > ((Integer) zzkb.zzif().zzd(zznh.zzbma)).intValue() * 1000) {
                    zza("Expired interstitial at %s.", zzthVar);
                    zztk.zzlc().zzld();
                }
            }
            String str2 = zzm2.zzbzy != null ? " (inline) " : " ";
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 34);
            sb.append("Pooled interstitial");
            sb.append(str2);
            sb.append("returned at %s.");
            zza(sb.toString(), zzthVar);
            return zzm2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzsd zzsdVar) {
        if (this.zzbzs == null) {
            this.zzbzs = zzsdVar.zzku();
            zzsd zzsdVar2 = this.zzbzs;
            if (zzsdVar2 != null) {
                SharedPreferences sharedPreferences = zzsdVar2.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.zzbzr.size() > 0) {
                    zzth remove = this.zzbzr.remove();
                    zzti zztiVar = this.zzbzq.get(remove);
                    zza("Flushing interstitial queue for %s.", remove);
                    while (zztiVar.size() > 0) {
                        zztiVar.zzm(null).zzbzx.zzdk();
                    }
                    this.zzbzq.remove(remove);
                }
                try {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        if (!entry.getKey().equals("PoolKeys")) {
                            zztm zzba = zztm.zzba((String) entry.getValue());
                            zzth zzthVar = new zzth(zzba.zzarx, zzba.zzapq, zzba.zzbzv);
                            if (!this.zzbzq.containsKey(zzthVar)) {
                                this.zzbzq.put(zzthVar, new zzti(zzba.zzarx, zzba.zzapq, zzba.zzbzv));
                                hashMap.put(zzthVar.toString(), zzthVar);
                                zza("Restored interstitial queue for %s.", zzthVar);
                            }
                        }
                    }
                    for (String str : zzax(sharedPreferences.getString("PoolKeys", ""))) {
                        zzth zzthVar2 = (zzth) hashMap.get(str);
                        if (this.zzbzq.containsKey(zzthVar2)) {
                            this.zzbzr.add(zzthVar2);
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "InterstitialAdPool.restore");
                    zzagf.zzc("Malformed preferences value for InterstitialAdPool.", e);
                    this.zzbzq.clear();
                    this.zzbzr.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzjj zzjjVar, String str) {
        zzsd zzsdVar = this.zzbzs;
        if (zzsdVar == null) {
            return;
        }
        int i = new zzacp(zzsdVar.getApplicationContext()).zzny().zzcty;
        zzjj zzk = zzk(zzjjVar);
        String zzaz = zzaz(str);
        zzth zzthVar = new zzth(zzk, zzaz, i);
        zzti zztiVar = this.zzbzq.get(zzthVar);
        if (zztiVar == null) {
            zza("Interstitial pool created at %s.", zzthVar);
            zztiVar = new zzti(zzk, zzaz, i);
            this.zzbzq.put(zzthVar, zztiVar);
        }
        zztiVar.zza(this.zzbzs, zzjjVar);
        zztiVar.zzla();
        zza("Inline entry added to the queue at %s.", zzthVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzkv() {
        int size;
        int zzky;
        if (this.zzbzs == null) {
            return;
        }
        for (Map.Entry<zzth, zzti> entry : this.zzbzq.entrySet()) {
            zzth key = entry.getKey();
            zzti value = entry.getValue();
            if (zzagf.zzae(2) && (zzky = value.zzky()) < (size = value.size())) {
                zzagf.v(String.format("Loading %s/%s pooled interstitials for %s.", Integer.valueOf(size - zzky), Integer.valueOf(size), key));
            }
            int zzkz = value.zzkz() + 0;
            while (value.size() < ((Integer) zzkb.zzif().zzd(zznh.zzblz)).intValue()) {
                zza("Pooling and loading one new interstitial for %s.", key);
                if (value.zzb(this.zzbzs)) {
                    zzkz++;
                }
            }
            zztk.zzlc().zzu(zzkz);
        }
        zzsd zzsdVar = this.zzbzs;
        if (zzsdVar != null) {
            SharedPreferences.Editor edit = zzsdVar.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Map.Entry<zzth, zzti> entry2 : this.zzbzq.entrySet()) {
                zzth key2 = entry2.getKey();
                zzti value2 = entry2.getValue();
                if (value2.zzlb()) {
                    edit.putString(key2.toString(), new zztm(value2).zzll());
                    zza("Saved interstitial queue for %s.", key2);
                }
            }
            edit.putString("PoolKeys", zzkw());
            edit.apply();
        }
    }
}
