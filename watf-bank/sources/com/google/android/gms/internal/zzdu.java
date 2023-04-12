package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdu implements Runnable {
    private /* synthetic */ zzdt zzakh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzdt zzdtVar) {
        this.zzakh = zzdtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzakh.zzax();
    }
}
