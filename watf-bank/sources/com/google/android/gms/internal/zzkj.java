package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzkj extends zzeu implements zzkh {

    /* renamed from: com.google.android.gms.internal.zzkj$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zzkj.this.zzs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClicked() throws RemoteException {
        zzb(6, zzbe());
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdClosed() throws RemoteException {
        zzb(1, zzbe());
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(2, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdImpression() throws RemoteException {
        zzb(7, zzbe());
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLeftApplication() throws RemoteException {
        zzb(3, zzbe());
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdLoaded() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zzkh
    public final void onAdOpened() throws RemoteException {
        zzb(5, zzbe());
    }
}
