package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzh extends Handler {
    private /* synthetic */ zzd zzfza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzd zzdVar, Looper looper) {
        super(looper);
        this.zzfza = zzdVar;
    }

    private static void zza(Message message) {
        ((zzi) message.obj).unregister();
    }

    private static boolean zzb(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzf zzfVar;
        zzf zzfVar2;
        ConnectionResult connectionResult;
        boolean zzakq;
        ConnectionResult connectionResult2;
        boolean z;
        if (this.zzfza.zzfyx.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.zzfza.isConnecting()) {
            zza(message);
        } else {
            if (message.what == 4) {
                this.zzfza.zzfyv = new ConnectionResult(message.arg2);
                zzakq = this.zzfza.zzakq();
                if (zzakq) {
                    z = this.zzfza.zzfyw;
                    if (!z) {
                        this.zzfza.zza(3, (int) null);
                        return;
                    }
                }
                connectionResult2 = this.zzfza.zzfyv;
                ConnectionResult connectionResult3 = connectionResult2 != null ? this.zzfza.zzfyv : new ConnectionResult(8);
                this.zzfza.zzfym.zzf(connectionResult3);
                this.zzfza.onConnectionFailed(connectionResult3);
            } else if (message.what == 5) {
                connectionResult = this.zzfza.zzfyv;
                ConnectionResult connectionResult4 = connectionResult != null ? this.zzfza.zzfyv : new ConnectionResult(8);
                this.zzfza.zzfym.zzf(connectionResult4);
                this.zzfza.onConnectionFailed(connectionResult4);
            } else if (message.what == 3) {
                ConnectionResult connectionResult5 = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                this.zzfza.zzfym.zzf(connectionResult5);
                this.zzfza.onConnectionFailed(connectionResult5);
            } else if (message.what == 6) {
                this.zzfza.zza(5, (int) null);
                zzfVar = this.zzfza.zzfyr;
                if (zzfVar != null) {
                    zzfVar2 = this.zzfza.zzfyr;
                    zzfVar2.onConnectionSuspended(message.arg2);
                }
                this.zzfza.onConnectionSuspended(message.arg2);
                this.zzfza.zza(5, 1, (int) null);
            } else if (message.what == 2 && !this.zzfza.isConnected()) {
                zza(message);
            } else if (zzb(message)) {
                ((zzi) message.obj).zzaks();
            } else {
                int i = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }
    }
}
