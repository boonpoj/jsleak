package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzjs;
import java.lang.reflect.InvocationTargetException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzeq extends zzet {
    private final View zzakj;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzeq {

        /* renamed from: com.google.android.gms.internal.zzeq$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0021zza implements zzeq {
            private IBinder zzrp;

            C0021zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, zzec zzecVar, String str, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (zzecVar != null) {
                        obtain.writeInt(1);
                        zzecVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, zzec zzecVar, String str, zzjs zzjsVar, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (zzecVar != null) {
                        obtain.writeInt(1);
                        zzecVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzjsVar != null ? zzjsVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzeq zzr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzeq)) ? new C0021zza(iBinder) : (zzeq) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder zza = zza(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder zza2 = zza(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza2);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    public zzeq(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2, View view) {
        super(zzdmVar, str, str2, zzazVar, i, 57);
        this.zzakj = view;
    }

    @Override // com.google.android.gms.internal.zzet
    protected final void zzay() throws IllegalAccessException, InvocationTargetException {
        if (this.zzakj != null) {
            zzds zzdsVar = new zzds((String) this.zzakw.invoke(null, this.zzakj, this.zzagr.getContext().getResources().getDisplayMetrics()));
            zzbb zzbbVar = new zzbb();
            zzbbVar.zzgd = zzdsVar.zzajv;
            zzbbVar.zzge = zzdsVar.zzge;
            zzbbVar.zzgf = zzdsVar.zzgf;
            this.zzako.zzeu = zzbbVar;
        }
    }
}
