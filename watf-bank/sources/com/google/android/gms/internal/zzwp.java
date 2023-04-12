package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzwp implements DialogInterface.OnClickListener {
    private /* synthetic */ zzwo zzcgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwp(zzwo zzwoVar) {
        this.zzcgj = zzwoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent createIntent = this.zzcgj.createIntent();
        com.google.android.gms.ads.internal.zzbs.zzei();
        context = this.zzcgj.mContext;
        zzahn.zza(context, createIntent);
    }
}
