package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public interface zzks extends IInterface {

    /* loaded from: assets/classes2.dex */
    public static abstract class zza extends Binder implements zzks {

        /* renamed from: com.google.android.gms.internal.zzks$zza$zza  reason: collision with other inner class name */
        /* loaded from: assets/classes2.dex */
        private static class C0058zza implements zzks {
            private IBinder zzrp;

            C0058zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzrp;
            }

            public IBinder zzo(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzks zzU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzks)) ? new C0058zza(iBinder) : (zzks) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            IBinder zzo = zzo(zzd.zza.zzcd(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeStrongBinder(zzo);
            return true;
        }
    }

    void destroy() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzll getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzadp zzadpVar) throws RemoteException;

    void zza(zzjn zzjnVar) throws RemoteException;

    void zza(zzke zzkeVar) throws RemoteException;

    void zza(zzkh zzkhVar) throws RemoteException;

    void zza(zzkx zzkxVar) throws RemoteException;

    void zza(zzld zzldVar) throws RemoteException;

    void zza(zzlr zzlrVar) throws RemoteException;

    void zza(zzmr zzmrVar) throws RemoteException;

    void zza(zzoa zzoaVar) throws RemoteException;

    void zza(zzxl zzxlVar) throws RemoteException;

    void zza(zzxr zzxrVar, String str) throws RemoteException;

    boolean zzb(zzjj zzjjVar) throws RemoteException;

    IObjectWrapper zzbr() throws RemoteException;

    zzjn zzbs() throws RemoteException;

    void zzbu() throws RemoteException;

    zzkx zzcd() throws RemoteException;

    zzkh zzce() throws RemoteException;

    String zzcp() throws RemoteException;
}
