package com.google.android.gms.ads.internal;

import android.view.View;
/* loaded from: classes.dex */
final class zzo implements View.OnClickListener {
    private /* synthetic */ zzl zzaod;
    private /* synthetic */ zzw zzaoe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzl zzlVar, zzw zzwVar) {
        this.zzaod = zzlVar;
        this.zzaoe = zzwVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzaoe.recordClick();
        if (this.zzaod.zzaob != null) {
            this.zzaod.zzaob.zzom();
        }
    }
}
