package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcbn implements com.google.android.gms.common.internal.zzf, com.google.android.gms.common.internal.zzg {
    private final String packageName;
    private zzcbo zzibm;
    private final String zzibn;
    private final LinkedBlockingQueue<zzaz> zzibo;
    private final HandlerThread zzibp = new HandlerThread("GassClient");

    public zzcbn(Context context, String str, String str2) {
        this.packageName = str;
        this.zzibn = str2;
        this.zzibp.start();
        this.zzibm = new zzcbo(context, this.zzibp.getLooper(), this, this);
        this.zzibo = new LinkedBlockingQueue<>();
        this.zzibm.zzakj();
    }

    private final zzcbt zzauo() {
        try {
            return this.zzibm.zzauq();
        } catch (DeadObjectException | IllegalStateException e) {
            return null;
        }
    }

    private static zzaz zzaup() {
        zzaz zzazVar = new zzaz();
        zzazVar.zzdt = Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
        return zzazVar;
    }

    private final void zznk() {
        zzcbo zzcboVar = this.zzibm;
        if (zzcboVar != null) {
            if (zzcboVar.isConnected() || this.zzibm.isConnecting()) {
                this.zzibm.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        zzcbt zzauo = zzauo();
        if (zzauo != null) {
            try {
                this.zzibo.put(zzauo.zza(new zzcbp(this.packageName, this.zzibn)).zzaur());
            } catch (Throwable th) {
                try {
                    this.zzibo.put(zzaup());
                } catch (InterruptedException e) {
                } catch (Throwable th2) {
                    zznk();
                    this.zzibp.quit();
                    throw th2;
                }
            }
            zznk();
            this.zzibp.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzibo.put(zzaup());
        } catch (InterruptedException e) {
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        try {
            this.zzibo.put(zzaup());
        } catch (InterruptedException e) {
        }
    }

    public final zzaz zzdo(int i) {
        zzaz zzazVar;
        try {
            zzazVar = this.zzibo.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzazVar = null;
        }
        return zzazVar == null ? zzaup() : zzazVar;
    }
}
