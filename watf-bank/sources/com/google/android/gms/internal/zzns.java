package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzjs;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzns {
    private final long zzbsm;
    private final String zzbsn;
    private final zzns zzbso;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzns {

        /* renamed from: com.google.android.gms.internal.zzns$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0074zza implements zzns {
            private IBinder zzrp;

            C0074zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public IBinder zza(com.google.android.gms.dynamic.zzd zzdVar, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
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

        public static zzns zzai(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzns)) ? new C0074zza(iBinder) : (zzns) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            IBinder zza = zza(zzd.zza.zzcd(parcel.readStrongBinder()), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(zza);
            return true;
        }
    }

    public zzns(long j, String str, zzns zznsVar) {
        this.zzbsm = j;
        this.zzbsn = str;
        this.zzbso = zznsVar;
    }

    public final long getTime() {
        return this.zzbsm;
    }

    public final String zzjc() {
        return this.zzbsn;
    }

    public final zzns zzjd() {
        return this.zzbso;
    }
}
