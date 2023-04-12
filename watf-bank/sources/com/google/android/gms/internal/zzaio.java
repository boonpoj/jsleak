package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.net.Uri;
/* loaded from: classes.dex */
final class zzaio implements DialogInterface.OnClickListener {
    private /* synthetic */ zzain zzdbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaio(zzain zzainVar) {
        this.zzdbx = zzainVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzbs.zzei();
        zzahn.zza(this.zzdbx.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
