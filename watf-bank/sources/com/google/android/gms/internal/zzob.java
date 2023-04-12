package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzob extends zzev implements zzoa {

    /* loaded from: assets/classes2.dex */
    public static final class zza {
        private String zzKo;
        private int zzPF;
        private String zzUW;
        private long zzUX;

        public zza zzaO(String str) {
            this.zzKo = str;
            return this;
        }

        public zza zzaP(String str) {
            this.zzUW = str;
            return this;
        }

        public zza zzac(int i) {
            this.zzPF = i;
            return this;
        }

        public zzob zzjt() {
            return new zzob(this, null);
        }

        public zza zzl(long j) {
            this.zzUX = j;
            return this;
        }
    }

    public zzob() {
        attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public static zzoa zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        return queryLocalInterface instanceof zzoa ? (zzoa) queryLocalInterface : new zzoc(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zznx zznzVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zznzVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
                zznzVar = queryLocalInterface instanceof zznx ? (zznx) queryLocalInterface : new zznz(readStrongBinder);
            }
            zza(zznzVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
