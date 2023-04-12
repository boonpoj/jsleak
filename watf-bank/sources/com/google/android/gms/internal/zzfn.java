package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzfn extends zzeu implements zzfl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zza(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeString(str);
        zzb(2, zzbe);
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeString(str);
        zzbe.writeString(null);
        zzb(8, zzbe);
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zza(int[] iArr) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeIntArray(null);
        zzb(4, zzbe);
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zzbk() throws RemoteException {
        zzb(3, zzbe());
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zzc(byte[] bArr) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeByteArray(bArr);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zzg(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(6, zzbe);
    }

    @Override // com.google.android.gms.internal.zzfl
    public final void zzh(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(7, zzbe);
    }
}
