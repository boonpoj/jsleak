package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzwv implements DialogInterface.OnClickListener {
    private /* synthetic */ String zzchb;
    private /* synthetic */ String zzchc;
    private /* synthetic */ zzwu zzchd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwv(zzwu zzwuVar, String str, String str2) {
        this.zzchd = zzwuVar;
        this.zzchb = str;
        this.zzchc = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.zzchd.mContext;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.zzchb;
            String str2 = this.zzchc;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzbs.zzek().zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException e) {
            this.zzchd.zzbm("Could not store picture.");
        }
    }
}
