package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzky;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzkz extends zzeu implements zzkx {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzkz {

        /* renamed from: com.google.android.gms.internal.zzkz$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0061zza implements zzkz {
            private IBinder zzrp;

            C0061zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // com.google.android.gms.internal.zzeu, android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzky zzkyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    obtain.writeStrongBinder(zzkyVar != null ? zzkyVar.asBinder() : null);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        public static zzkz zzX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkz)) ? new C0061zza(iBinder) : (zzkz) queryLocalInterface;
        }

        @Override // com.google.android.gms.internal.zzeu, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            zza(zzky.zza.zzW(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.zzkx
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzb(1, zzbe);
    }
}
