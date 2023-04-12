package com.google.android.gms.internal;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzpk implements Runnable {
    private /* synthetic */ zzow zzbvt;
    private /* synthetic */ zzpj zzbwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpk(zzpj zzpjVar, zzow zzowVar) {
        this.zzbwa = zzpjVar;
        this.zzbvt = zzowVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbwa.zza(this.zzbvt);
    }
}
