package com.google.android.gms.internal;

import android.view.View;
/* loaded from: classes.dex */
final class zzws implements View.OnClickListener {
    private /* synthetic */ zzwr zzcgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzws(zzwr zzwrVar) {
        this.zzcgy = zzwrVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzcgy.zzl(true);
    }
}
