package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
/* loaded from: classes.dex */
final class zzaom implements DialogInterface.OnCancelListener {
    private /* synthetic */ JsPromptResult zzdnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaom(JsPromptResult jsPromptResult) {
        this.zzdnp = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzdnp.cancel();
    }
}
