package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.ads.AdRequest;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzkf extends zzev implements zzke {

    /* renamed from: com.google.android.gms.internal.zzkf$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdClicked();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$10  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ AdRequest.ErrorCode zzLd;

        AnonymousClass10(AdRequest.ErrorCode errorCode) {
            this.zzLd = errorCode;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdFailedToLoad(zzkg.zza(this.zzLd));
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$11  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdLeftApplication();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdOpened();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$3  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdLoaded();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$4  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdClosed();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$5  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ AdRequest.ErrorCode zzLd;

        AnonymousClass5(AdRequest.ErrorCode errorCode) {
            this.zzLd = errorCode;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdFailedToLoad(zzkg.zza(this.zzLd));
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$6  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdLeftApplication();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$7  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdOpened();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$8  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdLoaded();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkf$9  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zzkf.zza(zzkf.this).onAdClosed();
            } catch (RemoteException e) {
                zzpy.zzc("Could not call onAdClosed.", e);
            }
        }
    }

    public zzkf() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            onAdClicked();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
