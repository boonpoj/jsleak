package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzlp extends zzev implements zzlo {

    /* renamed from: com.google.android.gms.internal.zzlp$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zzov zzPG;

        AnonymousClass1(zzov zzovVar) {
            this.zzPG = zzovVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            zzlp.zza(zzlp.this).zzb(this.zzPG);
        }
    }

    public zzlp() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            onVideoStart();
        } else if (i == 2) {
            onVideoPlay();
        } else if (i == 3) {
            onVideoPause();
        } else if (i == 4) {
            onVideoEnd();
        } else if (i != 5) {
            return false;
        } else {
            onVideoMute(zzew.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
