package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzajj;
import java.util.Map;
/* loaded from: classes.dex */
final class zzt implements com.google.android.gms.ads.internal.gmsg.zzt<zzaj> {
    private /* synthetic */ zzc zzcbg;
    private /* synthetic */ zzo zzcbh;
    private /* synthetic */ zzajj zzcbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzo zzoVar, zzc zzcVar, zzajj zzajjVar) {
        this.zzcbh = zzoVar;
        this.zzcbg = zzcVar;
        this.zzcbk = zzajjVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzaj zzajVar, Map map) {
        Object obj;
        int i;
        obj = this.zzcbh.zzcbf.mLock;
        synchronized (obj) {
            zzagf.zzct("JS Engine is requesting an update");
            i = this.zzcbh.zzcbf.zzcbc;
            if (i == 0) {
                zzagf.zzct("Starting reload.");
                this.zzcbh.zzcbf.zzcbc = 2;
                this.zzcbh.zzcbf.zza(this.zzcbh.zzcbd);
            }
            this.zzcbg.zzb("/requestReload", (com.google.android.gms.ads.internal.gmsg.zzt) this.zzcbk.get());
        }
    }
}
