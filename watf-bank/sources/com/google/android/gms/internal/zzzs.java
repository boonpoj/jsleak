package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzzs implements Runnable {
    private /* synthetic */ zzakc zzcmk;
    private /* synthetic */ String zzcml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzs(zzzp zzzpVar, zzakc zzakcVar, String str) {
        this.zzcmk = zzakcVar;
        this.zzcml = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcmk.zzck(this.zzcml);
    }
}
