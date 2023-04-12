package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzaxu;
/* loaded from: assets/classes2.dex */
public interface zzaxv extends IInterface {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzaxv {

        /* renamed from: com.google.android.gms.internal.zzaxv$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0010zza implements zzaxv {
            private IBinder zzrp;

            C0010zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(int i, Account account, zzaxu zzaxuVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaxuVar != null ? zzaxuVar.asBinder() : null);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(com.google.android.gms.common.internal.zzad zzadVar, com.google.android.gms.common.internal.zzx zzxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzadVar != null) {
                        obtain.writeInt(1);
                        zzadVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzxVar != null ? zzxVar.asBinder() : null);
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(com.google.android.gms.common.internal.zzd zzdVar, zzaxu zzaxuVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzdVar != null) {
                        obtain.writeInt(1);
                        zzdVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaxuVar != null ? zzaxuVar.asBinder() : null);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(com.google.android.gms.common.internal.zzr zzrVar, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzrVar != null ? zzrVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(zzaxs zzaxsVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzaxsVar != null) {
                        obtain.writeInt(1);
                        zzaxsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(zzaxw zzaxwVar, zzaxu zzaxuVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzaxwVar != null) {
                        obtain.writeInt(1);
                        zzaxwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaxuVar != null ? zzaxuVar.asBinder() : null);
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zza(zzaxz zzaxzVar, zzaxu zzaxuVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (zzaxzVar != null) {
                        obtain.writeInt(1);
                        zzaxzVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaxuVar != null ? zzaxuVar.asBinder() : null);
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zzaK(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zzb(zzaxu zzaxuVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzaxuVar != null ? zzaxuVar.asBinder() : null);
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzaxv
            public void zzmK(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaxv zzeY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaxv)) ? new C0010zza(iBinder) : (zzaxv) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                return true;
            }
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zza((com.google.android.gms.common.internal.zzd) (parcel.readInt() != 0 ? (com.google.android.gms.common.internal.zzd) com.google.android.gms.common.internal.zzd.CREATOR.createFromParcel(parcel) : null), zzaxu.zza.zzeX(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zza(parcel.readInt() != 0 ? (zzaxs) zzaxs.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzaK(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zza(parcel.readInt() != 0 ? (com.google.android.gms.common.internal.zzad) com.google.android.gms.common.internal.zzad.CREATOR.createFromParcel(parcel) : null, zzx.zza.zzbw(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    switch (i) {
                        case 7:
                            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                            zzmK(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                            zza(parcel.readInt(), (Account) (parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null), zzaxu.zza.zzeX(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                            zza(zzr.zza.zzbr(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                            zza((zzaxw) (parcel.readInt() != 0 ? (zzaxw) zzaxw.CREATOR.createFromParcel(parcel) : null), zzaxu.zza.zzeX(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                            zzb(zzaxu.zza.zzeX(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                            zza((zzaxz) (parcel.readInt() != 0 ? (zzaxz) zzaxz.CREATOR.createFromParcel(parcel) : null), zzaxu.zza.zzeX(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
            }
        }
    }

    void zza(int i, Account account, zzaxu zzaxuVar) throws RemoteException;

    void zza(com.google.android.gms.common.internal.zzad zzadVar, com.google.android.gms.common.internal.zzx zzxVar) throws RemoteException;

    void zza(com.google.android.gms.common.internal.zzd zzdVar, zzaxu zzaxuVar) throws RemoteException;

    void zza(com.google.android.gms.common.internal.zzr zzrVar, int i, boolean z) throws RemoteException;

    void zza(zzaxs zzaxsVar) throws RemoteException;

    void zza(zzaxw zzaxwVar, zzaxu zzaxuVar) throws RemoteException;

    void zza(zzaxz zzaxzVar, zzaxu zzaxuVar) throws RemoteException;

    void zzaK(boolean z) throws RemoteException;

    void zzb(zzaxu zzaxuVar) throws RemoteException;

    void zzmK(int i) throws RemoteException;
}
