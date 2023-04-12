package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzjs;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzeo extends zzet {
    private static volatile Long zzakt = null;
    private static final Object zzakl = new Object();

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzeo {

        /* renamed from: com.google.android.gms.internal.zzeo$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0019zza implements zzeo {
            private IBinder zzrp;

            C0019zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, String str, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzjsVar != null ? zzjsVar.asBinder() : null);
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

        public static zzeo zzp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzeo)) ? new C0019zza(iBinder) : (zzeo) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            IBinder zza = zza(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readString(), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(zza);
            return true;
        }
    }

    public zzeo(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        super(zzdmVar, str, str2, zzazVar, i, 33);
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        if (zzakt == null) {
            synchronized (zzakl) {
                if (zzakt == null) {
                    zzakt = (Long) this.zzakw.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzako) {
            this.zzako.zzdz = zzakt;
        }
    }
}
