package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zznt;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzep extends zzet {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzep {

        /* renamed from: com.google.android.gms.internal.zzep$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0020zza implements zzep {
            private IBinder zzrp;

            C0020zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getMediationAdapterClassName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setManualImpressionsEnabled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzrp.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserId(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeString(str);
                    this.zzrp.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzec zzecVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (zzecVar != null) {
                        obtain.writeInt(1);
                        zzecVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzek zzekVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzekVar != null ? zzekVar.asBinder() : null);
                    this.zzrp.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzel zzelVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzelVar != null ? zzelVar.asBinder() : null);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzer zzerVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzerVar != null ? zzerVar.asBinder() : null);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzet zzetVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzetVar != null ? zzetVar.asBinder() : null);
                    this.zzrp.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzfn zzfnVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (zzfnVar != null) {
                        obtain.writeInt(1);
                        zzfnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzgj zzgjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzgjVar != null ? zzgjVar.asBinder() : null);
                    this.zzrp.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzkz zzkzVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzkzVar != null ? zzkzVar.asBinder() : null);
                    this.zzrp.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzld zzldVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzldVar != null ? zzldVar.asBinder() : null);
                    obtain.writeString(str);
                    this.zzrp.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zznt zzntVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzntVar != null ? zzntVar.asBinder() : null);
                    this.zzrp.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzb(zzdy zzdyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (zzdyVar != null) {
                        obtain.writeInt(1);
                        zzdyVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public com.google.android.gms.dynamic.zzd zzbC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzcd(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzec zzbD() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzbF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzew zzbG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.zzrp.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzew.zza.zzw(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static zzep zzq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzep)) ? new C0020zza(iBinder) : (zzep) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 29) {
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                zza(parcel.readInt() != 0 ? (zzfn) zzfn.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                return true;
            } else {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        com.google.android.gms.dynamic.zzd zzbC = zzbC();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(zzbC != null ? zzbC.asBinder() : null);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        destroy();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        boolean isReady = isReady();
                        parcel2.writeNoException();
                        parcel2.writeInt(isReady ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        boolean zzb = zzb(parcel.readInt() != 0 ? (zzdy) zzdy.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(zzb ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        pause();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        resume();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zza(zzel.zza.zzm(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zza(zzer.zza.zzs(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        showInterstitial();
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        stopLoading();
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zzbF();
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zzec zzbD = zzbD();
                        parcel2.writeNoException();
                        if (zzbD != null) {
                            parcel2.writeInt(1);
                            zzbD.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 13:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zza(parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zza(zzkz.zza.zzX(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        zza(zzld.zza.zzab(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        switch (i) {
                            case 18:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                String mediationAdapterClassName = getMediationAdapterClassName();
                                parcel2.writeNoException();
                                parcel2.writeString(mediationAdapterClassName);
                                return true;
                            case 19:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                zza(zzgj.zza.zzA(parcel.readStrongBinder()));
                                parcel2.writeNoException();
                                return true;
                            case 20:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                zza(zzek.zza.zzl(parcel.readStrongBinder()));
                                parcel2.writeNoException();
                                return true;
                            case 21:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                zza(zzet.zza.zzt(parcel.readStrongBinder()));
                                parcel2.writeNoException();
                                return true;
                            case 22:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                setManualImpressionsEnabled(parcel.readInt() != 0);
                                parcel2.writeNoException();
                                return true;
                            case 23:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                boolean isLoading = isLoading();
                                parcel2.writeNoException();
                                parcel2.writeInt(isLoading ? 1 : 0);
                                return true;
                            case 24:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                zza(zznt.zza.zzaj(parcel.readStrongBinder()));
                                parcel2.writeNoException();
                                return true;
                            case 25:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                setUserId(parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 26:
                                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                                zzew zzbG = zzbG();
                                parcel2.writeNoException();
                                parcel2.writeStrongBinder(zzbG != null ? zzbG.asBinder() : null);
                                return true;
                            default:
                                return super.onTransact(i, parcel, parcel2, i2);
                        }
                }
            }
        }
    }

    public zzep(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 48);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        zzaz zzazVar;
        int i;
        this.zzako.zzek = 2;
        boolean booleanValue = ((Boolean) this.zzakw.invoke(null, this.zzagr.getContext())).booleanValue();
        synchronized (this.zzako) {
            if (booleanValue) {
                zzazVar = this.zzako;
                i = 1;
            } else {
                zzazVar = this.zzako;
                i = 0;
            }
            zzazVar.zzek = i;
        }
    }
}
