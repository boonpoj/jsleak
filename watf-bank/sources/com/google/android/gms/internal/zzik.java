package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzik extends com.google.android.gms.common.internal.zzd<zzio> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzik(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar) {
        super(context, looper, 123, zzfVar, zzgVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzio zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        return queryLocalInterface instanceof zzio ? (zzio) queryLocalInterface : new zzip(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhi() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhj() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public final zzio zzhk() throws DeadObjectException {
        return (zzio) super.zzakn();
    }
}
