package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzacb extends zzabc {
    private static final Object sLock = new Object();
    private static zzacb zzcrk;
    private final Context mContext;
    private final zzaca zzcrl;
    private final ScheduledExecutorService zzcrm = Executors.newSingleThreadScheduledExecutor();

    private zzacb(Context context, zzaca zzacaVar) {
        this.mContext = context;
        this.zzcrl = zzacaVar;
    }

    private static zzaax zza(Context context, zzaca zzacaVar, zzaat zzaatVar, ScheduledExecutorService scheduledExecutorService) {
        char c;
        String string;
        zzagf.zzbx("Starting ad request from service using: google.afma.request.getAdDictionary");
        zznu zznuVar = new zznu(((Boolean) zzkb.zzif().zzd(zznh.zzbjl)).booleanValue(), "load_ad", zzaatVar.zzauc.zzbek);
        if (zzaatVar.versionCode > 10 && zzaatVar.zzcnt != -1) {
            zznuVar.zza(zznuVar.zzd(zzaatVar.zzcnt), "cts");
        }
        zzns zzjf = zznuVar.zzjf();
        zzakv zza = zzakl.zza(zzacaVar.zzcrh.zzi(context), ((Long) zzkb.zzif().zzd(zznh.zzbpy)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        zzakv zza2 = zzakl.zza(zzacaVar.zzcrg.zzp(context), ((Long) zzkb.zzif().zzd(zznh.zzbnd)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        zzakv<String> zzby = zzacaVar.zzcrb.zzby(zzaatVar.zzcne.packageName);
        zzakv<String> zza3 = zzacaVar.zzcri.zza(zzaatVar.zzcnf, zzaatVar.zzcne);
        Future<zzaco> zzo = com.google.android.gms.ads.internal.zzbs.zzes().zzo(context);
        zzakv<Location> zzi = zzakl.zzi(null);
        Bundle bundle = zzaatVar.zzcnd.extras;
        boolean z = (bundle == null || bundle.getString("_ad") == null) ? false : true;
        if (zzaatVar.zzcnz && !z) {
            zzi = zzacaVar.zzcre.zza(zzaatVar.applicationInfo);
        }
        zzakv zza4 = zzakl.zza(zzi, ((Long) zzkb.zzif().zzd(zznh.zzbph)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        Future zzi2 = zzakl.zzi(null);
        if (((Boolean) zzkb.zzif().zzd(zznh.zzblh)).booleanValue()) {
            zzi2 = zzakl.zza(zzacaVar.zzcri.zzab(context), ((Long) zzkb.zzif().zzd(zznh.zzbli)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        }
        Bundle bundle2 = (zzaatVar.versionCode < 4 || zzaatVar.zzcnk == null) ? null : zzaatVar.zzcnk;
        ((Boolean) zzkb.zzif().zzd(zznh.zzbkb)).booleanValue();
        com.google.android.gms.ads.internal.zzbs.zzei();
        if (zzahn.zzd(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            zzagf.zzbx("Device is offline.");
        }
        String uuid = zzaatVar.versionCode >= 7 ? zzaatVar.zzcnq : UUID.randomUUID().toString();
        new zzach(context, uuid, zzaatVar.applicationInfo.packageName);
        if (zzaatVar.zzcnd.extras == null || (string = zzaatVar.zzcnd.extras.getString("_ad")) == null) {
            List<String> zzf = zzacaVar.zzcrc.zzf(zzaatVar.zzcnr);
            String str = uuid;
            Bundle bundle3 = (Bundle) zzakl.zza(zza, (Object) null, ((Long) zzkb.zzif().zzd(zznh.zzbpy)).longValue(), TimeUnit.MILLISECONDS);
            zzacy zzacyVar = (zzacy) zzakl.zza(zza2, (Object) null);
            Location location = (Location) zzakl.zza(zza4, (Object) null);
            AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzakl.zza(zzi2, (Object) null);
            String str2 = (String) zzakl.zza(zza3, (Object) null);
            String str3 = (String) zzakl.zza(zzby, (Object) null);
            zzaco zzacoVar = (zzaco) zzakl.zza(zzo, (Object) null);
            if (zzacoVar == null) {
                zzagf.zzcu("Error fetching device info. This is not recoverable.");
                return new zzaax(0);
            }
            zzabz zzabzVar = new zzabz();
            zzabzVar.zzcqv = zzaatVar;
            zzabzVar.zzcqw = zzacoVar;
            zzabzVar.zzcqs = zzacyVar;
            zzabzVar.zzbdn = location;
            zzabzVar.zzcqr = bundle3;
            zzabzVar.zzcnf = str2;
            zzabzVar.zzcqu = info;
            if (zzf == null) {
                zzabzVar.zzcnr.clear();
            }
            zzabzVar.zzcnr = zzf;
            zzabzVar.zzcnk = bundle2;
            zzabzVar.zzcqt = str3;
            zzabzVar.zzcqx = zzacaVar.zzcra.zze(context);
            zzabzVar.zzcqy = zzacaVar.zzcqy;
            JSONObject zza5 = zzacg.zza(context, zzabzVar);
            if (zza5 == null) {
                return new zzaax(0);
            }
            if (zzaatVar.versionCode < 7) {
                try {
                    zza5.put("request_id", str);
                } catch (JSONException e) {
                }
            }
            zza5.toString();
            zznuVar.zza(zzjf, "arc");
            zznuVar.zzjf();
            zzakv zza6 = zzakl.zza(zzakl.zza(zzacaVar.zzcrj.zznq().zzg(zza5), zzacc.zzcrn, scheduledExecutorService), 10L, TimeUnit.SECONDS, scheduledExecutorService);
            zzakv<Void> zznz = zzacaVar.zzcrd.zznz();
            if (zznz != null) {
                zzakj.zza(zznz, "AdRequestServiceImpl.loadAd.flags");
            }
            zzacn zzacnVar = (zzacn) zzakl.zza(zza6, (Object) null);
            if (zzacnVar == null) {
                return new zzaax(0);
            }
            if (zzacnVar.getErrorCode() != -2) {
                return new zzaax(zzacnVar.getErrorCode());
            }
            zznuVar.zzji();
            zzaax zza7 = !TextUtils.isEmpty(zzacnVar.zznw()) ? zzacg.zza(context, zzaatVar, zzacnVar.zznw()) : null;
            if (zza7 == null && !TextUtils.isEmpty(zzacnVar.getUrl())) {
                zza7 = zza(zzaatVar, context, zzaatVar.zzaty.zzcv, zzacnVar.getUrl(), str3, zzacnVar, zznuVar, zzacaVar);
            }
            if (zza7 == null) {
                c = 0;
                zza7 = new zzaax(0);
            } else {
                c = 0;
            }
            String[] strArr = new String[1];
            strArr[c] = "tts";
            zznuVar.zza(zzjf, strArr);
            zza7.zzcpj = zznuVar.zzjg();
            return zza7;
        }
        return zzacg.zza(context, zzaatVar, string);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0171, code lost:
        r1 = new java.lang.StringBuilder(46);
        r1.append("Received error HTTP response code: ");
        r1.append(r8);
        com.google.android.gms.internal.zzagf.zzcu(r1.toString());
        r0 = new com.google.android.gms.internal.zzaax(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018b, code lost:
        r10.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.zzaax zza(com.google.android.gms.internal.zzaat r17, android.content.Context r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.google.android.gms.internal.zzacn r22, com.google.android.gms.internal.zznu r23, com.google.android.gms.internal.zzaca r24) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacb.zza(com.google.android.gms.internal.zzaat, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzacn, com.google.android.gms.internal.zznu, com.google.android.gms.internal.zzaca):com.google.android.gms.internal.zzaax");
    }

    public static zzacb zza(Context context, zzaca zzacaVar) {
        zzacb zzacbVar;
        synchronized (sLock) {
            if (zzcrk == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zznh.initialize(context);
                zzcrk = new zzacb(context, zzacaVar);
                if (context.getApplicationContext() != null) {
                    com.google.android.gms.ads.internal.zzbs.zzei().zzai(context);
                }
                zzagd.zzae(context);
            }
            zzacbVar = zzcrk;
        }
        return zzacbVar;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzagf.zzae(2)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39);
            sb.append("Http Response: {\n  URL:\n    ");
            sb.append(str);
            sb.append("\n  Headers:");
            zzagf.v(sb.toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 5);
                    sb2.append("    ");
                    sb2.append(str3);
                    sb2.append(":");
                    zzagf.v(sb2.toString());
                    for (String str4 : map.get(str3)) {
                        String valueOf = String.valueOf(str4);
                        zzagf.v(valueOf.length() != 0 ? "      ".concat(valueOf) : new String("      "));
                    }
                }
            }
            zzagf.v("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    zzagf.v(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                zzagf.v("    null");
            }
            StringBuilder sb3 = new StringBuilder(34);
            sb3.append("  Response Code:\n    ");
            sb3.append(i);
            sb3.append("\n}");
            zzagf.v(sb3.toString());
        }
    }

    @Override // com.google.android.gms.internal.zzabb
    public final void zza(zzaat zzaatVar, zzabe zzabeVar) {
        com.google.android.gms.ads.internal.zzbs.zzem().zzc(this.mContext, zzaatVar.zzaty);
        zzakv<Void> zza = zzahh.zza(new zzacd(this, zzaatVar, zzabeVar));
        com.google.android.gms.ads.internal.zzbs.zzew().zzqs();
        com.google.android.gms.ads.internal.zzbs.zzew().getHandler().postDelayed(new zzace(this, zza), 60000L);
    }

    @Override // com.google.android.gms.internal.zzabb
    public final void zza(zzabm zzabmVar, zzabh zzabhVar) {
        zzagf.v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.zzabb
    public final zzaax zzb(zzaat zzaatVar) {
        return zza(this.mContext, this.zzcrl, zzaatVar, this.zzcrm);
    }
}
