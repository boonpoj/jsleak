package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzok implements Runnable {
    private /* synthetic */ zzoj zzbug;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzok(zzoj zzojVar) {
        this.zzbug = zzojVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzos zzosVar;
        zzos zzosVar2;
        zzos zzosVar3;
        zzosVar = this.zzbug.zzbuf;
        if (zzosVar != null) {
            zzosVar2 = this.zzbug.zzbuf;
            zzosVar2.zzki();
            zzosVar3 = this.zzbug.zzbuf;
            zzosVar3.zzkh();
        }
        this.zzbug.zzbuf = null;
    }
}
