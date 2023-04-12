package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
/* JADX WARN: Classes with same name are omitted:
  assets/classes2.dex
 */
@zzzv
/* loaded from: classes.dex */
public final class zzaar extends zzaan implements com.google.android.gms.common.internal.zzf, com.google.android.gms.common.internal.zzg {
    private Context mContext;
    private final Object mLock;
    private zzakd zzapr;
    private zzalh<zzaat> zzcmw;
    private final zzaal zzcmx;
    private zzaas zzcna;

    /* loaded from: assets/classes2.dex */
    public static abstract class zza {
        public abstract void zzvb();
    }

    public zzaar(Context context, zzakd zzakdVar, zzalh<zzaat> zzalhVar, zzaal zzaalVar) {
        super(zzalhVar, zzaalVar);
        this.mLock = new Object();
        this.mContext = context;
        this.zzapr = zzakdVar;
        this.zzcmw = zzalhVar;
        this.zzcmx = zzaalVar;
        this.zzcna = new zzaas(context, ((Boolean) zzkb.zzif().zzd(zznh.zzbjf)).booleanValue() ? com.google.android.gms.ads.internal.zzbs.zzew().zzqs() : context.getMainLooper(), this, this, this.zzapr.zzdek);
        this.zzcna.zzakj();
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnected(Bundle bundle) {
        zznd();
    }

    @Override // com.google.android.gms.common.internal.zzg
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzagf.zzbx("Cannot connect to remote service, fallback to local instance.");
        new zzaaq(this.mContext, this.zzcmw, this.zzcmx).zznd();
        Bundle bundle = new Bundle();
        bundle.putString("action", "gms_connection_failed_fallback_to_local");
        com.google.android.gms.ads.internal.zzbs.zzei().zzb(this.mContext, this.zzapr.zzcv, "gmob-apps", bundle, true);
    }

    @Override // com.google.android.gms.common.internal.zzf
    public final void onConnectionSuspended(int i) {
        zzagf.zzbx("Disconnected from remote ad request service.");
    }

    @Override // com.google.android.gms.internal.zzaan
    public final void zznk() {
        synchronized (this.mLock) {
            if (this.zzcna.isConnected() || this.zzcna.isConnecting()) {
                this.zzcna.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.internal.zzaan
    public final zzabb zznl() {
        synchronized (this.mLock) {
            try {
                try {
                    return this.zzcna.zznm();
                } finally {
                }
            } catch (DeadObjectException e) {
                return null;
            } catch (IllegalStateException e2) {
                return null;
            }
        }
    }
}
