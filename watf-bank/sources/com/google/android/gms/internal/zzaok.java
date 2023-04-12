package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
/* loaded from: classes.dex */
final class zzaok implements DialogInterface.OnClickListener {
    private /* synthetic */ JsResult zzdno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaok(JsResult jsResult) {
        this.zzdno = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdno.cancel();
    }
}
