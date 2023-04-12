package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zznr;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzes implements Runnable {
    private /* synthetic */ zzer zzakz;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzes {

        /* renamed from: com.google.android.gms.internal.zzes$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0023zza implements zzes {
            private IBinder zzrp;

            C0023zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public zzen createAdLoaderBuilder(com.google.android.gms.dynamic.zzd zzdVar, String str, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzjsVar != null ? zzjsVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzen.zza.zzo(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzkr createAdOverlay(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzkr.zza.zzT(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzep createBannerAdManager(com.google.android.gms.dynamic.zzd zzdVar, zzec zzecVar, String str, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
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
                    return zzep.zza.zzq(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzla createInAppPurchaseManager(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzla.zza.zzY(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzep createInterstitialAdManager(com.google.android.gms.dynamic.zzd zzdVar, zzec zzecVar, String str, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
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
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzep.zza.zzq(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzhb createNativeAdViewDelegate(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzd zzdVar2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeStrongBinder(zzdVar2 != null ? zzdVar2.asBinder() : null);
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzhb.zza.zzC(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zznr createRewardedVideoAd(com.google.android.gms.dynamic.zzd zzdVar, zzjs zzjsVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeStrongBinder(zzjsVar != null ? zzjsVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return zznr.zza.zzah(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzep createSearchAdManager(com.google.android.gms.dynamic.zzd zzdVar, zzec zzecVar, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (zzecVar != null) {
                        obtain.writeInt(1);
                        zzecVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzep.zza.zzq(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzeu getMobileAdsSettingsManager(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzeu.zza.zzu(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzeu getMobileAdsSettingsManagerWithClientJarVersion(com.google.android.gms.dynamic.zzd zzdVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzeu.zza.zzu(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
        }

        public static zzes asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzes)) ? new C0023zza(iBinder) : (zzes) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzep createBannerAdManager = createBannerAdManager(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createBannerAdManager != null ? createBannerAdManager.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzep createInterstitialAdManager = createInterstitialAdManager(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createInterstitialAdManager != null ? createInterstitialAdManager.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzen createAdLoaderBuilder = createAdLoaderBuilder(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readString(), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createAdLoaderBuilder != null ? createAdLoaderBuilder.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzeu mobileAdsSettingsManager = getMobileAdsSettingsManager(zzd.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mobileAdsSettingsManager != null ? mobileAdsSettingsManager.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzhb createNativeAdViewDelegate = createNativeAdViewDelegate(zzd.zza.zzcd(parcel.readStrongBinder()), zzd.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createNativeAdViewDelegate != null ? createNativeAdViewDelegate.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zznr createRewardedVideoAd = createRewardedVideoAd(zzd.zza.zzcd(parcel.readStrongBinder()), zzjs.zza.zzM(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createRewardedVideoAd != null ? createRewardedVideoAd.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzla createInAppPurchaseManager = createInAppPurchaseManager(zzd.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createInAppPurchaseManager != null ? createInAppPurchaseManager.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzkr createAdOverlay = createAdOverlay(zzd.zza.zzcd(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createAdOverlay != null ? createAdOverlay.asBinder() : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzeu mobileAdsSettingsManagerWithClientJarVersion = getMobileAdsSettingsManagerWithClientJarVersion(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mobileAdsSettingsManagerWithClientJarVersion != null ? mobileAdsSettingsManagerWithClientJarVersion.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzep createSearchAdManager = createSearchAdManager(zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzec) zzec.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createSearchAdManager != null ? createSearchAdManager.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzes(zzer zzerVar) {
        this.zzakz = zzerVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzakz.zzbc();
    }
}
