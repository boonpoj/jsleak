package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzzl implements zzaki<zzanh> {
    private /* synthetic */ String zzcmb;
    private /* synthetic */ com.google.android.gms.ads.internal.gmsg.zzt zzcmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzl(zzzf zzzfVar, String str, com.google.android.gms.ads.internal.gmsg.zzt zztVar) {
        this.zzcmb = str;
        this.zzcmc = zztVar;
    }

    @Override // com.google.android.gms.internal.zzaki
    public final /* synthetic */ void onSuccess(zzanh zzanhVar) {
        zzanhVar.zza(this.zzcmb, this.zzcmc);
    }

    @Override // com.google.android.gms.internal.zzaki
    public final void zzb(Throwable th) {
    }
}
