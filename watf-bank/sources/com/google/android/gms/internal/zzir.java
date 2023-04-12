package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzel;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzir {

    /* loaded from: assets/classes2.dex */
    private static class zza extends zzel.zza {
        private final zzel zzIy;

        zza(zzel zzelVar) {
            this.zzIy = zzelVar;
        }

        public void onAdClosed() throws RemoteException {
            this.zzIy.onAdClosed();
            com.google.android.gms.ads.internal.zzv.zzcY().zzgj();
        }

        public void onAdFailedToLoad(int i) throws RemoteException {
            this.zzIy.onAdFailedToLoad(i);
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzIy.onAdLeftApplication();
        }

        public void onAdLoaded() throws RemoteException {
            this.zzIy.onAdLoaded();
        }

        public void onAdOpened() throws RemoteException {
            this.zzIy.onAdOpened();
        }
    }
}
