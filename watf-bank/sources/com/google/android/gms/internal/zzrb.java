package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzrb extends zzeu implements zzqz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.zzqz
    public final void zzb(zzqm zzqmVar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqmVar);
        zzb(1, zzbe);
    }
}
