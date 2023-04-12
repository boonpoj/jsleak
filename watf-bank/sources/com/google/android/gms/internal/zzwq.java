package com.google.android.gms.internal;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class zzwq implements DialogInterface.OnClickListener {
    private /* synthetic */ zzwo zzcgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwq(zzwo zzwoVar) {
        this.zzcgj = zzwoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzcgj.zzbm("Operation denied by user.");
    }
}
