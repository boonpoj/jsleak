package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: assets/classes2.dex */
public interface zzapz extends IInterface {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzapz {

        /* renamed from: com.google.android.gms.internal.zzapz$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0008zza implements zzapz {
            private IBinder zzrp;

            C0008zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            @Override // com.google.android.gms.internal.zzapz
            public zzapx zza(zzapv zzapvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.gass.internal.IGassService");
                    if (zzapvVar != null) {
                        obtain.writeInt(1);
                        zzapvVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? zzapx.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzapz zzcU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzapz)) ? new C0008zza(iBinder) : (zzapz) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.gass.internal.IGassService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.gass.internal.IGassService");
            zzapx zza = zza(parcel.readInt() != 0 ? zzapv.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (zza != null) {
                parcel2.writeInt(1);
                zza.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    zzapx zza(zzapv zzapvVar) throws RemoteException;
}
