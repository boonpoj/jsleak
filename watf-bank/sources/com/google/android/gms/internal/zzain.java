package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.mopub.mobileads.resource.DrawableConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzain implements Runnable {
    final /* synthetic */ Context val$context;
    private /* synthetic */ String zzdbu;
    private /* synthetic */ boolean zzdbv;
    private /* synthetic */ boolean zzdbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzain(zzaim zzaimVar, Context context, String str, boolean z, boolean z2) {
        this.val$context = context;
        this.zzdbu = str;
        this.zzdbv = z;
        this.zzdbw = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.val$context);
        builder.setMessage(this.zzdbu);
        builder.setTitle(this.zzdbv ? "Error" : "Info");
        if (this.zzdbw) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton(DrawableConstants.CtaButton.DEFAULT_CTA_TEXT, new zzaio(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
