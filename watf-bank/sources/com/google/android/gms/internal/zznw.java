package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zznw implements CustomRenderedAd {
    private final zznx zzbsx;

    public zznw(zznx zznxVar) {
        this.zzbsx = zznxVar;
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getBaseUrl() {
        try {
            return this.zzbsx.zzjj();
        } catch (RemoteException e) {
            zzakb.zzc("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getContent() {
        try {
            return this.zzbsx.getContent();
        } catch (RemoteException e) {
            zzakb.zzc("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void onAdRendered(View view) {
        try {
            this.zzbsx.zze(view != null ? com.google.android.gms.dynamic.zzn.zzz(view) : null);
        } catch (RemoteException e) {
            zzakb.zzc("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordClick() {
        try {
            this.zzbsx.recordClick();
        } catch (RemoteException e) {
            zzakb.zzc("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordImpression() {
        try {
            this.zzbsx.recordImpression();
        } catch (RemoteException e) {
            zzakb.zzc("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
