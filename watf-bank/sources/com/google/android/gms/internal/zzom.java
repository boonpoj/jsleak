package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzom implements Runnable {
    private /* synthetic */ zzol zzbuj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzom(zzol zzolVar) {
        this.zzbuj = zzolVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzos zzosVar;
        zzos zzosVar2;
        zzos zzosVar3;
        zzosVar = this.zzbuj.zzbuf;
        if (zzosVar != null) {
            zzosVar2 = this.zzbuj.zzbuf;
            zzosVar2.zzki();
            zzosVar3 = this.zzbuj.zzbuf;
            zzosVar3.zzkh();
        }
        this.zzbuj.zzbuf = null;
    }
}
