package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzzm;
import org.json.JSONObject;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzzn implements zzaki<zzanh> {
    private /* synthetic */ String val$message;
    private /* synthetic */ JSONObject zzcmd;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzzn {

        /* renamed from: com.google.android.gms.internal.zzzn$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0080zza implements zzzn {
            private IBinder zzrp;

            C0080zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(zzzm zzzmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    obtain.writeStrongBinder(zzzmVar != null ? zzzmVar.asBinder() : null);
                    this.zzrp.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzzm zzzmVar, zzzh zzzhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    obtain.writeStrongBinder(zzzmVar != null ? zzzmVar.asBinder() : null);
                    if (zzzhVar != null) {
                        obtain.writeInt(1);
                        zzzhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzzn zzbo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzzn)) ? new C0080zza(iBinder) : (zzzn) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(zzzm.zza.zzbn(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzzh) zzzh.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(zzzm.zza.zzbn(parcel.readStrongBinder()));
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzn(zzzf zzzfVar, String str, JSONObject jSONObject) {
        this.val$message = str;
        this.zzcmd = jSONObject;
    }

    @Override // com.google.android.gms.internal.zzaki
    public final /* synthetic */ void onSuccess(zzanh zzanhVar) {
        zzanhVar.zza(this.val$message, this.zzcmd);
    }

    @Override // com.google.android.gms.internal.zzaki
    public final void zzb(Throwable th) {
    }
}
