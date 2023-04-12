package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzaej implements Runnable {
    private /* synthetic */ zzafo zzaox;
    private /* synthetic */ zzaei zzcwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaej(zzaei zzaeiVar, zzafo zzafoVar) {
        this.zzcwa = zzaeiVar;
        this.zzaox = zzafoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzade zzadeVar;
        zzadeVar = this.zzcwa.zzcvz;
        zzadeVar.zzb(this.zzaox);
    }
}
