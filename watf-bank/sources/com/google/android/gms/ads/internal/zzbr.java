package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
final class zzbr {
    private final String zzask;
    private final Map<String, String> zzasl = new TreeMap();
    private String zzasm;
    private String zzasn;

    public zzbr(String str) {
        this.zzask = str;
    }

    public final String getQuery() {
        return this.zzasm;
    }

    public final void zza(zzjj zzjjVar, zzakd zzakdVar) {
        this.zzasm = zzjjVar.zzbdm.zzbgw;
        Bundle bundle = zzjjVar.zzbdp != null ? zzjjVar.zzbdp.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle == null) {
            return;
        }
        String str = (String) zzkb.zzif().zzd(zznh.zzbpt);
        for (String str2 : bundle.keySet()) {
            if (str.equals(str2)) {
                this.zzasn = bundle.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.zzasl.put(str2.substring(4), bundle.getString(str2));
            }
        }
        this.zzasl.put("SDKVersion", zzakdVar.zzcv);
    }

    public final String zzea() {
        return this.zzasn;
    }

    public final String zzeb() {
        return this.zzask;
    }

    public final Map<String, String> zzec() {
        return this.zzasl;
    }
}
