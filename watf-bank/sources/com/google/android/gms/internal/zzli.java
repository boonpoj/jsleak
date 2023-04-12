package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzli extends zzeu implements zzlg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzli(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void initialize() throws RemoteException {
        zzb(1, zzbe());
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(4, zzbe);
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void setAppVolume(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(2, zzbe);
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, iObjectWrapper);
        zzb(6, zzbe);
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeString(str);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzlg
    public final float zzdn() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.zzlg
    public final boolean zzdo() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzlg
    public final void zzu(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(3, zzbe);
    }
}
