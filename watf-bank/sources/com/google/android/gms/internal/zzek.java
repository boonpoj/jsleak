package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzek extends zzet {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzek {

        /* renamed from: com.google.android.gms.internal.zzek$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0015zza implements zzek {
            private IBinder zzrp;

            C0015zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void onAdClicked() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdClickListener");
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
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdClickListener");
        }

        public static zzek zzl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzek)) ? new C0015zza(iBinder) : (zzek) queryLocalInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdClickListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
            onAdClicked();
            parcel2.writeNoException();
            return true;
        }
    }

    public zzek(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 61);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzakw.invoke(null, this.zzagr.getContext(), Boolean.valueOf(this.zzagr.zzan()))).longValue();
        synchronized (this.zzako) {
            this.zzako.zzey = Long.valueOf(longValue);
        }
    }
}
