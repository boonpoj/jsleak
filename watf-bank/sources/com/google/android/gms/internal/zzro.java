package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzro extends zzrg {
    private final OnPublisherAdViewLoadedListener zzbwr;

    public zzro(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzbwr = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzrf
    public final void zza(zzks zzksVar, IObjectWrapper iObjectWrapper) {
        if (zzksVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) com.google.android.gms.dynamic.zzn.zzx(iObjectWrapper));
        try {
            if (zzksVar.zzce() instanceof zzjg) {
                zzjg zzjgVar = (zzjg) zzksVar.zzce();
                publisherAdView.setAdListener(zzjgVar != null ? zzjgVar.getAdListener() : null);
            }
        } catch (RemoteException e) {
            zzakb.zzc("Failed to get ad listener.", e);
        }
        try {
            if (zzksVar.zzcd() instanceof zzjp) {
                zzjp zzjpVar = (zzjp) zzksVar.zzcd();
                publisherAdView.setAppEventListener(zzjpVar != null ? zzjpVar.getAppEventListener() : null);
            }
        } catch (RemoteException e2) {
            zzakb.zzc("Failed to get app event listener.", e2);
        }
        zzajr.zzajw.post(new zzrp(this, publisherAdView, zzksVar));
    }
}
