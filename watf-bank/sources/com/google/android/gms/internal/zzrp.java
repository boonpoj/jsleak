package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
/* loaded from: classes.dex */
final class zzrp implements Runnable {
    private /* synthetic */ PublisherAdView zzbws;
    private /* synthetic */ zzks zzbwt;
    private /* synthetic */ zzro zzbwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrp(zzro zzroVar, PublisherAdView publisherAdView, zzks zzksVar) {
        this.zzbwu = zzroVar;
        this.zzbws = publisherAdView;
        this.zzbwt = zzksVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.zzbws.zza(this.zzbwt)) {
            zzakb.zzcu("Could not bind ad manager");
            return;
        }
        onPublisherAdViewLoadedListener = this.zzbwu.zzbwr;
        onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.zzbws);
    }
}
