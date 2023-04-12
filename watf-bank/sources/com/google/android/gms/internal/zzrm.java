package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
@zzzv
/* loaded from: classes.dex */
public final class zzrm extends zzqx {
    private final NativeCustomTemplateAd.OnCustomClickListener zzbwp;

    public zzrm(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzbwp = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.zzqw
    public final void zzb(zzqm zzqmVar, String str) {
        this.zzbwp.onCustomClick(zzqp.zza(zzqmVar), str);
    }
}
