package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzamo {
    public final String zzdix;
    private boolean zzdiy;
    private int zzdiz;
    private int zzdja;
    private int zzdjb;
    private int zzdjc;
    private boolean zzdjd;

    public zzamo(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
        this.zzdiy = zza(jSONObject, "aggressive_media_codec_release", zznh.zzbis);
        this.zzdix = zzc(jSONObject, "exo_player_version", zznh.zzbhz);
        this.zzdiz = zzb(jSONObject, "exo_cache_buffer_size", zznh.zzbig);
        this.zzdja = zzb(jSONObject, "exo_connect_timeout_millis", zznh.zzbia);
        this.zzdjb = zzb(jSONObject, "exo_read_timeout_millis", zznh.zzbib);
        this.zzdjc = zzb(jSONObject, "load_check_interval_bytes", zznh.zzbic);
        this.zzdjd = zza(jSONObject, "use_cache_data_source", zznh.zzbqk);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzmx<Boolean> zzmxVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException e) {
            }
        }
        return ((Boolean) zzkb.zzif().zzd(zzmxVar)).booleanValue();
    }

    private static int zzb(JSONObject jSONObject, String str, zzmx<Integer> zzmxVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return ((Integer) zzkb.zzif().zzd(zzmxVar)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzmx<String> zzmxVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return (String) zzkb.zzif().zzd(zzmxVar);
    }
}
