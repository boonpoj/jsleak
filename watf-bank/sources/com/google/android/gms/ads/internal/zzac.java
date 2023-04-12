package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.zzafs;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzakg;
import com.google.android.gms.internal.zzakj;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzakv;
import com.google.android.gms.internal.zzala;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zztp;
import com.google.android.gms.internal.zztu;
import com.google.android.gms.internal.zzzv;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzac {
    private Context mContext;
    private final Object mLock = new Object();
    private long zzaoy = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzakv zza(JSONObject jSONObject) throws Exception {
        if (jSONObject.optBoolean("isSuccessful", false)) {
            return zzbs.zzem().zzk(this.mContext, jSONObject.getString("appSettingsJson"));
        }
        return zzakl.zzi(null);
    }

    public final void zza(Context context, zzakd zzakdVar, String str, Runnable runnable) {
        zza(context, zzakdVar, true, null, str, null, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Context context, zzakd zzakdVar, boolean z, zzafs zzafsVar, String str, String str2, Runnable runnable) {
        if (zzbs.zzeo().elapsedRealtime() - this.zzaoy < 5000) {
            zzagf.zzcu("Not retrying to fetch app settings");
            return;
        }
        this.zzaoy = zzbs.zzeo().elapsedRealtime();
        boolean z2 = true;
        if (zzafsVar != null) {
            if (!(zzbs.zzeo().currentTimeMillis() - zzafsVar.zzou() > ((Long) zzkb.zzif().zzd(zznh.zzbpn)).longValue()) && zzafsVar.zzov()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzagf.zzcu("Context not provided to fetch application settings");
            } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzagf.zzcu("App settings could not be fetched. Required parameters missing");
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                this.mContext = applicationContext;
                zztp zza = zzbs.zzev().zzb(this.mContext, zzakdVar).zza("google.afma.config.fetchAppSettings", zztu.zzccb, zztu.zzccb);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_id", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context.getPackageName());
                    zzakv zzg = zza.zzg(jSONObject);
                    zzakv zza2 = zzakl.zza(zzg, new zzakg(this) { // from class: com.google.android.gms.ads.internal.zzad
                        private final zzac zzaoz;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzaoz = this;
                        }

                        @Override // com.google.android.gms.internal.zzakg
                        public final zzakv zzc(Object obj) {
                            return this.zzaoz.zza((JSONObject) obj);
                        }
                    }, zzala.zzdff);
                    if (runnable != null) {
                        zzg.zza(runnable, zzala.zzdff);
                    }
                    zzakj.zza(zza2, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Exception e) {
                    zzagf.zzb("Error requesting application settings", e);
                }
            }
        }
    }
}
