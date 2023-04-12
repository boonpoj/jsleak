package com.google.android.gms.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzlw extends zzkd {
    private /* synthetic */ zzlv zzbgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlw(zzlv zzlvVar) {
        this.zzbgk = zzlvVar;
    }

    @Override // com.google.android.gms.internal.zzkd, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        this.zzbgk.zzbgd.zza(this.zzbgk.zzbj());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.zzkd, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzbgk.zzbgd.zza(this.zzbgk.zzbj());
        super.onAdLoaded();
    }
}
