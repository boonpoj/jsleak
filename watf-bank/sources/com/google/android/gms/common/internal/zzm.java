package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
public final class zzm implements zzj {
    private /* synthetic */ zzd zzfza;

    public zzm(zzd zzdVar) {
        this.zzfza = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void zzf(ConnectionResult connectionResult) {
        zzg zzgVar;
        zzg zzgVar2;
        if (connectionResult.isSuccess()) {
            zzd zzdVar = this.zzfza;
            zzdVar.zza((zzan) null, zzdVar.zzakp());
            return;
        }
        zzgVar = this.zzfza.zzfys;
        if (zzgVar != null) {
            zzgVar2 = this.zzfza.zzfys;
            zzgVar2.onConnectionFailed(connectionResult);
        }
    }
}
