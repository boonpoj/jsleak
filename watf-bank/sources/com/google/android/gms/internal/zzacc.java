package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzacc implements zzakg {
    static final zzakg zzcrn = new zzacc();

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzacc {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzacc$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        public static class C0004zza implements zzacc {
            private IBinder zzrp;

            C0004zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzcX(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
                    obtain.writeInt(i);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
        }

        public static zzacc zzbA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzacc)) ? new C0004zza(iBinder) : (zzacc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            zzcX(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    private zzacc() {
    }

    @Override // com.google.android.gms.internal.zzakg
    public final zzakv zzc(Object obj) {
        zzakv zzi;
        zzi = zzakl.zzi(new zzacn((JSONObject) obj));
        return zzi;
    }
}
