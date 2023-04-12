package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public final class zzxg extends zzeu implements zzxe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzbe.writeInt(i2);
        zzew.zza(zzbe, intent);
        zzb(12, zzbe);
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onBackPressed() throws RemoteException {
        zzb(10, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, bundle);
        zzb(1, zzbe);
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onDestroy() throws RemoteException {
        zzb(8, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onPause() throws RemoteException {
        zzb(5, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onRestart() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onResume() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, bundle);
        Parcel zza = zza(6, zzbe);
        if (zza.readInt() != 0) {
            bundle.readFromParcel(zza);
        }
        zza.recycle();
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onStart() throws RemoteException {
        zzb(3, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void onStop() throws RemoteException {
        zzb(7, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void zzbf() throws RemoteException {
        zzb(9, zzbe());
    }

    @Override // com.google.android.gms.internal.zzxe
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(13, zzbe);
    }

    @Override // com.google.android.gms.internal.zzxe
    public final boolean zzmu() throws RemoteException {
        Parcel zza = zza(11, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }
}
