package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzanh;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzg implements Runnable {
    private /* synthetic */ String zzcar;
    private /* synthetic */ JSONObject zzcas;
    private /* synthetic */ zze zzcat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zze zzeVar, String str, JSONObject jSONObject) {
        this.zzcat = zzeVar;
        this.zzcar = str;
        this.zzcas = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzanh zzanhVar;
        zzanhVar = this.zzcat.zzbyk;
        zzanhVar.zzb(this.zzcar, this.zzcas);
    }
}
