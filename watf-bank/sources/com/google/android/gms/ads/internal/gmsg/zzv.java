package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class zzv implements Runnable {
    private /* synthetic */ JSONObject zzbxs;
    private /* synthetic */ zzu zzbxt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzu zzuVar, JSONObject jSONObject) {
        this.zzbxt = zzuVar;
        this.zzbxs = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbxt.zzbxq.zza("fetchHttpRequestCompleted", this.zzbxs);
        zzagf.zzbx("Dispatched http response.");
    }
}
