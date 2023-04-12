package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaii implements DialogInterface.OnClickListener {
    private /* synthetic */ zzaig zzdbo;
    private /* synthetic */ String zzdbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaii(zzaig zzaigVar, String str) {
        this.zzdbo = zzaigVar;
        this.zzdbp = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        com.google.android.gms.ads.internal.zzbs.zzei();
        context = this.zzdbo.mContext;
        zzahn.zza(context, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.zzdbp), "Share via"));
    }
}
