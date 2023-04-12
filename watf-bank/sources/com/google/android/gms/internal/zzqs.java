package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzqs extends zzeu implements zzqq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzqq
    public final void zza(zzqe zzqeVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqeVar);
        zzb(1, zzbe);
    }
}
