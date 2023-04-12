package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakk implements zzaki {
    private /* synthetic */ String zzden;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakk(String str) {
        this.zzden = str;
    }

    @Override // com.google.android.gms.internal.zzaki
    public final void onSuccess(Object obj) {
    }

    @Override // com.google.android.gms.internal.zzaki
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.zzbs.zzem().zza(th, this.zzden);
    }
}
