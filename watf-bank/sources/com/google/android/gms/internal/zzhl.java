package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.zzhh;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzhl implements Runnable {
    private /* synthetic */ View zzazm;
    private /* synthetic */ zzhk zzazn;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzhl {

        /* renamed from: com.google.android.gms.internal.zzhl$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0041zza implements zzhl {
            private IBinder zzrp;

            C0041zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzhh zzhhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    obtain.writeStrongBinder(zzhhVar != null ? zzhhVar.asBinder() : null);
                    obtain.writeString(str);
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
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        }

        public static zzhl zzJ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzhl)) ? new C0041zza(iBinder) : (zzhl) queryLocalInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            zza(zzhh.zza.zzG(parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zzhk zzhkVar, View view) {
        this.zzazn = zzhkVar;
        this.zzazm = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzazn.zzj(this.zzazm);
    }
}
