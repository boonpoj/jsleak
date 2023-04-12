package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzop implements Runnable {
    private /* synthetic */ zzon zzbun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(zzon zzonVar) {
        this.zzbun = zzonVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzos zzosVar;
        zzos zzosVar2;
        zzos zzosVar3;
        zzosVar = this.zzbun.zzbuf;
        if (zzosVar != null) {
            zzosVar2 = this.zzbun.zzbuf;
            zzosVar2.zzki();
            zzosVar3 = this.zzbun.zzbuf;
            zzosVar3.zzkh();
        }
        this.zzbun.zzbuf = null;
    }
}
