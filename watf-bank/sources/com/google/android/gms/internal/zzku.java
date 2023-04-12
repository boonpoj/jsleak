package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzku extends zzeu implements zzks {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzku(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.zzks
    public final void destroy() throws RemoteException {
        zzb(2, zzbe());
    }

    @Override // com.google.android.gms.internal.zzks
    public final String getAdUnitId() throws RemoteException {
        Parcel zza = zza(31, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzks
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(18, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzll getVideoController() throws RemoteException {
        zzll zzlnVar;
        Parcel zza = zza(26, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzlnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzlnVar = queryLocalInterface instanceof zzll ? (zzll) queryLocalInterface : new zzln(readStrongBinder);
        }
        zza.recycle();
        return zzlnVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean isLoading() throws RemoteException {
        Parcel zza = zza(23, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean isReady() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void pause() throws RemoteException {
        zzb(5, zzbe());
    }

    @Override // com.google.android.gms.internal.zzks
    public final void resume() throws RemoteException {
        zzb(6, zzbe());
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(34, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(22, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void setUserId(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(25, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void showInterstitial() throws RemoteException {
        zzb(9, zzbe());
    }

    @Override // com.google.android.gms.internal.zzks
    public final void stopLoading() throws RemoteException {
        zzb(10, zzbe());
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzadp zzadpVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzadpVar);
        zzb(24, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzjn zzjnVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzjnVar);
        zzb(13, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzke zzkeVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzkeVar);
        zzb(20, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzkh zzkhVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzkhVar);
        zzb(7, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzkx zzkxVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzkxVar);
        zzb(8, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzld zzldVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzldVar);
        zzb(21, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzlr zzlrVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzlrVar);
        zzb(30, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzmr zzmrVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzmrVar);
        zzb(29, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzoa zzoaVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzoaVar);
        zzb(19, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzxl zzxlVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzxlVar);
        zzb(14, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zza(zzxr zzxrVar, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzxrVar);
        zzbe.writeString(str);
        zzb(15, zzbe);
    }

    @Override // com.google.android.gms.internal.zzks
    public final boolean zzb(zzjj zzjjVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzjjVar);
        Parcel zza = zza(4, zzbe);
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzks
    public final IObjectWrapper zzbr() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzjn zzbs() throws RemoteException {
        Parcel zza = zza(12, zzbe());
        zzjn zzjnVar = (zzjn) zzew.zza(zza, zzjn.CREATOR);
        zza.recycle();
        return zzjnVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final void zzbu() throws RemoteException {
        zzb(11, zzbe());
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzkx zzcd() throws RemoteException {
        zzkx zzkzVar;
        Parcel zza = zza(32, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkzVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzkzVar = queryLocalInterface instanceof zzkx ? (zzkx) queryLocalInterface : new zzkz(readStrongBinder);
        }
        zza.recycle();
        return zzkzVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final zzkh zzce() throws RemoteException {
        zzkh zzkjVar;
        Parcel zza = zza(33, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzkjVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzkjVar = queryLocalInterface instanceof zzkh ? (zzkh) queryLocalInterface : new zzkj(readStrongBinder);
        }
        zza.recycle();
        return zzkjVar;
    }

    @Override // com.google.android.gms.internal.zzks
    public final String zzcp() throws RemoteException {
        Parcel zza = zza(35, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
