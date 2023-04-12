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
public final class zzaas extends com.google.android.gms.common.internal.zzd<zzabb> {
    private int zzcnb;

    public zzaas(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.internal.zzg zzgVar, int i) {
        super(context.getApplicationContext() != null ? context.getApplicationContext() : context, looper, 8, zzfVar, zzgVar, null);
        this.zzcnb = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final /* synthetic */ zzabb zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return queryLocalInterface instanceof zzabb ? (zzabb) queryLocalInterface : new zzabd(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    protected final String zzhi() {
        return "com.google.android.gms.ads.service.START";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzd
    public final String zzhj() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public final zzabb zznm() throws DeadObjectException {
        return (zzabb) super.zzakn();
    }
}
