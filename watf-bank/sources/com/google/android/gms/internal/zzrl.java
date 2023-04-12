package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
@zzzv
/* loaded from: classes.dex */
public final class zzrl extends zzqu {
    private final NativeContentAd.OnContentAdLoadedListener zzbwo;

    public zzrl(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzbwo = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzqt
    public final void zza(zzqi zzqiVar) {
        this.zzbwo.onContentAdLoaded(new zzql(zzqiVar));
    }
}
