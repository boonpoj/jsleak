package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzlq extends zzeu implements zzlo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoEnd() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoMute(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoPause() throws RemoteException {
        zzb(3, zzbe());
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoPlay() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoStart() throws RemoteException {
        zzb(1, zzbe());
    }
}
