package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.zzaat;
import com.google.android.gms.internal.zzaau;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzou;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzbc implements Callable<zzou> {
    private /* synthetic */ zzafp zzanv;
    private /* synthetic */ zzba zzarp;
    private /* synthetic */ int zzarq;
    private /* synthetic */ JSONArray zzarr;
    private /* synthetic */ int zzars;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbc(zzba zzbaVar, int i, JSONArray jSONArray, int i2, zzafp zzafpVar) {
        this.zzarp = zzbaVar;
        this.zzarq = i;
        this.zzarr = jSONArray;
        this.zzars = i2;
        this.zzanv = zzafpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzou call() throws Exception {
        if (this.zzarq >= this.zzarr.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.zzarr.get(this.zzarq));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        zzba zzbaVar = new zzba(this.zzarp.zzano.zzair, this.zzarp.zzanr, this.zzarp.zzano.zzauc, this.zzarp.zzano.zzatw, this.zzarp.zzanw, this.zzarp.zzano.zzaty, true);
        zzba.zza(this.zzarp.zzano, zzbaVar.zzano);
        zzbaVar.zzdp();
        zzbaVar.zza(this.zzarp.zzank);
        zznu zznuVar = zzbaVar.zzanj;
        int i = this.zzarq;
        zznuVar.zzf("num_ads_requested", String.valueOf(this.zzars));
        zznuVar.zzf("ad_index", String.valueOf(i));
        zzaat zzaatVar = this.zzanv.zzcqv;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = zzaatVar.zzcnd.extras != null ? new Bundle(zzaatVar.zzcnd.extras) : new Bundle();
        bundle.putString("_ad", jSONObject2);
        zzbaVar.zza(new zzaau(zzaatVar.zzcnc, new zzjj(zzaatVar.zzcnd.versionCode, zzaatVar.zzcnd.zzbdf, bundle, zzaatVar.zzcnd.zzbdg, zzaatVar.zzcnd.zzbdh, zzaatVar.zzcnd.zzbdi, zzaatVar.zzcnd.zzbdj, zzaatVar.zzcnd.zzbdk, zzaatVar.zzcnd.zzbdl, zzaatVar.zzcnd.zzbdm, zzaatVar.zzcnd.zzbdn, zzaatVar.zzcnd.zzbdo, zzaatVar.zzcnd.zzbdp, zzaatVar.zzcnd.zzbdq, zzaatVar.zzcnd.zzbdr, zzaatVar.zzcnd.zzbds, zzaatVar.zzcnd.zzbdt, zzaatVar.zzcnd.zzbdu), zzaatVar.zzauc, zzaatVar.zzatw, zzaatVar.applicationInfo, zzaatVar.zzcne, zzaatVar.zzcng, zzaatVar.zzcnh, zzaatVar.zzaty, zzaatVar.zzcni, zzaatVar.zzauw, zzaatVar.zzcns, zzaatVar.zzcnk, zzaatVar.zzcnl, zzaatVar.zzcnm, zzaatVar.zzcnn, zzaatVar.zzaxx, zzaatVar.zzcno, zzaatVar.zzcnp, zzaatVar.zzcnq, zzaatVar.zzcnr, zzaatVar.zzatv, zzaatVar.zzauo, zzaatVar.zzcnu, zzaatVar.zzcnv, zzaatVar.zzcob, zzaatVar.zzcnw, zzaatVar.zzcnx, zzaatVar.zzcny, zzaatVar.zzcnz, zzakl.zzi(zzaatVar.zzcoa), zzaatVar.zzcoc, zzaatVar.zzcdo, zzaatVar.zzcod, zzaatVar.zzcoe, zzaatVar.zzcof, zzaatVar.zzauq, zzaatVar.zzcog, zzaatVar.zzcoh, zzaatVar.zzcol, zzakl.zzi(zzaatVar.zzcnf), zzaatVar.zzaus, zzaatVar.zzcom, zzaatVar.zzcon, 1, zzaatVar.zzcop, zzaatVar.zzcoq, zzaatVar.zzcor), zzbaVar.zzanj);
        return zzbaVar.zzdr().get();
    }
}
