package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public abstract class zzlm extends zzev implements zzll {

    /* renamed from: com.google.android.gms.internal.zzlm$1  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zzlm.this.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlm$2  reason: invalid class name */
    /* loaded from: assets/classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ zzov zzsW;

        AnonymousClass2(zzov zzovVar) {
            this.zzsW = zzovVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (zzlm.this.zzrN) {
                zzlm.this.zzn(this.zzsW);
            }
        }
    }

    /* loaded from: assets/classes2.dex */
    protected static final class zza extends Exception {
        private final int zzPF;

        public zza(String str, int i) {
            super(str);
            this.zzPF = i;
        }

        public int getErrorCode() {
            return this.zzPF;
        }
    }

    public zzlm() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzll zzh(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzll ? (zzll) queryLocalInterface : new zzln(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean isMuted;
        float zzih;
        zzlo zzlqVar;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                break;
            case 2:
                pause();
                parcel2.writeNoException();
                break;
            case 3:
                mute(zzew.zza(parcel));
                parcel2.writeNoException();
                break;
            case 4:
                isMuted = isMuted();
                parcel2.writeNoException();
                zzew.zza(parcel2, isMuted);
                break;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                break;
            case 6:
                zzih = zzih();
                parcel2.writeNoException();
                parcel2.writeFloat(zzih);
                break;
            case 7:
                zzih = zzii();
                parcel2.writeNoException();
                parcel2.writeFloat(zzih);
                break;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzlqVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzlqVar = queryLocalInterface instanceof zzlo ? (zzlo) queryLocalInterface : new zzlq(readStrongBinder);
                }
                zza(zzlqVar);
                parcel2.writeNoException();
                break;
            case 9:
                zzih = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(zzih);
                break;
            case 10:
                isMuted = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzew.zza(parcel2, isMuted);
                break;
            case 11:
                zzlo zzij = zzij();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzij);
                break;
            case 12:
                isMuted = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzew.zza(parcel2, isMuted);
                break;
            default:
                return false;
        }
        return true;
    }
}
