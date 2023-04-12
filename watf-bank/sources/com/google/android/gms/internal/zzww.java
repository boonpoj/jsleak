package com.google.android.gms.internal;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class zzww implements DialogInterface.OnClickListener {
    private /* synthetic */ zzwu zzchd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzww(zzwu zzwuVar) {
        this.zzchd = zzwuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzchd.zzbm("User canceled the download.");
    }
}
