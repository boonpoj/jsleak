package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public class zzer {
    private static String TAG = zzer.class.getSimpleName();
    private final String className;
    private final zzdm zzagr;
    private final String zzaku;
    private final Class<?>[] zzakx;
    private final int zzakv = 2;
    private volatile Method zzakw = null;
    private CountDownLatch zzaky = new CountDownLatch(1);

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzer {

        /* renamed from: com.google.android.gms.internal.zzer$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0022zza implements zzer {
            private IBinder zzrp;

            C0022zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void onAppEvent(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAppEventListener");
        }

        public static zzer zzs(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzer)) ? new C0022zza(iBinder) : (zzer) queryLocalInterface;
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
                parcel2.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            onAppEvent(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    public zzer(zzdm zzdmVar, String str, String str2, Class<?>... clsArr) {
        this.zzagr = zzdmVar;
        this.className = str;
        this.zzaku = str2;
        this.zzakx = clsArr;
        this.zzagr.zzag().submit(new zzes(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc() {
        try {
            Class loadClass = this.zzagr.zzah().loadClass(zzc(this.zzagr.zzaj(), this.className));
            if (loadClass != null) {
                this.zzakw = loadClass.getMethod(zzc(this.zzagr.zzaj(), this.zzaku), this.zzakx);
                Method method = this.zzakw;
            }
        } catch (zzcy e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } catch (Throwable th) {
            this.zzaky.countDown();
            throw th;
        }
        this.zzaky.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzcy, UnsupportedEncodingException {
        return new String(this.zzagr.zzai().zzb(bArr, str), "UTF-8");
    }

    public final Method zzbd() {
        if (this.zzakw != null) {
            return this.zzakw;
        }
        try {
            if (this.zzaky.await(2L, TimeUnit.SECONDS)) {
                return this.zzakw;
            }
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
