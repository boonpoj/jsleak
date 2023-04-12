package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzlj extends IInterface {

    /* renamed from: com.google.android.gms.internal.zzlj$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzlj.zza(zzlj.this).get()) {
                zzpe.e("Timed out waiting for WebView to finish loading.");
                zzlj.this.cancel();
            }
        }
    }

    IBinder zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException;
}
