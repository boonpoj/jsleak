package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.Random;
/* loaded from: classes.dex */
final class zzte extends zzki {
    private final zzkh zzbzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzte(zzkh zzkhVar) {
        this.zzbzo = zzkhVar;
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClicked() throws RemoteException {
        this.zzbzo.onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClosed() throws RemoteException {
        if (zztn.zzlm()) {
            int intValue = ((Integer) zzkb.zzif().zzd(zznh.zzbmc)).intValue();
            int intValue2 = ((Integer) zzkb.zzif().zzd(zznh.zzbmd)).intValue();
            if (intValue <= 0 || intValue2 < 0) {
                com.google.android.gms.ads.internal.zzbs.zzeu().zzkv();
            } else {
                zzahn.zzdaw.postDelayed(zztf.zzbzp, intValue + new Random().nextInt(intValue2 + 1));
            }
        }
        this.zzbzo.onAdClosed();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdFailedToLoad(int i) throws RemoteException {
        this.zzbzo.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdImpression() throws RemoteException {
        this.zzbzo.onAdImpression();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLeftApplication() throws RemoteException {
        this.zzbzo.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLoaded() throws RemoteException {
        this.zzbzo.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdOpened() throws RemoteException {
        this.zzbzo.onAdOpened();
    }
}
