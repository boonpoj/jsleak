package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzact extends zzacv {
    private final Context mApplicationContext;
    private final Object mLock = new Object();
    private SharedPreferences zzcuo;
    private final zztp<JSONObject, JSONObject> zzcup;

    public zzact(Context context, zztp<JSONObject, JSONObject> zztpVar) {
        this.mApplicationContext = context.getApplicationContext();
        this.zzcup = zztpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzn(JSONObject jSONObject) {
        zznh.zza(this.mApplicationContext, 1, jSONObject);
        this.zzcuo.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis()).apply();
        return null;
    }

    @Override // com.google.android.gms.internal.zzacv
    public final zzakv<Void> zznz() {
        synchronized (this.mLock) {
            if (this.zzcuo == null) {
                this.zzcuo = this.mApplicationContext.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzbs.zzeo().currentTimeMillis() - this.zzcuo.getLong("js_last_update", 0L) < ((Long) zzkb.zzif().zzd(zznh.zzboh)).longValue()) {
            return zzakl.zzi(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzakd.zzrd().zzcv);
            jSONObject.put("mf", zzkb.zzif().zzd(zznh.zzboi));
            jSONObject.put("cl", "179146524");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            return zzakl.zza(this.zzcup.zzg(jSONObject), new zzakh(this) { // from class: com.google.android.gms.internal.zzacu
                private final zzact zzcuq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcuq = this;
                }

                @Override // com.google.android.gms.internal.zzakh
                public final Object apply(Object obj) {
                    return this.zzcuq.zzn((JSONObject) obj);
                }
            }, zzala.zzdff);
        } catch (JSONException e) {
            zzagf.zzb("Unable to populate SDK Core Constants parameters.", e);
            return zzakl.zzi(null);
        }
    }
}
