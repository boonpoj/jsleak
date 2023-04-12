package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoOptions;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzmr extends zzbfm {
    public static final Parcelable.Creator<zzmr> CREATOR = new zzms();
    public final boolean zzbgx;
    public final boolean zzbgy;
    public final boolean zzbgz;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzmr {

        /* renamed from: com.google.android.gms.internal.zzmr$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0069zza implements zzmr {
            private IBinder zzrp;

            C0069zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zzb(zzmk zzmkVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (zzmkVar != null) {
                        obtain.writeInt(1);
                        zzmkVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
        }

        public static zzmr zzaf(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmr)) ? new C0069zza(iBinder) : (zzmr) queryLocalInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.request.IAdResponseListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
            zzb(parcel.readInt() != 0 ? (zzmk) zzmk.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    public zzmr(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    public zzmr(boolean z, boolean z2, boolean z3) {
        this.zzbgx = z;
        this.zzbgy = z2;
        this.zzbgz = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzbgx);
        zzbfp.zza(parcel, 3, this.zzbgy);
        zzbfp.zza(parcel, 4, this.zzbgz);
        zzbfp.zzai(parcel, zze);
    }
}
