package com.google.android.gms.internal;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzahq implements zzaju {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzdbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahq(zzahn zzahnVar, Context context, String str) {
        this.val$context = context;
        this.zzdbf = str;
    }

    @Override // com.google.android.gms.internal.zzaju
    public final void zzck(String str) {
        com.google.android.gms.ads.internal.zzbs.zzei();
        zzahn.zze(this.val$context, this.zzdbf, str);
    }
}
