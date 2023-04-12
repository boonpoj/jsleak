package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzml extends zzadl {
    private zzadp zzbgu;

    @Override // com.google.android.gms.internal.zzadk
    public final void destroy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void pause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void resume() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void show() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zza(zzadp zzadpVar) throws RemoteException {
        this.zzbgu = zzadpVar;
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zza(zzadv zzadvVar) throws RemoteException {
        zzakb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzajr.zzajw.post(new zzmm(this));
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.zzadk
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
    }
}
