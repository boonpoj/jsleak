package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdp implements Runnable {
    private /* synthetic */ zzdm zzaji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdp(zzdm zzdmVar) {
        this.zzaji = zzdmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznh.initialize(this.zzaji.zzair);
    }
}
