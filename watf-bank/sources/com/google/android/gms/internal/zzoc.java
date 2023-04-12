package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzoc extends zzeu implements zzoa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzoa
    public final void zza(zznx zznxVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zznxVar);
        zzb(1, zzbe);
    }
}
