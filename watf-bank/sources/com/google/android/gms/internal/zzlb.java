package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzlb extends zzev implements zzla {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzlb {

        /* renamed from: com.google.android.gms.internal.zzlb$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0063zza implements zzlb {
            private IBinder zzrp;

            C0063zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // com.google.android.gms.internal.zzev, android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            public IBinder zzp(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzlb zzZ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlb)) ? new C0063zza(iBinder) : (zzlb) queryLocalInterface;
        }

        @Override // android.os.Binder, com.google.android.gms.internal.zzlb
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            IBinder zzp = zzp(zzd.zza.zzcd(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeStrongBinder(zzp);
            return true;
        }
    }

    public zzlb() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzla asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return queryLocalInterface instanceof zzla ? (zzla) queryLocalInterface : new zzlc(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface createBannerAdManager;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                createBannerAdManager = createBannerAdManager(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), (zzjn) zzew.zza(parcel, zzjn.CREATOR), parcel.readString(), zzuy.zzu(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 2:
                createBannerAdManager = createInterstitialAdManager(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), (zzjn) zzew.zza(parcel, zzjn.CREATOR), parcel.readString(), zzuy.zzu(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                createBannerAdManager = createAdLoaderBuilder(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), parcel.readString(), zzuy.zzu(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 4:
                createBannerAdManager = getMobileAdsSettingsManager(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 5:
                createBannerAdManager = createNativeAdViewDelegate(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 6:
                createBannerAdManager = createRewardedVideoAd(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), zzuy.zzu(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 7:
                createBannerAdManager = createInAppPurchaseManager(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 8:
                createBannerAdManager = createAdOverlay(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            case 9:
                createBannerAdManager = getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                createBannerAdManager = createSearchAdManager(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), (zzjn) zzew.zza(parcel, zzjn.CREATOR), parcel.readString(), parcel.readInt());
                break;
            case 11:
                createBannerAdManager = createNativeAdViewHolderDelegate(IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), IObjectWrapper.zza.zzaq(parcel.readStrongBinder()), IObjectWrapper.zza.zzaq(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        zzew.zza(parcel2, createBannerAdManager);
        return true;
    }
}
