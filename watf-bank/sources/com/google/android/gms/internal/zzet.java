package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzet implements Callable {
    private String TAG = getClass().getSimpleName();
    private String className;
    protected final zzdm zzagr;
    protected final zzaz zzako;
    private String zzaku;
    protected Method zzakw;
    private int zzala;
    private int zzalb;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzet {

        /* renamed from: com.google.android.gms.internal.zzet$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0024zza implements zzet {
            private IBinder zzrp;

            C0024zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public long getValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
        }

        public static zzet zzt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzet)) ? new C0024zza(iBinder) : (zzet) queryLocalInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            long value = getValue();
            parcel2.writeNoException();
            parcel2.writeLong(value);
            return true;
        }
    }

    public zzet(zzdm zzdmVar, String str, String str2, zzaz zzazVar, int i, int i2) {
        this.zzagr = zzdmVar;
        this.className = str;
        this.zzaku = str2;
        this.zzako = zzazVar;
        this.zzala = i;
        this.zzalb = i2;
    }

    protected abstract void zzay() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: zzba */
    public Void call() throws Exception {
        long nanoTime;
        try {
            nanoTime = System.nanoTime();
            this.zzakw = this.zzagr.zza(this.className, this.zzaku);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        if (this.zzakw == null) {
            return null;
        }
        zzay();
        zzcp zzal = this.zzagr.zzal();
        if (zzal != null && this.zzala != Integer.MIN_VALUE) {
            zzal.zza(this.zzalb, this.zzala, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
