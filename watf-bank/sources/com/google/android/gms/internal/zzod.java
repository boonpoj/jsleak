package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzod extends zzob {
    private final OnCustomRenderedAdLoadedListener zzbgh;

    public zzod(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzbgh = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzoa
    public final void zza(zznx zznxVar) {
        this.zzbgh.onCustomRenderedAdLoaded(new zznw(zznxVar));
    }
}
