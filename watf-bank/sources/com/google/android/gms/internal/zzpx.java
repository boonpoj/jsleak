package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzpx extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzpx$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements zza {
        AnonymousClass1(zzpx zzpxVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzpx$1$1] */
        @Override // com.google.android.gms.internal.zzpx.zza
        public void zzu(final String str) {
            new Thread(this) { // from class: com.google.android.gms.internal.zzpx.1.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    new zzpz().zzu(str);
                }
            }.start();
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzu(String str);
    }

    IBinder zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) throws RemoteException;
}
