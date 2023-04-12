package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
public final class zzo extends zze {
    private /* synthetic */ zzd zzfza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzo(zzd zzdVar, int i, Bundle bundle) {
        super(zzdVar, i, null);
        this.zzfza = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final boolean zzakr() {
        this.zzfza.zzfym.zzf(ConnectionResult.zzfkr);
        return true;
    }

    @Override // com.google.android.gms.common.internal.zze
    protected final void zzj(ConnectionResult connectionResult) {
        this.zzfza.zzfym.zzf(connectionResult);
        this.zzfza.onConnectionFailed(connectionResult);
    }
}
