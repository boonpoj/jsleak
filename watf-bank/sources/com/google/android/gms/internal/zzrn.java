package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
@zzzv
/* loaded from: classes.dex */
public final class zzrn extends zzra {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzbwq;

    public zzrn(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzbwq = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzqz
    public final void zzb(zzqm zzqmVar) {
        this.zzbwq.onCustomTemplateAdLoaded(zzqp.zza(zzqmVar));
    }
}
