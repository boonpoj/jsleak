package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzln extends zzeu implements zzll {

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void zzb(zzov zzovVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzln(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.zzll
    public final float getAspectRatio() throws RemoteException {
        Parcel zza2 = zza(9, zzbe());
        float readFloat = zza2.readFloat();
        zza2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.zzll
    public final int getPlaybackState() throws RemoteException {
        Parcel zza2 = zza(5, zzbe());
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.zzll
    public final boolean isClickToExpandEnabled() throws RemoteException {
        Parcel zza2 = zza(12, zzbe());
        boolean zza3 = zzew.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.zzll
    public final boolean isCustomControlsEnabled() throws RemoteException {
        Parcel zza2 = zza(10, zzbe());
        boolean zza3 = zzew.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.zzll
    public final boolean isMuted() throws RemoteException {
        Parcel zza2 = zza(4, zzbe());
        boolean zza3 = zzew.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.zzll
    public final void mute(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zzll
    public final void pause() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzll
    public final void play() throws RemoteException {
        zzb(1, zzbe());
    }

    @Override // com.google.android.gms.internal.zzll
    public final void zza(zzlo zzloVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzloVar);
        zzb(8, zzbe);
    }

    @Override // com.google.android.gms.internal.zzll
    public final float zzih() throws RemoteException {
        Parcel zza2 = zza(6, zzbe());
        float readFloat = zza2.readFloat();
        zza2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.zzll
    public final float zzii() throws RemoteException {
        Parcel zza2 = zza(7, zzbe());
        float readFloat = zza2.readFloat();
        zza2.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.zzll
    public final zzlo zzij() throws RemoteException {
        zzlo zzlqVar;
        Parcel zza2 = zza(11, zzbe());
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            zzlqVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzlqVar = queryLocalInterface instanceof zzlo ? (zzlo) queryLocalInterface : new zzlq(readStrongBinder);
        }
        zza2.recycle();
        return zzlqVar;
    }
}
