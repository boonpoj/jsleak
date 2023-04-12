package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdo implements Runnable {
    private /* synthetic */ zzdm zzaji;
    private /* synthetic */ int zzajj;
    private /* synthetic */ boolean zzajk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdo(zzdm zzdmVar, int i, boolean z) {
        this.zzaji = zzdmVar;
        this.zzajj = i;
        this.zzajk = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zza;
        zzaz zzb = this.zzaji.zzb(this.zzajj, this.zzajk);
        this.zzaji.zzaiz = zzb;
        zza = zzdm.zza(this.zzajj, zzb);
        if (zza) {
            this.zzaji.zza(this.zzajj + 1, this.zzajk);
        }
    }
}
