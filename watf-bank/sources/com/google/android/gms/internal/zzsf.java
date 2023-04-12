package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
final class zzsf extends zzki {
    private /* synthetic */ zzse zzbzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsf(zzse zzseVar) {
        this.zzbzd = zzseVar;
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClicked() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsm(this));
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClosed() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsg(this));
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdFailedToLoad(int i) throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsh(this, i));
        zzagf.v("Pooled interstitial failed to load.");
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdImpression() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsl(this));
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLeftApplication() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsi(this));
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLoaded() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsj(this));
        zzagf.v("Pooled interstitial loaded.");
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdOpened() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsk(this));
    }
}
