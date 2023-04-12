package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjr;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzjv extends zzjr.zza<zzkn> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzbfa;
    private /* synthetic */ zzux zzbfb;
    private /* synthetic */ zzjr zzbfc;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzjv {

        /* renamed from: com.google.android.gms.internal.zzjv$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0054zza implements zzjv {
            private IBinder zzrp;

            C0054zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public int zzgH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
        }

        public static zzjv zzP(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjv)) ? new C0054zza(iBinder) : (zzjv) queryLocalInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            int zzgH = zzgH();
            parcel2.writeNoException();
            parcel2.writeInt(zzgH);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjv(zzjr zzjrVar, Context context, String str, zzux zzuxVar) {
        super();
        this.zzbfc = zzjrVar;
        this.val$context = context;
        this.zzbfa = str;
        this.zzbfb = zzuxVar;
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzkn zza(zzla zzlaVar) throws RemoteException {
        return zzlaVar.createAdLoaderBuilder(com.google.android.gms.dynamic.zzn.zzz(this.val$context), this.zzbfa, this.zzbfb, 11910000);
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzkn zzhw() throws RemoteException {
        zzkn zza2 = zzjr.zzc(this.zzbfc).zza(this.val$context, this.zzbfa, this.zzbfb);
        if (zza2 != null) {
            return zza2;
        }
        zzjr.zza(this.zzbfc, this.val$context, "native_ad");
        return new zzmc();
    }
}
