package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class zzahx implements Callable<Boolean> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ WebSettings zzdbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahx(zzahw zzahwVar, Context context, WebSettings webSettings) {
        this.val$context = context;
        this.zzdbg = webSettings;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        if (this.val$context.getCacheDir() != null) {
            this.zzdbg.setAppCachePath(this.val$context.getCacheDir().getAbsolutePath());
            this.zzdbg.setAppCacheMaxSize(0L);
            this.zzdbg.setAppCacheEnabled(true);
        }
        this.zzdbg.setDatabasePath(this.val$context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.zzdbg.setDatabaseEnabled(true);
        this.zzdbg.setDomStorageEnabled(true);
        this.zzdbg.setDisplayZoomControls(false);
        this.zzdbg.setBuiltInZoomControls(true);
        this.zzdbg.setSupportZoom(true);
        this.zzdbg.setAllowContentAccess(false);
        return true;
    }
}
