package com.google.android.gms.internal;

import org.json.JSONObject;
@zzzv
/* loaded from: classes.dex */
public final class zzua<I, O> implements zztp<I, O> {
    private final com.google.android.gms.ads.internal.js.zzn zzccg;
    private final zztr<O> zzcch;
    private final zzts<I> zzcci;
    private final String zzccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzua(com.google.android.gms.ads.internal.js.zzn zznVar, String str, zzts<I> zztsVar, zztr<O> zztrVar) {
        this.zzccg = zznVar;
        this.zzccj = str;
        this.zzcci = zztsVar;
        this.zzcch = zztrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(com.google.android.gms.ads.internal.js.zzaa zzaaVar, com.google.android.gms.ads.internal.js.zzaj zzajVar, I i, zzalf<O> zzalfVar) {
        try {
            com.google.android.gms.ads.internal.zzbs.zzei();
            String zzqb = zzahn.zzqb();
            com.google.android.gms.ads.internal.gmsg.zzd.zzbxl.zza(zzqb, new zzud(this, zzaaVar, zzalfVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzqb);
            jSONObject.put("args", this.zzcci.zzh(i));
            zzajVar.zzb(this.zzccj, jSONObject);
        } catch (Exception e) {
            try {
                zzalfVar.setException(e);
                zzagf.zzb("Unable to invokeJavaScript", e);
            } finally {
                zzaaVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzakg
    public final zzakv<O> zzc(I i) throws Exception {
        return zzg(i);
    }

    @Override // com.google.android.gms.internal.zztp
    public final zzakv<O> zzg(I i) {
        zzalf zzalfVar = new zzalf();
        com.google.android.gms.ads.internal.js.zzaa zzb = this.zzccg.zzb((zzcv) null);
        zzb.zza(new zzub(this, zzb, i, zzalfVar), new zzuc(this, zzalfVar, zzb));
        return zzalfVar;
    }
}
