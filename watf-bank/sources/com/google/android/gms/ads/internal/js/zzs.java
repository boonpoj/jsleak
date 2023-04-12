package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzaiq;
import java.util.Map;
/* loaded from: classes.dex */
final class zzs implements com.google.android.gms.ads.internal.gmsg.zzt<zzaj> {
    private /* synthetic */ zzc zzcbg;
    private /* synthetic */ zzo zzcbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzo zzoVar, zzc zzcVar) {
        this.zzcbh = zzoVar;
        this.zzcbg = zzcVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzt
    public final /* synthetic */ void zza(zzaj zzajVar, Map map) {
        Object obj;
        zzaiq zzaiqVar;
        obj = this.zzcbh.zzcbf.mLock;
        synchronized (obj) {
            if (this.zzcbh.zzcbe.getStatus() != -1 && this.zzcbh.zzcbe.getStatus() != 1) {
                this.zzcbh.zzcbf.zzcbc = 0;
                zzaiqVar = this.zzcbh.zzcbf.zzcaz;
                zzaiqVar.zzf(this.zzcbg);
                this.zzcbh.zzcbe.zzk(this.zzcbg);
                this.zzcbh.zzcbf.zzcbb = this.zzcbh.zzcbe;
                zzagf.v("Successfully loaded JS Engine.");
            }
        }
    }
}
