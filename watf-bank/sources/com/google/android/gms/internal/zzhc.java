package com.google.android.gms.internal;

import android.app.Application;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzhc {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzhc {

        /* renamed from: com.google.android.gms.internal.zzhc$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0035zza implements zzhc {
            private IBinder zzrp;

            C0035zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzd zzdVar2, com.google.android.gms.dynamic.zzd zzdVar3, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeStrongBinder(zzdVar2 != null ? zzdVar2.asBinder() : null);
                    obtain.writeStrongBinder(zzdVar3 != null ? zzdVar3.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzhc zzD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzhc)) ? new C0035zza(iBinder) : (zzhc) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            IBinder zza = zza(zzd.zza.zzcd(parcel.readStrongBinder()), zzd.zza.zzcd(parcel.readStrongBinder()), zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(zza);
            return true;
        }
    }

    void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);
}
