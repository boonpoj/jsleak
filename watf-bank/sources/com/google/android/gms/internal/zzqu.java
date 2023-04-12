package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzqu extends zzev implements zzqt {

    /* renamed from: com.google.android.gms.internal.zzqu$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Map zzZD;

        AnonymousClass1(Map map) {
            this.zzZD = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzqu.zzb(zzqu.this).zza("pubVideoCmd", this.zzZD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqu$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int zzZF;
        final /* synthetic */ int zzZG;

        AnonymousClass2(int i, int i2) {
            this.zzZF = i;
            this.zzZG = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzqu.zzc(zzqu.this)) {
                boolean z = false;
                boolean z2 = this.zzZF != this.zzZG;
                boolean z3 = !zzqu.zzd(zzqu.this) && this.zzZG == 1;
                boolean z4 = z2 && this.zzZG == 1;
                boolean z5 = z2 && this.zzZG == 2;
                boolean z6 = z2 && this.zzZG == 3;
                zzqu.zza(zzqu.this, (zzqu.zzd(zzqu.this) || z3) ? true : true);
                if (zzqu.zze(zzqu.this) == null) {
                    return;
                }
                if (z3) {
                    try {
                        zzqu.zze(zzqu.this).zzeT();
                    } catch (RemoteException e) {
                        zzpe.zzc("Unable to call onVideoStart()", e);
                    }
                }
                if (z4) {
                    try {
                        zzqu.zze(zzqu.this).zzeU();
                    } catch (RemoteException e2) {
                        zzpe.zzc("Unable to call onVideoPlay()", e2);
                    }
                }
                if (z5) {
                    try {
                        zzqu.zze(zzqu.this).zzeV();
                    } catch (RemoteException e3) {
                        zzpe.zzc("Unable to call onVideoPause()", e3);
                    }
                }
                if (z6) {
                    try {
                        zzqu.zze(zzqu.this).onVideoEnd();
                    } catch (RemoteException e4) {
                        zzpe.zzc("Unable to call onVideoEnd()", e4);
                    }
                }
            }
        }
    }

    public zzqu() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public static zzqt zzp(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        return queryLocalInterface instanceof zzqt ? (zzqt) queryLocalInterface : new zzqv(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzqi zzqkVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzqkVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                zzqkVar = queryLocalInterface instanceof zzqi ? (zzqi) queryLocalInterface : new zzqk(readStrongBinder);
            }
            zza(zzqkVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
