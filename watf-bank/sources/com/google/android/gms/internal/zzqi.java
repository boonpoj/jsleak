package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzqi extends IInterface {

    /* loaded from: assets/classes2.dex */
    public interface zza {
        void run();
    }

    /* loaded from: assets/classes2.dex */
    public static class zzb implements zza {
        @Override // com.google.android.gms.internal.zzqi.zza
        public void run() {
        }
    }

    /* loaded from: assets/classes2.dex */
    public interface zzc<T> {
        void zzd(T t);
    }

    void destroy() throws RemoteException;

    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzll getVideoController() throws RemoteException;

    void performClick(Bundle bundle) throws RemoteException;

    boolean recordImpression(Bundle bundle) throws RemoteException;

    void reportTouchEvent(Bundle bundle) throws RemoteException;

    IObjectWrapper zzjt() throws RemoteException;

    IObjectWrapper zzjx() throws RemoteException;

    zzpm zzjy() throws RemoteException;

    zzpq zzjz() throws RemoteException;
}
