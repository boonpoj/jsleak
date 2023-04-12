package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanm;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzpq;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzar implements zzanm {
    private /* synthetic */ zzoj zzaqw;
    private /* synthetic */ String zzaqx;
    private /* synthetic */ zzanh zzaqy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzoj zzojVar, String str, zzanh zzanhVar) {
        this.zzaqw = zzojVar;
        this.zzaqx = str;
        this.zzaqy = zzanhVar;
    }

    @Override // com.google.android.gms.internal.zzanm
    public final void zza(zzanh zzanhVar, boolean z) {
        JSONObject zza;
        zzpq zzd;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.zzaqw.getHeadline());
            jSONObject.put("body", this.zzaqw.getBody());
            jSONObject.put("call_to_action", this.zzaqw.getCallToAction());
            jSONObject.put("price", this.zzaqw.getPrice());
            jSONObject.put("star_rating", String.valueOf(this.zzaqw.getStarRating()));
            jSONObject.put("store", this.zzaqw.getStore());
            jSONObject.put("icon", zzaq.zza(this.zzaqw.zzjs()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.zzaqw.getImages();
            if (images != null) {
                for (Object obj : images) {
                    zzd = zzaq.zzd(obj);
                    jSONArray.put(zzaq.zza(zzd));
                }
            }
            jSONObject.put("images", jSONArray);
            zza = zzaq.zza(this.zzaqw.getExtras(), this.zzaqx);
            jSONObject.put("extras", zza);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", InternalAvidAdSessionContext.AVID_API_LEVEL);
            this.zzaqy.zzb("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzagf.zzc("Exception occurred when loading assets", e);
        }
    }
}
