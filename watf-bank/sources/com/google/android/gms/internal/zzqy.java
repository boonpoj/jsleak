package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
/* loaded from: classes.dex */
public final class zzqy extends zzeu implements zzqw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.zzqw
    public final void zzb(zzqm zzqmVar, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, zzqmVar);
        zzbe.writeString(str);
        zzb(1, zzbe);
    }
}
