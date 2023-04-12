package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
/* loaded from: classes.dex */
public final class zzk extends zzax {
    private zzd zzfzc;
    private final int zzfzd;

    public zzk(zzd zzdVar, int i) {
        this.zzfzc = zzdVar;
        this.zzfzd = i;
    }

    @Override // com.google.android.gms.common.internal.zzaw
    public final void zza(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.zzaw
    public final void zza(int i, IBinder iBinder, Bundle bundle) {
        zzbq.checkNotNull(this.zzfzc, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zzfzc.zza(i, iBinder, bundle, this.zzfzd);
        this.zzfzc = null;
    }
}
