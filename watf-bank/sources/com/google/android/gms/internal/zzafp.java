package com.google.android.gms.internal;

import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzafp {
    public final int errorCode;
    public final zzjn zzauc;
    public final zzaat zzcqv;
    public final JSONObject zzcxj;
    public final zzui zzcxl;
    public final long zzcxp;
    public final long zzcxq;
    public final zzis zzcxw;
    public final boolean zzcxx;
    public final zzaax zzcxy;

    public zzafp(zzaat zzaatVar, zzaax zzaaxVar, zzui zzuiVar, zzjn zzjnVar, int i, long j, long j2, JSONObject jSONObject, zzis zzisVar, Boolean bool) {
        boolean z;
        this.zzcqv = zzaatVar;
        this.zzcxy = zzaaxVar;
        this.zzcxl = zzuiVar;
        this.zzauc = zzjnVar;
        this.errorCode = i;
        this.zzcxp = j;
        this.zzcxq = j2;
        this.zzcxj = jSONObject;
        this.zzcxw = zzisVar;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            com.google.android.gms.ads.internal.zzbs.zzei();
            z = zzahn.zzp(zzaatVar.zzcnd);
        }
        this.zzcxx = z;
    }

    public zzafp(zzaat zzaatVar, zzaax zzaaxVar, zzui zzuiVar, zzjn zzjnVar, int i, long j, long j2, JSONObject jSONObject, zzix zzixVar) {
        this.zzcqv = zzaatVar;
        this.zzcxy = zzaaxVar;
        this.zzcxl = null;
        this.zzauc = null;
        this.errorCode = i;
        this.zzcxp = j;
        this.zzcxq = j2;
        this.zzcxj = null;
        this.zzcxw = new zzis(zzixVar, ((Boolean) zzkb.zzif().zzd(zznh.zzbrf)).booleanValue());
        this.zzcxx = false;
    }
}
