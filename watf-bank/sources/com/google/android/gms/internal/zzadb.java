package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzadb implements zzacf {
    private zztp<JSONObject, JSONObject> zzcup;
    private zztp<JSONObject, JSONObject> zzcuu;

    public zzadb(Context context) {
        this.zzcuu = com.google.android.gms.ads.internal.zzbs.zzev().zzb(context, zzakd.zzrd()).zza("google.afma.request.getAdDictionary", zztu.zzccb, zztu.zzccb);
        this.zzcup = com.google.android.gms.ads.internal.zzbs.zzev().zzb(context, zzakd.zzrd()).zza("google.afma.sdkConstants.getSdkConstants", zztu.zzccb, zztu.zzccb);
    }

    @Override // com.google.android.gms.internal.zzacf
    public final zztp<JSONObject, JSONObject> zznq() {
        return this.zzcuu;
    }

    @Override // com.google.android.gms.internal.zzacf
    public final zztp<JSONObject, JSONObject> zznr() {
        return this.zzcup;
    }
}
