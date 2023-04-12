package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
/* loaded from: classes.dex */
public final class zzl extends zzeu implements zzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeString(str);
        zzew.zza(zzbe, z);
        Parcel zza = zza(3, zzbe);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, iObjectWrapper);
        zzbe.writeString(str);
        zzbe.writeInt(i);
        Parcel zza = zza(2, zzbe);
        IObjectWrapper zzaq = IObjectWrapper.zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }
}
