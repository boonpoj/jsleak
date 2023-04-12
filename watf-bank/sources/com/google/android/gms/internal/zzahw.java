package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Set;
/* loaded from: classes.dex */
public class zzahw extends zzahv {
    @Override // com.google.android.gms.internal.zzahv, com.google.android.gms.internal.zzaht
    public final boolean zza(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    @Override // com.google.android.gms.internal.zzaht
    public boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        return ((Boolean) zzajk.zza(context, new zzahx(this, context, webSettings))).booleanValue();
    }

    @Override // com.google.android.gms.internal.zzaht
    public final boolean zza(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    @Override // com.google.android.gms.internal.zzaht
    public zzani zzb(zzanh zzanhVar, boolean z) {
        return new zzaoq(zzanhVar, z);
    }

    @Override // com.google.android.gms.internal.zzaht
    public final Set<String> zzg(Uri uri) {
        return uri.getQueryParameterNames();
    }

    @Override // com.google.android.gms.internal.zzaht
    public WebChromeClient zzk(zzanh zzanhVar) {
        return new zzaoi(zzanhVar);
    }

    @Override // com.google.android.gms.internal.zzaht
    public final boolean zzx(View view) {
        view.setLayerType(0, null);
        return true;
    }

    @Override // com.google.android.gms.internal.zzaht
    public final boolean zzy(View view) {
        view.setLayerType(1, null);
        return true;
    }
}
