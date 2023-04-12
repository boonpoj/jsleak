package com.google.android.gms.internal;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzpq extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzpq$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzpq.zza(zzpq.this)) {
                String str = "Suspending the looper thread";
                while (true) {
                    zzpe.v(str);
                    while (zzpq.zzb(zzpq.this) == 0) {
                        try {
                            zzpq.zza(zzpq.this).wait();
                            zzpe.v("Looper thread resumed");
                        } catch (InterruptedException unused) {
                            str = "Looper thread interrupted.";
                        }
                    }
                }
            }
        }
    }

    double getScale() throws RemoteException;

    Uri getUri() throws RemoteException;

    IObjectWrapper zzjr() throws RemoteException;
}
