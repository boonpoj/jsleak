package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzabg extends zzeu implements zzabe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    @Override // com.google.android.gms.internal.zzabe
    public final void zza(zzaax zzaaxVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzaaxVar);
        zzb(1, zzbe);
    }
}
