package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznj {
    private Context mContext;
    private String zzavn;
    private boolean zzbrz = ((Boolean) zzkb.zzif().zzd(zznh.zzbjl)).booleanValue();
    private String zzbsa = (String) zzkb.zzif().zzd(zznh.zzbjm);
    private Map<String, String> zzbsb = new LinkedHashMap();

    /* loaded from: assets/classes2.dex */
    public static class zza {
        public final int zzUA;
        public final long zzUB;
        public final long zzUC;
    }

    public zznj(Context context, String str) {
        this.mContext = null;
        this.zzavn = null;
        this.mContext = context;
        this.zzavn = str;
        this.zzbsb.put("s", "gmob_sdk");
        this.zzbsb.put("v", "3");
        this.zzbsb.put("os", Build.VERSION.RELEASE);
        this.zzbsb.put("sdk", Build.VERSION.SDK);
        Map<String, String> map = this.zzbsb;
        com.google.android.gms.ads.internal.zzbs.zzei();
        map.put("device", zzahn.zzqc());
        this.zzbsb.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.zzbsb;
        com.google.android.gms.ads.internal.zzbs.zzei();
        map2.put("is_lite_sdk", zzahn.zzau(context) ? "1" : "0");
        Future<zzaco> zzo = com.google.android.gms.ads.internal.zzbs.zzes().zzo(this.mContext);
        try {
            zzo.get();
            this.zzbsb.put("network_coarse", Integer.toString(zzo.get().zzcty));
            this.zzbsb.put("network_fine", Integer.toString(zzo.get().zzctz));
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzbs.zzem().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzfs() {
        return this.zzavn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zziy() {
        return this.zzbrz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zziz() {
        return this.zzbsa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zzja() {
        return this.zzbsb;
    }
}
