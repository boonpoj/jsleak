package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaix implements zzakg<Throwable, T> {
    private /* synthetic */ zzajb zzdcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaix(zzaiv zzaivVar, zzajb zzajbVar) {
        this.zzdcm = zzajbVar;
    }

    @Override // com.google.android.gms.internal.zzakg
    public final /* synthetic */ zzakv zzc(Throwable th) throws Exception {
        Throwable th2 = th;
        zzagf.zzb("Error occurred while dispatching http response in getter.", th2);
        com.google.android.gms.ads.internal.zzbs.zzem().zza(th2, "HttpGetter.deliverResponse.1");
        return zzakl.zzi(this.zzdcm.zzni());
    }
}
