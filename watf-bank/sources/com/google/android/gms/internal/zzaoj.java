package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
/* loaded from: classes.dex */
final class zzaoj implements DialogInterface.OnCancelListener {
    private /* synthetic */ JsResult zzdno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoj(JsResult jsResult) {
        this.zzdno = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzdno.cancel();
    }
}
