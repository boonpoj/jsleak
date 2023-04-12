package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjt;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
final class zzjs extends zzjr.zza<zzks> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ zzjn zzbez;
    private /* synthetic */ String zzbfa;
    private /* synthetic */ zzux zzbfb;
    private /* synthetic */ zzjr zzbfc;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzjs {

        /* renamed from: com.google.android.gms.internal.zzjs$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0051zza implements zzjs {
            private IBinder zzrp;

            C0051zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public zzjt zzar(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzjt.zza.zzN(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzas(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static zzjs zzM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjs)) ? new C0051zza(iBinder) : (zzjs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    zzjt zzar = zzar(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzar != null ? zzar.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    boolean zzas = zzas(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zzas ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjs(zzjr zzjrVar, Context context, zzjn zzjnVar, String str, zzux zzuxVar) {
        super();
        this.zzbfc = zzjrVar;
        this.val$context = context;
        this.zzbez = zzjnVar;
        this.zzbfa = str;
        this.zzbfb = zzuxVar;
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzks zza(zzla zzlaVar) throws RemoteException {
        return zzlaVar.createBannerAdManager(com.google.android.gms.dynamic.zzn.zzz(this.val$context), this.zzbez, this.zzbfa, this.zzbfb, 11910000);
    }

    @Override // com.google.android.gms.internal.zzjr.zza
    public final /* synthetic */ zzks zzhw() throws RemoteException {
        zzks zza2 = zzjr.zzb(this.zzbfc).zza(this.val$context, this.zzbez, this.zzbfa, this.zzbfb, 1);
        if (zza2 != null) {
            return zza2;
        }
        zzjr.zza(this.zzbfc, this.val$context, "banner");
        return new zzmg();
    }
}
