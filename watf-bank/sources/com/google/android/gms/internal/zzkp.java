package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzkp extends zzeu implements zzkn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, publisherAdViewOptions);
        zzb(9, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzpe zzpeVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzpeVar);
        zzb(6, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzqq zzqqVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqqVar);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzqt zzqtVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqtVar);
        zzb(4, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzrc zzrcVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzrcVar);
        zzb(10, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(zzrf zzrfVar, zzjn zzjnVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzrfVar);
        zzew.zza(zzbe, zzjnVar);
        zzb(8, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zza(String str, zzqz zzqzVar, zzqw zzqwVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, zzqzVar);
        zzew.zza(zzbe, zzqwVar);
        zzb(5, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zzb(zzkh zzkhVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzkhVar);
        zzb(2, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final void zzb(zzld zzldVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzldVar);
        zzb(7, zzbe);
    }

    @Override // com.google.android.gms.internal.zzkn
    public final zzkk zzdi() throws RemoteException {
        zzkk zzkmVar;
        Parcel zza = zza(1, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzkmVar = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzkm(readStrongBinder);
        }
        zza.recycle();
        return zzkmVar;
    }
}
