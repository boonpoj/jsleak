package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzlc extends zzeu implements zzla {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzlc {

        /* renamed from: com.google.android.gms.internal.zzlc$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0064zza implements zzlc {
            private IBinder zzrp;

            C0064zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // com.google.android.gms.internal.zzeu, android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            public void finishPurchase() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getProductId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent getPurchaseData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getResultCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isVerified() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
        }

        public static zzlc zzaa(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlc)) ? new C0064zza(iBinder) : (zzlc) queryLocalInterface;
        }

        @Override // com.google.android.gms.internal.zzeu, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    String productId = getProductId();
                    parcel2.writeNoException();
                    parcel2.writeString(productId);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    Intent purchaseData = getPurchaseData();
                    parcel2.writeNoException();
                    if (purchaseData != null) {
                        parcel2.writeInt(1);
                        purchaseData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    int resultCode = getResultCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(resultCode);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    boolean isVerified = isVerified();
                    parcel2.writeNoException();
                    parcel2.writeInt(isVerified ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
                    finishPurchase();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzux zzuxVar, int i) throws RemoteException {
        zzkn zzkpVar;
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzuxVar);
        zzbe.writeInt(i);
        Parcel zza2 = zza(3, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzkpVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzkpVar = queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new zzkp(readStrongBinder);
        }
        zza2.recycle();
        return zzkpVar;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzxe createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        Parcel zza2 = zza(8, zzbe);
        zzxe zzv = zzxf.zzv(zza2.readStrongBinder());
        zza2.recycle();
        return zzv;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, zzux zzuxVar, int i) throws RemoteException {
        zzks zzkuVar;
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjnVar);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzuxVar);
        zzbe.writeInt(i);
        Parcel zza2 = zza(1, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzkuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkuVar = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(readStrongBinder);
        }
        zza2.recycle();
        return zzkuVar;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzxo createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        Parcel zza2 = zza(7, zzbe);
        zzxo zzx = zzxp.zzx(zza2.readStrongBinder());
        zza2.recycle();
        return zzx;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzks createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, zzux zzuxVar, int i) throws RemoteException {
        zzks zzkuVar;
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjnVar);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzuxVar);
        zzbe.writeInt(i);
        Parcel zza2 = zza(2, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzkuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkuVar = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(readStrongBinder);
        }
        zza2.recycle();
        return zzkuVar;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzpu createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, iObjectWrapper2);
        Parcel zza2 = zza(5, zzbe);
        zzpu zzl = zzpv.zzl(zza2.readStrongBinder());
        zza2.recycle();
        return zzl;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzpz createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, iObjectWrapper2);
        zzew.zza(zzbe, iObjectWrapper3);
        Parcel zza2 = zza(11, zzbe);
        zzpz zzm = zzqa.zzm(zza2.readStrongBinder());
        zza2.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzadk createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzux zzuxVar, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzuxVar);
        zzbe.writeInt(i);
        Parcel zza2 = zza(6, zzbe);
        zzadk zzz = zzadl.zzz(zza2.readStrongBinder());
        zza2.recycle();
        return zzz;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn zzjnVar, String str, int i) throws RemoteException {
        zzks zzkuVar;
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjnVar);
        zzbe.writeString(str);
        zzbe.writeInt(i);
        Parcel zza2 = zza(10, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzkuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzkuVar = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(readStrongBinder);
        }
        zza2.recycle();
        return zzkuVar;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzlg getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzlg zzliVar;
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        Parcel zza2 = zza(4, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzliVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzliVar = queryLocalInterface instanceof zzlg ? (zzlg) queryLocalInterface : new zzli(readStrongBinder);
        }
        zza2.recycle();
        return zzliVar;
    }

    @Override // com.google.android.gms.internal.zzla
    public final zzlg getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzlg zzliVar;
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeInt(i);
        Parcel zza2 = zza(9, zzbe);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzliVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzliVar = queryLocalInterface instanceof zzlg ? (zzlg) queryLocalInterface : new zzli(readStrongBinder);
        }
        zza2.recycle();
        return zzliVar;
    }
}
