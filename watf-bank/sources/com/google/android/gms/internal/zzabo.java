package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzabo extends zzagb {
    private final Context mContext;
    private final Object zzcjn;
    private final zzzx zzcmm;
    private final zzaau zzcmn;
    private zzix zzcmp;
    private com.google.android.gms.ads.internal.js.zzaa zzcqm;
    private static long zzcqh = TimeUnit.SECONDS.toMillis(10);
    private static final Object sLock = new Object();
    private static boolean zzcqi = false;
    private static com.google.android.gms.ads.internal.js.zzn zzclt = null;
    private static HttpClient zzcqj = null;
    private static com.google.android.gms.ads.internal.gmsg.zzy zzcqk = null;
    private static com.google.android.gms.ads.internal.gmsg.zzt<Object> zzcql = null;

    public zzabo(Context context, zzaau zzaauVar, zzzx zzzxVar, zzix zzixVar) {
        super(true);
        this.zzcjn = new Object();
        this.zzcmm = zzzxVar;
        this.mContext = context;
        this.zzcmn = zzaauVar;
        this.zzcmp = zzixVar;
        synchronized (sLock) {
            if (!zzcqi) {
                zzcqk = new com.google.android.gms.ads.internal.gmsg.zzy();
                zzcqj = new HttpClient(context.getApplicationContext(), zzaauVar.zzaty);
                zzcql = new zzabw();
                zzclt = new com.google.android.gms.ads.internal.js.zzn(this.mContext.getApplicationContext(), this.zzcmn.zzaty, (String) zzkb.zzif().zzd(zznh.zzbhm), new zzabv(), new zzabu());
                zzcqi = true;
            }
        }
    }

    private final JSONObject zza(zzaat zzaatVar, String str) {
        zzaco zzacoVar;
        AdvertisingIdClient.Info info;
        Bundle bundle = zzaatVar.zzcnd.extras.getBundle("sdk_less_server_data");
        if (bundle == null) {
            return null;
        }
        try {
            zzacoVar = com.google.android.gms.ads.internal.zzbs.zzes().zzo(this.mContext).get();
        } catch (Exception e) {
            zzagf.zzc("Error grabbing device info: ", e);
            zzacoVar = null;
        }
        Context context = this.mContext;
        zzabz zzabzVar = new zzabz();
        zzabzVar.zzcqv = zzaatVar;
        zzabzVar.zzcqw = zzacoVar;
        JSONObject zza = zzacg.zza(context, zzabzVar);
        if (zza == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzagf.zzc("Cannot get advertising id info", e2);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("request_param", zza);
        hashMap.put("data", bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return com.google.android.gms.ads.internal.zzbs.zzei().zzq(hashMap);
        } catch (JSONException e3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zza(com.google.android.gms.ads.internal.js.zzc zzcVar) {
        zzcVar.zza("/loadAd", zzcqk);
        zzcVar.zza("/fetchHttpRequest", zzcqj);
        zzcVar.zza("/invalidRequest", zzcql);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzb(com.google.android.gms.ads.internal.js.zzc zzcVar) {
        zzcVar.zzb("/loadAd", zzcqk);
        zzcVar.zzb("/fetchHttpRequest", zzcqj);
        zzcVar.zzb("/invalidRequest", zzcql);
    }

    private final zzaax zzc(zzaat zzaatVar) {
        com.google.android.gms.ads.internal.zzbs.zzei();
        String zzqb = zzahn.zzqb();
        JSONObject zza = zza(zzaatVar, zzqb);
        if (zza == null) {
            return new zzaax(0);
        }
        long elapsedRealtime = com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime();
        Future<JSONObject> zzas = zzcqk.zzas(zzqb);
        zzajr.zzajw.post(new zzabq(this, zza, zzqb));
        try {
            JSONObject jSONObject = zzas.get(zzcqh - (com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzaax(-1);
            }
            zzaax zza2 = zzacg.zza(this.mContext, zzaatVar, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.body)) ? zza2 : new zzaax(3);
        } catch (InterruptedException e) {
            return new zzaax(-1);
        } catch (CancellationException e2) {
            return new zzaax(-1);
        } catch (ExecutionException e3) {
            return new zzaax(0);
        } catch (TimeoutException e4) {
            return new zzaax(2);
        }
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void onStop() {
        synchronized (this.zzcjn) {
            zzajr.zzajw.post(new zzabt(this));
        }
    }

    @Override // com.google.android.gms.internal.zzagb
    public final void zzdm() {
        zzagf.zzbx("SdkLessAdLoaderBackgroundTask started.");
        String zzy = com.google.android.gms.ads.internal.zzbs.zzfd().zzy(this.mContext);
        zzaat zzaatVar = new zzaat(this.zzcmn, -1L, com.google.android.gms.ads.internal.zzbs.zzfd().zzw(this.mContext), com.google.android.gms.ads.internal.zzbs.zzfd().zzx(this.mContext), zzy);
        com.google.android.gms.ads.internal.zzbs.zzfd().zzg(this.mContext, zzy);
        zzaax zzc = zzc(zzaatVar);
        zzajr.zzajw.post(new zzabp(this, new zzafp(zzaatVar, zzc, null, null, zzc.errorCode, com.google.android.gms.ads.internal.zzbs.zzeo().elapsedRealtime(), zzc.zzcpa, null, this.zzcmp)));
    }
}
