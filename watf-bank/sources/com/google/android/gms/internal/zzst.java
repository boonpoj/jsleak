package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
final class zzst extends zzadq {
    private /* synthetic */ zzse zzbzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzst(zzse zzseVar) {
        this.zzbzd = zzseVar;
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdClosed() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsx(this));
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzta(this, i));
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsz(this));
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsu(this));
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoAdOpened() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsv(this));
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void onRewardedVideoStarted() throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsw(this));
    }

    @Override // com.google.android.gms.internal.zzadp
    public final void zza(zzadh zzadhVar) throws RemoteException {
        List list;
        list = this.zzbzd.zzapa;
        list.add(new zzsy(this, zzadhVar));
    }
}
