package com.google.android.gms.internal;
/* loaded from: classes.dex */
final class zzanz implements Runnable {
    private /* synthetic */ zzanx zzdmx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanz(zzanx zzanxVar) {
        this.zzdmx = zzanxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
