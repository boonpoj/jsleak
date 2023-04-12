package com.google.android.gms.internal;

import android.view.View;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzfy implements zzhd {
    private final View mView;
    private final zzafo zzawq;

    public zzfy(View view, zzafo zzafoVar) {
        this.mView = view;
        this.zzawq = zzafoVar;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final View zzgd() {
        return this.mView;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final boolean zzge() {
        return this.zzawq == null || this.mView == null;
    }

    @Override // com.google.android.gms.internal.zzhd
    public final zzhd zzgf() {
        return this;
    }
}
