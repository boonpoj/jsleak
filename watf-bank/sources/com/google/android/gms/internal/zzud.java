package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzud implements com.google.android.gms.ads.internal.gmsg.zzae {
    private /* synthetic */ zzua zzccn;
    private final com.google.android.gms.ads.internal.js.zzaa zzcco;
    private final zzalf zzccp;

    public zzud(zzua zzuaVar, com.google.android.gms.ads.internal.js.zzaa zzaaVar, zzalf zzalfVar) {
        this.zzccn = zzuaVar;
        this.zzcco = zzaaVar;
        this.zzccp = zzalfVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzae
    public final void zzau(String str) {
        try {
            if (str == null) {
                this.zzccp.setException(new zzto());
            } else {
                this.zzccp.setException(new zzto(str));
            }
        } catch (IllegalStateException e) {
        } catch (Throwable th) {
            this.zzcco.release();
            throw th;
        }
        this.zzcco.release();
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzae
    public final void zze(JSONObject jSONObject) {
        zztr zztrVar;
        try {
            try {
                zzalf zzalfVar = this.zzccp;
                zztrVar = this.zzccn.zzcch;
                zzalfVar.set(zztrVar.zzf(jSONObject));
            } catch (IllegalStateException e) {
            } catch (JSONException e2) {
                this.zzccp.set(e2);
            }
        } finally {
            this.zzcco.release();
        }
    }
}
