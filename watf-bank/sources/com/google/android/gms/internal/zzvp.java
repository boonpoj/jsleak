package com.google.android.gms.internal;

import android.os.RemoteException;
/* loaded from: classes.dex */
public final class zzvp extends zzlm {
    private final Object mLock = new Object();
    private volatile zzlo zzcfl;

    @Override // com.google.android.gms.internal.zzll
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final void zza(zzlo zzloVar) throws RemoteException {
        synchronized (this.mLock) {
            this.zzcfl = zzloVar;
        }
    }

    @Override // com.google.android.gms.internal.zzll
    public final float zzih() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final float zzii() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzll
    public final zzlo zzij() throws RemoteException {
        zzlo zzloVar;
        synchronized (this.mLock) {
            zzloVar = this.zzcfl;
        }
        return zzloVar;
    }
}
