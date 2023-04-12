package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzll extends IInterface {
    float getAspectRatio() throws RemoteException;

    int getPlaybackState() throws RemoteException;

    boolean isClickToExpandEnabled() throws RemoteException;

    boolean isCustomControlsEnabled() throws RemoteException;

    boolean isMuted() throws RemoteException;

    void mute(boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void zza(zzlo zzloVar) throws RemoteException;

    float zzih() throws RemoteException;

    float zzii() throws RemoteException;

    zzlo zzij() throws RemoteException;
}
