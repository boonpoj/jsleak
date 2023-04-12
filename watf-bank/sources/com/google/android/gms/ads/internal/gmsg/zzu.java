package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzu implements Runnable {
    private /* synthetic */ Map zzbvc;
    final /* synthetic */ com.google.android.gms.ads.internal.js.zza zzbxq;
    private /* synthetic */ HttpClient zzbxr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(HttpClient httpClient, Map map, com.google.android.gms.ads.internal.js.zza zzaVar) {
        this.zzbxr = httpClient;
        this.zzbvc = map;
        this.zzbxq = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzagf.zzbx("Received Http request.");
        try {
            JSONObject send = this.zzbxr.send(new JSONObject((String) this.zzbvc.get("http_request")));
            if (send == null) {
                zzagf.e("Response should not be null.");
            } else {
                zzahn.zzdaw.post(new zzv(this, send));
            }
        } catch (Exception e) {
            zzagf.zzb("Error converting request to json.", e);
        }
    }
}
