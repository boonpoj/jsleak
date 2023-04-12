package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
/* loaded from: classes.dex */
public final class zzvc extends zzeu implements zzva {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.zzva
    public final void destroy() throws RemoteException {
        zzb(5, zzbe());
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel zza = zza(18, zzbe());
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzll getVideoController() throws RemoteException {
        Parcel zza = zza(26, zzbe());
        zzll zzh = zzlm.zzh(zza.readStrongBinder());
        zza.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.zzva
    public final IObjectWrapper getView() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean isInitialized() throws RemoteException {
        Parcel zza = zza(13, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzva
    public final void pause() throws RemoteException {
        zzb(8, zzbe());
    }

    @Override // com.google.android.gms.internal.zzva
    public final void resume() throws RemoteException {
        zzb(9, zzbe());
    }

    @Override // com.google.android.gms.internal.zzva
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(25, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void showInterstitial() throws RemoteException {
        zzb(4, zzbe());
    }

    @Override // com.google.android.gms.internal.zzva
    public final void showVideo() throws RemoteException {
        zzb(12, zzbe());
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzaem zzaemVar, List<String> list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzaemVar);
        zzbe.writeStringList(list);
        zzb(23, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzaem zzaemVar, String str2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzaemVar);
        zzbe.writeString(str2);
        zzb(10, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzvdVar);
        zzb(3, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, zzvdVar);
        zzb(7, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjjVar, String str, String str2, zzvd zzvdVar, zzpe zzpeVar, List<String> list) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, zzvdVar);
        zzew.zza(zzbe, zzpeVar);
        zzbe.writeStringList(list);
        zzb(14, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, zzvd zzvdVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjnVar);
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzew.zza(zzbe, zzvdVar);
        zzb(1, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjnVar, zzjj zzjjVar, String str, String str2, zzvd zzvdVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzew.zza(zzbe, zzjnVar);
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, zzvdVar);
        zzb(6, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zza(zzjj zzjjVar, String str, String str2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzb(20, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zzc(zzjj zzjjVar, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzjjVar);
        zzbe.writeString(str);
        zzb(11, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzb(21, zzbe);
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvj zzme() throws RemoteException {
        zzvj zzvlVar;
        Parcel zza = zza(15, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzvlVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzvlVar = queryLocalInterface instanceof zzvj ? (zzvj) queryLocalInterface : new zzvl(readStrongBinder);
        }
        zza.recycle();
        return zzvlVar;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzvm zzmf() throws RemoteException {
        zzvm zzvoVar;
        Parcel zza = zza(16, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzvoVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzvoVar = queryLocalInterface instanceof zzvm ? (zzvm) queryLocalInterface : new zzvo(readStrongBinder);
        }
        zza.recycle();
        return zzvoVar;
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle zzmg() throws RemoteException {
        Parcel zza = zza(17, zzbe());
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzva
    public final Bundle zzmh() throws RemoteException {
        Parcel zza = zza(19, zzbe());
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzva
    public final boolean zzmi() throws RemoteException {
        Parcel zza = zza(22, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzva
    public final zzqm zzmj() throws RemoteException {
        Parcel zza = zza(24, zzbe());
        zzqm zzn = zzqn.zzn(zza.readStrongBinder());
        zza.recycle();
        return zzn;
    }
}
