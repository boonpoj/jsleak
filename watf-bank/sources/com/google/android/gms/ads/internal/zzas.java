package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanm;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzpq;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzas implements zzanm {
    private /* synthetic */ String zzaqx;
    private /* synthetic */ zzanh zzaqy;
    private /* synthetic */ zzol zzaqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzol zzolVar, String str, zzanh zzanhVar) {
        this.zzaqz = zzolVar;
        this.zzaqx = str;
        this.zzaqy = zzanhVar;
    }

    @Override // com.google.android.gms.internal.zzanm
    public final void zza(zzanh zzanhVar, boolean z) {
        JSONObject zza;
        zzpq zzd;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.zzaqz.getHeadline());
            jSONObject.put("body", this.zzaqz.getBody());
            jSONObject.put("call_to_action", this.zzaqz.getCallToAction());
            jSONObject.put("advertiser", this.zzaqz.getAdvertiser());
            jSONObject.put("logo", zzaq.zza(this.zzaqz.zzjz()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.zzaqz.getImages();
            if (images != null) {
                for (Object obj : images) {
                    zzd = zzaq.zzd(obj);
                    jSONArray.put(zzaq.zza(zzd));
                }
            }
            jSONObject.put("images", jSONArray);
            zza = zzaq.zza(this.zzaqz.getExtras(), this.zzaqx);
            jSONObject.put("extras", zza);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            this.zzaqy.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzagf.zzc("Exception occurred when loading assets", e);
        }
    }
}
