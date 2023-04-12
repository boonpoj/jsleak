package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.zzmr;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzmq extends zzlp {
    private final VideoController.VideoLifecycleCallbacks zzamd;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzmq {

        /* renamed from: com.google.android.gms.internal.zzmq$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0068zza implements zzmq {
            private IBinder zzrp;

            C0068zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // com.google.android.gms.internal.zzev, android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzmh zzmhVar, zzmr zzmrVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (zzmhVar != null) {
                        obtain.writeInt(1);
                        zzmhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzmrVar != null ? zzmrVar.asBinder() : null);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzmk zzd(zzmh zzmhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (zzmhVar != null) {
                        obtain.writeInt(1);
                        zzmhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (zzmk) zzmk.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static zzmq zzae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmq)) ? new C0068zza(iBinder) : (zzmq) queryLocalInterface;
        }

        @Override // com.google.android.gms.internal.zzev, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder, com.google.android.gms.internal.zzlp
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    zzmk zzd = zzd(parcel.readInt() != 0 ? (zzmh) zzmh.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zzd != null) {
                        parcel2.writeInt(1);
                        zzd.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    zza(parcel.readInt() != 0 ? (zzmh) zzmh.CREATOR.createFromParcel(parcel) : null, zzmr.zza.zzaf(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    public zzmq(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzamd = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoEnd() {
        this.zzamd.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoMute(boolean z) {
        this.zzamd.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoPause() {
        this.zzamd.onVideoPause();
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoPlay() {
        this.zzamd.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.zzlo
    public final void onVideoStart() {
        this.zzamd.onVideoStart();
    }
}
