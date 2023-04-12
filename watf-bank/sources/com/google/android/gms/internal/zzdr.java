package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzdr {
    private static final char[] zzaju = "0123456789abcdef".toCharArray();

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzdr {

        /* renamed from: com.google.android.gms.internal.zzdr$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0014zza implements zzdr {
            private IBinder zzrp;

            C0014zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public zzdl zza(zzdo zzdoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.cache.ICacheService");
                    if (zzdoVar != null) {
                        obtain.writeInt(1);
                        zzdoVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (zzdl) zzdl.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzdr zzi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzdr)) ? new C0014zza(iBinder) : (zzdr) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.cache.ICacheService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.cache.ICacheService");
            zzdl zza = zza(parcel.readInt() != 0 ? (zzdo) zzdo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (zza != null) {
                parcel2.writeInt(1);
                zza.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    public static long zza(double d, int i, DisplayMetrics displayMetrics) {
        double d2 = i;
        Double.isNaN(d2);
        double d3 = displayMetrics.density;
        Double.isNaN(d3);
        return Math.round((d * d2) / d3);
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzdvl.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean zza(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static Long zzat() {
        return Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime().getTime());
    }

    public static boolean zzau() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static Activity zzc(View view) {
        View rootView = view.getRootView();
        if (rootView != null) {
            view = rootView;
        }
        Context context = view.getContext();
        for (int i = 0; (context instanceof ContextWrapper) && i < 10; i++) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String zzn(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return zzbu.zza(bArr, true);
    }

    public static boolean zzo(String str) {
        return str == null || str.isEmpty();
    }
}
