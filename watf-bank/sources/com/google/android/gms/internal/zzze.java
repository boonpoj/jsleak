package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzze implements zzys<zzon> {
    private final boolean zzcln;

    public zzze(boolean z) {
        this.zzcln = z;
    }

    private static <K, V> SimpleArrayMap<K, V> zza(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws InterruptedException, ExecutionException {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap<>();
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            simpleArrayMap2.put(simpleArrayMap.keyAt(i), simpleArrayMap.valueAt(i).get());
        }
        return simpleArrayMap2;
    }

    @Override // com.google.android.gms.internal.zzys
    public final /* synthetic */ zzon zza(zzym zzymVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        View view;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        zzakv<zzog> zzh = zzymVar.zzh(jSONObject);
        zzakv<zzanh> zzc = zzymVar.zzc(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString(VastExtensionXmlManager.TYPE);
            if ("string".equals(string)) {
                simpleArrayMap2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if ("image".equals(string)) {
                simpleArrayMap.put(jSONObject2.getString("name"), zzymVar.zza(jSONObject2, "image_value", this.zzcln));
            } else {
                String valueOf = String.valueOf(string);
                zzagf.zzcu(valueOf.length() != 0 ? "Unknown custom asset type: ".concat(valueOf) : new String("Unknown custom asset type: "));
            }
        }
        zzanh zzb = zzym.zzb(zzc);
        String string2 = jSONObject.getString("custom_template_id");
        SimpleArrayMap zza = zza(simpleArrayMap);
        zzog zzogVar = zzh.get();
        zzaoa zzsg = zzb != null ? zzb.zzsg() : null;
        if (zzb == null) {
            view = null;
        } else if (zzb == null) {
            throw null;
        } else {
            view = (View) zzb;
        }
        return new zzon(string2, zza, simpleArrayMap2, zzogVar, zzsg, view);
    }
}
