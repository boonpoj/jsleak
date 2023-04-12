package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzgq implements Runnable {
    private /* synthetic */ zzgp zzaxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(zzgp zzgpVar) {
        this.zzaxn = zzgpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaxn.zzm(3);
    }
}
