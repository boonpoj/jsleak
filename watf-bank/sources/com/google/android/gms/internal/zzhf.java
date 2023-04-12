package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgz;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzhf {
    private int zzayp;
    private final Object mLock = new Object();
    private List<zzhe> zzayq = new LinkedList();

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzhf {

        /* renamed from: com.google.android.gms.internal.zzhf$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0037zza implements zzhf {
            private IBinder zzrp;

            C0037zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAdvertiser() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getBody() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCallToAction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getHeadline() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List getImages() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public com.google.android.gms.dynamic.zzd zzfM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzcd(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzgz zzfQ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzgz.zza.zzB(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        }

        public static zzhf zzF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzhf)) ? new C0037zza(iBinder) : (zzhf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                return true;
            }
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    com.google.android.gms.dynamic.zzd zzfM = zzfM();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzfM != null ? zzfM.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String headline = getHeadline();
                    parcel2.writeNoException();
                    parcel2.writeString(headline);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    List images = getImages();
                    parcel2.writeNoException();
                    parcel2.writeList(images);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String body = getBody();
                    parcel2.writeNoException();
                    parcel2.writeString(body);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzgz zzfQ = zzfQ();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzfQ != null ? zzfQ.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String callToAction = getCallToAction();
                    parcel2.writeNoException();
                    parcel2.writeString(callToAction);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String advertiser = getAdvertiser();
                    parcel2.writeNoException();
                    parcel2.writeString(advertiser);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    if (extras != null) {
                        parcel2.writeInt(1);
                        extras.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    destroy();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    public final boolean zza(zzhe zzheVar) {
        synchronized (this.mLock) {
            return this.zzayq.contains(zzheVar);
        }
    }

    public final boolean zzb(zzhe zzheVar) {
        synchronized (this.mLock) {
            Iterator<zzhe> it = this.zzayq.iterator();
            while (it.hasNext()) {
                zzhe next = it.next();
                if (!((Boolean) zzkb.zzif().zzd(zznh.zzbju)).booleanValue() || com.google.android.gms.ads.internal.zzbs.zzem().zzoy()) {
                    if (((Boolean) zzkb.zzif().zzd(zznh.zzbjw)).booleanValue() && !com.google.android.gms.ads.internal.zzbs.zzem().zzoz() && zzheVar != next && next.zzgm().equals(zzheVar.zzgm())) {
                        it.remove();
                        return true;
                    }
                } else if (zzheVar != next && next.zzgk().equals(zzheVar.zzgk())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzhe zzheVar) {
        synchronized (this.mLock) {
            if (this.zzayq.size() >= 10) {
                int size = this.zzayq.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzagf.zzbx(sb.toString());
                this.zzayq.remove(0);
            }
            int i = this.zzayp;
            this.zzayp = i + 1;
            zzheVar.zzo(i);
            this.zzayq.add(zzheVar);
        }
    }

    public final zzhe zzgs() {
        synchronized (this.mLock) {
            zzhe zzheVar = null;
            if (this.zzayq.size() == 0) {
                zzagf.zzbx("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzayq.size() < 2) {
                zzhe zzheVar2 = this.zzayq.get(0);
                zzheVar2.zzgn();
                return zzheVar2;
            }
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            for (zzhe zzheVar3 : this.zzayq) {
                int score = zzheVar3.getScore();
                if (score > i2) {
                    i = i3;
                    zzheVar = zzheVar3;
                    i2 = score;
                }
                i3++;
            }
            this.zzayq.remove(i);
            return zzheVar;
        }
    }
}
