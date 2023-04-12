package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
@zzzv
/* loaded from: classes.dex */
public final class zzrq extends com.google.android.gms.common.internal.zzd<zzrv> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrq(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar) {
        super(context, looper, 166, zzfVar, zzgVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzrv zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        return queryLocalInterface instanceof zzrv ? (zzrv) queryLocalInterface : new zzrw(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhi() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhj() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    public final zzrv zzkt() throws DeadObjectException {
        return (zzrv) super.zzakn();
    }
}
