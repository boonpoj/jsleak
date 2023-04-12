package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzai extends zzag implements Handler.Callback {
    private final Context mApplicationContext;
    private final Handler mHandler;
    private final HashMap<zzah, zzaj> zzgam = new HashMap<>();
    private final com.google.android.gms.common.stats.zza zzgan = com.google.android.gms.common.stats.zza.zzamc();
    private final long zzgao = 5000;
    private final long zzgap = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zzgam) {
                zzah zzahVar = (zzah) message.obj;
                zzaj zzajVar = this.zzgam.get(zzahVar);
                if (zzajVar != null && zzajVar.zzalm()) {
                    if (zzajVar.isBound()) {
                        zzajVar.zzgj("GmsClientSupervisor");
                    }
                    this.zzgam.remove(zzahVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zzgam) {
                zzah zzahVar2 = (zzah) message.obj;
                zzaj zzajVar2 = this.zzgam.get(zzahVar2);
                if (zzajVar2 != null && zzajVar2.getState() == 3) {
                    String valueOf = String.valueOf(zzahVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = zzajVar2.getComponentName();
                    if (componentName == null) {
                        componentName = zzahVar2.getComponentName();
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(zzahVar2.getPackage(), EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    zzajVar2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zza(zzah zzahVar, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzbq.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzgam) {
            zzaj zzajVar = this.zzgam.get(zzahVar);
            if (zzajVar == null) {
                zzajVar = new zzaj(this, zzahVar);
                zzajVar.zza(serviceConnection, str);
                zzajVar.zzgi(str);
                this.zzgam.put(zzahVar, zzajVar);
            } else {
                this.mHandler.removeMessages(0, zzahVar);
                if (zzajVar.zza(serviceConnection)) {
                    String valueOf = String.valueOf(zzahVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                zzajVar.zza(serviceConnection, str);
                int state = zzajVar.getState();
                if (state == 1) {
                    serviceConnection.onServiceConnected(zzajVar.getComponentName(), zzajVar.getBinder());
                } else if (state == 2) {
                    zzajVar.zzgi(str);
                }
            }
            isBound = zzajVar.isBound();
        }
        return isBound;
    }

    @Override // com.google.android.gms.common.internal.zzag
    protected final void zzb(zzah zzahVar, ServiceConnection serviceConnection, String str) {
        zzbq.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzgam) {
            zzaj zzajVar = this.zzgam.get(zzahVar);
            if (zzajVar == null) {
                String valueOf = String.valueOf(zzahVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (!zzajVar.zza(serviceConnection)) {
                String valueOf2 = String.valueOf(zzahVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            } else {
                zzajVar.zzb(serviceConnection, str);
                if (zzajVar.zzalm()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzahVar), this.zzgao);
                }
            }
        }
    }
}
