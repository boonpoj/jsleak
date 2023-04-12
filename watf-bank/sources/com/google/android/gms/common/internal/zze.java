package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zze extends zzi<Boolean> {
    private int statusCode;
    private Bundle zzfyz;
    private /* synthetic */ zzd zzfza;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(zzd zzdVar, int i, Bundle bundle) {
        super(zzdVar, true);
        this.zzfza = zzdVar;
        this.statusCode = i;
        this.zzfyz = bundle;
    }

    protected abstract boolean zzakr();

    protected abstract void zzj(ConnectionResult connectionResult);

    @Override // com.google.android.gms.common.internal.zzi
    protected final /* synthetic */ void zzw(Boolean bool) {
        if (bool == null) {
            this.zzfza.zza(1, (int) null);
            return;
        }
        int i = this.statusCode;
        if (i == 0) {
            if (zzakr()) {
                return;
            }
            this.zzfza.zza(1, (int) null);
            zzj(new ConnectionResult(8, null));
        } else if (i == 10) {
            this.zzfza.zza(1, (int) null);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        } else {
            this.zzfza.zza(1, (int) null);
            Bundle bundle = this.zzfyz;
            zzj(new ConnectionResult(this.statusCode, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }
}
