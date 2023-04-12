package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public final class zzl implements ServiceConnection {
    private /* synthetic */ zzd zzfza;
    private final int zzfzd;

    public zzl(zzd zzdVar, int i) {
        this.zzfza = zzdVar;
        this.zzfzd = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzay zzazVar;
        zzd zzdVar = this.zzfza;
        if (iBinder == null) {
            zzd.zza(zzdVar, 16);
            return;
        }
        synchronized (zzd.zza(zzdVar)) {
            zzd zzdVar2 = this.zzfza;
            if (iBinder == null) {
                zzazVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                zzazVar = (queryLocalInterface == null || !(queryLocalInterface instanceof zzay)) ? new zzaz(iBinder) : (zzay) queryLocalInterface;
            }
            zzd.zza(zzdVar2, zzazVar);
        }
        this.zzfza.zza(0, (Bundle) null, this.zzfzd);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (zzd.zza(this.zzfza)) {
            zzd.zza(this.zzfza, (zzay) null);
        }
        this.zzfza.mHandler.sendMessage(this.zzfza.mHandler.obtainMessage(6, this.zzfzd, 1));
    }
}
