package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzano;
import com.google.android.gms.internal.zzgp;
/* loaded from: classes.dex */
final class zzal implements zzano {
    private /* synthetic */ zzafo zzaox;
    private /* synthetic */ zzak zzaqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzak zzakVar, zzafo zzafoVar) {
        this.zzaqk = zzakVar;
        this.zzaox = zzafoVar;
    }

    @Override // com.google.android.gms.internal.zzano
    public final void zzdc() {
        Context context = this.zzaqk.zzano.zzair;
        zzanh zzanhVar = this.zzaox.zzciy;
        if (zzanhVar == null) {
            throw null;
        }
        new zzgp(context, (View) zzanhVar).zza(this.zzaox.zzciy);
    }
}
