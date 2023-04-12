package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zznl implements Runnable {
    private /* synthetic */ zznk zzbsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznl(zznk zznkVar) {
        this.zzbsi = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbsi.zzjb();
    }
}
